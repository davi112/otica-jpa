/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Classe pra centralizar a exibição de mensagens de erro e de sucesso
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class MessagesUtils {

    public static void showErrorMessages(Component parent, String erros, String titulo) {
        JOptionPane.showMessageDialog(parent, erros, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void showSucessMessages(Component parent, String mensagens, String titulo) {
        JOptionPane.showMessageDialog(parent, mensagens, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
