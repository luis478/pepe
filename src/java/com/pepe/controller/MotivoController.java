/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.Motivo;
import com.pepe.jpa.sesions.MotivoFacade;
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
public class MotivoController {

    @EJB
    private MotivoFacade motivoFacade;
    private Motivo motivoActual;
    private List<Motivo> listaMotivo = null;

    /**
     * Creates a new instance of CiudadController
     */
    public MotivoController() {
    }

    public MotivoFacade getMotivoFacade() {
        return motivoFacade;
    }
    public Motivo getMotivoActual() {
        if (motivoActual == null) {
            motivoActual = new Motivo();
        }
        return motivoActual;
    }

    public void setMotivoActual(Motivo motivoActual) {
        this.motivoActual = motivoActual;
    }

  
    public List<Motivo> getListaMotivo() {
        if (listaMotivo == null) {
            try {
                listaMotivo = getMotivoFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaMotivo;
    }

    private void recargarLista() {
        listaMotivo = null;
    }

    public String prepareCreate() {
        motivoActual = new Motivo();
        return "/admin/crear_motivo";
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

    public String addMotivo() {
        try {

            getMotivoFacade().create(motivoActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateMotivo() {
        try {
            getMotivoFacade().edit(motivoActual);
            recargarLista();
            return "Admin_ListaCategorias";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteMotivo() {
        try {
            getMotivoFacade().remove(motivoActual);
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
    
    public Motivo getMotivo(java.lang.Integer id) {
        return getMotivoFacade().find(id);
    }
    
    @FacesConverter(forClass = Motivo.class)
    public static class MotivoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MotivoController controller = (MotivoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "motivoController");
            return controller.getMotivo(getKey(value));
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
            if (object instanceof Motivo) {
                Motivo o = (Motivo) object;
                return getStringKey(o.getIdMotivo());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Motivo.class.getName());
            }
        }

    }
    
}
