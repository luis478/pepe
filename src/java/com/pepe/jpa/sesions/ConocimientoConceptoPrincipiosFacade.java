/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.jpa.sesions;

import com.pepe.jpa.entities.Competencia;
import com.pepe.jpa.entities.ConocimientoConceptoPrincipios;
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
public class ConocimientoConceptoPrincipiosFacade extends AbstractFacade<ConocimientoConceptoPrincipios> {

    @PersistenceContext(unitName = "pepeAplicacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConocimientoConceptoPrincipiosFacade() {
        super(ConocimientoConceptoPrincipios.class);
    }

    public List<ConocimientoConceptoPrincipios> consulta(Competencia c) {
        Query q = getEntityManager().createNamedQuery("ConocimientoConceptoPrincipios.consultarCCP");
        q.setParameter("idCompetencia", c.getIdCompetencia());
        try {
            return q.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
