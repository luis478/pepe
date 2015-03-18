package com.pepe.controller;

import com.pepe.jpa.entities.CentroFormacion;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.Jornada;
import com.pepe.jpa.entities.Programa;
import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.entities.TipoFormacion;
import com.pepe.jpa.entities.TipoOferta;
import com.pepe.jpa.entities.UsuarioHasFicha;
import com.pepe.jpa.entities.UsuarioHasFichaPK;
import com.pepe.jpa.sesions.CentroFormacionFacade;
import com.pepe.jpa.sesions.FichaFacade;
import com.pepe.jpa.sesions.JornadaFacade;
import com.pepe.jpa.sesions.ProgramaFacade;
import com.pepe.jpa.sesions.ProyectoFacade;
import com.pepe.jpa.sesions.TipoFormacionFacade;
import com.pepe.jpa.sesions.TipoInstructorFacade;
import com.pepe.jpa.sesions.TipoOfertaFacade;
import com.pepe.jpa.sesions.UsuarioFacade;
import com.pepe.jpa.sesions.UsuarioHasFichaFacade;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author Adsim
 */
@Named(value = "fichaController")
@SessionScoped
public class FichaController implements Serializable {

    private Programa programaActual = null;
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
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private TipoInstructorFacade tipoInstructorFacade;
    private List<Ficha> listaFicha = null;
    private Ficha fichaActual = null;
    private int idCentro;
    private int idOferta;
    private int jornada;
    private int idTipoFormacion;
    private int idProyecto;
    private int fichaSeleccionadaInt;
    private int idUsu;
    private Ficha fichaSeleccionada;
    private UsuarioHasFicha usuarioHasFichaSeleccionada = null;

    public FichaController() {
    }

    public UsuarioHasFichaFacade getUsuarioHasFichaFacade() {
        return usuarioHasFichaFacade;
    }

    public Programa getProgramaActual() {
        if (programaActual == null) {
            programaActual = new Programa();
        }
        return programaActual;
    }

    public void setProgramaActual(Programa programaActual) {
        this.programaActual = programaActual;
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public void setUsuarioHasFichaFacade(UsuarioHasFichaFacade usuarioHasFichaFacade) {
        this.usuarioHasFichaFacade = usuarioHasFichaFacade;
    }

    public TipoInstructorFacade getTipoInstructorFacade() {
        return tipoInstructorFacade;
    }

    public void setTipoInstructorFacade(TipoInstructorFacade tipoInstructorFacade) {
        this.tipoInstructorFacade = tipoInstructorFacade;
    }

    public UsuarioHasFicha getUsuarioHasFichaSeleccionada() {
        return usuarioHasFichaSeleccionada;
    }

    public void setUsuarioHasFichaSeleccionada(UsuarioHasFicha usuarioHasFichaSeleccionada) {
        this.usuarioHasFichaSeleccionada = usuarioHasFichaSeleccionada;
    }

    public Ficha getFichaSeleccionada() {
        if (fichaSeleccionada == null) {
            fichaSeleccionada = new Ficha();
        }
        return fichaSeleccionada;
    }
    
//    public void asignarFichaSeleccionada(){
//        fichaSeleccionada = getFichaFacade().find(fichaActual.getIdFicha());
//    }

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
        if (fichaActual != null && fichaActual.getIdProyecto() != null) {
            idProyecto = fichaActual.getIdProyecto().getIdProyecto();

        }
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdTipoFormacion() {
        if (fichaActual != null && fichaActual.getIdTipoFormacion() != null) {
            idTipoFormacion = fichaActual.getIdTipoFormacion().getIdTipoFormacion();

        }
        return idTipoFormacion;
    }

    public void setIdTipoFormacion(int idTipoFormacion) {
        this.idTipoFormacion = idTipoFormacion;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public int getJornada() {
        if (fichaActual != null && fichaActual.getIdJornada() != null) {
            jornada = fichaActual.getIdJornada().getIdJornada();

        }
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public int getIdOferta() {
        if (fichaActual != null && fichaActual.getIdTipoOferta() != null) {
            idOferta = fichaActual.getIdTipoOferta().getIdTipoOferta();
        }
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public int getIdCentro() {
        if (fichaActual != null && fichaActual.getIdCentroFormacion() != null) {
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

    public List<Programa> getListaProgramaAutocomplete(String query) {
        try {
            return getProgramaFacade().finByNombre(query);
        } catch (Exception ex) {
            Logger.getLogger(FichaController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public UsuarioHasFicha getUsuarioFicha() {
        try {
            return getUsuarioHasFichaFacade().finByTipoInstructor(fichaSeleccionada.getCodigoFicha());
        } catch (Exception ex) {
            Logger.getLogger(FichaController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public FichaFacade getFichaFacade() {
        return fichaFacade;
    }

    public void validarCodigoFicha(FacesContext context, UIComponent component, Object o) throws ValidatorException {
        Ficha u = getFichaFacade().getByCodigoFicha((String) o);
        Pattern pat = Pattern.compile("[0-9]{6,8}");
        Matcher mat = pat.matcher((String) o);
        if (mat.matches()) {
            if (u == null) {
                fichaActual.setCodigoFicha((String) o);
            } else {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El Codigo de Ficha ya fue registrado"));
            }
        } else {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El codigo de la ficha debe contener 6 digitos númericos"));
        }
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

    public List<TipoOferta> getListaTipoOfertaSelectOne() {
        return getTipoOfertaFacade().findAll();
    }

    public JornadaFacade getJornadaFacade() {
        return JornadaFacade;
    }

    public void setJornadaFacade(JornadaFacade JornadaFacade) {
        this.JornadaFacade = JornadaFacade;
    }

    public List<Jornada> getListaJornadaSelectOne() {
        return getJornadaFacade().findAll();
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

    public TipoFormacionFacade getTipoFormacionFacade() {
        return tipoFormacionFacade;
    }

    public void setTipoFormacionFacade(TipoFormacionFacade tipoFormacionFacade) {
        this.tipoFormacionFacade = tipoFormacionFacade;
    }

    public List<TipoFormacion> getListaTipoFormacionSelectOne() {
        return getTipoFormacionFacade().findAll();
    }

    public List<Ficha> getFichaListaPrograma() {
        return programaActual.getFichaList();
    }

    public void asignarProgramaActual(ActionEvent event) {
        programaActual = (Programa) event.getComponent().getAttributes().get("prog");
        getProgramaActual();
    }

    private void recargarLista() {
        listaFicha = null;
    }

    public void prepareCreate() {
        idCentro = 0;
        idOferta = 0;
        jornada = 0;
        idTipoFormacion = 0;
        idUsu = 0;
        fichaActual = null;
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

    public void addFicha(ActionEvent event) {
        try {
            fichaActual.setPrograma((Programa) event.getComponent().getAttributes().get("prog"));
            fichaActual.setIdCentroFormacion(getCentroFormacionFacade().find(idCentro));
            fichaActual.setIdTipoOferta(getTipoOfertaFacade().find(idOferta));
            fichaActual.setIdJornada(getJornadaFacade().find(jornada));
            fichaActual.setIdTipoFormacion(getTipoFormacionFacade().find(idTipoFormacion));
            fichaActual.setEstado(true);
            getFichaFacade().create(fichaActual);
            usuarioHasFichaSeleccionada = new UsuarioHasFicha();
            usuarioHasFichaSeleccionada.setUsuarioHasFichaPK(new UsuarioHasFichaPK());
            usuarioHasFichaSeleccionada.getUsuarioHasFichaPK().setIdUsuario(idUsu);
            usuarioHasFichaSeleccionada.getUsuarioHasFichaPK().setIdFicha(fichaActual.getIdFicha());
            usuarioHasFichaSeleccionada.setFicha(fichaActual);
            usuarioHasFichaSeleccionada.setUsuario(getUsuarioFacade().find(idUsu));
            usuarioHasFichaSeleccionada.setIdTipoInstructor(getTipoInstructorFacade().find(1));
            getUsuarioHasFichaFacade().create(usuarioHasFichaSeleccionada);
            recargarLista();
            idUsu = 0;
            idCentro = 0;
            idOferta = 0;
            jornada = 0;
            idTipoFormacion = 0;
            fichaActual = null;
            getFichaActual();
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
        }

    }

    public boolean fichaBoolean() {
        if (getFichaSeleccionada().getIdFicha() == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean proyectoBoolean() {
        if (getFichaSeleccionada().getIdProyecto() == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean proyectoActividadBoolean() {
        try {
            if (!proyectoBoolean() || (fichaActual.getIdProyecto().getActividadList().isEmpty())) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getCause());
            return false;
        }
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
//<!--
//                <label for="ProgrmaText">Programa:</label>
//                <p:autoComplete id="Programa" value="#{fichaController.fichaActual.programa}"
//                                completeMethod="#{fichaController.getListaProgramaAutocomplete}"
//                                var="Programa" itemLabel="#{Programa}" itemValue="#{Programa}"
//                                converter="ProgramaConverter" required="true"
//                                forceSelection="true" maxResults="10"/>
//                -->
