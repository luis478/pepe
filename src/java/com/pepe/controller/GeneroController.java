/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.Genero;
import com.pepe.jpa.sesions.GeneroFacade;
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
public class GeneroController {

 @EJB
    private GeneroFacade generoFacade;
    private Genero generoActual;
    private List<Genero> listaGenero = null;

    /**
     * Creates a new instance of CiudadController
     */
    public GeneroController() {
    }

    public GeneroFacade getGeneroFacade() {
        return generoFacade;
    }
    public Genero getGeneroActual() {
        if (generoActual == null) {
            generoActual = new Genero();
        }
        return generoActual;
    }

    public void setGeneroActual(Genero generoActual) {
        this.generoActual = generoActual;
    }

  
    public List<Genero> getListaGenero() {
        if (listaGenero == null) {
            try {
                listaGenero = getGeneroFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaGenero;
    }

    private void recargarLista() {
        listaGenero = null;
    }

    public String prepareCreate() {
        generoActual = new Genero();
        return "/admin/genero";
    }

    public String prepareEdit() {
        return "Admin_EditarCategoria";
    }

    public String prepareView() {
        return "View";
    }

    public String prepareList() {
        recargarLista();
        return "html Administrador/Admin_ListaCategorias";
    }

    public String addGenero() {
        try {

            getGeneroFacade().create(generoActual);
            recargarLista();
            return "Admin_ListaCategorias";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateGenero() {
        try {
            getGeneroFacade().edit(generoActual);
            recargarLista();
            return "Admin_ListaCategorias";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteGenero() {
        try {
            getGeneroFacade().remove(generoActual);
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
    
    public Genero getGenero(java.lang.Integer id) {
        return getGeneroFacade().find(id);
    }

    
 
    @FacesConverter(forClass = Genero.class)
    public static class GeneroControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GeneroController controller = (GeneroController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "generoController");
            return controller.getGenero(getKey(value));
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
            if (object instanceof Genero) {
                Genero o = (Genero) object;
                return getStringKey(o.getIdGenero());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Genero.class.getName());
            }
        }

    }
}
