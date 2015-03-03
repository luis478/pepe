/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;


import com.pepe.jpa.entities.Competencia;
import com.pepe.jpa.sesions.CompetenciaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.pepe.jpa.entities.Programa;
import com.pepe.jpa.sesions.ProgramaFacade;
/**
 *
 * @author Adsit
 */
@ManagedBean
@SessionScoped
public class CompetenciaController {
    
    @EJB
    private CompetenciaFacade competenciaFacade;
    private Competencia competenciaActual;
    @EJB
    private ProgramaFacade programaFacade;    
    private List<Competencia> listaCompetencia = null;    
    private List<Programa> listaPrograma = null;
    
    
    public CompetenciaController(){
        
    }
    
    public CompetenciaFacade getCompetenciaFacade(){
        return competenciaFacade;
    }
    
    public Competencia getCompetenciaActual() {
        if (competenciaActual == null) {
            competenciaActual = new Competencia();
        }
        return competenciaActual;
    }
    
    public void setCompetenciaActual(Competencia CompetenciaActual) {
        this.competenciaActual = CompetenciaActual;
    }
    
     public List<Competencia> getListaCompetencia() {
        if (listaCompetencia == null) {
            try {
                listaCompetencia = getCompetenciaFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaCompetencia;
    }

   
    
     private void recargarLista() {
        listaCompetencia = null;
    }

    public String prepareCreate() {
        competenciaActual = new Competencia();
        return "/competencia/crear_competencia";
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
    
    public String xd(){
        return "/admin/competencia/crear_competencia.xhtml";
    }
    
    public String addCompetencia() {
        try {

            getCompetenciaFacade().create(competenciaActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateCompetencia() {
        try {
            getCompetenciaFacade().edit(competenciaActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public ProgramaFacade getProgramaFacade() {
        return programaFacade;
    }

    public void setProgramaFacade(ProgramaFacade programaFacade) {
        this.programaFacade = programaFacade;
    }

    public List<Programa> getListaPrograma() {
       listaPrograma = programaFacade.findAll();
       return listaPrograma;
    }

    public void setListaPrograma(List<Programa> listaPrograma) {
        this.listaPrograma = listaPrograma;
    }
    
    
    
    public String deleteCompetencia() {
        try {
            getCompetenciaFacade().remove(competenciaActual);
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
    
    public Competencia getCompetencia(java.lang.Integer id) {
        return getCompetenciaFacade().find(id);
    }
    
    @FacesConverter(forClass = Competencia.class)
    public static class CompetenciaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CompetenciaController controller = (CompetenciaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "competenciaController");
            return controller.getCompetencia(getKey(value));
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
            if (object instanceof Competencia) {
                Competencia o = (Competencia) object;
                return getStringKey(o.getIdCompetencia());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Competencia.class.getName());
            }
        }

    }
    
    
    
}
