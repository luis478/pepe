/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.controller;

import com.pepe.jpa.entities.Actividad;
import com.pepe.jpa.entities.ActividadAprendizaje;
import com.pepe.jpa.entities.Fase;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.entities.Recurso;
import com.pepe.jpa.entities.ResultadoAprendizaje;
import com.pepe.jpa.entities.TecnicaDidactica;
import com.pepe.jpa.entities.TipoActividadAprendizaje;
import com.pepe.jpa.entities.Usuario;
import com.pepe.jpa.sesions.ActividadAprendizajeFacade;
import com.pepe.jpa.sesions.ActividadFacade;
import com.pepe.jpa.sesions.FaseFacade;
import com.pepe.jpa.sesions.ProyectoFacade;
import com.pepe.jpa.sesions.RecursoFacade;
import com.pepe.jpa.sesions.ResultadoAprendizajeFacade;
import com.pepe.jpa.sesions.TecnicaDidacticaFacade;
import com.pepe.jpa.sesions.TipoActividadAprendizajeFacade;
import com.pepe.jpa.sesions.UsuarioFacade;
import java.io.Serializable;
import java.util.ArrayList;
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
import javax.faces.event.ActionEvent;

/**
 *
 * @author Adsit
 */
@ManagedBean
@SessionScoped
public class ActividadController implements Serializable {

    private Actividad actividadActual;
    private List<Actividad> listaActividad = null;
    private List<ActividadAprendizaje> actividadAprendizajeList =null;
    private List<TecnicaDidactica> tecnicaDidacticaList=null;
    @EJB
    private ProyectoFacade proyectoFacade;
    @EJB
    private ActividadFacade actividadFacade;
    @EJB
    private FaseFacade faseFacade;
    @EJB
    private ActividadAprendizajeFacade actividadAprendizajeFacade;
    private Fase faseActual;
    private Ficha fichaActual;
    private int actividadSeleccionadaInt;
    private Actividad actividadSeleccionada;

    public int getActividadSeleccionadaInt() {
        return actividadSeleccionadaInt;
    }

    public void setActividadSeleccionadaInt(int actividadSeleccionadaInt) {
        this.actividadSeleccionadaInt = actividadSeleccionadaInt;
    }

    public Actividad getActividadSeleccionada() {
         if(actividadSeleccionada == null){
            actividadSeleccionada = new Actividad();
        }
        return actividadSeleccionada;
    }

    public void setActividadSeleccionada(Actividad actividadSeleccionada) {
        this.actividadSeleccionada = actividadSeleccionada;
    }

    public void setActividadAprendizajeFacade(ActividadAprendizajeFacade actividadAprendizajeFacade) {
        this.actividadAprendizajeFacade = actividadAprendizajeFacade;
    }

    public ActividadAprendizajeFacade getActividadAprendizajeFacade() {
        return actividadAprendizajeFacade;
    }

   
    
    

    public ActividadController() {
    }

    public List<ActividadAprendizaje> getActividadAprendizajeList() {
        return actividadAprendizajeList;
    }

    public void setActividadAprendizajeList(List<ActividadAprendizaje> ActividadAprendizajeList) {
        this.actividadAprendizajeList = ActividadAprendizajeList;
    }
    
    
    
    
    public Fase getFaseActual() {
        return faseActual;
    }

    public void setFaseActual(Fase faseActual) {
        this.faseActual = faseActual;
    }

    public Ficha getFichaActual() {
        return fichaActual;
    }

    public void setFichaActual(Ficha fichaActual) {
        this.fichaActual = fichaActual;
    }

    public Actividad getActividadActual() {
        if (actividadActual == null) {
            actividadActual = new Actividad();
        }
        return actividadActual;
    }

    public void setActividadActual(Actividad actividadActual) {
        this.actividadActual = actividadActual;
    }

    public List<Actividad> getListaActividad() {
        return listaActividad = getActividadFacade().consultaPlaneacionActividades(faseActual, fichaActual.getIdProyecto());
    }

    public ActividadFacade getActividadFacade() {
        return actividadFacade;
    }

    public void setActividadFacade(ActividadFacade actividadFacade) {
        this.actividadFacade = actividadFacade;
    }

    public void setListaActividad(List<Actividad> listaActividad) {
        this.listaActividad = listaActividad;
    }

    public ProyectoFacade getProyectoFacade() {
        return proyectoFacade;
    }

    public void setProyectoFacade(ProyectoFacade proyectoFacade) {
        this.proyectoFacade = proyectoFacade;
    }

    public List<Proyecto> getListaProyectoSelectOne() {
        return getProyectoFacade().findAll();
    }
    public List<Fase> getListaFaseSelectOne() {
        return getFaseFacade().findAll();
    }

    public FaseFacade getFaseFacade() {
        return faseFacade;
    }

    public void setFaseFacade(FaseFacade faseFacade) {
        this.faseFacade = faseFacade;
    }


    private void recargarlista() {
        listaActividad = null;
    }
    public void prepareCreateGenerarGuia(ActionEvent event) {
        actividadActual = new Actividad();
        actividadActual = (Actividad) event.getComponent().getAttributes().get("actividad");
        actividadAprendizajeList = new ArrayList<>();
         
                    actividadAprendizajeList.addAll(getActividadAprendizajeFacade().consultaActividad(actividadActual));
           
                    
        //listaActividadAprendizaje=actividadActual.getActividadAprendizajeList();
        
    }
    public void prepareCreateGuiaAprendizaje(ActionEvent event){
        fichaActual = new Ficha();
        fichaActual = (Ficha) event.getComponent().getAttributes().get("ficha");
        faseActual = new Fase();
        faseActual = (Fase) event.getComponent().getAttributes().get("fase");
        listaActividad=null;
        listaActividad = getActividadFacade().consultaPlaneacionActividades(faseActual, fichaActual.getIdProyecto());
    }

    public void prepareCreate(ActionEvent event) {
        fichaActual = new Ficha();
        fichaActual = (Ficha) event.getComponent().getAttributes().get("ficha");
        faseActual = new Fase();
        faseActual = (Fase) event.getComponent().getAttributes().get("fase");
        listaActividad=null;
        actividadAprendizajeList= new ArrayList<>();
        listaActividad = getActividadFacade().consultaPlaneacionActividades(faseActual, fichaActual.getIdProyecto());
        
            for(Actividad consultar: listaActividad){
                    actividadAprendizajeList.addAll(getActividadAprendizajeFacade().consultaActividad(consultar));
            }
        }
    public String createActividadProyecto(){
        actividadActual = new Actividad();
        return "crear_actividad";
    }

    public String createActividad() {
        return "/planeacionpedagogica/planeacion_pedagogica";
    }
    
    public String createGuiaAprendizaje(){
        return "/planeacionpedagogica/guia_aprendizaje";
    }
    public String createGenerarGuia(){
        return "generar_guiaAprendizaje";
    }

    public String prepareEdit() {
        return "/Actividad/editar_Actividad";
    }

    public String prepareView() {
        return "/Actividad/ver_Actividad";
    }

    public String prepareList() {
        recargarlista();
        return "/Actividad/lista_Actividad";
    }

    public String addActividad() {
        try {
            getActividadFacade().create(actividadActual);
            recargarlista();
            return "lista_Actividad";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateActividad() {
        try {
            getActividadFacade().edit(actividadActual);
            recargarlista();
            return "lista_Actividad";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteActividad() {
        try {
            getActividadFacade().remove(actividadActual);
            addSuccessMessage("Eliminado Exitosamente", "actividad eliminada");
            recargarlista();
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message" + e.getMessage());

        }
        return "lista_Actividad";
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

    public Actividad getActividad(java.lang.Integer id) {
        return getActividadFacade().find(id);
    }

    public List<Actividad> getItemsAvailableSelectMany() {
        return getActividadFacade().findAll();
    }

    public List<Actividad> getItemsAvailableSelectOne() {
        return getActividadFacade().findAll();
    }

    @FacesConverter(forClass = Actividad.class)
    public static class ActividadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ActividadController controller = (ActividadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "actividadController");
            return controller.getActividad(getKey(value));
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
            if (object instanceof Actividad) {
                Actividad o = (Actividad) object;
                return getStringKey(o.getIdActividad());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Actividad.class.getName()});
                return null;
            }
        }

    }

    
    
    
   
    private ActividadAprendizaje actividadAprendizajeActual;
    private int tipoActividadAprendizajeSelect;
    private int actividadSelect;
    private List<ActividadAprendizaje> listaActividadAprendizaje = null;
    private List<Usuario> usuarioList= null;
    private List<Recurso> listaRecurso = null;
    private List<ResultadoAprendizaje> listaResultadoAprendizaje = null;
    private ResultadoAprendizaje resultadoAprendizajeActual;
    private Recurso recursoActual;
    private TecnicaDidactica tecnicaDidacticaActual;
    private Usuario usuarioActual;
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private TecnicaDidacticaFacade TecnicaDidacticaFacade;
    @EJB
    private ResultadoAprendizajeFacade resultadoAprendizajeFacade;
    @EJB
    private TipoActividadAprendizajeFacade tipoActividadAprendizajeFacade;
    @EJB
    private RecursoFacade recursoFacade;
   
   
    public ActividadAprendizaje getActividadAprendizajeActual() {
        
        return actividadAprendizajeActual;
    }

    public void setActividadAprendizajeActual(ActividadAprendizaje actividadAprendizajeActual) {
        this.actividadAprendizajeActual = actividadAprendizajeActual;
    }
   
  
    public List<ActividadAprendizaje> getListaActividadAprendizaje() {
          return listaActividadAprendizaje;

    }
    
    
    
    private void recargarListaActividadAprendizaje() {
                actividadAprendizajeList.add(actividadAprendizajeActual);
    }


    
    public String prepareResultadoAprendizaje(){
        listaResultadoAprendizaje = new ArrayList<>();
        listaResultadoAprendizaje = actividadAprendizajeActual.getResultadoAprendizajeList();
        return "lista_resultadoAprendizaje";
    }
     public String prepareRecursos(){
        listaRecurso = new ArrayList<>();
        listaRecurso = actividadAprendizajeActual.getRecursoList();
       return "lista_recursos";
    }
    public String crearActividadAprendizaje(){
        tecnicaDidacticaList = new ArrayList<>();
        listaResultadoAprendizaje = new ArrayList<>();
        listaRecurso = new ArrayList<>();
        usuarioList= new ArrayList<>();
        
        tecnicaDidacticaActual= new TecnicaDidactica();
        resultadoAprendizajeActual = new ResultadoAprendizaje();
        recursoActual = new Recurso();
        usuarioActual = new Usuario();
        actividadAprendizajeActual = new ActividadAprendizaje();
        
        return "crear_actividadAprendizaje";
    }

    public String addActividadAprendizaje() {
        try {
            actividadAprendizajeActual.setUsuarioList(usuarioList);
            actividadAprendizajeActual.setTecnicaDidacticaList(tecnicaDidacticaList);
            actividadAprendizajeActual.setResultadoAprendizajeList(listaResultadoAprendizaje);
            actividadAprendizajeActual.setRecursoList(listaRecurso);
            actividadAprendizajeActual.setIdTipoActividadAprendizaje(getTipoActividadAprendizajeFacade().find(tipoActividadAprendizajeSelect));
            getActividadAprendizajeFacade().create(actividadAprendizajeActual);
            recargarListaActividadAprendizaje();
            return "planeacion_pedagogica";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }
    public void editarDialogo(ActionEvent event){
        actividadAprendizajeActual= (ActividadAprendizaje) event.getComponent().getAttributes().get("actividad");
    }

    public void updateActividadAprendizaje() {
        try {
            getActividadAprendizajeFacade().edit(actividadAprendizajeActual);
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
        }
    }

    public String deleteActividadAprendizaje() {
        try {
            getActividadAprendizajeFacade().remove(actividadAprendizajeActual);
            recargarListaActividadAprendizaje();
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
        }
        return "List";
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

   
     public List<Actividad> getListaActividadSelectOne() {
        return getActividadFacade().consultaPlaneacionActividades(faseActual, fichaActual.getIdProyecto());
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
    
    public TecnicaDidactica getTecnicaDidacticaActual() {
        return tecnicaDidacticaActual;
    }

    public void setTecnicaDidacticaActual(TecnicaDidactica tecnicaDidacticaActual) {
        this.tecnicaDidacticaActual = tecnicaDidacticaActual;
    }

    public List<TecnicaDidactica> getTecnicaDidacticaList() {
        return tecnicaDidacticaList;
    }

    public void setTecnicaDidacticaList(List<TecnicaDidactica> tecnicaDidacticaList) {
        this.tecnicaDidacticaList = tecnicaDidacticaList;
    }
    
    
    public void addTecnicaDidactica(){
        tecnicaDidacticaList.add(tecnicaDidacticaActual);
        tecnicaDidacticaActual = new TecnicaDidactica();
    }
    
    //select one menu instructor
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }
    
    public List<Usuario> getListaUsuariosSelectOne(){
        return getUsuarioFacade().findAll();
    }
    public void addInstructor(){
        usuarioList.add(usuarioActual);
        usuarioActual = new Usuario();
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
