/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.model;

//import java.io.Serializable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 * @author Davi Martins
 * @author Vinicius Fraga
 */
@Entity
@Table(name="cliente")
public class Cliente extends Pessoa implements Serializable{
  

    @Column(name = "data_cadastro")
    private Calendar dataCadastro;
    
    @Column(name = "possui_receita")
    private boolean possuiReceita;
    
    
    @OneToMany(mappedBy = "cliente")
    private List<Receita> receitas = new ArrayList<>();

    public Cliente(){
        
    }

    public Cliente(Calendar dataCadastro, boolean possuiReceita, Integer id, String nome, String cpf, Calendar dataNascimento, String telefone, String email) {
        super(id, nome, cpf, dataNascimento, telefone, email);
        this.dataCadastro = dataCadastro;
        this.possuiReceita = possuiReceita;
    }
    
     
    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isPossuiReceita() {
        return possuiReceita;
    }

    public void setPossuiReceita(boolean possuiReceita) {
        this.possuiReceita = possuiReceita;
    }   

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
}
