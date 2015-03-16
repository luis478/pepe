package com.pepe.controller;

import com.pepe.jpa.entities.Caracterizacion;
import com.pepe.jpa.entities.Desercion;
import com.pepe.jpa.entities.Eps;
import com.pepe.jpa.entities.Especialidad;
import com.pepe.jpa.entities.EstiloAprendizaje;
import com.pepe.jpa.entities.Genero;
import com.pepe.jpa.entities.LibretaMilitar;
import com.pepe.jpa.entities.Rol;
import com.pepe.jpa.entities.TipoContrato;
import com.pepe.jpa.entities.TipoDocumento;
import com.pepe.jpa.entities.TipoSangre;
import com.pepe.jpa.entities.TipoVocero;
import com.pepe.jpa.entities.Usuario;
import com.pepe.jpa.sesions.CaracterizacionFacade;
import com.pepe.jpa.sesions.DesercionFacade;
import com.pepe.jpa.sesions.EpsFacade;
import com.pepe.jpa.sesions.EspecialidadFacade;
import com.pepe.jpa.sesions.EstiloAprendizajeFacade;
import com.pepe.jpa.sesions.FaseFacade;
import com.pepe.jpa.sesions.FichaFacade;
import com.pepe.jpa.sesions.GeneroFacade;
import com.pepe.jpa.sesions.LibretaMilitarFacade;
import com.pepe.jpa.sesions.RolFacade;
import com.pepe.jpa.sesions.TipoContratoFacade;
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
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private CaracterizacionFacade caracterizacionFacade;
    @EJB
    private EstiloAprendizajeFacade estiloAprendizajeFacade;

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
    private TipoContratoFacade tipoContratoFacade;
    @EJB
    private RolFacade rolFacade;
    private List<Rol> listaRol = null;
    private Usuario usuarioActual;
    private List<Usuario> listaUsuario = null;
    int tipoContratoSelect;
    private List<Usuario> listaUsuarios = null;

    public RolFacade getRolFacade() {
        return rolFacade;
    }

    public void setRolFacade(RolFacade rolFacade) {
        this.rolFacade = rolFacade;
    }

    public List<Rol> getListaRol() {
        return listaRol;
    }

    public void setListaRol(List<Rol> listaRol) {
        this.listaRol = listaRol;
    }

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

    /* select one menu Patrocinio
     public PatrocinioFacade getPatrocinioFacade() {
     return patrocinioFacade;
     }
     public void setPatrocinioFacade(PatrocinioFacade patrocinioFacade) {
     this.patrocinioFacade = patrocinioFacade;
     }
     public List<Patrocinio> getListaPatrocinioSelectOne() {
     return getPatrocinioFacade().findAll();
     }*/
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

    // select one tipo contrato
    public int getTipoContratoSelect() {
        if (usuarioActual != null && usuarioActual.getIdTipoContrato() != null) {
            tipoContratoSelect = usuarioActual.getIdUsuario();
        }
        return tipoContratoSelect;
    }

    public void setTipoContratoSelect(int tipoContratoSelect) {
        this.tipoContratoSelect = tipoContratoSelect;
    }

    public TipoContratoFacade getTipoContratoFacade() {
        return tipoContratoFacade;
    }

    public void setTipoContratoFacade(TipoContratoFacade tipoContratoFacade) {
        this.tipoContratoFacade = tipoContratoFacade;
    }

    public List<TipoContrato> getListaTipoContratoSelectOne() {
        return getTipoContratoFacade().findAll();
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

    public List<Usuario> getListaUsuarios() {
        listaUsuarios = new ArrayList<>();
        listaUsuarios = getUsuarioFacade().findAll();
        return listaUsuarios;
    }

    public List<Usuario> getListaUsuariosInstr() {
        List<Usuario> listaUsuariosInstr = new ArrayList<>();
        boolean b;
        for (Usuario u : getListaUsuarios()) {
            b = false;
            for (Rol r : u.getRolList()) {
                if (r.getCodigoRol().equals("INSTR")) {
                    b = true;
                }
            }
            if (b) {
                listaUsuariosInstr.add(u);
            }
        }
        return listaUsuariosInstr;
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

    public void prepareCreate() {
        usuarioActual = new Usuario();
        listaRol = new ArrayList<>();
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
                listaRol = new ArrayList<>();
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

    public Usuario getUsuario(java.lang.Integer id) {
        return usuarioFacade.find(id);
    }

    @FacesConverter(forClass = Usuario.class)
    public static class UsuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioController controller = (UsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioController");
            return controller.getUsuario(getKey(value));
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
            if (object instanceof Usuario) {
                Usuario o = (Usuario) object;
                return getStringKey(o.getIdUsuario());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Usuario.class.getName());
            }
        }

    }
}
