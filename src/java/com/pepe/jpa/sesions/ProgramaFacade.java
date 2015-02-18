/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.sesions;

import com.pepe.jpa.entities.Programa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Windows 8
 */
@Stateless
public class ProgramaFacade extends AbstractFacade<Programa> {
    @PersistenceContext(unitName = "pepeAplicacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramaFacade() {
        super(Programa.class);
    }
    
    public List<Programa> autoCompletarNombre(String query){
        Query q = getEntityManager().createNamedQuery("Programa.encontrarNombrePrograma");
        q.setParameter("nombrePrograma", query + "%");
        try{
            return (List<Programa>) q.getResultList();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
