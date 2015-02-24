/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.UsuarioHasFicha;
import com.pepe.jpa.sesions.UsuarioHasFichaFacade;
import java.util.List;
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
public class UsuarioHasFichaController {
    
    @EJB
    private UsuarioHasFichaFacade usuarioHasFichaFacade;
    
    private List<Ficha> listaFicha = null;
    private UsuarioHasFicha fichaSeleccionada;
    private int idTipoInstructor;
    public UsuarioHasFichaController() {
    }

    public UsuarioHasFichaFacade getUsuarioHasFichaFacade() {
        return usuarioHasFichaFacade;
    }

    public void setUsuarioHasFichaFacade(UsuarioHasFichaFacade usuarioHasFichaFacade) {
        this.usuarioHasFichaFacade = usuarioHasFichaFacade;
    }

    

    public List<Ficha> getListaFicha() {
        return listaFicha;
    }

    public void setListaFicha(List<Ficha> listaFicha) {
        this.listaFicha = listaFicha;
    }

    public UsuarioHasFicha getFichaSeleccionada() {
        return fichaSeleccionada;
    }

    public void setFichaSeleccionada(UsuarioHasFicha fichaSeleccionada) {
        this.fichaSeleccionada = fichaSeleccionada;
    }

    

    public int getIdTipoInstructor() {
        return idTipoInstructor;
    }

    public void setIdTipoInstructor(int idTipoInstructor) {
        this.idTipoInstructor = idTipoInstructor;
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
