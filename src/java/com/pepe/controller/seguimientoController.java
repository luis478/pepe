/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.controller;

import com.pepe.jpa.entities.Acompanamiento;
import com.pepe.jpa.entities.Fase;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.sesions.AcompanamientoFacade;
import com.pepe.jpa.sesions.ConclusionesFacade;
import com.pepe.jpa.sesions.FaseFacade;
import com.pepe.jpa.sesions.FichaFacade;
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
public class seguimientoController {
private Acompanamiento   acompanamientoActual;
private List<Acompanamiento> listaAcompanamiento = null;
@EJB
 private  AcompanamientoFacade acompanamientoFacade;
 @EJB
 private FichaFacade fichaFacade;
 @EJB
 private FaseFacade faseFacade;
 @EJB
 private ConclusionesFacade conclusionesFacade;
 
 
    /**
     * Creates a new instance of seguimientoController
     */
    public seguimientoController() {
    }

    public FichaFacade getFichaFacade() {
        return fichaFacade;
    }

    public FaseFacade getFaseFacade() {
        return faseFacade;
    }

    public ConclusionesFacade getConclusionesFacade() {
        return conclusionesFacade;
    }

    public Acompanamiento getAcompanamientoActual() {
        if (acompanamientoActual == null) {
             acompanamientoActual = new Acompanamiento();
        }
        return acompanamientoActual;
    }

    public void setAcompanamientoActual(Acompanamiento acompanamientoActual) {
        this.acompanamientoActual = acompanamientoActual;
    }

    public AcompanamientoFacade getAcompanamientoFacade() {
        return acompanamientoFacade;
    }
    
     public List<Acompanamiento> getListaAcompanamiento() {
        if (listaAcompanamiento == null) {
            try {
                listaAcompanamiento = getAcompanamientoFacade().findAll();
            } catch (Exception e) {
                System.out.println("Error closing resource " + e.getClass().getName());
                System.out.println("Message: " + e.getMessage());
            }
        }
        return listaAcompanamiento;
    }

     private void recargarLista() {
        listaAcompanamiento = null;
    }
     public String prepareList() {
        recargarLista();
        return "/acompañamieno/List";
    }

    public String prepareEdit() {
        return "Edit";
    }

    public String prepareView() {
        return "View";
    }
     public List<Ficha> getListFichaSelectOne() {
        return getFichaFacade().findAll();
    }
     public List<Fase> getListFaseSelectOne() {
        return getFaseFacade().findAll();
    }
    public String addAcompanamiento() {
        try {
            getAcompanamientoFacade().create(acompanamientoActual);
            
            
           addSuccessMessage("crear acompanamiento","acompanamiento creado Exitosamente");
           recargarLista();
            return "acompanamiento vista";
        
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
           
            return null;
        }
    }

    public String updateAcompanamieno() {
        try {
            getAcompanamientoFacade().edit(acompanamientoActual);
          
            addSuccessMessage("Actualizar acompanamiento","acompanamiento actualizado Exitosamente");
            return "View";
        }catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
           
            return null;
        }
    }
    public String deleteAcompanamiento() {
        try {
           
            getAcompanamientoFacade().remove(acompanamientoActual);
            addSuccessMessage("Eliminar acompanamiento","acompanamiento eliminado Exitosamente");
            recargarLista();
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
        }
        return "List";
    }
    public String prepareCreate() {
        
        acompanamientoActual = new Acompanamiento();
        return "Create";
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
