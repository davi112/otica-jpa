package org.example;

import org.example.controllers.cadastro.LoginController;
import org.example.dao.imp.FuncionarioDao;
import org.example.dao.imp.UsuarioDao;
import org.example.model.Cargo;
import org.example.model.Funcionario;
import org.example.model.Usuario;
import org.example.utils.AutenticacaoUtils;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Usuario u = new Usuario();
        u.setLogin("admin");
        AutenticacaoUtils aut = AutenticacaoUtils.getInstance();
        u.setSenha(aut.hash("admin"));
        UsuarioDao uDao = new UsuarioDao();
        uDao.create(u);


        Funcionario f = new Funcionario();
        f.setNome("admin");
        f.setCargo(Cargo.GERENTE);
        f.setDataAdmissao(Calendar.getInstance());
        f.setSalario(10000);
        f.setCpf("14832301632");
        f.setDataNascimento(Calendar.getInstance());
        f.setEmail("admin@admin.com");
        f.setTelefone("31997270845");



       FuncionarioDao fDao = new FuncionarioDao();
        f.setUsuario(u);
        fDao.create(f);



        LoginController loginController = new LoginController();
    }
}