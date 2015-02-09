package com.pepe.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pepe.jpa.entities.EstiloAprendizaje;
import com.pepe.jpa.sesions.EstiloAprendizajeFacade;
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
 * @author Windows 8
 */
@ManagedBean
@SessionScoped
public class EstiloAprendizajeController {

   @EJB
    private EstiloAprendizajeFacade estiloAprendizajeFacade;
    private EstiloAprendizaje estiloAprendizajeActual;
    private List<EstiloAprendizaje> listaEstiloAprendizaje = null;

    /**
     * Creates a new instance of CiudadController
     */
    public EstiloAprendizajeController() {
    }

    public EstiloAprendizajeFacade getEstiloAprendizajeFacade() {
        return estiloAprendizajeFacade;
    }
    public EstiloAprendizaje getEstiloAprendizajeActual() {
        if (estiloAprendizajeActual == null) {
            estiloAprendizajeActual = new EstiloAprendizaje();
        }
        return estiloAprendizajeActual;
    }

    public void setEstiloAprendizajeActual(EstiloAprendizaje estiloAprendizajeActual) {
        this.estiloAprendizajeActual = estiloAprendizajeActual;
    }

  
    public List<EstiloAprendizaje> getListaEstiloAprendizaje() {
        if (listaEstiloAprendizaje == null) {
            try {
                listaEstiloAprendizaje = getEstiloAprendizajeFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaEstiloAprendizaje;
    }

    private void recargarLista() {
        listaEstiloAprendizaje = null;
    }

    public String prepareCreate() {
        estiloAprendizajeActual = new EstiloAprendizaje();
        return "/admin/crear_estiloAprendizaje";
    }

    public String prepareEdit() {
        return "";
    }

    public String prepareView() {
        return "View";
    }

    public String prepareList() {
        recargarLista();
        return "";
    }

    public String addEstiloAprendizaje() {
        try {

            getEstiloAprendizajeFacade().create(estiloAprendizajeActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateEstiloAprendizaje() {
        try {
            getEstiloAprendizajeFacade().edit(estiloAprendizajeActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteEstiloAprendizaje() {
        try {
            getEstiloAprendizajeFacade().remove(estiloAprendizajeActual);
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
    
    public EstiloAprendizaje getEstiloAprendizaje(java.lang.Integer id) {
        return getEstiloAprendizajeFacade().find(id);
    }
      

    @FacesConverter(forClass = EstiloAprendizaje.class)
    public static class EstiloAprendizajeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EstiloAprendizajeController controller = (EstiloAprendizajeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "estiloAprendizajeController");
            return controller.getEstiloAprendizaje(getKey(value));
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
            if (object instanceof EstiloAprendizaje) {
                EstiloAprendizaje o = (EstiloAprendizaje) object;
                return getStringKey(o.getIdEstiloAprendizaje());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EstiloAprendizaje.class.getName());
            }
        }

    }

}
