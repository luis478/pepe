/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.sesions;

import com.pepe.jpa.entities.Competencia;
import com.pepe.jpa.entities.ConocimientoProceso;
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
public class ConocimientoProcesoFacade extends AbstractFacade<ConocimientoProceso> {
    @PersistenceContext(unitName = "pepeAplicacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConocimientoProcesoFacade() {
        super(ConocimientoProceso.class);
    }
    
    //@NamedQuery(name = "ConocimientoProceso.consultaCP", query = "SELECT c FROM ConocimientoProceso c WHERE c.idCompetencia.idCompetencia = :idCompetencia AND c.estado = 1"),
    public List<ConocimientoProceso> consulta(Competencia c) {
        Query q = getEntityManager().createNamedQuery("ConocimientoProceso.consultaCP");
        q.setParameter("idCompetencia", c.getIdCompetencia());
        try {
            return q.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}

