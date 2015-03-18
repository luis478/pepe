/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.controller;

import com.pepe.jpa.entities.Aspectos;
import com.pepe.jpa.entities.DescripcionAspectos;
import com.pepe.jpa.entities.Fase;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.Seguimiento;
import com.pepe.jpa.entities.Usuario;
import com.pepe.jpa.sesions.AspectosFacade;
import com.pepe.jpa.sesions.DescripcionAspectosFacade;
import com.pepe.jpa.sesions.FaseFacade;
import com.pepe.jpa.sesions.SeguimientoFacade;
import com.pepe.jpa.sesions.UsuarioHasFichaFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Aprendiz
 */
@ManagedBean
@SessionScoped
public class EjecucionController implements Serializable {

    private Aspectos aspectosActual;
    private List<Aspectos> listaAspectos = null;
    private Ficha fichaActual;
    private List<Seguimiento> listaSeguimiento = null;
    private Seguimiento seguimientoActual;

    @EJB
    private AspectosFacade aspectosFacade;
    @EJB
    private UsuarioHasFichaFacade usuarioHasFichaFacade;
    @EJB
    private SeguimientoFacade seguimientoFacade;
    @EJB
    private DescripcionAspectosFacade descripcionAspectosFacade;
    @EJB
    private FaseFacade faseFacade;

    public List<Seguimiento> getListaSeguimiento() {
        return listaSeguimiento;
    }

    public void setListaSeguimiento(List<Seguimiento> listaSeguimiento) {
        this.listaSeguimiento = listaSeguimiento;
    }

    public SeguimientoFacade getSeguimientoFacade() {
        return seguimientoFacade;
    }

    public void setSeguimientoFacade(SeguimientoFacade seguimientoFacade) {
        this.seguimientoFacade = seguimientoFacade;
    }
    
    public Seguimiento getSeguimientoActual() {
        return seguimientoActual;
    }

    public void setSeguimientoActual(Seguimiento seguimientoActual) {
        this.seguimientoActual = seguimientoActual;
    }

    public DescripcionAspectosFacade getDescripcionAspectosFacade() {
        return descripcionAspectosFacade;
    }

    public FaseFacade getFaseFacade() {
        return faseFacade;
    }

    public List<Usuario> getListaUsuarioOSelectOne() {
        return getUsuarioHasFichaFacade().finByUsuario(seguimientoActual.getIdFicha().getCodigoFicha());

    }

    public List<Fase> getListaFaseSelectOne() {
        return getFaseFacade().findAll();
    }

    public String cargarCreate() {
        return "/aspectos/crear_aspectos";
    }

    public Ficha getFichaActual() {
        return fichaActual;
    }

    public void setFichaActual(Ficha fichaActual) {
        this.fichaActual = fichaActual;
    }

    public UsuarioHasFichaFacade getUsuarioHasFichaFacade() {
        return usuarioHasFichaFacade;
    }

    public void setUsuarioHasFichaFacade(UsuarioHasFichaFacade usuarioHasFichaFacade) {
        this.usuarioHasFichaFacade = usuarioHasFichaFacade;
    }

    /**
     * Creates a new instance of EjecucionController
     */
    public EjecucionController() {
    }

    public AspectosFacade getAspectosFacade() {
        return aspectosFacade;
    }

    public Aspectos getAspectosActual() {
        if (aspectosActual == null) {
            aspectosActual = new Aspectos();

        }
        return aspectosActual;
    }

    public void setAspectosActual(Aspectos AspectosActual) {
        this.aspectosActual = AspectosActual;
    }

    public List<Aspectos> getListaAspectos() {

//        if (listaAspectos==null) {
//            try {
        // listaAspectos = getAspectosFacade().findAll();
//            } catch (Exception e) {
//                System.out.println("Error closing resource " + e.getClass().getName());
//                System.out.println("Message: " + e.getMessage());
//            }
//            
//        }
        return listaAspectos;
    }

    private void recargarLista() {
        listaAspectos = null;
    }

    public String prepareList() {
        recargarLista();
        return "";
    }

    public String prepareEdit() {
        return "Edit";
    }

    public String prepareView() {
        return "View";
    }

    public String addSeguimiento() {
        try {
            seguimientoActual.setFechaRegistro(new Date());
            getSeguimientoFacade().create(seguimientoActual);
            for (Aspectos aspectos : listaAspectos) {
                aspectos.setIdSeguimiento(seguimientoActual);
                getAspectosFacade().create(aspectos);
            }
            addSuccessMessage("crear aspectos", "aspecto creado Exitosamente");
            recargarLista();
            return "View";

        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());

            return null;
        }
    }

    public String updateAspectos() {
        try {
            getAspectosFacade().edit(aspectosActual);

            addSuccessMessage("Actualizar aspectos", "aspecto actualizado Exitosamente");
            return "View";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());

            return null;
        }
    }

    public String deleteAspectos() {
        try {

            getAspectosFacade().remove(aspectosActual);
            addSuccessMessage("Eliminar aspectos", "aspecto eliminado Exitosamente");
            recargarLista();
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
        }
        return "List";
    }

    public void prepareCreate(ActionEvent event) {
        seguimientoActual = new Seguimiento();
        seguimientoActual.setIdFicha(((Ficha) event.getComponent().getAttributes().get("ficha")));
        listaAspectos = new ArrayList<>();

        for (DescripcionAspectos descripcion : getDescripcionAspectosFacade().findAll()) {
            aspectosActual = new Aspectos();
            aspectosActual.setIdDescripcionAspectos(descripcion);
            aspectosActual.setValoracion(true);
            listaAspectos.add(aspectosActual);
        }
    }

    private void addErrorMessage(String title, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    private void addSuccessMessage(String title, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

}
