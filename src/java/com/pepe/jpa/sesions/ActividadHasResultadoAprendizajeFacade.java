/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.sesions;

import com.pepe.jpa.entities.Actividad;
import com.pepe.jpa.entities.ActividadHasResultadoAprendizaje;
import com.pepe.jpa.entities.Ficha;
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
public class ActividadHasResultadoAprendizajeFacade extends AbstractFacade<ActividadHasResultadoAprendizaje> {
    @PersistenceContext(unitName = "pepeAplicacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadHasResultadoAprendizajeFacade() {
        super(ActividadHasResultadoAprendizaje.class);
    }
    public List<ActividadHasResultadoAprendizaje> finByResultado(Actividad actividad) {
        Query q = getEntityManager().createNamedQuery("ActividadHasResultadoAprendizaje.findByIdActividad");
        q.setParameter("idActividad", actividad.getIdActividad());
        try {
            return (List<ActividadHasResultadoAprendizaje>) q.getResultList();
        } catch (NonUniqueResultException e) {
            System.out.println(e.getCause());
            return null;
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    public List<ActividadHasResultadoAprendizaje> findByIdActividadPoyecto(Ficha ficha){
        Query q= getEntityManager().createNamedQuery("ActividadHasResultadoAprendizaje.findByIdActividadPoyecto");
        q.setParameter("idProyecto", ficha.getIdProyecto().getIdProyecto());
           return q.getResultList();   
     }
}
