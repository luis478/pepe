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
 * @author ADSI TARDE
 */
@Stateless
public class ProgramaFacade extends AbstractFacade<Programa> {

       //@NamedQuery(name = "Programa.encontrarCodigoVersion", query = "SELECT p FROM Programa p WHERE p.programaPK.codigo = :codigo AND p.programaPK.version = :version"),
    //@NamedQuery(name = "Programa.findByCodigo", query = "SELECT p FROM Programa p WHERE p.programaPK.codigo = :codigo"),
    //@NamedQuery(name = "Programa.encontrarNombrePrograma", query = "SELECT p FROM Programa p WHERE p.nombrePrograma LIKE :nombrePrograma"),  
//@NamedQuery(name = "Programa.findByNombrePrograma", query = "SELECT p FROM Programa p WHERE p.nombrePrograma like :nombrePrograma"),
    @PersistenceContext(unitName = "pepeAplicacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramaFacade() {
        super(Programa.class);
    }

    public List<Programa> autoCompletarNombre(String query) {
        Query q = getEntityManager().createNamedQuery("Programa.encontrarNombrePrograma");
        q.setParameter("nombrePrograma", query + "%");
        try {
            return (List<Programa>) q.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Programa consultaCodigoVersion(String c, String v) {
        Query q = getEntityManager().createNamedQuery("Programa.encontrarCodigoVersion");
        q.setParameter("codigo", c);
        q.setParameter("version", v);
        try {
            return (Programa) q.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Programa> consultaCodigo(String c) {
        Query q = getEntityManager().createNamedQuery("Programa.findByCodigo");
        q.setParameter("codigo", c);
        try {
            return (List<Programa>) q.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Programa> finByNombre(String nombrePrograma) {
        Query q = getEntityManager().createNamedQuery("Programa.findByNombrePrograma");
        q.setParameter("nombrePrograma", nombrePrograma + "%");
        return q.getResultList();
    }

}
