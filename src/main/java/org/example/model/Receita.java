/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;


/**
 *
 * @author Davi Martins
 */
@Entity
@Table(name="receita")
public class Receita implements Serializable {

    @Id
    @Column(name = "id_receita")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int esfericoOD;

    private int esfericoOE;

    private int cilindricoOD;

    private int cilindricoOE;

    private int eixoOD;

    private int eixoOE;

    private double adicao;

    @Column(name = "distancia_pupilar")
    private double distanciaPupilar;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Receita() {

    }

    public Receita(Integer id, int esfericoOD, int esfericoOE, int cilindricoOD, int cilindricoOE, int eixoOD, int eixoOE, double adicao, double distanciaPupilar, Cliente cliente) {
        this.id = id;
        this.esfericoOD = esfericoOD;
        this.esfericoOE = esfericoOE;
        this.cilindricoOD = cilindricoOD;
        this.cilindricoOE = cilindricoOE;
        this.eixoOD = eixoOD;
        this.eixoOE = eixoOE;
        this.adicao = adicao;
        this.distanciaPupilar = distanciaPupilar;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEsfericoOD() {
        return esfericoOD;
    }

    public void setEsfericoOD(int esfericoOD) {
        this.esfericoOD = esfericoOD;
    }

    public int getEsfericoOE() {
        return esfericoOE;
    }

    public void setEsfericoOE(int esfericoOE) {
        this.esfericoOE = esfericoOE;
    }

    public int getCilindricoOD() {
        return cilindricoOD;
    }

    public void setCilindricoOD(int cilindricoOD) {
        this.cilindricoOD = cilindricoOD;
    }

    public int getCilindricoOE() {
        return cilindricoOE;
    }

    public void setCilindricoOE(int cilindricoOE) {
        this.cilindricoOE = cilindricoOE;
    }

    public int getEixoOD() {
        return eixoOD;
    }

    public void setEixoOD(int eixoOD) {
        this.eixoOD = eixoOD;
    }

    public int getEixoOE() {
        return eixoOE;
    }

    public void setEixoOE(int eixoOE) {
        this.eixoOE = eixoOE;
    }

    public double getAdicao() {
        return adicao;
    }

    public void setAdicao(double adicao) {
        this.adicao = adicao;
    }

    public double getDistanciaPupilar() {
        return distanciaPupilar;
    }

    public void setDistanciaPupilar(double distanciaPupilar) {
        this.distanciaPupilar = distanciaPupilar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
