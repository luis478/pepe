/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.Eps;
import com.pepe.jpa.sesions.EpsFacade;
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
public class EpsController {

    @EJB
    private EpsFacade EpsFacade;
    private Eps EpsActual;
    private List<Eps> listaEps = null;

    /**
     * Creates a new instance of CiudadController
     */
    public EpsController() {
    }

    public EpsFacade getEpsFacade() {
        return EpsFacade;
    }
    public Eps getEpsActual() {
        if (EpsActual == null) {
            EpsActual = new Eps();
        }
        return EpsActual;
    }

    public void setEpsActual(Eps epsActual) {
        this.EpsActual = epsActual;
    }

  
    public List<Eps> getListaEps() {
        if (listaEps == null) {
            try {
                listaEps = getEpsFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaEps;
    }

    private void recargarLista() {
        listaEps = null;
    }

    public String prepareCreate() {
        EpsActual = new Eps();
        return "/admin/crear_eps";
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

    public String addEps() {
        try {

            getEpsFacade().create(EpsActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateEps() {
        try {
            getEpsFacade().edit(EpsActual);
            recargarLista();
            return "Admin_ListaCategorias";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteEps() {
        try {
            getEpsFacade().remove(EpsActual);
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
    
    public Eps getEps(java.lang.String id) {
        return getEpsFacade().find(id);
    }
    
    @FacesConverter(forClass = Eps.class)
    public static class EpsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EpsController controller = (EpsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "epsController");
            return controller.getEps(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = String.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Eps) {
                Eps o = (Eps) object;
                return getStringKey(o.getIdEps());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Eps.class.getName());
            }
        }

    }

    
}
