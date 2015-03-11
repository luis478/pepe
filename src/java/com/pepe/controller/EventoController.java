/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.Evento;
import com.pepe.jpa.entities.Fase;
import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.sesions.ActividadAprendizajeFacade;
import com.pepe.jpa.sesions.ActividadFacade;
import com.pepe.jpa.sesions.CompetenciaFacade;
import com.pepe.jpa.sesions.EventoFacade;
import com.pepe.jpa.sesions.FaseFacade;
import com.pepe.jpa.sesions.ProyectoFacade;
import com.pepe.jpa.sesions.ResultadoAprendizajeFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ADSI TARDE
 */
@ManagedBean
@SessionScoped
public class EventoController {

    @EJB
    private ResultadoAprendizajeFacade resultadoAprendizajeFacade;
    @EJB
    private FaseFacade faseFacade; 
    @EJB
    private ActividadAprendizajeFacade actividadAprendizajeFacade;
    @EJB
    private CompetenciaFacade competenciaFacade;
    @EJB
    private EventoFacade eventoFacade;
    @EJB
    private ActividadFacade actividadFacade;
    @EJB
    private ProyectoFacade ProyectoFacade;
    
    private Evento eventoActual;
    private List<Evento> listaEvento =null;
    private Proyecto proyectoActual;

    public ActividadFacade getActividadFacade() {
        return actividadFacade;
    }

    public void setActividadFacade(ActividadFacade actividadFacade) {
        this.actividadFacade = actividadFacade;
    }

    public ProyectoFacade getProyectoFacade() {
        return ProyectoFacade;
    }

    public void setProyectoFacade(ProyectoFacade ProyectoFacade) {
        this.ProyectoFacade = ProyectoFacade;
    }

    public List<Evento> getListaEvento() {
        return listaEvento;
    }

    public void setListaEvento(List<Evento> listaEvento) {
        this.listaEvento = listaEvento;
    }

    public Proyecto getProyectoActual() {
        return proyectoActual;
    }

    public void setProyectoActual(Proyecto proyectoActual) {
        this.proyectoActual = proyectoActual;
    }
    

    public EventoController() {
    }

    public EventoFacade getEventoFacade() {
        return eventoFacade;
    }

    public void setEventoFacade(EventoFacade eventoFacade) {
        this.eventoFacade = eventoFacade;
    }

    public Evento getEventoActual() {
        return eventoActual;
    }

    public void setEventoActual(Evento eventoActual) {
        this.eventoActual = eventoActual;
    }

    
    
    public ResultadoAprendizajeFacade getResultadoAprendizajeFacade() {
        return resultadoAprendizajeFacade;
    }

    public void setResultadoAprendizajeFacade(ResultadoAprendizajeFacade resultadoAprendizajeFacade) {
        this.resultadoAprendizajeFacade = resultadoAprendizajeFacade;
    }

    public FaseFacade getFaseFacade() {
        return faseFacade;
    }

    public void setFaseFacade(FaseFacade faseFacade) {
        this.faseFacade = faseFacade;
    }

    public ActividadAprendizajeFacade getActividadAprendizajeFacade() {
        return actividadAprendizajeFacade;
    }

    public void setActividadAprendizajeFacade(ActividadAprendizajeFacade actividadAprendizajeFacade) {
        this.actividadAprendizajeFacade = actividadAprendizajeFacade;
    }



    public CompetenciaFacade getCompetenciaFacade() {
        return competenciaFacade;
    }

    public void setCompetenciaFacade(CompetenciaFacade competenciaFacade) {
        this.competenciaFacade = competenciaFacade;
    }

      private void recargarLista() {
        listaEvento = null;
    }

    public String prepareCreate() {
      
        return "";
    }

    public String prepareEdit() {
        return "";
    }

    public String prepareView() {
        return "";
    }

    public String prepareList() {
        recargarLista();
        return "";
    }
    
      public String addEvento() {
         try {
            getEventoFacade().create(eventoActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
        
        }
    
    
   
    
     private void addErrorMessage(String title, String msg) {
        FacesMessage facesMsg
                = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    private void addSuccessMessage(String title, String msg) {
        FacesMessage facesMsg
                = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
    
    public Evento getEvento(java.lang.Integer id) {
        return getEventoFacade().find(id);
    }

    @FacesConverter(forClass = Evento.class)
    public static class EventoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EventoController controller = (EventoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "eventoController");
            return controller.getEvento(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Evento) {
                Evento o = (Evento) object;
                return getStringKey(o.getIdEvento());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Evento.class.getName());
            }
        }

    }
    
}
