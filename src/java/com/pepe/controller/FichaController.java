package com.pepe.controller;

import com.pepe.jpa.entities.CentroFormacion;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.Jornada;
import com.pepe.jpa.entities.Programa;
import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.entities.TipoFormacion;
import com.pepe.jpa.entities.TipoOferta;
import com.pepe.jpa.entities.UsuarioHasFicha;
import com.pepe.jpa.sesions.CentroFormacionFacade;
import com.pepe.jpa.sesions.FichaFacade;
import com.pepe.jpa.sesions.JornadaFacade;
import com.pepe.jpa.sesions.ProgramaFacade;
import com.pepe.jpa.sesions.ProyectoFacade;
import com.pepe.jpa.sesions.TipoFormacionFacade;
import com.pepe.jpa.sesions.TipoOfertaFacade;
import com.pepe.jpa.sesions.UsuarioHasFichaFacade;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
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
       @EJB
       private UsuarioHasFichaFacade usuarioHasFichaFacade;
    
    private List<Ficha> listaFicha = null;
    private Ficha fichaActual;
    private int idCentro;
    private int idOferta;
    private int jornada;
    private int idTipoFormacion;
    private int idProyecto;
    private int fichaSeleccionadaInt;
    private Ficha fichaSeleccionada;
    private UsuarioHasFicha usuarioHasFichaSeleccionada;

    public UsuarioHasFichaFacade getUsuarioHasFichaFacade() {
        return usuarioHasFichaFacade;
    }

    public void setUsuarioHasFichaFacade(UsuarioHasFichaFacade usuarioHasFichaFacade) {
        this.usuarioHasFichaFacade = usuarioHasFichaFacade;
    }

    public UsuarioHasFicha getUsuarioHasFichaSeleccionada() {
        return usuarioHasFichaSeleccionada;
    }

    public void setUsuarioHasFichaSeleccionada(UsuarioHasFicha usuarioHasFichaSeleccionada) {
        this.usuarioHasFichaSeleccionada = usuarioHasFichaSeleccionada;
    }

    public Ficha getFichaSeleccionada() {
        if(fichaSeleccionada == null){
            fichaSeleccionada = new Ficha();
        }
        return fichaSeleccionada;
    }

    public int getFichaSeleccionadaInt() {
        return fichaSeleccionadaInt;
    }

    public void setFichaSeleccionadaInt(int fichaSeleccionadaInt) {
        this.fichaSeleccionadaInt = fichaSeleccionadaInt;
    }

    
    public void setFichaSeleccionada(Ficha fichaSeleccionada) {
        this.fichaSeleccionada = fichaSeleccionada;
    }

   
    

    public int getIdProyecto() {
        if(fichaActual != null && fichaActual.getIdProyecto() !=null){
            idProyecto = fichaActual.getIdProyecto().getIdProyecto();
        
    }
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
    

    
    public int getIdTipoFormacion() {
        if(fichaActual != null && fichaActual.getIdTipoFormacion() !=null){
            idTipoFormacion = fichaActual.getIdTipoFormacion().getIdTipoFormacion();
        
    }
        return idTipoFormacion;
    }

    public void setIdTipoFormacion(int idTipoFormacion) {
        this.idTipoFormacion = idTipoFormacion;
    }
    
    

    public int getJornada() {
         if(fichaActual != null && fichaActual.getIdJornada() !=null){
            jornada = fichaActual.getIdJornada().getIdJornada();
        
    }
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    
    public int getIdOferta() {
        if(fichaActual != null && fichaActual.getIdTipoOferta() !=null){
            idOferta = fichaActual.getIdTipoOferta().getIdTipoOferta();
        
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
    
     public Ficha getFicha(java.lang.Integer id) {
        return fichaFacade.find(id);
    }
    
    @FacesConverter(forClass = Ficha.class)
    public static class FichaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FichaController controller = (FichaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fichaController");
            return controller.getFicha(getKey(value));
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
            if (object instanceof Ficha) {
                Ficha o = (Ficha) object;
                return getStringKey(o.getIdFicha());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Ficha.class.getName());
            }
        }
        

    }
    
       public UsuarioHasFicha getUsuarioHasFicha(com.pepe.jpa.entities.UsuarioHasFichaPK id) {
        return getUsuarioHasFichaFacade().find(id);
    }

    @FacesConverter(forClass = UsuarioHasFicha.class)
    public static class UsuarioHasFichaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioHasFichaController controller = (UsuarioHasFichaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioHasFichaController");
            return controller.getUsuarioHasFicha(getKey(value));
        }

        com.pepe.jpa.entities.UsuarioHasFichaPK getKey(String value) {
            com.pepe.jpa.entities.UsuarioHasFichaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.pepe.jpa.entities.UsuarioHasFichaPK();
            key.setIdUsuario(Integer.parseInt(values[0]));
            key.setIdFicha(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.pepe.jpa.entities.UsuarioHasFichaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdUsuario());
            sb.append(SEPARATOR);
            sb.append(value.getIdFicha());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof UsuarioHasFicha) {
                UsuarioHasFicha o = (UsuarioHasFicha) object;
                return getStringKey(o.getUsuarioHasFichaPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + UsuarioHasFicha.class.getName());
            }
        }

    }
}
