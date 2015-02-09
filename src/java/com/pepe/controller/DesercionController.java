/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.Desercion;
import com.pepe.jpa.entities.Estado;
import com.pepe.jpa.entities.Motivo;
import com.pepe.jpa.sesions.DesercionFacade;
import com.pepe.jpa.sesions.EstadoFacade;
import com.pepe.jpa.sesions.MotivoFacade;
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
 * @author Windows 8
 */
@ManagedBean
@SessionScoped
public class DesercionController implements Serializable {

   @EJB
    private DesercionFacade desercionFacade;
   @EJB
    private MotivoFacade motivoFacade;
   @EJB
    private EstadoFacade estadoFacade;
    private Desercion desercionActual;
    private List<Desercion> listaDesercion = null;

    
    
    
    public MotivoFacade getMotivoFacade() {
        return motivoFacade;
    }
    public void setMotivoFacade(MotivoFacade motivoFacade) {
        this.motivoFacade = motivoFacade;
    }
    public List<Motivo> getListaMotivoSelectOne() {
        return getMotivoFacade().findAll();
    }

    public EstadoFacade getEstadoFacade() {
        return estadoFacade;
    }
    public void setEstadoFacade(EstadoFacade estadoFacade) {
        this.estadoFacade = estadoFacade;
    }
    public List<Estado> getListaEstadoSelectOne() {
        return getEstadoFacade().findAll();
    }
    
    /**
     * Creates a new instance of CiudadController
     */
    public DesercionController() {
    }

    public DesercionFacade getDesercionFacade() {
        return desercionFacade;
    }
    public Desercion getDesercionActual() {
        if (desercionActual == null) {
            desercionActual = new Desercion();
        }
        return desercionActual;
    }

    public void setDesercionActual(Desercion desercionActual) {
        this.desercionActual = desercionActual;
    }

  
    public List<Desercion> getListaDesercion() {
        if (listaDesercion == null) {
            try {
                listaDesercion = getDesercionFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaDesercion;
    }

    private void recargarLista() {
        listaDesercion = null;
    }

    public String prepareCreate() {
        desercionActual = new Desercion();
        return "/admin/crear_desercion";
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

    public String addDesercion() {
        try {

            getDesercionFacade().create(desercionActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateDesercion() {
        try {
            getDesercionFacade().edit(desercionActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteDesercion() {
        try {
            getDesercionFacade().remove(desercionActual);
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
    
    public Desercion getDesercion(java.lang.Integer id) {
        return getDesercionFacade().find(id);
    }
     @FacesConverter(forClass = Desercion.class)
    public static class DesercionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DesercionController controller = (DesercionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "desercionController");
            return controller.getDesercion(getKey(value));
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
            if (object instanceof Desercion) {
                Desercion o = (Desercion) object;
                return getStringKey(o.getIdDesercion());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Desercion.class.getName());
            }
        }

    }
}
