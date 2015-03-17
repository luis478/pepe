/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.controller;

import com.pepe.jpa.entities.Actividad;
import com.pepe.jpa.entities.Competencia;
import com.pepe.jpa.entities.Fase;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.sesions.ActividadFacade;
import com.pepe.jpa.sesions.CompetenciaFacade;
import com.pepe.jpa.sesions.FaseFacade;
import com.pepe.jpa.sesions.FichaFacade;
import com.pepe.jpa.sesions.ProyectoFacade;
import java.io.Serializable;
import java.util.ArrayList;
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
 * @author Adsit
 */
@Named(value = "proyectoController")
@SessionScoped
public class ProyectoController implements Serializable {
    
    @EJB
    private ProyectoFacade proyectoFacade;
    private Proyecto proyectoActual;
    private List<Proyecto> listaProyecto = null;
    @EJB
    private FichaFacade fichaFacade;
    private Ficha fichaActual;
    @EJB
    private ActividadFacade actividadFacade;
    private Actividad actividadActual;
    private List<Actividad> listaActividad;
    @EJB
    private CompetenciaFacade competenciaFacade;
    private List<Competencia> listaCompetencia;
    @EJB
    private FaseFacade faseFacade;
    private int idFase;
    private int faseActividad;
    
    public ProyectoFacade getProyectoFacade() {
        return proyectoFacade;
    }
    
    public FichaFacade getFichaFacade() {
        return fichaFacade;
    }
    
    public void setFichaFacade(FichaFacade fichaFacade) {
        this.fichaFacade = fichaFacade;
    }
    
    public int getIdFase() {
        return idFase;
    }
    
    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }
    
    public int getFaseActividad() {
        return faseActividad;
    }
    
    public void setFaseActividad(int faseActividad) {
        this.faseActividad = faseActividad;
    }
    
    public void setProyectoFacade(ProyectoFacade proyectoFacade) {
        this.proyectoFacade = proyectoFacade;
    }
    
    public ActividadFacade getActividadFacade() {
        return actividadFacade;
    }
    
    public void setActividadFacade(ActividadFacade actividadFacade) {
        this.actividadFacade = actividadFacade;
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
        listaActividad = new ArrayList<>();
        if (fichaActual.getIdProyecto() != null) {
            listaActividad = getActividadFacade().consultaActividadProyecto(fichaActual.getIdProyecto().getIdProyecto(), faseActividad);
        }
        return listaActividad;
    }
    
    public void setListaActividad(List<Actividad> listaActividad) {
        this.listaActividad = listaActividad;
    }
    
    public CompetenciaFacade getCompetenciaFacade() {
        return competenciaFacade;
    }
    
    public void setCompetenciaFacade(CompetenciaFacade competenciaFacade) {
        this.competenciaFacade = competenciaFacade;
    }
    
    public List<Competencia> getListaCompetencia() {
        listaCompetencia = fichaActual.getPrograma().getCompetenciaList();
        return listaCompetencia;
    }
    
    public void setListaCompetencia(List<Competencia> listaCompetencia) {
        this.listaCompetencia = listaCompetencia;
    }
    
    public Proyecto getProyectoActual() {
        if (proyectoActual == null) {
            proyectoActual = new Proyecto();
        }
        return proyectoActual;
    }
    
    public FaseFacade getFaseFacade() {
        return faseFacade;
    }
    
    public void setFaseFacade(FaseFacade faseFacade) {
        this.faseFacade = faseFacade;
    }
    
    public List<Fase> listaFase() {
        return getFaseFacade().findAll();
    }
    
    public Ficha getFichaActual() {
        return fichaActual;
    }
    
    public void setFichaActual(Ficha fichaActual) {
        this.fichaActual = fichaActual;
    }
    
    public void setProyectoActual(Proyecto proyectoActual) {
        this.proyectoActual = proyectoActual;
    }
    
    public List<Proyecto> getListaProyecto() {
        return listaProyecto;
    }
    
    public void setListaProyecto(List<Proyecto> listaProyecto) {
        this.listaProyecto = listaProyecto;
    }
    
    public void validarCodigoProyecto(FacesContext context, UIComponent component, Object o) throws ValidatorException {
        Proyecto u = getProyectoFacade().getByCodigoProyecto((String) o);
        Pattern pat = Pattern.compile("[0-9]{6,8}");
        Matcher mat = pat.matcher((String) o);
        if (mat.matches()) {
            if (u == null) {
                proyectoActual.setCodigoProyecto((String) o);
            } else {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El Codigo del proyecto ya fue registrado"));
            }
        } else {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El codigo de la ficha debe contener 6 digitos númericos"));
        }
    }
    
    public void validarNumeroAprendices(FacesContext context, UIComponent component, Object o) throws ValidatorException {
        String u = (String) o;
        int n;
        Pattern pat = Pattern.compile("[0-9]");
        Matcher mat = pat.matcher((String) o);
        if (mat.matches()) {
            n = Integer.parseInt(u);
            if ((n < 20) || (n > 35)) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El numero de aprendices requeridos debe estar en el rango de 20-35"));
            } else {
                proyectoActual.setAprendicesSugeridos(n);
            }
        } else {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Ingrese el numero de aprendices requeridos para la ejecución del proyecto"));
        }
    }
    
    public void validarNumeroInstructores(FacesContext context, UIComponent component, Object o) throws ValidatorException {
        String u = (String) o;
        int n;
        Pattern pat = Pattern.compile("[0-9]");
        Matcher mat = pat.matcher((String) o);
        if (mat.matches()) {
            n = Integer.parseInt(u);
            if ((n < 10) || (n > 15)) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El numero de instructores requeridos debe estar en el rango de 10-15"));
            } else {
                proyectoActual.setAprendicesSugeridos(n);
            }
        } else {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Ingrese el numero de instructores requeridos para la ejecución del proyecto"));
        }
    }
    
    public String validarProyecto() {
        if (fichaActual.getIdProyecto() == null) {
            return "No hay un proyecto asignado a la ficha";
        } else {
            return fichaActual.getIdProyecto().getCodigoProyecto();
        }
    }
    
    public void asignarFicha(ActionEvent e) {
        fichaActual = (Ficha) e.getComponent().getAttributes().get("ficha");
    }
    
    public void addProyecto(ActionEvent ev) {
        try {
            getProyectoFacade().create(proyectoActual);
            fichaActual.setIdProyecto(proyectoActual);
            getFichaFacade().edit(fichaActual);
            proyectoActual = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Proyecto getProyecto(java.lang.Integer id) {
        return getProyectoFacade().find(id);
    }
    
    public void addActividad() {
        try {
            actividadActual.setIdFase(getFaseFacade().find(idFase));
            actividadActual.setIdProyecto(fichaActual.getIdProyecto());
            getActividadFacade().create(actividadActual);
            faseActividad = idFase;
            idFase = 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ProyectoController() {
    }
    
    @FacesConverter(forClass = Proyecto.class)
    public static class ProyectoControllerConverter implements Converter {
        
        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProyectoController controller = (ProyectoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "proyectoController");
            return controller.getProyecto(getKey(value));
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
            if (object instanceof Proyecto) {
                Proyecto o = (Proyecto) object;
                return getStringKey(o.getIdProyecto());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Proyecto.class.getName()});
                return null;
            }
        }
        
    }
    
}
