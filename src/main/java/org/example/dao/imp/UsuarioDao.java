/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.dao.imp;

import org.example.dao.GenericDao;
import org.example.model.Usuario;

import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author Davi Martins
 * @author Vinicius Fraga
 */
public class UsuarioDao extends GenericDao<Usuario> {

    public UsuarioDao() {
        super();
    }

    /**
     * Encontra o usuario pelo login
     * @param login, String contendo o nome de usuario
     * @return unico usuario que corresponde a esse login na base de dados
     */
    public Usuario findByLogin(String login) {
        Query query = getEntityManager().createQuery("FROM " + Usuario.class.getName()
                + " WHERE login = :login", Usuario.class);

        query.setParameter("login", login);

        List<Usuario> list = query.getResultList();
        return list.isEmpty() ? null : list.get(0);
    }

}
