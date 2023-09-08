/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Classe facilitadora das operações com datas
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class DataUtils {

    /**
     * @param data, a String a ser convertida para um objeto de data Calendar
     * @return a data
     */
    public static Calendar parse(String data) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

        Calendar dataNascimento = Calendar.getInstance();
        try {
            dataNascimento.setTime(f.parse(data));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return dataNascimento;
    }
  
    /**
     * Oposto do método parse. Recebe uma data e converte pra String.
     * @param calendar, a data a ser convertida para uma string
     * @return a data, formatada no padrão dd/MM/yyyy.Ex.: 01/01/1999
     */
    public static String toString(Calendar calendar){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return f.format(calendar.getTime());
    }

}
