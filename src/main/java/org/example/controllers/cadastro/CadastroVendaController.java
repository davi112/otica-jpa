/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controllers.cadastro;

import org.example.controllers.AbstractController;
import org.example.dao.imp.ClienteDao;
import org.example.dao.imp.FuncionarioDao;
import org.example.dao.imp.ProdutoDao;
import org.example.dao.imp.VendaDao;
import org.example.model.*;
import org.example.view.CadastroVendasForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 *
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class CadastroVendaController extends AbstractController<Venda> {

    private CadastroVendasForm view;
    private Venda v;
    private VendaDao vendaDao;
    private DefaultTableModel modelProdutos;

    public CadastroVendaController() {
        v = new Venda();
        view = new CadastroVendasForm();
        modelProdutos = new DefaultTableModel(new String[]{"Nome", "Preco", "Quantidade"}, 0);
        view.getTblProdutos().setModel(modelProdutos);
        popularCombos();

        view.getBtnRegistrar().addActionListener((ActionEvent e) -> {
            cadastrar();
        });

        view.getBtnAdicionar().addActionListener((ActionEvent e) -> {
            addProduto((Produto) view.getComboProdutos().getSelectedItem());
        });

        view.getBtnExit().addActionListener((ActionEvent e) -> {
            view.dispose();
        });
        
        view.getBtnRemover().addActionListener((ActionEvent e) -> {
            removerProduto(view.getTblProdutos().getSelectedRow());
        });

    }
    
    public CadastroVendaController(Venda v){
        this.v = v;
        view = new CadastroVendasForm();
        modelProdutos = new DefaultTableModel(new String[]{"Nome", "Preco", "Quantidade"}, 0);
        view.getTblProdutos().setModel(modelProdutos);
        
        popularCombos();
        popularDados(this.v);
        
        view.getBtnRegistrar().addActionListener((ActionEvent e) -> {
            cadastrar();
        });

        view.getBtnAdicionar().addActionListener((ActionEvent e) -> {
            addProduto((Produto) view.getComboProdutos().getSelectedItem());
        });

        view.getBtnExit().addActionListener((ActionEvent e) -> {
            view.dispose();
        });
        
        view.getBtnRemover().addActionListener((ActionEvent e) -> {
            removerProduto(view.getTblProdutos().getSelectedRow());
        });
    }
    
    private void popularCombos() {

        //Produtos
        ProdutoDao pDao = new ProdutoDao();
        List<Produto> produtos = pDao.findAll(Produto.class);

        DefaultComboBoxModel pModel = new DefaultComboBoxModel();

        pModel.addAll(produtos);

        view.getComboProdutos().setModel(pModel);
        if (!produtos.isEmpty()) {
            view.getComboProdutos().setSelectedIndex(0);
        }

        //Clientes
        DefaultComboBoxModel cModel = new DefaultComboBoxModel();

        ClienteDao cDao = new ClienteDao();

        List<Cliente> clientes = cDao.findAll(Cliente.class);

        cModel.addAll(clientes);
        view.getComboCliente().setModel(cModel);

        if (!clientes.isEmpty()) {
            view.getComboCliente().setSelectedIndex(0);
        }

        //Vendedores
        DefaultComboBoxModel vModel = new DefaultComboBoxModel();

        FuncionarioDao fDao = new FuncionarioDao();
        List<Funcionario> funcionarios = fDao.findAllByCargo(Cargo.VENDEDOR);

        vModel.addAll(funcionarios);

        view.getComboVendedor().setModel(vModel);

        if (!funcionarios.isEmpty()) {
            view.getComboVendedor().setSelectedIndex(0);
        }

    }

    private void popularDados(Venda v){
        
        view.getTxtDesconto().setText(Double.toString(v.getDesconto()));
        view.getComboCliente().setSelectedItem(v.getCliente());
        view.getComboVendedor().setSelectedItem(v.getVendedor());
        view.getComboForma().setSelectedItem(v.getFormaPagamento().toString());
        view.getTxtValor().setText(Double.toString(v.getValor()));
        
        for(Produto p : v.getProdutos()){
            modelProdutos.addRow(new Object[]{
                p.getNome(),
                p.getPreco(),
                p.getQuantidadeVendida()
            });
        }
        
    }
    
    private boolean validaCampos() {
        clearMessages();

        if (view.getComboCliente().getSelectedItem() == null) {
            addErro("Necessário selecionar o cliente");
        }

        if (v.getProdutos().isEmpty()) {
            addErro("Necessário adicionar ao menos um produto");
        }

        if (view.getComboVendedor().getSelectedItem() == null) {
            addErro("Necessário selecionar o vendedor");
        }

        if (view.getComboForma().getSelectedItem() == null) {
            addErro("Necessário selecionar a forma de pagamento");
        }

        if (!getErros().isEmpty()) {
            printMessages(view, "Erros");
            return false;
        } else {
            return true;
        }

    }

    private void cadastrar() {
        if (validaCampos()) {

            v.setCliente((Cliente) view.getComboCliente().getSelectedItem());

            if (view.getComboForma().getSelectedItem() == FormaPagamento.CREDITO.toString()) {
                v.setFormaPagamento(FormaPagamento.CREDITO);
            } else {
                v.setFormaPagamento(FormaPagamento.DEBITO);
            }

            v.setValor(Double.parseDouble(view.getTxtValor().getText()));
            v.setVendedor((Funcionario) view.getComboVendedor().getSelectedItem());
            v.setDesconto(Double.parseDouble(view.getTxtDesconto().getText()));

            clearMessages();
            vendaDao = new VendaDao();
            boolean erro = false;
            try {
                vendaDao.create(v);
            } catch (Exception e) {
                addErro("Não foi possível inserir a venda");
                printMessages(view, "Erro");
                erro = true;
            }

            if (!erro) {
                addMensagemSuceso("Venda cadastrada");
                printMessages(view, "Sucesso!");
            }

        }

    }

    private void addProduto(Produto p) {
        clearMessages();

        if (p != null && Integer.parseInt(view.getTxtQuantidade().getText()) > 0) {
            p.setQuantidadeVendida(Integer.parseInt(view.getTxtQuantidade().getText()));
            v.getProdutos().add(p);
        } else {
            addErro("Não foi possível inserir o produto");
            printMessages(view, "Erro");
            return;
        }

        double valor = Double.parseDouble(view.getTxtValor().getText());

        valor += (p.getPreco() * Integer.parseInt(view.getTxtQuantidade().getText()));

        view.getTxtValor().setText(Double.toString(valor));

        modelProdutos.addRow(new Object[]{
            p.getNome(),
            p.getPreco(),
            p.getQuantidadeVendida()
        });
        
        if(modelProdutos.getRowCount() > 0)
           view.getTblProdutos().changeSelection(0, 0, false, false);
            
        addMensagemSuceso("Produto adicionado");

        printMessages(view, "Sucesso");
    }

    private void removerProduto(int linhaSelecionada) {

        if(linhaSelecionada == -1){
            addErro("Não há produtos para remover");
            printMessages(view, "Erro");
            return;
        }
        
        Produto p = v.getProdutos().get(linhaSelecionada);
        double valor = Double.parseDouble(view.getTxtValor().getText());

        valor -= p.getPreco() * p.getQuantidadeVendida();
        
        view.getTxtValor().setText(Double.toString(valor));
        
        modelProdutos.removeRow(linhaSelecionada);
        v.getProdutos().remove(p);
                
    }

}
