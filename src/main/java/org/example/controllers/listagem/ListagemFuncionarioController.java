/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controllers.listagem;

import org.example.controllers.AbstractController;
import org.example.controllers.cadastro.CadastroFuncionarioController;
import org.example.dao.imp.FuncionarioDao;
import org.example.model.Funcionario;
import org.example.view.ListagemFuncionarioForm;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 *
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class ListagemFuncionarioController extends AbstractController<Funcionario> {

    private List<Funcionario> lista;
    private ListagemFuncionarioForm view;

    public ListagemFuncionarioController() {
        view = new ListagemFuncionarioForm();

        FuncionarioDao dao = new FuncionarioDao();

        lista = dao.findAll(Funcionario.class);

        String[] colunas = {"Nome", "CPF", "telefone", "email", "salario"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Funcionario f : lista) {

            model.addRow(new Object[]{
                f.getNome(),
                f.getCpf(),
                f.getTelefone(),
                f.getEmail(),
                f.getSalario()
            });

        }

        view.getTblFuncionarios().setModel(model);
        
        if(view.getTblFuncionarios().getRowCount() > 0)
            view.getTblFuncionarios().changeSelection(0, 0, false, false);
       
        view.getBtnVisualizar().addActionListener((ActionEvent e) -> {

            new CadastroFuncionarioController(lista.get(view.getTblFuncionarios().getSelectedRow()));
            view.dispose();

        });
        
        view.getBtnExit().addActionListener((ActionEvent e) -> {
            view.dispose();
        });
    }

}
