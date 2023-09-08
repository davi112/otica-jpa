package org.example.utils;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Singleton para auxiliar no processo de autenticação. Utiliza o algoritmo Pbkdf2 para encriptar a senha
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class AutenticacaoUtils {
    
    private static AutenticacaoUtils autenticacao;
    private final Pbkdf2PasswordEncoder pbkdf2PasswordEncoder;
    
    private AutenticacaoUtils(){
        pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
    }
    
    public static AutenticacaoUtils getInstance(){
        if(autenticacao == null){
            autenticacao = new AutenticacaoUtils();
        }
        return autenticacao;
    }
    
    /**
     * 
     * @param senha, String a ser codificada
     * @return a codificação da senha, chamada ao metodo implementado pelo Encoder Pbkdf2.
     */
    public final String hash(String senha){
        return pbkdf2PasswordEncoder.encode(senha);
    }
    
    /**
     * @param senha, a senha informada pelo usuário na tela de login
     * @param pbkdf2CryptedPassword, a senha do usuário armzenada no banco
     * @return verdadeiro, se as senhas corresponderem, falso, caso contrarios
     */
    public boolean isPasswordValid(String senha, String pbkdf2CryptedPassword){
        return pbkdf2PasswordEncoder.matches(senha, pbkdf2CryptedPassword);
    }

    public Pbkdf2PasswordEncoder getPbkdf2PasswordEncoder() {
        return pbkdf2PasswordEncoder;
    }
}
