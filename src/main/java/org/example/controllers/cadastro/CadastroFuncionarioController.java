/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controllers.cadastro;

import org.example.controllers.AbstractController;
import org.example.dao.imp.FuncionarioDao;
import org.example.model.Cargo;
import org.example.model.Funcionario;
import org.example.utils.DataUtils;
import org.example.view.CadastroFuncionarioForm;

import java.awt.event.ActionEvent;

/**
 *
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class CadastroFuncionarioController extends AbstractController<Funcionario> {

    private CadastroFuncionarioForm view;
    private Funcionario f;
    private FuncionarioDao funcionarioDao;

    public CadastroFuncionarioController() {

        view = new CadastroFuncionarioForm();
        f = new Funcionario();

        view.getBtnCadastrar().addActionListener((ActionEvent e) -> {
            cadastrar();
        });

        view.getBtnExit().addActionListener((ActionEvent e) -> {
            view.dispose();
        });

    }

    public CadastroFuncionarioController(Funcionario f) {

        view = new CadastroFuncionarioForm();
        this.f = f;

        view.getBtnCadastrar().setText("SALVAR");

        preencheDados(f);
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

        view.getBtnExit().addActionListener((ActionEvent e) -> {
            view.dispose();
        });

        view.getBtnRemove().addActionListener((ActionEvent e) -> {
            remove();
        });
    }

    private void habilitaBotoes(boolean habilita) {
        view.getBtnEditar().setEnabled(habilita);
        view.getBtnCadastrar().setEnabled(!habilita);
        view.getBtnExit().setEnabled(habilita);
        view.getBtnRemove().setEnabled(habilita);
    }

    private void preencheDados(Funcionario f) {
        view.getTxtCpf1().setText(f.getCpf());
        view.getTxtNome1().setText(f.getNome());
        view.getTxtDataNascimento1().setText(DataUtils.toString(f.getDataNascimento()));
        view.getTxtTelefone().setText(f.getTelefone());
        view.getTxtEmail().setText(f.getEmail());
        view.getTxtSalario().setText(Double.toString(f.getSalario()));
        view.getComboCargo().setSelectedItem(f.getCargo().toString());
        view.getTxtDataAdmissao().setText(DataUtils.toString(f.getDataAdmissao()));
    }

    private void habilitaCampos(boolean habilita) {
        view.getTxtCpf1().setEnabled(habilita);
        view.getTxtNome1().setEnabled(habilita);
        view.getTxtDataNascimento1().setEnabled(habilita);
        view.getTxtTelefone().setEnabled(habilita);
        view.getTxtEmail().setEnabled(habilita);
        view.getTxtDataAdmissao().setEnabled(habilita);
        view.getComboCargo().setEnabled(false);
        view.getTxtSalario().setEnabled(habilita);
    }

    private void cadastrar() {

        if (validaCampos()) {

            f.setNome(view.getTxtNome1().getText());

            if (view.getComboCargo().getSelectedItem() == Cargo.GERENTE.toString()) {
                f.setCargo(Cargo.GERENTE);
            } else {
                f.setCargo(Cargo.VENDEDOR);
            }
            f.setCpf(view.getTxtCpf1().getText().replaceAll("[.-]", ""));
            f.setDataAdmissao(DataUtils.parse(view.getTxtDataAdmissao().getText()));
            f.setDataNascimento(DataUtils.parse(view.getTxtDataNascimento1().getText()));
            f.setTelefone(view.getTxtTelefone().getText());
            f.setEmail(view.getTxtEmail().getText());
            f.setSalario(Double.parseDouble(view.getTxtSalario().getText()));

            clearMessages();
            boolean erro = false;
            funcionarioDao = new FuncionarioDao();

            try {
                if (f.getId() != null) {
                    funcionarioDao.update(f);
                }else{
                    funcionarioDao.create(f);
                }
            } catch (Exception e) {
                erro = true;
                addErro("Não foi possível salvar o funcionario");
                e.printStackTrace();
                printMessages(view, "Erro");
            }

            if (!erro) {
                addMensagemSuceso("Funcionario salvo com suscesso");
                printMessages(view, "Funcionario cadastrado");
            }
        }

    }

    private boolean validaCampos() {
        clearMessages();
        if (view.getTxtCpf1().getText().isEmpty()) {

            addErro("CPF INVALIDO");

        }
        if (view.getTxtEmail().getText().isEmpty()) {

            addErro("EMAIL INVALIDO");
        }
        if (view.getTxtNome1().getText().isEmpty()) {

            addErro("NOME INVALIDO");
        }
        if (view.getTxtDataNascimento1().getText().isEmpty()) {

            addErro("DATA DE NASCIMENTO INVALIDA");
        }
        if (view.getTxtDataAdmissao().getText().isEmpty()) {

            addErro("DATA DE ADMISSAO INVALIDA");
        }
        if (view.getTxtTelefone().getText().isEmpty()) {

            addErro("TELEFONE INVALIDO");
        }
        if (getErros().isEmpty()) {
            return true;

        } else {
            printMessages(view, "Erros no cadastro de funcionario");
            return false;
        }

    }

    private void remove() {
        clearMessages();
        boolean erro = false;

        funcionarioDao = new FuncionarioDao();
        try {
            funcionarioDao.delete(f);
        } catch (Exception e) {
            erro = true;
            addErro("Não foi possível excluir o registro");
            e.printStackTrace();
            printMessages(view, "Erro");
        }

        if (!erro) {
            addMensagemSuceso("Funcionário removido");
            printMessages(view, "Confirmação");
            view.dispose();
        }
    }

}
