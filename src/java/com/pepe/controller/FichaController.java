package com.pepe.controller;

import com.pepe.jpa.entities.CentroFormacion;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.Jornada;
import com.pepe.jpa.entities.Programa;
import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.entities.TipoFormacion;
import com.pepe.jpa.entities.TipoOferta;
import com.pepe.jpa.sesions.CentroFormacionFacade;
import com.pepe.jpa.sesions.FichaFacade;
import com.pepe.jpa.sesions.JornadaFacade;
import com.pepe.jpa.sesions.ProgramaFacade;
import com.pepe.jpa.sesions.ProyectoFacade;
import com.pepe.jpa.sesions.TipoFormacionFacade;
import com.pepe.jpa.sesions.TipoOfertaFacade;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Adsim
 */
@Named(value = "fichaController")
@SessionScoped
public class FichaController implements Serializable {

    @EJB
    private FichaFacade fichaFacade;
    @EJB
    private CentroFormacionFacade centroFormacionFacade;
     @EJB
    private TipoOfertaFacade tipoOfertaFacade;
     @EJB
    private JornadaFacade JornadaFacade;
      @EJB
    private ProyectoFacade proyectoFacade;
       @EJB
    private TipoFormacionFacade tipoFormacionFacade;
       @EJB
    private ProgramaFacade programaFacade; 
     
    private List<Ficha> listaFicha = null;
    private Ficha fichaActual;
    private int idCentro;
    private int idOferta;
    private int jornada;
    private int idTipoFormacion;
    private int idProyecto;

    public int getIdProyecto() {
        if(fichaActual != null && fichaActual.getIdProyecto() !=null){
            idCentro = fichaActual.getIdProyecto().getIdProyecto();
        
    }
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
    

    
    public int getIdTipoFormacion() {
        if(fichaActual != null && fichaActual.getIdTipoFormacion() !=null){
            idCentro = fichaActual.getIdTipoFormacion().getIdTipoFormacion();
        
    }
        return idTipoFormacion;
    }

    public void setIdTipoFormacion(int idTipoFormacion) {
        this.idTipoFormacion = idTipoFormacion;
    }
    
    

    public int getJornada() {
         if(fichaActual != null && fichaActual.getIdJornada() !=null){
            idCentro = fichaActual.getIdJornada().getIdJornada();
        
    }
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    
    public int getIdOferta() {
        if(fichaActual != null && fichaActual.getIdTipoOferta() !=null){
            idCentro = fichaActual.getIdTipoOferta().getIdTipoOferta();
        
    }
      return idOferta;  
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }
    
    

    public int getIdCentro() {
        if(fichaActual != null && fichaActual.getIdCentroFormacion() !=null){
            idCentro = fichaActual.getIdCentroFormacion().getIdCentroFormacion();
        }
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }
    
    

    public ProgramaFacade getProgramaFacade() {
        return programaFacade;
    }

    public void setProgramaFacade(ProgramaFacade programaFacade) {
        this.programaFacade = programaFacade;
    }
    
       
    public  List<Programa> getListaProgramaAutocomplete(String query) {        
        try{
            return getProgramaFacade().finByNombre(query);            
        }catch (Exception ex){
            Logger.getLogger(FichaController.class.getName()).log(Level.SEVERE,null,ex);
            return null;            
        }
    }
    
    public FichaFacade getFichaFacade() {
        return fichaFacade;
    }

    
    public void setFichaFacade(FichaFacade fichaFacade) {
        this.fichaFacade = fichaFacade;
    }

    public List<Ficha> getListaFicha() {
         if (listaFicha == null) {
            try {
                listaFicha = getFichaFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaFicha;
    }

    public void setListaFicha(List<Ficha> listaFicha) {
        this.listaFicha = listaFicha;
    }

    public Ficha getFichaActual() {
       if (fichaActual == null) {
            fichaActual = new Ficha();
        }
        return fichaActual;
    }

    public void setFichaActual(Ficha fichaActual) {
        this.fichaActual = fichaActual;
    }

    public CentroFormacionFacade getCentroFormacionFacade() {
        return centroFormacionFacade;
    }

    public void setCentroFormacionFacade(CentroFormacionFacade centroFormacionFacade) {
        this.centroFormacionFacade = centroFormacionFacade;
    }
    public List<CentroFormacion> getListaCentroFormacionSelectOne() {
        return getCentroFormacionFacade().findAll();
    }
    
    
    public TipoOfertaFacade getTipoOfertaFacade() {
        return tipoOfertaFacade;
    }

    public void setTipoOfertaFacade(TipoOfertaFacade tipoOfertaFacade) {
        this.tipoOfertaFacade = tipoOfertaFacade;
    }
    public  List<TipoOferta> getListaTipoOfertaSelectOne() {
        return getTipoOfertaFacade().findAll();
    }

    public JornadaFacade getJornadaFacade() {
        return JornadaFacade;
    }

    public void setJornadaFacade(JornadaFacade JornadaFacade) {
        this.JornadaFacade = JornadaFacade;
    }
    public  List<Jornada> getListaJornadaSelectOne() {
        return getJornadaFacade().findAll();
    }
    public ProyectoFacade getProyectoFacade() {
        return proyectoFacade;
    }

    public void setProyectoFacade(ProyectoFacade proyectoFacade) {
        this.proyectoFacade = proyectoFacade;
    }

    public  List<Proyecto> getListaProyectoSelectOne() {
        return getProyectoFacade().findAll();
    }
    
    public TipoFormacionFacade getTipoFormacionFacade() {
        return tipoFormacionFacade;
    }

    public void setTipoFormacionFacade(TipoFormacionFacade tipoFormacionFacade) {
        this.tipoFormacionFacade = tipoFormacionFacade;
    }
    
    public  List<TipoFormacion> getListaTipoFormacionSelectOne() {
        return getTipoFormacionFacade().findAll();
    }
      private void recargarLista() {
        listaFicha = null;
    }

    public String prepareCreate() {
      
        return "";
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
    
        public String addFicha() {
         try {
            fichaActual.setIdCentroFormacion(getCentroFormacionFacade().find(idCentro));
            fichaActual.setIdTipoOferta(getTipoOfertaFacade().find(idOferta));
            fichaActual.setIdJornada(getJornadaFacade().find(jornada));
            fichaActual.setIdTipoFormacion(getTipoFormacionFacade().find(idTipoFormacion));
            fichaActual.setIdProyecto(getProyectoFacade().find(idProyecto));
            fichaActual.setEstado((short) 1);
            getFichaFacade().create(fichaActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
        
        }
    
    
    public FichaController() {
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
    
}
