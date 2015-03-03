/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.TipoContrato;
import com.pepe.jpa.sesions.TipoContratoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Junior Cabal
 */
@ManagedBean
@RequestScoped
public class TipoContratoController {

   @EJB
    private TipoContratoFacade tipoContratoFacade;
    private TipoContrato tipoContratoActual;
    private List<TipoContrato> listaTipoContrato = null;


    public TipoContratoController() {
    }

    public TipoContratoFacade getTipoContratoFacade() {
        return tipoContratoFacade;
    }
    public TipoContrato getTipoContrato() {
        if (tipoContratoActual == null) {
            tipoContratoActual = new TipoContrato();
        }
        return tipoContratoActual;
    }

    public void setTipoContratoActual(TipoContrato tipoContratoActual) {
        this.tipoContratoActual = tipoContratoActual;
    }

  
    public List<TipoContrato> getListaTipoContrato() {
        if (listaTipoContrato == null) {
            try {
                listaTipoContrato = getTipoContratoFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaTipoContrato;
    }

    private void recargarLista() {
        listaTipoContrato = null;
    }

    public String prepareCreate() {
        tipoContratoActual = new TipoContrato();
        return "/admin/TipoContrato";
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

    public String addTipoContrato() {
        try {

            getTipoContratoFacade().create(tipoContratoActual);
            recargarLista();
            return "Admin_ListaCategorias";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateTipoContrato() {
        try {
            getTipoContratoFacade().edit(tipoContratoActual);
            recargarLista();
            return "Admin_ListaCategorias";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteTipoContrato() {
        try {
            getTipoContratoFacade().remove(tipoContratoActual);
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
    public TipoContrato getTipoContrato(java.lang.Integer id){
        return getTipoContratoFacade().find(id);
    }
    
    @FacesConverter(forClass = TipoContrato.class)
    public static class TipoContratoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TipoContratoController controller = (TipoContratoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoContratoController");
            return controller.getTipoContrato(getKey(value));
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
            if (object instanceof TipoContrato) {
                TipoContrato o = (TipoContrato) object;
                return getStringKey(o.getIdTipoContrato());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TipoContrato.class.getName());
            }
        }

    }
}
