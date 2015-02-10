/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.controller;

import com.pepe.jpa.entities.Caracterizacion;
import com.pepe.jpa.entities.Desercion;
import com.pepe.jpa.entities.Eps;
import com.pepe.jpa.entities.Especialidad;
import com.pepe.jpa.entities.EstiloAprendizaje;
import com.pepe.jpa.entities.Genero;
import com.pepe.jpa.entities.LibretaMilitar;
import com.pepe.jpa.entities.Patrocinio;
import com.pepe.jpa.entities.Rol;
import com.pepe.jpa.entities.TipoDocumento;
import com.pepe.jpa.entities.TipoSangre;
import com.pepe.jpa.entities.TipoVocero;
import com.pepe.jpa.entities.Usuario;
import com.pepe.jpa.sesions.CaracterizacionFacade;
import com.pepe.jpa.sesions.DesercionFacade;
import com.pepe.jpa.sesions.EpsFacade;
import com.pepe.jpa.sesions.EspecialidadFacade;
import com.pepe.jpa.sesions.EstiloAprendizajeFacade;
import com.pepe.jpa.sesions.GeneroFacade;
import com.pepe.jpa.sesions.LibretaMilitarFacade;
import com.pepe.jpa.sesions.PatrocinioFacade;
import com.pepe.jpa.sesions.RolFacade;
import com.pepe.jpa.sesions.TipoDocumentoFacade;
import com.pepe.jpa.sesions.TipoSangreFacade;
import com.pepe.jpa.sesions.TipoVoceroFacade;
import com.pepe.jpa.sesions.UsuarioFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Windows 8
 */
@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable{

   @EJB
    private UsuarioFacade usuarioFacade;
   @EJB
    private CaracterizacionFacade caracterizacionFacade;
   @EJB
    private EstiloAprendizajeFacade estiloAprendizajeFacade;
   @EJB
    private PatrocinioFacade patrocinioFacade;
   @EJB
    private DesercionFacade desercionFacade;
   @EJB
    private TipoVoceroFacade tipoVoceroFacade;
   @EJB
    private TipoDocumentoFacade tipoDocumentoFacade;
   @EJB
    private GeneroFacade generoFacade;
   @EJB
    private TipoSangreFacade tipoSangreFacade;
   @EJB
    private LibretaMilitarFacade libretaMilitarFacade;
   @EJB
    private EpsFacade epsFacade;
   @EJB
    private EspecialidadFacade especialidadFacade;
   @EJB
    private RolFacade rolFacade;
    private List<Rol> listaRol = null;
    private Usuario usuarioActual;
    private List<Usuario> listaUsuario = null;

    
    
    // select one menu caracterizacion
    public CaracterizacionFacade getCaracterizacionFacade() {
        return caracterizacionFacade;
    }
    public void setCaracterizacionFacade(CaracterizacionFacade caracterizacionFacade) {
        this.caracterizacionFacade = caracterizacionFacade;
    }
    public List<Caracterizacion> getListaCaracterizacionSelectOne() {
        return getCaracterizacionFacade().findAll();
    }

    
    
    // select one menu Estilo de aprendizaje
    public EstiloAprendizajeFacade getEstiloAprendizajeFacade() {
        return estiloAprendizajeFacade;
    }
    public void setEstiloAprendizajeFacade(EstiloAprendizajeFacade estiloAprendizajeFacade) {
        this.estiloAprendizajeFacade = estiloAprendizajeFacade;
    }
    public List<EstiloAprendizaje> getListaEstiloAprendizajeSelectOne() {
        return getEstiloAprendizajeFacade().findAll();
    }
    
    
    // select one menu Patrocinio
    public PatrocinioFacade getPatrocinioFacade() {
        return patrocinioFacade;
    }
    public void setPatrocinioFacade(PatrocinioFacade patrocinioFacade) {
        this.patrocinioFacade = patrocinioFacade;
    }
    public List<Patrocinio> getListaPatrocinioSelectOne() {
        return getPatrocinioFacade().findAll();
    }
    
    
    // select one menu Desercion
    public DesercionFacade getDesercionFacade() {
        return desercionFacade;
    }
    public void setDesercionFacade(DesercionFacade desercionFacade) {
        this.desercionFacade = desercionFacade;
    }
    public List<Desercion> getListaDesercionSelectOne() {
        return getDesercionFacade().findAll();
    }
    
    
    // select one menu Tipo Vocero
    public TipoVoceroFacade getTipoVoceroFacade() {
        return tipoVoceroFacade;
    }
    public void setTipoVoceroFacade(TipoVoceroFacade tipoVoceroFacade) {
        this.tipoVoceroFacade = tipoVoceroFacade;
    }
    public List<TipoVocero> getListaTipoVoceroSelectOne() {
        return getTipoVoceroFacade().findAll();
    }
    
    // select one menu Tipo Documento
    public TipoDocumentoFacade getTipoDocumentoFacade() {
        return tipoDocumentoFacade;
    }
    public void setTipoDocumentoFacade(TipoDocumentoFacade tipoDocumentoFacade) {
        this.tipoDocumentoFacade = tipoDocumentoFacade;
    }
    public List<TipoDocumento> getListaTipoDocumentoSelectOne() {
        return getTipoDocumentoFacade().findAll();
    }
    
    
    // select one menu Genero
    public GeneroFacade getGeneroFacade() {
        return generoFacade;
    }
    public void setGeneroFacade(GeneroFacade generoFacade) {
        this.generoFacade = generoFacade;
    }
    public List<Genero> getListaGeneroSelectOne() {
        return getGeneroFacade().findAll();
    }
    
    // select one menu Tipo de Sangre
    public TipoSangreFacade getTipoSangreFacade() {
        return tipoSangreFacade;
    }
    public void setTipoSangreFacade(TipoSangreFacade tipoSangreFacade) {
        this.tipoSangreFacade = tipoSangreFacade;
    }
    public List<TipoSangre> getListaTipoSangreSelectOne() {
        return getTipoSangreFacade().findAll();
    }
    
    // select one menu libreta Militar
    public LibretaMilitarFacade getLibretaMilitarFacade() {
        return libretaMilitarFacade;
    }
    public void setLibretaMilitarFacade(LibretaMilitarFacade libretaMilitarFacade) {
        this.libretaMilitarFacade = libretaMilitarFacade;
    }
    public List<LibretaMilitar> getListaLibretaMilitarSelectOne() {
        return getLibretaMilitarFacade().findAll();
    }
    
    
    // select one menu Eps
    public EpsFacade getEpsFacade() {
        return epsFacade;
    }
    public void setEpsFacade(EpsFacade epsFacade) {
        this.epsFacade = epsFacade;
    }
    public List<Eps> getListaEpsSelectOne() {
        return getEpsFacade().findAll();
    }
    
        // select one menu Especialidad
    public EspecialidadFacade getEspecialidadFacade() {
        return especialidadFacade;
    }
    public void setEspecialidadFacade(EspecialidadFacade especialidadFacade) {
        this.especialidadFacade = especialidadFacade;
    }
    public List<Especialidad> getListaEspecialidadSelectOne() {
        return getEspecialidadFacade().findAll();
    }
    
    /**
     * Creates a new instance of CiudadController
     */
    public UsuarioController() {
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }
    public Usuario getUsuarioActual() {
        if (usuarioActual == null) {
            usuarioActual = new Usuario();
        }
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

  
    public List<Usuario> getListaUsuario() {
        if (listaUsuario == null) {
            try {
                listaUsuario = getUsuarioFacade().findAll();
            } catch (Exception e) {
                addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaUsuario;
    }

    private void recargarLista() {
        listaUsuario = null;
    }

    public String prepareCreate() {
        usuarioActual = new Usuario();
        listaRol= new ArrayList<>();
        return "/admin/crear_usuario";
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

    public String addUsuario() {
        try {
            usuarioActual.setEstado(true);
              if (listaRol == null || listaRol.isEmpty()) {
                listaRol= new ArrayList<>();
                listaRol.add(new Rol(2));
                usuarioActual.setRolList(listaRol); 
            } else {
                usuarioActual.setRolList(listaRol);
            }
            getUsuarioFacade().create(usuarioActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String updateUsuario() {
        try {
            getUsuarioFacade().edit(usuarioActual);
            recargarLista();
            return "";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }

    public String deleteUsuario() {
        try {
            getUsuarioFacade().remove(usuarioActual);
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
    
}
