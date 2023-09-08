/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.dao;

import org.example.utils.EntityManagerUtils;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Classe utilizando Generics do Java para centralizar a implementação das operações básicas de CRUD.
 * Todos os outros DAO's herdam dessa classe, e o tipo genérico T é typeSafe para cada dao específico.
 * @author Davi Martins
 * @author Vinicius Fraga
 * @param <T>
 */
public class GenericDao<T> implements AbstractDao<T>{
    
    private EntityManager entityManager;
     
    public GenericDao(){
        getEntityManager();
    }
    
    public final EntityManager getEntityManager(){
        if(entityManager == null)
              entityManager = EntityManagerUtils.getEntityManagerFactory().createEntityManager();
        
        return entityManager;
    }
    
    @Override
    public void create(T obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
    }

    @Override
    public T findById(Class<T> classe, Integer id) {
        return entityManager.find(classe, id);
    }

    @Override
    public void update(T obj) {
       entityManager.getTransaction().begin();
       entityManager.merge(obj);
       entityManager.getTransaction().commit();
    }

    @Override
    public void delete(T obj) {
        entityManager.getTransaction().begin();
        
        if(!entityManager.contains(obj))
            entityManager.remove(entityManager.merge(obj));
        
        entityManager.getTransaction().commit();
    }    

    @Override
    public List<T> findAll(Class<T> classe) { // ou Class<T> classe
        return entityManager.createQuery
        ("FROM " + classe.getName(), classe).getResultList();
    }   
}
