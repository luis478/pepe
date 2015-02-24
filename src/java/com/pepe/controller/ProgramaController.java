/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.Programa;
import com.pepe.jpa.sesions.ProgramaFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ADSI TARDE
 */
@ManagedBean
@SessionScoped
public class ProgramaController {

   @EJB ProgramaFacade programaFacade;
   
    public ProgramaController() {
    }

    public ProgramaFacade getProgramaFacade() {
        return programaFacade;
    }

    public void setProgramaFacade(ProgramaFacade programaFacade) {
        this.programaFacade = programaFacade;
    }

    
     public Programa getPrograma(com.pepe.jpa.entities.ProgramaPK id) {
        return getProgramaFacade().find(id);
    }

    
     @FacesConverter(forClass = Programa.class, value="ProgramaConverter")
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

        com.pepe.jpa.entities.ProgramaPK getKey(String value) {
            com.pepe.jpa.entities.ProgramaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.pepe.jpa.entities.ProgramaPK();
            key.setCodigo(values[0]);
            key.setVersion(values[1]);
            return key;
        }

        String getStringKey(com.pepe.jpa.entities.ProgramaPK value) {
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
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Programa.class.getName());
            }
        }

    }
    
}
