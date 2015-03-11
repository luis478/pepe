/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.sesions;

import com.pepe.jpa.entities.Actividad;
import com.pepe.jpa.entities.Fase;
import com.pepe.jpa.entities.Proyecto;
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
public class ActividadFacade extends AbstractFacade<Actividad> {
    @PersistenceContext(unitName = "pepeAplicacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadFacade() {
        super(Actividad.class);
    }
     public List<Actividad> consultaPlaneacionActividades(Fase idFase, Proyecto idProyecto){
        Query q= getEntityManager().createNamedQuery("Actividad.findByActividadesProyecto");
        q.setParameter("idFase", idFase);
        q.setParameter("idProyecto", idProyecto);
        return q.getResultList();
    }
      public List<Actividad> consultaActividad(Actividad idActividad){
        Query q= getEntityManager().createNamedQuery("Actividad.findByIdActividad");
        q.setParameter("idActividad", idActividad);
        return q.getResultList();
    }
}
