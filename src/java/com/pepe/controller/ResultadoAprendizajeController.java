/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.ResultadoAprendizaje;
import com.pepe.jpa.sesions.ResultadoAprendizajeFacade;
import java.io.Serializable;
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
 * @author Junior Cabal
 */
@ManagedBean
@SessionScoped
public class ResultadoAprendizajeController implements Serializable{

  @EJB
    private ResultadoAprendizajeFacade resultadoAprendizajeFacade;
    private ResultadoAprendizaje resultadoAprendizajeActual;
    private List<ResultadoAprendizaje> listaResultadoAprendizaje = null;

    /**
     * Creates a new instance of CiudadController
     */
    public ResultadoAprendizajeController() {
    }

    public ResultadoAprendizajeFacade getResultadoAprendizajeFacade() {
        return resultadoAprendizajeFacade;
    }
    public ResultadoAprendizaje getResultadoAprendizajeActual() {
        if (resultadoAprendizajeActual == null) {
            resultadoAprendizajeActual = new ResultadoAprendizaje();
        }
        return resultadoAprendizajeActual;
    }

    public void setResultadoAprendizajeActual(ResultadoAprendizaje resultadoAprendizajeActual) {
        this.resultadoAprendizajeActual = resultadoAprendizajeActual;
    }

  
    public List<ResultadoAprendizaje> getListaResultadoAprendizaje() {
        if (listaResultadoAprendizaje == null) {
            try {
                listaResultadoAprendizaje = getResultadoAprendizajeFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaResultadoAprendizaje;
    }

    private void recargarLista() {
        listaResultadoAprendizaje = null;
    }

    public String prepareCreate() {
        resultadoAprendizajeActual = new ResultadoAprendizaje();
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

    public String addResultadoAprendizaje() {
        try {

            getResultadoAprendizajeFacade().create(resultadoAprendizajeActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateResultadoAprendizaje() {
        try {
            getResultadoAprendizajeFacade().edit(resultadoAprendizajeActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteResultadoAprendizaje() {
        try {
            getResultadoAprendizajeFacade().remove(resultadoAprendizajeActual);
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
     public ResultadoAprendizaje getResultadoAprendizaje(java.lang.Integer id) {
        return getResultadoAprendizajeFacade().find(id);
    }

    @FacesConverter(forClass = ResultadoAprendizaje.class)
    public static class ResultadoAprendizajeControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ResultadoAprendizajeController controller = (ResultadoAprendizajeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "resultadoAprendizajeController");
            return controller.getResultadoAprendizaje(getKey(value));
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
            if (object instanceof ResultadoAprendizaje) {
                ResultadoAprendizaje o = (ResultadoAprendizaje) object;
                return getStringKey(o.getIdResultadoAprendizaje());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ResultadoAprendizaje.class.getName());
            }
        }

    }
    
}
