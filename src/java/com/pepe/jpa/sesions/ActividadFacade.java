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
//@NamedQuery(name = "Actividad.findByActividadesProyecto", query = "SELECT a FROM Actividad a WHERE a.idProyecto = :idProyecto AND a.idFase = :idFase"),

    public List<Actividad> consultaPlaneacionActividades(Fase idFase, Proyecto idProyecto) {
        Query q = getEntityManager().createNamedQuery("Actividad.findByActividadesProyecto");
        q.setParameter("idFase", idFase);
        q.setParameter("idProyecto", idProyecto);
        try {
            return (List<Actividad>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
//@NamedQuery(name = "Actividad.findByIdActividad", query = "SELECT a FROM Actividad a WHERE a.idActividad = :idActividad"),

    public List<Actividad> consultaActividad(Actividad idActividad) {
        Query q = getEntityManager().createNamedQuery("Actividad.findByIdActividad");
        q.setParameter("idActividad", idActividad);
        try {
            return (List<Actividad>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public List<Actividad> consultaActividadProyecto(int proyecto, int fase) {
        Query q = null;
        switch (fase) {
            case 1:
                q = getEntityManager().createNamedQuery("Actividad.buscarActividadProyecto1");
                q.setParameter("idProyecto", proyecto);
                break;
            case 2:
                q = getEntityManager().createNamedQuery("Actividad.buscarActividadProyecto2");
                q.setParameter("idProyecto", proyecto);
                break;
            case 3:
                q = getEntityManager().createNamedQuery("Actividad.buscarActividadProyecto3");
                q.setParameter("idProyecto", proyecto);
                break;
            case 4:
                q = getEntityManager().createNamedQuery("Actividad.buscarActividadProyecto4");
                q.setParameter("idProyecto", proyecto);
                break;
            default:
                q = getEntityManager().createNamedQuery("Actividad.buscarActividadProyecto");
                q.setParameter("idProyecto", proyecto);
        }
        try {
            return (List<Actividad>) q.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
