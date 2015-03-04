/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.sesions;

import com.pepe.jpa.entities.ActividadAprendizaje;
import com.pepe.jpa.entities.Fase;
import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.entities.UsuarioHasFicha;
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
public class ActividadAprendizajeFacade extends AbstractFacade<ActividadAprendizaje> {
    @PersistenceContext(unitName = "pepeAplicacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadAprendizajeFacade() {
        super(ActividadAprendizaje.class);
    }
    public List<ActividadAprendizaje> consultaPlaneacion(Fase idFase, Proyecto idProyecto){
        Query q= getEntityManager().createNamedQuery("ActividadAprendizaje.findByFase");
        q.setParameter("idFase", idFase);
        q.setParameter("idProyecto", idProyecto);
        return q.getResultList();
    }
}
