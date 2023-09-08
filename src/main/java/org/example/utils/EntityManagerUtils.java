/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Singleton para centralizar a criação do EntityManagerFactory
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class EntityManagerUtils {
    
    private static EntityManagerFactory factory;
    
    public static EntityManagerFactory getEntityManagerFactory(){
        if (factory == null)
            factory = Persistence.createEntityManagerFactory("my-persistence-unit");
        return factory;
    }
}
