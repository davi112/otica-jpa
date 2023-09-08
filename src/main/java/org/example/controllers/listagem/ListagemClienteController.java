/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controllers.listagem;

import org.example.controllers.AbstractController;
import org.example.controllers.cadastro.CadastroClienteController;
import org.example.dao.imp.ClienteDao;
import org.example.model.Cliente;
import org.example.view.ListagemClientesForm;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 *
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class ListagemClienteController extends AbstractController<Cliente> {
    
    private ListagemClientesForm view;
    private List<Cliente> lista;
    
    public ListagemClienteController(){
        view = new ListagemClientesForm();
        view.setVisible(true);
        
        ClienteDao dao = new ClienteDao();
        
        lista = dao.findAll(Cliente.class);
      
        String[] colunas = {"Nome", "CPF", "telefone", "email"};
        
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        
        
        for(Cliente c : lista){
            
            model.addRow(new Object[]{
                  c.getNome(),
                  c.getCpf(),
                  c.getTelefone(),
                  c.getEmail()
            });
            
        }
        
        view.getTblClientes().setModel(model);
        
        if(view.getTblClientes().getRowCount() > 0)
            view.getTblClientes().changeSelection(0, 0, false, false);
      
        view.getBtnVisualizar().addActionListener((ActionEvent e) -> {
                
            new CadastroClienteController(lista.get(view.getTblClientes().getSelectedRow()));
            view.dispose();
            
        });
        
         view.getBtnExit().addActionListener((ActionEvent e) -> {
            view.dispose();
        });
         
         view.getBtnReceitas().addActionListener((ActionEvent e) -> {
            new ReceitasPorClienteController(lista.get(view.getTblClientes().getSelectedRow()).getReceitas(),
            lista.get(view.getTblClientes().getSelectedRow()));
            view.dispose();
        });
        
    }
}
