/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.Caracterizacion;
import com.pepe.jpa.sesions.CaracterizacionFacade;
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
public class CaracterizacionController {

    @EJB
    private CaracterizacionFacade caracterizacionFacade;
    private Caracterizacion caracterizacionActual;
    private List<Caracterizacion> listaCaracterizacion = null;

    /**
     * Creates a new instance of CiudadController
     */
    public CaracterizacionController() {
    }

    public CaracterizacionFacade getCaracterizacionFacade() {
        return caracterizacionFacade;
    }
    public Caracterizacion getCaracterizacionActual() {
        if (caracterizacionActual == null) {
            caracterizacionActual = new Caracterizacion();
        }
        return caracterizacionActual;
    }

    public void setCaracterizacionActual(Caracterizacion caracterizacionActual) {
        this.caracterizacionActual = caracterizacionActual;
    }

  
    public List<Caracterizacion> getListaCaracterizacion() {
        if (listaCaracterizacion == null) {
            try {
                listaCaracterizacion = getCaracterizacionFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaCaracterizacion;
    }

    private void recargarLista() {
        listaCaracterizacion = null;
    }

    public String prepareCreate() {
        caracterizacionActual = new Caracterizacion();
        return "/admin/crear_caracterizacion";
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

    public String addCaracterizacion() {
        try {

            getCaracterizacionFacade().create(caracterizacionActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateCaracterizacion() {
        try {
            getCaracterizacionFacade().edit(caracterizacionActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteCaracterizacion() {
        try {
            getCaracterizacionFacade().remove(caracterizacionActual);
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
    
    public Caracterizacion getCaracterizacion(java.lang.Integer id) {
        return getCaracterizacionFacade().find(id);
    }
    
     @FacesConverter(forClass = Caracterizacion.class)
    public static class CaracterizacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CaracterizacionController controller = (CaracterizacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "caracterizacionController");
            return controller.getCaracterizacion(getKey(value));
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
            if (object instanceof Caracterizacion) {
                Caracterizacion o = (Caracterizacion) object;
                return getStringKey(o.getIdCaracterizacion());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Caracterizacion.class.getName());
            }
        }

    }

    
}
