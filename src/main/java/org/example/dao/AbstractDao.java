/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.example.dao;

import java.util.List;

/**
 * Interface que especifica quais acoes devem ser implementadas pelo GenericDao
 * @author Davi Martins
 * @author Vinicius Fraga
 * @param <T>
 */
public interface AbstractDao<T> {
    
    public void create(T obj);  // n usando <T> antes do tipo de retorno
     
    public void update(T obj);
    
    public void delete(T obj);
    
    public T findById(Class<T> classe, Integer id); //Class<T> classe ou Class T Class<T> classe
    
    public List<T> findAll(Class<T> classe);
}
