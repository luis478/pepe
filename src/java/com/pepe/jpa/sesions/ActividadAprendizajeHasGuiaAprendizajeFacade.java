/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.sesions;

import com.pepe.jpa.entities.ActividadAprendizajeHasGuiaAprendizaje;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ADSI TARDE
 */
@Stateless
public class ActividadAprendizajeHasGuiaAprendizajeFacade extends AbstractFacade<ActividadAprendizajeHasGuiaAprendizaje> {
    @PersistenceContext(unitName = "pepeAplicacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadAprendizajeHasGuiaAprendizajeFacade() {
        super(ActividadAprendizajeHasGuiaAprendizaje.class);
    }
    
}
