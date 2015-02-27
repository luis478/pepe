/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.controller;

import com.pepe.jpa.entities.Actividad;
import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.sesions.ActividadFacade;
import com.pepe.jpa.sesions.ProyectoFacade;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Adsit
 */
@ManagedBean
@SessionScoped
public class ActividadController implements Serializable {

    private Actividad actividadActual;
    private List<Actividad> listaActividad = null;
    @EJB
    private ProyectoFacade proyectoFacade;
    @EJB
    private ActividadFacade actividadFacade;

    public ActividadController() {
    }

    public Actividad getActividadActual() {
        if (actividadActual == null) {
            actividadActual = new Actividad();
        }
        return actividadActual;
    }

    public void setActividadActual(Actividad actividadActual) {
        this.actividadActual = actividadActual;
    }

    public List<Actividad> getListaActividad() {
        if (listaActividad == null) {
            try {
                listaActividad = getActividadFacade().findAll();
            } catch (Exception e){ 
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }

        }
        return listaActividad;
    }

    public ActividadFacade getActividadFacade() {
        return actividadFacade;
    }

    public void setActividadFacade(ActividadFacade actividadFacade) {
        this.actividadFacade = actividadFacade;
    }

    public void setListaActividad(List<Actividad> listaActividad) {
        this.listaActividad = listaActividad;
    }

    public ProyectoFacade getProyectoFacade() {
        return proyectoFacade;
    }

    public void setProyectoFacade(ProyectoFacade proyectoFacade) {
        this.proyectoFacade = proyectoFacade;
    }

    
    public  List<Proyecto> getListaProyectoSelectOne() {
        return getProyectoFacade().findAll();
    }
    
    private void recargarlista() {
        listaActividad = null;
    }
    
    public String prepareCreate(){
        actividadActual = new Actividad();
        return "Actividad/crear_actividad";
}
    public String prepareEdit (){
    return "";
}
    public String prepareView (){
    return "";
}
    public String prepareList (){
    recargarlista();
        return "";
}
    
    public String addActividad(){
        try{
        getActividadFacade().create(actividadActual);
        recargarlista();
        return "";
        }catch (Exception e){
        addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }
    
    public String updateActividad(){
        try{
        getActividadFacade().edit(actividadActual);
        recargarlista();
        return "";
        }catch (Exception e){
        addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }
    
    public String deleteActividad(){
        try{
        getActividadFacade().remove(actividadActual);
        recargarlista();
        return "";
        }catch (Exception e){
        addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return "";
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
    
     public Actividad getActividad(java.lang.Integer id) {
        return getActividadFacade().find(id);
    }
     public List<Actividad> getItemsAvailableSelectMany() {
        return getActividadFacade().findAll();
    }

    public List<Actividad> getItemsAvailableSelectOne() {
        return getActividadFacade().findAll();
    }
  @FacesConverter(forClass = Actividad.class)
    public static class ActividadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ActividadController controller = (ActividadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "actividadController");
            return controller.getActividad(getKey(value));
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
            if (object instanceof Actividad) {
                Actividad o = (Actividad) object;
                return getStringKey(o.getIdActividad());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Actividad.class.getName()});
                return null;
            }
        }

    }

    
    }
