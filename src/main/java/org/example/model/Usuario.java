/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;


/**
 *
 * @author Davi Martins
 */
@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String login;
    
    private String senha;
    
    @OneToOne(mappedBy = "usuario")
    private Funcionario pessoaFuncionario;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getPessoaFuncionario() {
        return pessoaFuncionario;
    }

    public void setPessoaFuncionario(Funcionario pessoaFuncionario) {
        this.pessoaFuncionario = pessoaFuncionario;
    } 
}
