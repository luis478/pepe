/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.Especialidad;
import com.pepe.jpa.sesions.EspecialidadFacade;
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
public class EspecialidadController {

    @EJB
    private EspecialidadFacade especialidadFacade;
    private Especialidad especialidadActual;
    private List<Especialidad> listaEspecialidad = null;

    /**
     * Creates a new instance of CiudadController
     */
    public EspecialidadController() {
    }

    public EspecialidadFacade getEspecialidadFacade() {
        return especialidadFacade;
    }
    public Especialidad getEspecialidadActual() {
        if (especialidadActual == null) {
            especialidadActual = new Especialidad();
        }
        return especialidadActual;
    }

    public void setEspecialidadActual(Especialidad especialidadActual) {
        this.especialidadActual = especialidadActual;
    }

  
    public List<Especialidad> getListaEspecialidad() {
        if (listaEspecialidad == null) {
            try {
                listaEspecialidad = getEspecialidadFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaEspecialidad;
    }

    private void recargarLista() {
        listaEspecialidad = null;
    }

    public String prepareCreate() {
        especialidadActual = new Especialidad();
        return "/admin/crear_especialidad";
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

    public String addEspecialidad() {
        try {

            getEspecialidadFacade().create(especialidadActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateEspecialidad() {
        try {
            getEspecialidadFacade().edit(especialidadActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteEspecialidad() {
        try {
            getEspecialidadFacade().remove(especialidadActual);
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
    
    public Especialidad getEspecialidad(java.lang.Integer id) {
        return getEspecialidadFacade().find(id);
    }

    @FacesConverter(forClass = Especialidad.class)
    public static class EspecialidadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EspecialidadController controller = (EspecialidadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "especialidadController");
            return controller.getEspecialidad(getKey(value));
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
            if (object instanceof Especialidad) {
                Especialidad o = (Especialidad) object;
                return getStringKey(o.getIdEspecialidad());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Especialidad.class.getName());
            }
        }

    }
    
}
