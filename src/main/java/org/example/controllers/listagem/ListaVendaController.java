/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controllers.listagem;

import org.example.controllers.AbstractController;
import org.example.controllers.cadastro.CadastroVendaController;
import org.example.dao.imp.VendaDao;
import org.example.model.Venda;
import org.example.view.ListagemVendasForm;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 *
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class ListaVendaController extends AbstractController<Venda> {
    
    private List<Venda> lista;
    private ListagemVendasForm view;
    private VendaDao dao;
    
    public ListaVendaController(){
        view = new ListagemVendasForm();
        dao = new VendaDao();
        lista = dao.findAll(Venda.class);
        
        String[] colunas = {"Valor", "Cliente", "Vendedor"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        
        for(Venda v : lista){
            model.addRow(new Object[]{
                v.getValor(),
                v.getCliente(),
                v.getVendedor()
            });
        }
        
       view.getTblVendas().setModel(model);
       
       // Já seleciona a primeira linha da tabela
       if(model.getRowCount() > 0)
           view.getTblVendas().changeSelection(0, 0, false, false);
  
       view.getBtnVisualizar().addActionListener((ActionEvent e) -> {
           new CadastroVendaController(lista.get(view.getTblVendas().getSelectedRow()));
       });
       
       view.getBtnSair().addActionListener((ActionEvent e) -> {
           view.dispose();
       });
    }
}
