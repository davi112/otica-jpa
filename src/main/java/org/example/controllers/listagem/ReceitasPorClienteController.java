/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controllers.listagem;

import org.example.controllers.AbstractController;
import org.example.dao.imp.ReceitaDao;
import org.example.model.Cliente;
import org.example.model.Receita;
import org.example.view.ListagemReceitasForm;
import org.example.view.ReceitasPorClienteForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Controller utilizado para listar as receitas de um determinado cliente.
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class ReceitasPorClienteController extends AbstractController<Receita> {

    private ListagemReceitasForm viewLista;
    private ReceitasPorClienteForm viewCadastro;
    private List<Receita> lista;
    private ReceitaDao receitaDao;
    private Cliente c;
    private boolean novo = true;

    public ReceitasPorClienteController(List<Receita> lista, Cliente c) {
        viewLista = new ListagemReceitasForm();
        receitaDao = new ReceitaDao();
        this.lista = lista;
        this.c = c;

        loadReceitas();

        if(viewLista.getTblReceitas().getRowCount() == 0){
            viewLista.getBtnVisualizar().setEnabled(false);
        }

        viewLista.getBtnNovo().addActionListener((ActionEvent e) -> {
            viewLista.dispose();
            viewCadastro = new ReceitasPorClienteForm();

            configuraViewCadastro();
        });

        viewLista.getBtnVisualizar().addActionListener((ActionEvent e) -> {
            viewLista.dispose();
            viewCadastro = new ReceitasPorClienteForm();
            popularDados(lista.get(viewLista.getTblReceitas().getSelectedRow()));

            configuraViewCadastro();
        });

        viewLista.getBtnSair().addActionListener((ActionEvent e) -> {
            viewLista.dispose();
        });

    }

    private void popularDados(Receita r) {
        viewCadastro.getTxtAdicao().setText(Double.toString(r.getAdicao()));
        viewCadastro.getTxtDistanciaPupilar().setText(Double.toString(r.getDistanciaPupilar()));
        viewCadastro.getTxtODCilindrico().setText(Integer.toString(r.getCilindricoOD()));
        viewCadastro.getTxtODEsferico().setText(Integer.toString(r.getEsfericoOD()));
        viewCadastro.getTxtODEixo().setText(Integer.toString(r.getEixoOD()));
        viewCadastro.getTxtOECilindrico().setText(Integer.toString(r.getCilindricoOE()));
        viewCadastro.getTxtOEEsferico().setText(Integer.toString(r.getEsfericoOE()));
        viewCadastro.getTxtOEEixo().setText(Integer.toString(r.getEixoOE()));
        novo = false;
    }

    private void configuraViewCadastro() {

        if (novo) {
            habilitaCampos(true);
            viewCadastro.getBtnEdit().setEnabled(false);
            viewCadastro.getBtnRemove().setEnabled(false);
        } else {
            habilitaCampos(false);
            habilitaBotoes(true);
        }

        viewCadastro.getBtnEdit().addActionListener((ActionEvent e) -> {
            habilitaCampos(true);
            habilitaBotoes(false);
        });

        viewCadastro.getBtnSave().addActionListener((ActionEvent e) -> {
            cadastrar();
            viewCadastro.dispose();
        });

        viewCadastro.getBtnRemove().addActionListener((ActionEvent e) -> {
            remover(lista.get(viewLista.getTblReceitas().getSelectedRow()));
            viewCadastro.dispose();
        });

    }

    private void habilitaCampos(boolean habilita) {
        viewCadastro.getTxtAdicao().setEnabled(habilita);
        viewCadastro.getTxtDistanciaPupilar().setEnabled(habilita);
        viewCadastro.getTxtODCilindrico().setEnabled(habilita);
        viewCadastro.getTxtODEsferico().setEnabled(habilita);
        viewCadastro.getTxtODEixo().setEnabled(habilita);
        viewCadastro.getTxtOECilindrico().setEnabled(habilita);
        viewCadastro.getTxtOEEsferico().setEnabled(habilita);
        viewCadastro.getTxtOEEixo().setEnabled(habilita);
    }

    private void habilitaBotoes(boolean habilita) {
        viewCadastro.getBtnEdit().setEnabled(habilita);
        viewCadastro.getBtnRemove().setEnabled(!habilita);
        viewCadastro.getBtnSave().setEnabled(!habilita);
    }

    private void cadastrar() {
        boolean erro = false;

        if (novo) {
            Receita r = new Receita();
            r.setAdicao(Double.parseDouble(viewCadastro.getTxtAdicao().getText()));
            r.setCilindricoOD(Integer.parseInt(viewCadastro.getTxtODCilindrico().getText()));
            r.setCliente(c);
            r.setCilindricoOE(Integer.parseInt(viewCadastro.getTxtOECilindrico().getText()));
            r.setDistanciaPupilar(Double.parseDouble(viewCadastro.getTxtDistanciaPupilar().getText()));
            r.setEixoOD(Integer.parseInt(viewCadastro.getTxtODEixo().getText()));
            r.setEixoOE(Integer.parseInt(viewCadastro.getTxtOEEixo().getText()));
            r.setEsfericoOD(Integer.parseInt(viewCadastro.getTxtODEsferico().getText()));
            r.setEsfericoOE(Integer.parseInt(viewCadastro.getTxtOEEsferico().getText()));
            try {
                receitaDao.create(r);
            } catch (Exception e) {
                erro = true;
                addErro("Não foi possível cadastrar a receita");
                printMessages(viewCadastro, "Erro");
            }
        } else {
            Receita r = lista.get(viewLista.getTblReceitas().getSelectedRow());
            r.setAdicao(Double.parseDouble(viewCadastro.getTxtAdicao().getText()));
            r.setCilindricoOD(Integer.parseInt(viewCadastro.getTxtODCilindrico().getText()));
            r.setCliente(c);
            r.setCilindricoOE(Integer.parseInt(viewCadastro.getTxtOECilindrico().getText()));
            r.setDistanciaPupilar(Double.parseDouble(viewCadastro.getTxtDistanciaPupilar().getText()));
            r.setEixoOD(Integer.parseInt(viewCadastro.getTxtODEixo().getText()));
            r.setEixoOE(Integer.parseInt(viewCadastro.getTxtOEEixo().getText()));
            r.setEsfericoOD(Integer.parseInt(viewCadastro.getTxtODEsferico().getText()));
            r.setEsfericoOE(Integer.parseInt(viewCadastro.getTxtOEEsferico().getText()));
            try {
                receitaDao.update(r);
            } catch (Exception e) {
                erro = true;
                addErro("Não foi possível atualizar a receita");
                printMessages(viewCadastro, "Erro");
            }
        }

        if (!erro) {
            addMensagemSuceso("Salvo com sucesso !");
            printMessages(viewCadastro, "Sucesso");
        }

    }

    private boolean validaCampos(){
     return true;   
    }
    private void remover(Receita r) {
        clearMessages();
        boolean erro = false;
        try {
            receitaDao.delete(r);
        } catch (Exception e) {
            erro = true;
            addErro("Não foi possível excluir a receita");
        }

        if (!erro) {
            addMensagemSuceso("Receita excluída");
        }

        printMessages(viewCadastro, "Informação");

    }

    private void loadReceitas() {
         String[] colunas = {"esfericoOD", "esfericoOE", "cilindricoOD", "cilindricoOE"};

        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Receita r : lista) {

            model.addRow(new Object[]{
                r.getEsfericoOD(),
                r.getEsfericoOE(),
                r.getCilindricoOD(),
                r.getCilindricoOE()
            });

        }

        viewLista.getTblReceitas().setModel(model);

        if (viewLista.getTblReceitas().getRowCount() > 0) {
            viewLista.getTblReceitas().changeSelection(0, 0, false, false);
        }
    }
}
