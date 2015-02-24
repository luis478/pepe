/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.controller;

import com.pepe.jpa.entities.Conclusiones;
import com.pepe.jpa.sesions.ConclusionesFacade;
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
public class ConclusionesController implements Serializable{
    private Conclusiones conclusionesActual;
    private List<Conclusiones> listaConclusiones=null;
@EJB
private ConclusionesFacade  conclusionesFacade;
    /**
     * Creates a new instance of ConclusionesController
     */
    public ConclusionesController() {
    }

    public ConclusionesFacade getConclusionesFacade() {
        return conclusionesFacade;
    }

    public Conclusiones getConclusionesActual() {
          if (conclusionesActual == null) {
             conclusionesActual = new Conclusiones();
        }
        return conclusionesActual;
    }

    public void setConclusionesActual(Conclusiones conclusionesActual) {
        this.conclusionesActual = conclusionesActual;
    }

    public List<Conclusiones> getListaConclusiones() {
        if (listaConclusiones==null) {
           try {
                listaConclusiones = getConclusionesFacade().findAll();
            } catch (Exception e) {
                System.out.println("Error closing resource " + e.getClass().getName());
                System.out.println("Message: " + e.getMessage());
            }
            
        }
        
        return listaConclusiones;
    }
     private void recargarLista() {
        listaConclusiones = null;
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
    public String addConclusiones() {
        try {
            getConclusionesFacade().create(conclusionesActual);
            
            
           addSuccessMessage("crear conclusiones","conclusiones creado Exitosamente");
           recargarLista();
            return "View";
        
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
           
            return null;
        }
    }

    public String updateConclusiones() {
        try {
            getConclusionesFacade().edit(conclusionesActual);
          
            addSuccessMessage("Actualizar conclusiones","conclusiones actualizado Exitosamente");
            return "View";
        }catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
           
            return null;
        }
    }
    public String deleteAcompanamiento() {
        try {
           
            getConclusionesFacade().remove(conclusionesActual);
            addSuccessMessage("Eliminar conclusiones","conclusiones eliminado Exitosamente");
            recargarLista();
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
        }
        return "List";
    }
    public String prepareCreate() {
        
        conclusionesActual = new  Conclusiones();
        return "conclusiones";
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
