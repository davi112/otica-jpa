/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controllers.cadastro;

import org.example.controllers.AbstractController;
import org.example.controllers.LoginAction;
import org.example.dao.imp.UsuarioDao;
import org.example.model.Usuario;
import org.example.utils.AutenticacaoUtils;
import org.example.view.LoginForm;

import java.awt.event.ActionEvent;

/**
 * Classe pra centralizar as operacoes de Login
 *
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class LoginController extends AbstractController<LoginForm> implements LoginAction {

    private LoginForm view;
    private UsuarioDao usuarioDao;
    private AutenticacaoUtils autenticacao;

    public LoginController() {

        usuarioDao = new UsuarioDao();
        autenticacao = AutenticacaoUtils.getInstance();
        view = new LoginForm();

        view.getBtnLogin().addActionListener((ActionEvent e) -> {
            clearMessages();
            logar();
            printMessages(view, "Informações de login");
        });

        view.getBtnSair().addActionListener((ActionEvent e) -> {
            view.setVisible(false);
            view.dispose();
            System.exit(0);
        });
    }

    /**
     * Método que realiza as validações de login e imprime as Mensagens;
     */
    @Override
    public void logar() {

        Usuario usuario = null;
        String login = view.getTxtUserName().getText();
        char[] password = view.getTxtPassword().getPassword();

        if (login.isBlank() || password.length == 0) {
            addErro("Usuário ou senha não podem ser vazios!");
            return; //parar a execução
        }

        usuario = usuarioDao.findByLogin(login);

        if (usuario == null) {
            addErro("Usuário não encontrado");
        } else if (validatePassword(password, usuario)) {
            addMensagemSuceso("Logado com sucesso!");
            redirect(usuario);
        } else {
            addErro("Senha inválida !");
        }

    }

    @Override
    public boolean validatePassword(char[] password, Usuario usuario) {
        return autenticacao.isPasswordValid(String.valueOf(password), usuario.getSenha());
    }

    /**
     * Redireciona o usuario para tela principal do sistema
     *
     * @param usuario
     */
    public void redirect(Usuario usuario) {
        view.dispose();
        new PainelFuncionarioController(usuario.getPessoaFuncionario());
    }

}
