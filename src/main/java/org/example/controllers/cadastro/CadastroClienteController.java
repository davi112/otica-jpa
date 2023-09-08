/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controllers.cadastro;

import org.example.controllers.AbstractController;
import org.example.dao.imp.ClienteDao;
import org.example.model.Cliente;
import org.example.utils.DataUtils;
import org.example.view.CadastroClientesForm;

import java.awt.event.ActionEvent;
import java.util.Calendar;

/**
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class CadastroClienteController extends AbstractController<Cliente> {

    private Cliente c;
    private CadastroClientesForm view;
    private ClienteDao clienteDao;

    /**
     * Construtor utilizado no cadastro. Nao utilizar no caso de uso de edição.
     */
    public CadastroClienteController() {
        view = new CadastroClientesForm();
        clienteDao = new ClienteDao();
        c = new Cliente();

        view.getBtnCadastrar().addActionListener((ActionEvent e) -> {
            cadastrar();
            view.dispose();
        });

        view.getBtnExit().addActionListener((ActionEvent e) -> {
            view.dispose();
        });
    }

    /**
     * Construtor utilizado na edição. Nao utilizar no caso de uso de cadastro.
     * @param c, o cliente a ser alterado.
     */
    public CadastroClienteController(Cliente c) {
        this.c = c;
        clienteDao = new ClienteDao();
        view = new CadastroClientesForm();
        view.getBtnCadastrar().setText("SALVAR");

        preencheDados(c);
        habilitaCampos(false);
        habilitaBotoes(true);

        view.getBtnEditar().addActionListener((ActionEvent e) -> {
            habilitaCampos(true);
            habilitaBotoes(false);
        });

        view.getBtnCadastrar().addActionListener((ActionEvent e) -> {
            cadastrar();
            habilitaBotoes(true);
            habilitaCampos(false);
        });

        
        view.getBtnRemove().addActionListener((ActionEvent e) -> {
            remove();
        });

        view.getBtnExit().addActionListener((ActionEvent e) -> {
            view.dispose();
        });
    }

    private void habilitaBotoes(boolean habilita) {
        view.getBtnEditar().setEnabled(habilita);
        view.getBtnCadastrar().setEnabled(!habilita);
        view.getBtnRemove().setEnabled(!habilita);
    }
    
    /**
     * Preenche os campos da tela de visualizacao detalhada.
     * @param c, o cliente a ser visualizado 
     */
    private void preencheDados(Cliente c) {
        view.getTxtCpf().setText(c.getCpf());
        view.getTxtNome().setText(c.getNome());
        view.getTxtDataNascimento().setText(DataUtils.toString(c.getDataNascimento()));
        view.getTxtTelefone().setText(c.getTelefone());
        view.getTxtEmail().setText(c.getEmail());
    }

    private void habilitaCampos(boolean habilita) {
        view.getTxtCpf().setEnabled(habilita);
        view.getTxtNome().setEnabled(habilita);
        view.getTxtDataNascimento().setEnabled(habilita);
        view.getTxtTelefone().setEnabled(habilita);
        view.getTxtEmail().setEnabled(habilita);
    }

    /**
     * Método que realiza a lógica de cadastro e edicao de clientes
     */
    private void cadastrar() {

        if (validarCampos()) {
            c.setNome(view.getTxtNome().getText());
            c.setCpf(view.getTxtCpf().getText());
            c.setDataCadastro(Calendar.getInstance());
            c.setEmail(view.getTxtEmail().getText());
            c.setDataNascimento(DataUtils.parse(view.getTxtDataNascimento().getText()));
            c.setTelefone(view.getTxtTelefone().getText());


            boolean erro = false;

            clearMessages();
            try {
                if (c.getId() != null)
                    clienteDao.update(c);
                else
                    clienteDao.create(c);

            } catch (Exception e) {
                addErro("Não foi possível cadastrar o cliente");
                printMessages(view, "Erro");
                erro = true;
            }

            if (!erro) {
                addMensagemSuceso("Cliente salvo com sucesso");
                printMessages(view, "Cliente cadastrado");
            }
        }
    }

    /**
     * Valida os campos de cadastro e adiciona as mensagens de erro, caso hajam.
     * Metodo chamado pelo metodo cadastrar
     * @return false, se houver algum erro, true, caso contrario.
     */
    private boolean validarCampos() {
        clearMessages();

        if (view.getTxtNome().getText().isEmpty()) {
            addErro("Nome não pode ser nulo");
        }

        if (view.getTxtCpf().getText().isEmpty()) {
            addErro("CPF iválido");
        }

        if (view.getTxtEmail().getText().isEmpty()) {
            addErro("Email inválido");
        }

        if (view.getTxtDataNascimento().getText().isEmpty()) {
            addErro("Nascimento inválido");
        }

        if (getErros().isEmpty()) {
            return true;
        } else {
            printMessages(view, "Erros no cadastro de cliente");
            return false;
        }
    }
    
    /**
     * Remove o cliente e imprime as mensagens de sucesso ou erro da operacao.
     */
    private void remove(){
        clearMessages();
        boolean erro = false;
        try {
            clienteDao.delete(c);
        } catch (Exception e) {
            addErro("Não foi possível remover o registro");
            erro = true;
            printMessages(view, "Erro");
        }
        
        if(!erro){
            addMensagemSuceso("Removido");
            printMessages(view, "Confirmação");
            view.dispose();
        }
        
    }
}
