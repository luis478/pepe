package com.pepe.controller;

import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.Revision;
import com.pepe.jpa.entities.TipoRevision;
import com.pepe.jpa.entities.Valoracion;
import com.pepe.jpa.entities.Variable;
import com.pepe.jpa.sesions.RevisionFacade;
import com.pepe.jpa.sesions.ValoracionFacade;
import com.pepe.jpa.sesions.VariableFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named("variableController")
@SessionScoped
public class VariableController implements Serializable {

    @EJB
    private VariableFacade variableFacade;
    @EJB
    private RevisionFacade revisionFacade;
    @EJB
    private ValoracionFacade valoracionFacade;
    
    private Valoracion valoracionActual;
    private Variable variableActual;
    private List<Variable> listaVariable;
    private Ficha fichaActual;
    private List<Valoracion> listaValoracion;
    private Revision revisionActual;

    public List<Valoracion> getListaValoracion() {
        return listaValoracion;
    }

    public void setListaValoracion(List<Valoracion> listaValoracion) {
        this.listaValoracion = listaValoracion;
    }

    public VariableFacade getVariableFacade() {
        return variableFacade;
    }

    public Valoracion getValoracionActual() {
        return valoracionActual;
    }

    public void setValoracionActual(Valoracion valoracionActual) {
        this.valoracionActual = valoracionActual;
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

    public RevisionFacade getRevisionFacade() {
        return revisionFacade;
    }

    public void setRevisionFacade(RevisionFacade revisionFacade) {
        this.revisionFacade = revisionFacade;
    }

    public ValoracionFacade getValoracionFacade() {
        return valoracionFacade;
    }

    public void setValoracionFacade(ValoracionFacade valoracionFacade) {
        this.valoracionFacade = valoracionFacade;
    }

    public Variable getVariableActual() {
        if (variableActual == null) {
            variableActual = new Variable();
        }
        return variableActual;
    }

    public void setVariableActual(Variable variableActual) {
        this.variableActual = variableActual;
    }

    public List<Variable> getListaVariable() {
        return listaVariable;
    }

    public void setListaVariable(List<Variable> listaVariable) {
        this.listaVariable = listaVariable;
    }

    public void setVariableFacade(VariableFacade variableFacade) {
        this.variableFacade = variableFacade;
    }

    public VariableController() {
    }

    public String prepareList() {

        return "List";
    }

    public String prepareView() {

        return "View";
    }

    public void prepareCreate(ActionEvent event) {
        fichaActual = ((Ficha) event.getComponent().getAttributes().get("ficha"));
        revisionActual = new Revision();
        revisionActual.setIdProyecto(fichaActual.getIdProyecto());
        revisionActual.setFechaRevision(new Date());
        revisionActual.setIdTipoRevision(new TipoRevision(Integer.parseInt((String) event.getComponent().getAttributes().get("variable"))));
        variableActual = new Variable();
        listaValoracion = new ArrayList<>();

        for (Variable variableGeneral : getVariableFacade().findByIdTipoRevision(revisionActual.getIdTipoRevision())) {
            valoracionActual = new Valoracion();
            valoracionActual.setIdVariable(variableGeneral);
            valoracionActual.setCumple(true);
            listaValoracion.add(valoracionActual);
        }
    }

    public boolean tipoRevisionForm() {
        if (revisionActual.getIdTipoRevision().getIdTipoRevision() == 1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isProyecto() {
        return revisionActual.getIdTipoRevision().getIdTipoRevision() == 1;
    }

    public String cargarCreate() {
        return "/Valoracion/crearValoracion";
    }

    public Variable getVariable(java.lang.Integer id) {
        return variableFacade.find(id);
    }

    @FacesConverter(forClass = Variable.class)
    public static class VariableControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VariableController controller = (VariableController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "variableController");
            return controller.getVariable(getKey(value));
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
            if (object instanceof Variable) {
                Variable o = (Variable) object;
                return getStringKey(o.getIdVariable());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Variable.class.getName());
            }
        }

    }

}
