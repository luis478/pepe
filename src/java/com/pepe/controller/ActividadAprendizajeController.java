/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.controller;


import com.pepe.jpa.entities.Actividad;
import com.pepe.jpa.entities.ActividadAprendizaje;
import com.pepe.jpa.entities.Recurso;
import com.pepe.jpa.entities.ResultadoAprendizaje;
import com.pepe.jpa.entities.TecnicaDidactica;
import com.pepe.jpa.entities.TipoActividadAprendizaje;
import com.pepe.jpa.sesions.ActividadAprendizajeFacade;
import com.pepe.jpa.sesions.ActividadFacade;
import com.pepe.jpa.sesions.RecursoFacade;
import com.pepe.jpa.sesions.ResultadoAprendizajeFacade;
import com.pepe.jpa.sesions.TecnicaDidacticaFacade;
import com.pepe.jpa.sesions.TipoActividadAprendizajeFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Luis Carlos
 */
@ManagedBean
@SessionScoped
public class ActividadAprendizajeController implements Serializable {

    @EJB
    private ActividadAprendizajeFacade actividadAprendizajeFacade;
    private ActividadAprendizaje actividadAprendizajeActual;
    private int tipoActividadAprendizajeSelect;
    private int actividadSelect;
    private List<ActividadAprendizaje> listaActividadAprendizaje = null;
    private List<Recurso> listaRecurso = null;
    private List<ResultadoAprendizaje> listaResultadoAprendizaje = null;
    private Actividad actividadActual;
    private ResultadoAprendizaje resultadoAprendizajeActual;
    private Recurso recursoActual;
    @EJB
    private ActividadFacade actividadFacade;
    @EJB
    private TecnicaDidacticaFacade TecnicaDidacticaFacade;
    @EJB
    private ResultadoAprendizajeFacade resultadoAprendizajeFacade;
    @EJB
    private TipoActividadAprendizajeFacade tipoActividadAprendizajeFacade;
    @EJB
    private RecursoFacade recursoFacade;
    
    /**
     * Creates a new instance of CiudadController
     */
    public ActividadAprendizajeController() {
    }

    public ActividadAprendizajeFacade getActividadAprendizajeFacade() {
        return actividadAprendizajeFacade;
    }
    public ActividadAprendizaje getActividadAprendizajeActual() {
        
        return actividadAprendizajeActual;
    }

    public void setActividadAprendizajeActual(ActividadAprendizaje actividadAprendizajeActual) {
        this.actividadAprendizajeActual = actividadAprendizajeActual;
    }
   
  
    public List<ActividadAprendizaje> getListaActividadAprendizaje() {
//        if (listaActividadAprendizaje == null) {
//            try {
//                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
//            }
//        }
//        return listaActividadAprendizaje;
          return listaActividadAprendizaje;//            } catch (Exception e) {

    }
    
    
    
    private void recargarLista() {
        listaActividadAprendizaje = getActividadAprendizajeFacade().consultaActividad(actividadActual);
    }

    public void prepareCreate(ActionEvent event) {
        actividadActual = new Actividad();
        actividadActual = (Actividad) event.getComponent().getAttributes().get("actividad");
        listaActividadAprendizaje=actividadActual.getActividadAprendizajeList();
        recargarLista();
    }
    
    public String createActividad(){
        return "/planeacionpedagogica/lista_ActividadAprendizaje";
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

    public String addActividadAprendizaje() {
        try {
            actividadAprendizajeActual.setResultadoAprendizajeList(listaResultadoAprendizaje);
            actividadAprendizajeActual.setRecursoList(listaRecurso);
            actividadAprendizajeActual.setIdActividad(actividadActual);
            actividadAprendizajeActual.setIdTipoActividadAprendizaje(getTipoActividadAprendizajeFacade().find(tipoActividadAprendizajeSelect));
            getActividadAprendizajeFacade().create(actividadAprendizajeActual);
            recargarLista();
            return "lista_ActividadAprendizaje";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateActividadAprendizaje() {
        try {
            getActividadAprendizajeFacade().edit(actividadAprendizajeActual);
            recargarLista();
            return "Admin_ListaCategorias";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteActividadAprendizaje() {
        try {
            getActividadAprendizajeFacade().remove(actividadAprendizajeActual);
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

     // Select one menu Actividad
    public int getActividadSelect() {
        if(actividadAprendizajeActual!=null && actividadAprendizajeActual.getIdActividad()!= null){
            actividadSelect=actividadAprendizajeActual.getIdActividadAprendizaje();
        }
        return actividadSelect;
    }

    public void setActividadSelect(int actividadSelect) {
        this.actividadSelect = actividadSelect;
    }

    public ActividadFacade getActividadFacade() {
        return actividadFacade;
    }

    public void setActividadFacade(ActividadFacade actividadFacade) {
        this.actividadFacade = actividadFacade;
    }
     public List<Actividad> getListaActividadSelectOne() {
        return getActividadFacade().findAll();
    }
     
     // Select one menu Tecnica Didactica


    public TecnicaDidacticaFacade getTecnicaDidacticaFacade() {
        return TecnicaDidacticaFacade;
    }

    public void setTecnicaDidacticaFacade(TecnicaDidacticaFacade TecnicaDidacticaFacade) {
        this.TecnicaDidacticaFacade = TecnicaDidacticaFacade;
    }
    
    public List<TecnicaDidactica> getListaTecnicaDidacticaSelectOne() {
        return getTecnicaDidacticaFacade().findAll();
    }

    //select one menu Recurso    
    public List<Recurso> getListaRecurso() {
        return listaRecurso;
    }

    public void setListaRecurso(List<Recurso> listaRecurso) {
        this.listaRecurso = listaRecurso;
    }

    public Recurso getRecursoActual() {
        return recursoActual;
    }

    public void setRecursoActual(Recurso recursoActual) {
        this.recursoActual = recursoActual;
    }

    public RecursoFacade getRecursoFacade() {
        return recursoFacade;
    }

    public void setRecursoFacade(RecursoFacade recursoFacade) {
        this.recursoFacade = recursoFacade;
    }
    
      public List<Recurso> getListaRecursoSelectOne() {
        return getRecursoFacade().findAll();
    }
    public void addRecurso(){
        listaRecurso.add(recursoActual);
        recursoActual = new Recurso();
    }
 
    //select one menu resultado de aprendizaje
    
    public List<ResultadoAprendizaje> getListaResultadoAprendizaje() {
        return listaResultadoAprendizaje;
    }

    public void setListaResultadoAprendizaje(List<ResultadoAprendizaje> listaResultadoAprendizaje) {
        this.listaResultadoAprendizaje = listaResultadoAprendizaje;
    }

    public ResultadoAprendizaje getResultadoAprendizajeActual() {
        return resultadoAprendizajeActual;
    }

    public void setResultadoAprendizajeActual(ResultadoAprendizaje resultadoAprendizajeActual) {
        this.resultadoAprendizajeActual = resultadoAprendizajeActual;
    }

    public ResultadoAprendizajeFacade getResultadoAprendizajeFacade() {
        return resultadoAprendizajeFacade;
    }

    public void setResultadoAprendizajeFacade(ResultadoAprendizajeFacade resultadoAprendizajeFacade) {
        this.resultadoAprendizajeFacade = resultadoAprendizajeFacade;
    }
    public List<ResultadoAprendizaje> getListaResultadoAprendizajeSelectOne() {
        return getResultadoAprendizajeFacade().findAll();
    }
    public void addResultadoAprendizaje(){
        listaResultadoAprendizaje.add(resultadoAprendizajeActual);
        resultadoAprendizajeActual = new ResultadoAprendizaje();
    }
    
    public String crearActividadAprendizaje(){
        listaResultadoAprendizaje = new ArrayList<>();
        listaRecurso = new ArrayList<>();
        resultadoAprendizajeActual = new ResultadoAprendizaje();
        recursoActual = new Recurso();
        actividadAprendizajeActual = new ActividadAprendizaje();
        return "crear_actividadAprendizaje";
    }
    
    // Select one menu Tipo actividad aprendizaje

    public int getTipoActividadAprendizajeSelect() {
         if(actividadAprendizajeActual!=null && actividadAprendizajeActual.getIdTipoActividadAprendizaje()!= null){
            tipoActividadAprendizajeSelect=actividadAprendizajeActual.getIdActividadAprendizaje();
        }
        return tipoActividadAprendizajeSelect;
    }

    public void setTipoActividadAprendizajeSelect(int tipoActividadAprendizajeSelect) {
        this.tipoActividadAprendizajeSelect = tipoActividadAprendizajeSelect;
    }

    public TipoActividadAprendizajeFacade getTipoActividadAprendizajeFacade() {
        return tipoActividadAprendizajeFacade;
    }

    public void setTipoActividadAprendizajeFacade(TipoActividadAprendizajeFacade tipoActividadAprendizajeFacade) {
        this.tipoActividadAprendizajeFacade = tipoActividadAprendizajeFacade;
    }
    
    public List<TipoActividadAprendizaje> getListaTipoActividadAprendizajeSelectOne() {
        return getTipoActividadAprendizajeFacade().findAll();
    }
    
}
