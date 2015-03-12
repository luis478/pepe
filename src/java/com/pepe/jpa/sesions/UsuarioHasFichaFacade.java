/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.sesions;

import com.pepe.jpa.entities.Programa;
import com.pepe.jpa.entities.UsuarioHasFicha;
import com.pepe.jpa.entities.Usuario;
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
public class UsuarioHasFichaFacade extends AbstractFacade<UsuarioHasFicha> {
    @PersistenceContext(unitName = "pepeAplicacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioHasFichaFacade() {
        super(UsuarioHasFicha.class);
    }
    
     public UsuarioHasFicha finByNombre(String ficha){
        Query q= getEntityManager().createNamedQuery("UsuarioHasFicha.findByTipoInstructor");
        q.setParameter("codigoFicha", ficha);
         try {
           return (UsuarioHasFicha)q.getSingleResult();  
         } catch (NonUniqueResultException e) {
             System.out.println(e.getCause());
               return null;
         }
        catch(NoResultException e){
            System.out.println(e.getCause());
              return null;
        }
    }
     
     public List<Usuario> finByUsuario(String ficha){
        Query q= getEntityManager().createNamedQuery("UsuarioHasFicha.findByUsuario");
        q.setParameter("codigoFicha", ficha);
         
           return q.getResultList();  
  
    }
    
}
