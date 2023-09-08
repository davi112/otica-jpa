/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.controllers;

import org.example.utils.MessagesUtils;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe pra centralizar a adição das mensagens de erro e sucesso. Todos os controllers herdam dessa classe
 * @author Davi Martins
 * @author Vinicius Fraga
 * @param <T>
 */
public abstract class AbstractController<T> {
    
    private List<String> erros;
    private List<String> mensagensSucesso;
    
    public AbstractController(){
        erros = new ArrayList<>();
        mensagensSucesso = new ArrayList<>();
    }
    
    public AbstractController(List<String> erros){
        this.erros = erros;
    }

    public List<String> getErros() {
        return erros;
    }

    public void addErro(String error){
        erros.add(error);
    }
    
    public List<String> getMensagensSucesso(){
        return mensagensSucesso;
    }
    
    public void addMensagemSuceso(String mensagem){
        mensagensSucesso.add(mensagem);
    }
    
    public void clearMessages(){
        erros.clear();
        mensagensSucesso.clear();
    }
    
    /**
     * Formata as mensagens, sequencialmente, pulando uma linha
     * @param list, a lista de mensagens
     * @return todas as mensagens concatenadas
     */
    public String getMensagensFormatado(List<String> list){
        String result = "";
        for(String message : list){
            result += message + "\n";
        }
        return result;
    }
    
    /**
     * Chamada aos metodos da classe MessagesUtils, para imprimir ou erro ou mensagens de sucesso na tela
     * @param T, a view associada aos erros
     * @param titulo, O título da mensagem, a ser passado para o JOptionPane
     */
    public void printMessages(Component T, String titulo){
         if(!erros.isEmpty())
            MessagesUtils.showErrorMessages(T, getMensagensFormatado(erros), titulo);
         else if(!mensagensSucesso.isEmpty())
             MessagesUtils.showSucessMessages(T, getMensagensFormatado(mensagensSucesso), titulo);
    }
}
