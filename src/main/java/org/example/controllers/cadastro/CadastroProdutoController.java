/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controllers.cadastro;

import org.example.controllers.AbstractController;
import org.example.dao.imp.ProdutoDao;
import org.example.model.Categoria;
import org.example.model.Produto;
import org.example.view.CadastroProdutoForm;

import java.awt.event.ActionEvent;

/**
 *
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class CadastroProdutoController extends AbstractController<Produto> {

    private CadastroProdutoForm view;
    private Produto p;
    private ProdutoDao produtoDao;

    public CadastroProdutoController() {
        view = new CadastroProdutoForm();

        p = new Produto();

        view.getBtnCadastrar().addActionListener((ActionEvent e) -> {
            cadastrar();
            view.dispose();
        });
        
        view.getBtnSair().addActionListener((ActionEvent e) -> {
            view.dispose();
        });
    }

    public CadastroProdutoController(Produto p) {

        this.p = p;
        view = new CadastroProdutoForm();

        preencheDados(p);
        habilitaBotoes(true);
        habilitaCampos(false);

        view.getBtnRemover().addActionListener((ActionEvent e) -> {
            remover();
            view.dispose();
        });

        view.getBtnEditar().addActionListener((ActionEvent e) -> {
            habilitaBotoes(false);
            habilitaCampos(true);
        });

        view.getBtnCadastrar().addActionListener((ActionEvent e) -> {
            cadastrar();
            view.dispose();
        });

        view.getBtnSair().addActionListener((ActionEvent e) -> {
            view.dispose();
        });

    }

    private void preencheDados(Produto p){
      view.getTxtPreco().setText(Double.toString(p.getPreco()));
      view.getTxtDescricao().setText(p.getDescricao());
      view.getTxtNome().setText(p.getDescricao());
      view.getComboCategoria().setSelectedItem(p.getCategoria().toString());
    }
    private void habilitaCampos(boolean habilita) {
        view.getTxtDescricao().setEnabled(habilita);
        view.getTxtNome().setEnabled(habilita);
        view.getComboCategoria().setEnabled(habilita);
        view.getTxtPreco().setEnabled(habilita);
    }

    private void habilitaBotoes(boolean habilita) {
        view.getBtnEditar().setEnabled(habilita);
        view.getBtnCadastrar().setEnabled(!habilita);
        view.getBtnSair().setEnabled(habilita);
        view.getBtnRemover().setEnabled(habilita);
    }

    private void cadastrar() {
        if (validaCampos()) {

            p.setNome(view.getTxtNome().getText());

            if (view.getComboCategoria().getSelectedItem() == Categoria.ARMACOES.toString()) {
                p.setCategoria(Categoria.ARMACOES);
            } else {
                p.setCategoria(Categoria.LENTES);
            }

            p.setPreco(Double.parseDouble(view.getTxtPreco().getText()));
            p.setDescricao(view.getTxtDescricao().getText());

            clearMessages();
            boolean erro = false;
            produtoDao = new ProdutoDao();

            try {
                if (p.getId() != null) {
                    produtoDao.update(p);
                } else {
                    produtoDao.create(p);
                }
            } catch (Exception e) {
                erro = true;
                addErro("Não foi possível salvar o produto");
                printMessages(view, "Erro");
            }

            if (!erro) {
                addMensagemSuceso("Produto salvo com suscesso");
                printMessages(view, "Produto cadastrado");
            }
        }
    }

    private boolean validaCampos() {
        clearMessages();

        if (view.getTxtDescricao().getText().isBlank()) {
            addErro("Descrição não pode ser nula");
        }

        if (view.getTxtNome().getText().isBlank()) {
            addErro("Nome não pode ser nulo");
        }

        if (view.getTxtPreco().getText().isBlank()) {
            addErro("Preço não pode ser nulo");
        }

        if (getErros().isEmpty()) {
            return true;
        } else {
            printMessages(view, "Erros");
            return false;
            
        }
    }

    private void remover() {
        clearMessages();
        boolean erro = false;

        produtoDao = new ProdutoDao();
        try {
            produtoDao.delete(p);
        } catch (Exception e) {
            erro = true;
            addErro("Não foi possível excluir o produto");
            printMessages(view, "Erro");
        }

        if (!erro) {
            addMensagemSuceso("Produto excluído");
            printMessages(view, "Confirmação");
        }

    }
}
