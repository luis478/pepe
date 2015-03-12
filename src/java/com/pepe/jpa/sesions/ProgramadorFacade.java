/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.jpa.sesions;

import com.pepe.jpa.entities.Programador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ADSI TARDE
 */
@Stateless
public class ProgramadorFacade extends AbstractFacade<Programador> {
    @PersistenceContext(unitName = "pepeAplicacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramadorFacade() {
        super(Programador.class);
    }
    
     public List<Programador> findByUsuarioP(String programador){
        Query q= getEntityManager().createNamedQuery("Programador.findByUsuarioP");
        q.setParameter("idProgramador", programador);
         
           return q.getResultList();  
  
    }
    
   
    
}