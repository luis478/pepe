/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.controller;

import com.pepe.jpa.entities.Fase;
import com.pepe.jpa.sesions.FaseFacade;
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
 * @author Aprendiz
 */
@ManagedBean
@SessionScoped
public class FaseController implements Serializable{

    @EJB
    private FaseFacade faseFacade;
    private Fase faseSeleccionada;
    private int faseSeleccionadaInt;
    private List<Fase> listaFase = null;

    /**
     * Creates a new instance of FaseControlller
     */
    public Fase getFaseSeleccionada() {
        if (faseSeleccionada == null) {
            faseSeleccionada = new Fase();
        }
        return faseSeleccionada;
    }

    public void setFaseSeleccionada(Fase faseSeleccionada) {
        this.faseSeleccionada = faseSeleccionada;
    }

    public int getFaseSeleccionadaInt() {
        return faseSeleccionadaInt;
    }

    public void setFaseSeleccionadaInt(int faseSeleccionadaInt) {
        this.faseSeleccionadaInt = faseSeleccionadaInt;
    }

    public FaseController() {
    }

    public FaseFacade getFaseFacade() {
        return faseFacade;
    }

    public Fase getFase(java.lang.Integer id) {
        return getFaseFacade().find(id);
    }

    public List<Fase> getListaFase() {
        try {
            if (listaFase == null) {
                listaFase = getFaseFacade().findAll();
            }
            return listaFase;
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public void setListaFase(List<Fase> listaFase) {
        this.listaFase = listaFase;
    }

    private void addErrorMessage(String string, String string0) {
        FacesMessage facesMsg
                = new FacesMessage(FacesMessage.SEVERITY_ERROR, string, string0);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    @FacesConverter(forClass = Fase.class)
    public static class FaseControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FaseController controller = (FaseController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "faseController");
            return controller.getFase(getKey(value));
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
            if (object instanceof Fase) {
                Fase o = (Fase) object;
                return getStringKey(o.getIdFase());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Fase.class.getName());
            }
        }

    }

}
