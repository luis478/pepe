/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.LibretaMilitar;
import com.pepe.jpa.sesions.LibretaMilitarFacade;
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
public class LibretaMilitarController {

  @EJB
    private LibretaMilitarFacade LibretaMilitarFacade;
    private LibretaMilitar LibretaMilitarActual;
    private List<LibretaMilitar> listaLibretaMilitar = null;

    /**
     * Creates a new instance of CiudadController
     */
    public LibretaMilitarController() {
    }

    public LibretaMilitarFacade getLibretaMilitarFacade() {
        return LibretaMilitarFacade;
    }
    public LibretaMilitar getLibretaMilitarActual() {
        if (LibretaMilitarActual == null) {
            LibretaMilitarActual = new LibretaMilitar();
        }
        return LibretaMilitarActual;
    }

    public void setLibretaMilitarActual(LibretaMilitar generoActual) {
        this.LibretaMilitarActual = generoActual;
    }

  
    public List<LibretaMilitar> getListaLibretaMilitar() {
        if (listaLibretaMilitar == null) {
            try {
                listaLibretaMilitar = getLibretaMilitarFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaLibretaMilitar;
    }

    private void recargarLista() {
        listaLibretaMilitar = null;
    }

    public String prepareCreate() {
        LibretaMilitarActual = new LibretaMilitar();
        return "/admin/crear_libretaMilitar";
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

    public String addLibretaMilitar() {
        try {

            getLibretaMilitarFacade().create(LibretaMilitarActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateLibretaMilitar() {
        try {
            getLibretaMilitarFacade().edit(LibretaMilitarActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteLibretaMilitar() {
        try {
            getLibretaMilitarFacade().remove(LibretaMilitarActual);
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
    
    public LibretaMilitar getLibretaMilitar(java.lang.Integer id) {
        return getLibretaMilitarFacade().find(id);
    }
    
    
    
    @FacesConverter(forClass = LibretaMilitar.class)
    public static class LibretaMilitarControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LibretaMilitarController controller = (LibretaMilitarController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "libretaMilitarController");
            return controller.getLibretaMilitar(getKey(value));
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
            if (object instanceof LibretaMilitar) {
                LibretaMilitar o = (LibretaMilitar) object;
                return getStringKey(o.getIdLibretaMilitar());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + LibretaMilitar.class.getName());
            }
        }

    }
}
