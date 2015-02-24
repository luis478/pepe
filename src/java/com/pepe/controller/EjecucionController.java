/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.controller;


import com.pepe.jpa.entities.Aspectos;
import com.pepe.jpa.sesions.AspectosFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aprendiz
 */
@ManagedBean
@SessionScoped
public class EjecucionController implements Serializable{
    private Aspectos AspectosActual;
    private List<Aspectos> listaAspectos=null;
    
    @EJB
    private  AspectosFacade aspectosFacade;
 

    /**
     * Creates a new instance of EjecucionController
     */
    public EjecucionController() {
    }
    public AspectosFacade getAspectosFacade() {
        return aspectosFacade;
    }
    public Aspectos getAspectosActual() {
        if (AspectosActual==null) {
            AspectosActual = new Aspectos();
            
        }
        return AspectosActual;
    }

    public void setAspectosActual(Aspectos AspectosActual) {
        this.AspectosActual = AspectosActual;
    }

    public List<Aspectos> getListaAspectos() {
        if (listaAspectos==null) {
            try {
                listaAspectos = getAspectosFacade().findAll();
            } catch (Exception e) {
                System.out.println("Error closing resource " + e.getClass().getName());
                System.out.println("Message: " + e.getMessage());
            }
            
        }
        return listaAspectos;
    }
    

   private void recargarLista() {
        listaAspectos = null;
    }
     public String prepareList() {
        recargarLista();
        return "";
    }

    public String prepareEdit() {
        return "Edit";
    }

    public String prepareView() {
        return "View";
    }
    public String addAspectos() {
        try {
            getAspectosFacade().create(AspectosActual);
            
            
           addSuccessMessage("crear aspectos","aspecto creado Exitosamente");
           recargarLista();
            return "View";
        
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
           
            return null;
        }
    }

    public String updateAspectos() {
        try {
            getAspectosFacade().edit(AspectosActual);
          
            addSuccessMessage("Actualizar aspectos","aspecto actualizado Exitosamente");
            return "View";
        }catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
           
            return null;
        }
    }
    public String deleteAspectos() {
        try {
           
            getAspectosFacade().remove(AspectosActual);
            addSuccessMessage("Eliminar aspectos","aspecto eliminado Exitosamente");
            recargarLista();
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
        }
        return "List";
    }
    public String prepareCreate() {
        
        AspectosActual = new  Aspectos();
        return "aspectos";
    }

    private void addErrorMessage(String title, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    private void addSuccessMessage(String title, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
    
    
}
