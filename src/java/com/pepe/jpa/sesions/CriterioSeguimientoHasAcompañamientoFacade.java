/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.sesions;

import com.pepe.jpa.entities.CriterioSeguimientoHasAcompañamiento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Windows 8
 */
@Stateless
public class CriterioSeguimientoHasAcompañamientoFacade extends AbstractFacade<CriterioSeguimientoHasAcompañamiento> {
    @PersistenceContext(unitName = "pepeAplicacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CriterioSeguimientoHasAcompañamientoFacade() {
        super(CriterioSeguimientoHasAcompañamiento.class);
    }
    
}
