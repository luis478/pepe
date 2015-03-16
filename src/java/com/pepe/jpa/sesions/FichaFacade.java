/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.jpa.sesions;

import com.pepe.jpa.entities.Ficha;
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
public class FichaFacade extends AbstractFacade<Ficha> {

    @PersistenceContext(unitName = "pepeAplicacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichaFacade() {
        super(Ficha.class);
    }
//@NamedQuery(name = "Ficha.consultaFP", query = "SELECT f FROM Ficha f WHERE f.programa.programaPK.codigo = :codigo AND f.programa.programaPK.version = :version AND f.idProyecto.idProyecto = NULL"),
    public List<Ficha> consultaFichaPrograma(Programa p) {
        Query q = getEntityManager().createNamedQuery("Ficha.consultaFP");
        q.setParameter("codigo", p.getProgramaPK().getCodigo());
        q.setParameter("version", p.getProgramaPK().getVersion());
        try {
            return q.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    //@NamedQuery(name = "Ficha.findByCodigoFicha", query = "SELECT f FROM Ficha f WHERE f.codigoFicha = :codigoFicha"),
    public Ficha getByCodigoFicha(String c) {
        Query q = getEntityManager().createNamedQuery("Ficha.findByCodigoFicha");
        q.setParameter("codigoFicha", c);
        try {
            return (Ficha) q.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
