/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.TipoSangre;
import com.pepe.jpa.sesions.TipoSangreFacade;
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
public class TipoSangreController {

    @EJB
    private TipoSangreFacade tipoSangreFacade;
    private TipoSangre tipoSangreActual;
    private List<TipoSangre> listaTipoSangre = null;

    /**
     * Creates a new instance of CiudadController
     */
    public TipoSangreController() {
    }

    public TipoSangreFacade getTipoSangreFacade() {
        return tipoSangreFacade;
    }
    public TipoSangre getTipoSangreActual() {
        if (tipoSangreActual == null) {
            tipoSangreActual = new TipoSangre();
        }
        return tipoSangreActual;
    }

    public void seTipoSangreActual(TipoSangre tipoSangreActual) {
        this.tipoSangreActual = tipoSangreActual;
    }

  
    public List<TipoSangre> getListaTipoSangre() {
        if (listaTipoSangre == null) {
            try {
                listaTipoSangre = getTipoSangreFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaTipoSangre;
    }

    private void recargarLista() {
        listaTipoSangre = null;
    }

    public String prepareCreate() {
        tipoSangreActual = new TipoSangre();
        return "/admin/crear_tipoSangre";
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

    public String addTipoSangre() {
        try {

            getTipoSangreFacade().create(tipoSangreActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateTipoSangre() {
        try {
            getTipoSangreFacade().edit(tipoSangreActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteTipoSangre() {
        try {
            getTipoSangreFacade().remove(tipoSangreActual);
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
    
    public TipoSangre getTipoSangre(java.lang.Integer id) {
        return getTipoSangreFacade().find(id);
    }

    
    @FacesConverter(forClass = TipoSangre.class)
    public static class TipoSangreControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoSangreController controller = (TipoSangreController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoSangreController");
            return controller.getTipoSangre(getKey(value));
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
            if (object instanceof TipoSangre) {
                TipoSangre o = (TipoSangre) object;
                return getStringKey(o.getIdTipoSangre());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TipoSangre.class.getName());
            }
        }

    }

    
}
