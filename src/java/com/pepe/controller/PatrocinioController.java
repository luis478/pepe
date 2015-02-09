/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.Empresa;
import com.pepe.jpa.entities.Patrocinio;
import com.pepe.jpa.sesions.EmpresaFacade;
import com.pepe.jpa.sesions.PatrocinioFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PatrocinioController {

    @EJB
    private PatrocinioFacade patrocinioFacade;
    @EJB
    private EmpresaFacade empresaFacade;
    private Patrocinio patrocinioActual;
    private List<Patrocinio> listaPatrocinio = null;

    /**
     * Creates a new instance of CiudadController
     */
    public PatrocinioController() {
    }

    public PatrocinioFacade getPatrocinioFacade() {
        return patrocinioFacade;
    }
    public Patrocinio getPatrocinioActual() {
        if (patrocinioActual == null) {
            patrocinioActual = new Patrocinio();
        }
        return patrocinioActual;
    }

    public void setPatrocinioActual(Patrocinio generoActual) {
        this.patrocinioActual = generoActual;
    }
    public EmpresaFacade getEmpresaFacade() {
        return empresaFacade;
    }
    public void setEmpresaFacade(EmpresaFacade empresaFacade) {
        this.empresaFacade = empresaFacade;
    }
     public List<Empresa> getListaEmpresaSelectOne() {
        return getEmpresaFacade().findAll();
    }
 

    public List<Patrocinio> getListaPatrocinio() {
        if (listaPatrocinio == null) {
            try {
                listaPatrocinio = getPatrocinioFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaPatrocinio;
    }

    private void recargarLista() {
        listaPatrocinio = null;
    }

    public String prepareCreate() {
        patrocinioActual = new Patrocinio();
        return "/admin/crear_patrocinio";
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

    public String addPatrocinio() {
        try {

            getPatrocinioFacade().create(patrocinioActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updatePatrocinio() {
        try {
            getPatrocinioFacade().edit(patrocinioActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deletePatrocinio() {
        try {
            getPatrocinioFacade().remove(patrocinioActual);
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
    
    public Patrocinio getPatrocinio(java.lang.Integer id) {
        return getPatrocinioFacade().find(id);
    }

   @FacesConverter(forClass = Patrocinio.class)
    public static class PatrocinioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PatrocinioController controller = (PatrocinioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "patrocinioController");
            return controller.getPatrocinio(getKey(value));
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
            if (object instanceof Patrocinio) {
                Patrocinio o = (Patrocinio) object;
                return getStringKey(o.getIdPatrocinio());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Patrocinio.class.getName());
            }
        }

    } 
}
