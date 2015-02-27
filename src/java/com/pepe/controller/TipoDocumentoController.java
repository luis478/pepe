/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.TipoDocumento;
import com.pepe.jpa.sesions.TipoDocumentoFacade;
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
public class TipoDocumentoController {

    @EJB
    private TipoDocumentoFacade tipoDocumentoFacade;
    private TipoDocumento tipoDocumentoActual;
    private List<TipoDocumento> listaTipoDocumento = null;

    /**
     * Creates a new instance of CiudadController
     */
    public TipoDocumentoController() {
    }

    public TipoDocumentoFacade getTipoDocumentoFacade() {
        return tipoDocumentoFacade;
    }
    public TipoDocumento getTipoDocumentoActual() {
        if (tipoDocumentoActual == null) {
            tipoDocumentoActual = new TipoDocumento();
        }
        return tipoDocumentoActual;
    }

    public void seTipoDocumentoActual(TipoDocumento tipoDocumentoActual) {
        this.tipoDocumentoActual = tipoDocumentoActual;
    }

  
    public List<TipoDocumento> getListaTipoDocumento() {
        if (listaTipoDocumento == null) {
            try {
                listaTipoDocumento = getTipoDocumentoFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaTipoDocumento;
    }

    private void recargarLista() {
        listaTipoDocumento = null;
    }

    public String prepareCreate() {
        tipoDocumentoActual = new TipoDocumento();
        return "/admin/crear_tipoDocumento";
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

    public String addTipoDocumento() {
        try {

            getTipoDocumentoFacade().create(tipoDocumentoActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateTipoDocumento() {
        try {
            getTipoDocumentoFacade().edit(tipoDocumentoActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteTipoDocumento() {
        try {
            getTipoDocumentoFacade().remove(tipoDocumentoActual);
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
    
    public TipoDocumento getTipoDocumento(java.lang.Integer id) {
        return getTipoDocumentoFacade().find(id);
    }
    
    @FacesConverter(forClass = TipoDocumento.class)
    public static class TipoDocumentoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoDocumentoController controller = (TipoDocumentoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoDocumentoController");
            return controller.getTipoDocumento(getKey(value));
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
            if (object instanceof TipoDocumento) {
                TipoDocumento o = (TipoDocumento) object;
                return getStringKey(o.getIdTipoDocumento());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TipoDocumento.class.getName());
            }
        }
    }
}
