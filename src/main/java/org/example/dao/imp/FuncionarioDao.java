/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.dao.imp;

import org.example.dao.GenericDao;
import org.example.model.Cargo;
import org.example.model.Funcionario;

import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class FuncionarioDao extends GenericDao<Funcionario> {
    
    public FuncionarioDao(){
        super();
    }
    /**
     * retorna a lista de funcionarios, de acordo com o cargo passado 
     * por parametro
     * @see Cargo
     */
    public List<Funcionario> findAllByCargo(Cargo cargo){
        Query query = getEntityManager().createQuery("FROM " + Funcionario.class.getName()
                + " WHERE cargo = :cargo ", Funcionario.class);
        query.setParameter("cargo", cargo);
        return query.getResultList();
    }
}
