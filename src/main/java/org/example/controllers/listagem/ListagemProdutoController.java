/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controllers.listagem;

import org.example.controllers.AbstractController;
import org.example.controllers.cadastro.CadastroProdutoController;
import org.example.dao.imp.ProdutoDao;
import org.example.model.Produto;
import org.example.view.ListagemProdutoForm;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 *
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class ListagemProdutoController extends AbstractController<Produto> {

    private ListagemProdutoForm view;
    private List<Produto> lista;
    private ProdutoDao produtoDao;

    public ListagemProdutoController() {
        view = new ListagemProdutoForm();

        produtoDao = new ProdutoDao();
        lista = produtoDao.findAll(Produto.class);

        String[] colunas = {"nome", "preço", "descricao"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Produto p : lista) {
            model.addRow(new Object[] {
                    p.getNome(),
                    p.getPreco(),
                    p.getDescricao()
            });
        }
        
        view.getTblProdutos().setModel(model);
        
         if(view.getTblProdutos().getRowCount() > 0)
            view.getTblProdutos().changeSelection(0, 0, false, false);
        
        view.getBtnVisualizar().addActionListener((ActionEvent e) -> {
            new CadastroProdutoController(lista.get(view.getTblProdutos().getSelectedRow()));
            view.dispose();
        });

        view.getBtnSair().addActionListener((ActionEvent e) -> {
            view.dispose();
        });
    }

}
