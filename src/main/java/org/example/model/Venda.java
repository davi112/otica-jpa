/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Davi Martins
 */
@Entity
@Table(name="venda")
public class Venda implements Serializable {
    
    @Id
    @Column(name = "id_venda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private double valor;
    
    private double desconto;
   
    @Column(name = "forma_pagamento")
    private FormaPagamento formaPagamento;
    
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario vendedor;
    
    @ManyToMany
    @JoinTable(
           name = "itens_venda",
           joinColumns = { @JoinColumn(name = "id_venda") },
           inverseJoinColumns = { @JoinColumn (name = "id_produto")}
    )
    List<Produto> produtos = new ArrayList<Produto>();

    public Venda(){
        
    }
    
    public Venda(Integer id, double valor, double desconto, FormaPagamento formaPagamento, Cliente cliente, Funcionario vendedor, List<Produto> produtos) {
        this.id = id;
        this.valor = valor;
        this.desconto = desconto;
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.produtos = produtos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }   
}
