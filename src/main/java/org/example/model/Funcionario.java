/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;


/**
 *
 * @author Davi Martins
 */
@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa implements Serializable{
    
    private double salario;
    
    @Column(name = "data_admissao")
    private Calendar dataAdmissao;
    
    private Cargo cargo;

    public Funcionario(){
        
    }

    public Funcionario(double salario, Calendar dataAdmissao, Cargo cargo, Integer id, String nome, String cpf, Calendar dataNascimento, String telefone, String email) {
        super(id, nome, cpf, dataNascimento, telefone, email);
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;
    }


   
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Calendar getData_admissao() {
        return dataAdmissao;
    }

    public void setData_admissao(Calendar data_admissao) {
        this.dataAdmissao = data_admissao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Calendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}
