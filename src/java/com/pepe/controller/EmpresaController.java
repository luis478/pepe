/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.Empresa;
import com.pepe.jpa.sesions.EmpresaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Windows 8
 */
@ManagedBean
@SessionScoped
public class EmpresaController {

    @EJB
    private EmpresaFacade EmpresaFacade;
    private List<Empresa> listaEmpresa = null;
    private Empresa empresaActual;   

    /**
     * Creates a new instance of CiudadController
     */
    public EmpresaController() {
    }

    public EmpresaFacade getEmpresaFacade() {
        return EmpresaFacade;
    }
    public Empresa getEmpresaActual() {
        if (empresaActual == null) {
            empresaActual = new Empresa();
        }
        return empresaActual;
    }

    public void setEmpresaActual(Empresa empresaActual) {
        this.empresaActual = empresaActual;
    }

  
    public List<Empresa> getListaEmpresa() {
        if (listaEmpresa == null) {
            try {
                listaEmpresa = getEmpresaFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaEmpresa;
    }

    private void recargarLista() {
        listaEmpresa = null;
    }

    public String prepareCreate() {
        empresaActual = new Empresa();
        return "/admin/crear_empresa";
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

    public String addEmpresa() {
        try {

            getEmpresaFacade().create(empresaActual);
            recargarLista();
            return "crear_empresa";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateEmpresa() {
        try {
            getEmpresaFacade().edit(empresaActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteEmpresa() {
        try {
            getEmpresaFacade().remove(empresaActual);
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
    
    public Empresa getEmpresa(java.lang.Integer id) {
        return getEmpresaFacade().find(id);
    }
    
   @FacesConverter(forClass = Empresa.class)
    public static class EmpresaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmpresaController controller = (EmpresaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "empresaController");
            return controller.getEmpresa(getKey(value));
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
            if (object instanceof Empresa) {
                Empresa o = (Empresa) object;
                return getStringKey(o.getIdEmpresa());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Empresa.class.getName());
            }
        }
   }
}

    

