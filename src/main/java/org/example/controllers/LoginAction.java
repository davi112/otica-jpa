/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.example.controllers;

import org.example.model.Usuario;

/**
 * interface que especifica as acoes de login
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public interface LoginAction {
    
    public void logar();
    
    public boolean validatePassword(char[] senha, Usuario usuario);
}
