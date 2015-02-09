/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.TipoVocero;
import com.pepe.jpa.sesions.TipoVoceroFacade;
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
public class TipoVoceroController {

  @EJB
    private TipoVoceroFacade tipoVoceroFacade;
    private TipoVocero tipoVoceroActual;
    private List<TipoVocero> listaTipoVocero = null;

    /**
     * Creates a new instance of CiudadController
     */
    public TipoVoceroController() {
    }

    public TipoVoceroFacade getTipoVoceroFacade() {
        return tipoVoceroFacade;
    }
    public TipoVocero getTipoVoceroActual() {
        if (tipoVoceroActual == null) {
            tipoVoceroActual = new TipoVocero();
        }
        return tipoVoceroActual;
    }

    public void setTipoVoceroActual(TipoVocero tipoVoceroActual) {
        this.tipoVoceroActual = tipoVoceroActual;
    }

  
    public List<TipoVocero> getListaTipoVocero() {
        if (listaTipoVocero == null) {
            try {
                listaTipoVocero = getTipoVoceroFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaTipoVocero;
    }

    private void recargarLista() {
        listaTipoVocero = null;
    }

    public String prepareCreate() {
        tipoVoceroActual = new TipoVocero();
        return "/admin/crear_tipoVocero";
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

    public String addTipoVocero() {
        try {

            getTipoVoceroFacade().create(tipoVoceroActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateTipoVocero() {
        try {
            getTipoVoceroFacade().edit(tipoVoceroActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteTipoVocero() {
        try {
            getTipoVoceroFacade().remove(tipoVoceroActual);
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
    
    public TipoVocero getTipoVocero(java.lang.Integer id) {
        return getTipoVoceroFacade().find(id);
    }
    
    @FacesConverter(forClass = TipoVocero.class)
    public static class TipoVoceroControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoVoceroController controller = (TipoVoceroController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoVoceroController");
            return controller.getTipoVocero(getKey(value));
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
            if (object instanceof TipoVocero) {
                TipoVocero o = (TipoVocero) object;
                return getStringKey(o.getIdTipoVocero());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TipoVocero.class.getName());
            }
        }

    }
}
