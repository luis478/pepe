/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.controller;


import com.pepe.jpa.entities.Actividad;
import com.pepe.jpa.entities.ActividadAprendizaje;
import com.pepe.jpa.entities.TecnicaDidactica;
import com.pepe.jpa.entities.TipoActividadAprendizaje;
import com.pepe.jpa.sesions.ActividadAprendizajeFacade;
import com.pepe.jpa.sesions.ActividadFacade;
import com.pepe.jpa.sesions.TecnicaDidacticaFacade;
import com.pepe.jpa.sesions.TipoActividadAprendizajeFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Luis Carlos
 */
@ManagedBean
@SessionScoped
public class ActividadAprendizajeController implements Serializable {

    @EJB
    private ActividadAprendizajeFacade actividadAprendizajeFacade;
    private ActividadAprendizaje actividadAprendizajeActual;
    private List<ActividadAprendizaje> listaActividadAprendizaje = null;
    private int actividadSelect;
    @EJB
    private ActividadFacade actividadFacade;
    private int tecnicaDidacticaSelect;
    @EJB
    private TecnicaDidacticaFacade TecnicaDidacticaFacade;
    private int tipoActividadAprendizajeSelect;
    @EJB
    private TipoActividadAprendizajeFacade tipoActividadAprendizajeFacade;
    /**
     * Creates a new instance of CiudadController
     */
    public ActividadAprendizajeController() {
    }

    public ActividadAprendizajeFacade getActividadAprendizajeFacade() {
        return actividadAprendizajeFacade;
    }
    public ActividadAprendizaje getActividadAprendizajeActual() {
        if (actividadAprendizajeActual == null) {
            actividadAprendizajeActual = new ActividadAprendizaje();
        }
        return actividadAprendizajeActual;
    }

    public void setActividadAprendizajeActual(ActividadAprendizaje actividadAprendizajeActual) {
        this.actividadAprendizajeActual = actividadAprendizajeActual;
    }

  
    public List<ActividadAprendizaje> getListaActividadAprendizaje() {
        if (listaActividadAprendizaje == null) {
            try {
                listaActividadAprendizaje = getActividadAprendizajeFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaActividadAprendizaje;
    }

    private void recargarLista() {
        listaActividadAprendizaje = null;
    }

    public String prepareCreate() {
        actividadAprendizajeActual = new ActividadAprendizaje();
        return "/planeacionpedagogica/FaseDeAnalisis/crear_actividadAprendizaje";
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

    public String addActividadAprendizaje() {
        try {
            actividadAprendizajeActual.setIdActividad(getActividadFacade().find(actividadSelect));
            actividadAprendizajeActual.setIdTecnicaDidactica(getTecnicaDidacticaFacade().find(tecnicaDidacticaSelect));
            actividadAprendizajeActual.setIdTipoActividadAprendizaje(getTipoActividadAprendizajeFacade().find(tipoActividadAprendizajeSelect));
            getActividadAprendizajeFacade().create(actividadAprendizajeActual);
            recargarLista();
            return "Admin_ListaActividadAprendizaje";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateActividadAprendizaje() {
        try {
            getActividadAprendizajeFacade().edit(actividadAprendizajeActual);
            recargarLista();
            return "Admin_ListaCategorias";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteActividadAprendizaje() {
        try {
            getActividadAprendizajeFacade().remove(actividadAprendizajeActual);
            recargarLista();
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
        }
        return "List";
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

     // Select one menu Actividad
    public int getActividadSelect() {
        if(actividadAprendizajeActual!=null && actividadAprendizajeActual.getIdActividad()!= null){
            actividadSelect=actividadAprendizajeActual.getIdActividadAprendizaje();
        }
        return actividadSelect;
    }

    public void setActividadSelect(int actividadSelect) {
        this.actividadSelect = actividadSelect;
    }

    public ActividadFacade getActividadFacade() {
        return actividadFacade;
    }

    public void setActividadFacade(ActividadFacade actividadFacade) {
        this.actividadFacade = actividadFacade;
    }
     public List<Actividad> getListaActividadSelectOne() {
        return getActividadFacade().findAll();
    }
     
     // Select one menu Tecnica Didactica

    public int getTecnicaDidacticaSelect() {
        if(actividadAprendizajeActual!=null && actividadAprendizajeActual.getIdTecnicaDidactica()!= null){
            tecnicaDidacticaSelect=actividadAprendizajeActual.getIdActividadAprendizaje();
        }
        return tecnicaDidacticaSelect;
    }

    public void setTecnicaDidacticaSelect(int tecnicaDidacticaSelect) {
        this.tecnicaDidacticaSelect = tecnicaDidacticaSelect;
    }

    public TecnicaDidacticaFacade getTecnicaDidacticaFacade() {
        return TecnicaDidacticaFacade;
    }

    public void setTecnicaDidacticaFacade(TecnicaDidacticaFacade TecnicaDidacticaFacade) {
        this.TecnicaDidacticaFacade = TecnicaDidacticaFacade;
    }
    
    public List<TecnicaDidactica> getListaTecnicaDidacticaSelectOne() {
        return getTecnicaDidacticaFacade().findAll();
    }
     
    // Select one menu Tipo actividad aprendizaje

    public int getTipoActividadAprendizajeSelect() {
         if(actividadAprendizajeActual!=null && actividadAprendizajeActual.getIdTipoActividadAprendizaje()!= null){
            tipoActividadAprendizajeSelect=actividadAprendizajeActual.getIdActividadAprendizaje();
        }
        return tipoActividadAprendizajeSelect;
    }

    public void setTipoActividadAprendizajeSelect(int tipoActividadAprendizajeSelect) {
        this.tipoActividadAprendizajeSelect = tipoActividadAprendizajeSelect;
    }

    public TipoActividadAprendizajeFacade getTipoActividadAprendizajeFacade() {
        return tipoActividadAprendizajeFacade;
    }

    public void setTipoActividadAprendizajeFacade(TipoActividadAprendizajeFacade tipoActividadAprendizajeFacade) {
        this.tipoActividadAprendizajeFacade = tipoActividadAprendizajeFacade;
    }
    
    public List<TipoActividadAprendizaje> getListaTipoActividadAprendizajeSelectOne() {
        return getTipoActividadAprendizajeFacade().findAll();
    }
    
}
