/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controllers.cadastro;

import org.example.controllers.AbstractController;
import org.example.controllers.listagem.ListaVendaController;
import org.example.controllers.listagem.ListagemClienteController;
import org.example.controllers.listagem.ListagemFuncionarioController;
import org.example.controllers.listagem.ListagemProdutoController;
import org.example.model.Cargo;
import org.example.model.Funcionario;
import org.example.view.PainelFuncionarioForm;

import java.awt.event.ActionEvent;

/**
 * Classe principal após o login. Centraliza o acesso a todas as funcionalidades.
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class PainelFuncionarioController extends AbstractController<PainelFuncionarioForm> {

    private PainelFuncionarioForm view;
    private Funcionario f;

    public PainelFuncionarioController(Funcionario f) {
        view = new PainelFuncionarioForm();
        this.f = f;

        if (f.getCargo() == Cargo.VENDEDOR) {
            view.getMenuFuncCadastro().setVisible(false);
            view.getMenuFunc().setVisible(false);
        }
        
        if(f.getCargo() == Cargo.GERENTE){
            view.getMenuVenda().setVisible(false);
            view.getMenuVendaCadastro().setVisible(false);
        }   

        view.getListaCliente().addActionListener((ActionEvent e) -> {
            listarCliente();
        });

        view.getMenuClienteCadastro().addActionListener((ActionEvent e) -> {
            cadastrarCliente();
        });

        view.getMenuFuncCadastro().addActionListener((ActionEvent e) -> {
            cadastrarFuncionario();
        });

        view.getMenuFunc().addActionListener((ActionEvent e) -> {
            listarFuncionario();
        });

        view.getMenuProduto().addActionListener((ActionEvent e) -> {
            listarProdutos();
        });

        view.getMenuProdutoCadas().addActionListener((ActionEvent e) -> {
            cadastrarProduto();
        });

        view.getMenuVendaCadastro().addActionListener((ActionEvent e) -> {
            cadastrarVenda();
        });
        
        view.getMenuLogout().addActionListener((ActionEvent e) -> {
            logout();
        });
        
        view.getBtnExit().addActionListener(((ActionEvent e) -> {
            System.exit(0);
        }));
        
        view.getMenuVenda().addActionListener(((ActionEvent e) -> {
            listarVendas();
        }));
    }

    private void listarCliente() {
        new ListagemClienteController();
    }

    private void cadastrarCliente() {
        new CadastroClienteController();
    }

    private void cadastrarFuncionario() {
        new CadastroFuncionarioController();
    }

    private void listarFuncionario() {
        new ListagemFuncionarioController();
    }

    private void listarProdutos() {
        new ListagemProdutoController();
    }

    private void cadastrarProduto() {
        new CadastroProdutoController();
    }
    
    private void cadastrarVenda(){
        new CadastroVendaController();
    }
    
    private void logout(){
        view.dispose();
        new LoginController();
    }
    
    private void listarVendas(){
        new ListaVendaController();
    }
        
}
