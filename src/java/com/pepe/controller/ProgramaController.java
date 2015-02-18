package com.pepe.controller;

import com.pepe.jpa.entities.Programa;
import com.pepe.jpa.entities.ProgramaPK;
import com.pepe.jpa.sesions.ProgramaFacade;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

/**
 *
 * @author EQUIPO 3
 */
@Named(value = "programaController")
@SessionScoped
public class ProgramaController implements Serializable {

    @EJB
    private ProgramaFacade programaFacade;
    private Programa programaActual = null;
    private Programa programaSeleccionado;

    public ProgramaController() {
    }

    public Programa getProgramaActual() {
        if(programaActual == null){
            programaActual = new Programa();
        }
        return programaActual;
    }

    public void setProgramaActual(Programa programaActual) {
        this.programaActual = programaActual;
    }

    public ProgramaFacade getProgramaFacade() {
        return programaFacade;
    }

    public void setProgramaFacade(ProgramaFacade programaFacade) {
        this.programaFacade = programaFacade;
    }

    public Programa getProgramaSeleccionado() {
        return programaSeleccionado;
    }

    public void setProgramaSeleccionado(Programa programaSeleccionado) {
        this.programaSeleccionado = programaSeleccionado;
    }

    public List<Programa> autoCompletarNombre(String query) {
        try {
            return getProgramaFacade().autoCompletarNombre(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void anular(){
        programaActual = null;
        programaSeleccionado = null;
    }
    
    public boolean programaSeleccionadoNull(){
        if(programaSeleccionado != null){
            return true;
        }else {
            return false;
        }
    }

    /*   CONVERTER   */
    public Programa getPrograma(ProgramaPK id) {
        return getProgramaFacade().find(id);
    }

    @FacesConverter(forClass = Programa.class, value = "programaConverter")
    public static class ProgramaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProgramaController controller = (ProgramaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "programaController");
            return controller.getPrograma(getKey(value));
        }

        ProgramaPK getKey(String value) {
            ProgramaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new ProgramaPK();
            key.setCodigo(values[0]);
            key.setVersion(values[1]);
            return key;
        }

        String getStringKey(ProgramaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getVersion());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Programa) {
                Programa o = (Programa) object;
                return getStringKey(o.getProgramaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Programa.class.getName()});
                return null;
            }
        }

    }

}
