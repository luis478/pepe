/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.TipoActividadAprendizaje;
import com.pepe.jpa.sesions.TipoActividadAprendizajeFacade;
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
public class TipoActividadAprendizajeController {

    @EJB
    private TipoActividadAprendizajeFacade TipoActividadAprendizajeFacade;
    private TipoActividadAprendizaje tipoActividadAprendizajeActual;
    private List<TipoActividadAprendizaje> listaTipoActividadAprendizaje = null;

    /**
     * Creates a new instance of CiudadController
     */
    public TipoActividadAprendizajeController() {
    }

    public TipoActividadAprendizajeFacade getTipoActividadAprendizajeFacade() {
        return TipoActividadAprendizajeFacade;
    }
    public TipoActividadAprendizaje getTipoActividadAprendizajeActual() {
        if (tipoActividadAprendizajeActual == null) {
            tipoActividadAprendizajeActual = new TipoActividadAprendizaje();
        }
        return tipoActividadAprendizajeActual;
    }

    public void setTipoActividadAprendizajeActual(TipoActividadAprendizaje tipoActividadAprendizajeActual) {
        this.tipoActividadAprendizajeActual = tipoActividadAprendizajeActual;
    }

  
    public List<TipoActividadAprendizaje> getListaTipoActividadAprendizaje() {
        if (listaTipoActividadAprendizaje == null) {
            try {
                listaTipoActividadAprendizaje = getTipoActividadAprendizajeFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaTipoActividadAprendizaje;
    }

    private void recargarLista() {
        listaTipoActividadAprendizaje = null;
    }

    public String prepareCreate() {
        tipoActividadAprendizajeActual = new TipoActividadAprendizaje();
        return "/planeacionpedagogica/crear_tipoEvidencia";
    }

    public String prepareEdit() {
        return "Admin_EditarCategoria";
    }

    public String prepareView() {
        return "View";
    }

    public String prepareList() {
        recargarLista();
        return "html Administrador/Admin_ListaCategorias";
    }

    public String addTipoActividadAprendizaje() {
        try {

            getTipoActividadAprendizajeFacade().create(tipoActividadAprendizajeActual);
            recargarLista();
            return "Admin_ListaCategorias";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateTipoActividadAprendizaje() {
        try {
            getTipoActividadAprendizajeFacade().edit(tipoActividadAprendizajeActual);
            recargarLista();
            return "Admin_ListaCategorias";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteTipoActividadAprendizaje() {
        try {
            getTipoActividadAprendizajeFacade().remove(tipoActividadAprendizajeActual);
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
    
   
     public TipoActividadAprendizaje getTipoActividadAprendizaje(java.lang.Integer id) {
        return getTipoActividadAprendizajeFacade().find(id);
    }

    @FacesConverter(forClass = TipoActividadAprendizaje.class)
    public static class TipoActividadAprendizajeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoActividadAprendizajeController controller = (TipoActividadAprendizajeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoActividadAprendizajeController");
            return controller.getTipoActividadAprendizaje(getKey(value));
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
            if (object instanceof TipoActividadAprendizaje) {
                TipoActividadAprendizaje o = (TipoActividadAprendizaje) object;
                return getStringKey(o.getIdTipoActividadAprendizaje());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TipoActividadAprendizaje.class.getName());
            }
        }

    }

    
}
