
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.jpa.entities;

import controller.util.DigestUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis Carlos
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNumeroDocumento", query = "SELECT u FROM Usuario u WHERE u.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Usuario.findByNombre1", query = "SELECT u FROM Usuario u WHERE u.nombre1 = :nombre1"),
    @NamedQuery(name = "Usuario.findByNombre2", query = "SELECT u FROM Usuario u WHERE u.nombre2 = :nombre2"),
    @NamedQuery(name = "Usuario.findByApellido1", query = "SELECT u FROM Usuario u WHERE u.apellido1 = :apellido1"),
    @NamedQuery(name = "Usuario.findByApellido2", query = "SELECT u FROM Usuario u WHERE u.apellido2 = :apellido2"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByCorreo1", query = "SELECT u FROM Usuario u WHERE u.correo1 = :correo1"),
    @NamedQuery(name = "Usuario.findByCorreo2", query = "SELECT u FROM Usuario u WHERE u.correo2 = :correo2"),
    @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByFechaExpedicion", query = "SELECT u FROM Usuario u WHERE u.fechaExpedicion = :fechaExpedicion"),
    @NamedQuery(name = "Usuario.findByTelefono2", query = "SELECT u FROM Usuario u WHERE u.telefono2 = :telefono2"),
    @NamedQuery(name = "Usuario.findByTelefono3", query = "SELECT u FROM Usuario u WHERE u.telefono3 = :telefono3")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_1")
    private String nombre1;
    @Size(max = 45)
    @Column(name = "nombre_2")
    private String nombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido_1")
    private String apellido1;
    @Size(max = 45)
    @Column(name = "apellido_2")
    private String apellido2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo_1")
    private String correo1;
    @Size(max = 45)
    @Column(name = "correo_2")
    private String correo2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private short estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_expedicion")
    @Temporal(TemporalType.DATE)
    private Date fechaExpedicion;
    @Size(max = 10)
    @Column(name = "telefono_2")
    private String telefono2;
    @Size(max = 10)
    @Column(name = "telefono_3")
    private String telefono3;
    @JoinTable(name = "rol_has_usuario", joinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")})
       @ManyToMany
       private  List<Rol> rolList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Evento> eventoList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Revision> revisionList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<ActividadAprendizaje> actividadAprendizajeList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Area> areaList;
    @ManyToMany(mappedBy = "usuarioList")
    
    private List<Aspectos> aspectosList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<CentroFormacion> centroFormacionList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Acompanamiento> acompanamientoList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Ciudad> ciudadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<Verificacion> verificacionList;
    @JoinColumn(name = "id_patrocinio", referencedColumnName = "id_patrocinio")
    @ManyToOne
    private Patrocinio idPatrocinio;
    @JoinColumn(name = "id_caracterizacion", referencedColumnName = "id_caracterizacion")
    @ManyToOne
    private Caracterizacion idCaracterizacion;
    @JoinColumn(name = "id_desercion", referencedColumnName = "id_desercion")
    @ManyToOne
    private Desercion idDesercion;
    @JoinColumn(name = "id_estilo_aprendizaje", referencedColumnName = "id_estilo_aprendizaje")
    @ManyToOne
    private EstiloAprendizaje idEstiloAprendizaje;
    @JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
    @ManyToOne(optional = false)
    private Genero idGenero;
    @JoinColumn(name = "id_libreta_militar", referencedColumnName = "id_libreta_militar")
    @ManyToOne
    private LibretaMilitar idLibretaMilitar;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne(optional = false)
    private TipoDocumento idTipoDocumento;
    @JoinColumn(name = "id_tipo_sangre", referencedColumnName = "id_tipo_sangre")
    @ManyToOne(optional = false)
    private TipoSangre idTipoSangre;
    @JoinColumn(name = "id_tipo_contrato", referencedColumnName = "id_tipo_contrato")
    @ManyToOne
    private TipoContrato idTipoContrato;
    @JoinColumn(name = "id_tipo_vocero", referencedColumnName = "id_tipo_vocero")
    @ManyToOne
    private TipoVocero idTipoVocero;
    @JoinColumn(name = "id_eps", referencedColumnName = "id_eps")
    @ManyToOne(optional = false)
    private Eps idEps;
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")
    @ManyToOne
    private Especialidad idEspecialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<UsuarioHasFicha> usuarioHasFichaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<ResultadoAprendizaje> resultadoAprendizajeList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String numeroDocumento, String nombre1, String apellido1, String telefono, String correo1, String direccion, short estado, String password, Date fechaExpedicion) {
        this.idUsuario = idUsuario;
        this.numeroDocumento = numeroDocumento;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.telefono = telefono;
        this.correo1 = correo1;
        this.direccion = direccion;
        this.estado = estado;
        this.password = password;
        this.fechaExpedicion = fechaExpedicion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo1() {
        return correo1;
    }

    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
    }

    public String getCorreo2() {
        return correo2;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws UnsupportedEncodingException {
        try {
            this.password = DigestUtil.generateDigest(password);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getTelefono3() {
        return telefono3;
    }

    public void setTelefono3(String telefono3) {
        this.telefono3 = telefono3;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @XmlTransient
    public List<Revision> getRevisionList() {
        return revisionList;
    }

    public void setRevisionList(List<Revision> revisionList) {
        this.revisionList = revisionList;
    }

    @XmlTransient
    public List<ActividadAprendizaje> getActividadAprendizajeList() {
        return actividadAprendizajeList;
    }

    public void setActividadAprendizajeList(List<ActividadAprendizaje> actividadAprendizajeList) {
        this.actividadAprendizajeList = actividadAprendizajeList;
    }

    @XmlTransient
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Aspectos> getAspectosList() {
        return aspectosList;
    }

    public void setAspectosList(List<Aspectos> aspectosList) {
        this.aspectosList = aspectosList;
    }

    @XmlTransient
    public List<CentroFormacion> getCentroFormacionList() {
        return centroFormacionList;
    }

    public void setCentroFormacionList(List<CentroFormacion> centroFormacionList) {
        this.centroFormacionList = centroFormacionList;
    }

    @XmlTransient
    public List<Acompanamiento> getAcompanamientoList() {
        return acompanamientoList;
    }

    public void setAcompanamientoList(List<Acompanamiento> acompanamientoList) {
        this.acompanamientoList = acompanamientoList;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }



    @XmlTransient
    public List<Verificacion> getVerificacionList() {
        return verificacionList;
    }

    public void setUsuarioHasFichaList(List<UsuarioHasFicha> usuarioHasFichaList) {
        this.usuarioHasFichaList = usuarioHasFichaList;
    }

    public Patrocinio getIdPatrocinio() {
        return idPatrocinio;
    }

    public void setIdPatrocinio(Patrocinio idPatrocinio) {
        this.idPatrocinio = idPatrocinio;
    }

    public Caracterizacion getIdCaracterizacion() {
        return idCaracterizacion;
    }

    public void setIdCaracterizacion(Caracterizacion idCaracterizacion) {
        this.idCaracterizacion = idCaracterizacion;
    }

    public Desercion getIdDesercion() {
        return idDesercion;
    }

    public void setIdDesercion(Desercion idDesercion) {
        this.idDesercion = idDesercion;
    }

    public EstiloAprendizaje getIdEstiloAprendizaje() {
        return idEstiloAprendizaje;
    }

    public void setIdEstiloAprendizaje(EstiloAprendizaje idEstiloAprendizaje) {
        this.idEstiloAprendizaje = idEstiloAprendizaje;
    }

    public Genero getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Genero idGenero) {
        this.idGenero = idGenero;
    }

    public LibretaMilitar getIdLibretaMilitar() {
        return idLibretaMilitar;
    }

    public void setIdLibretaMilitar(LibretaMilitar idLibretaMilitar) {
        this.idLibretaMilitar = idLibretaMilitar;
    }


    public TipoSangre getIdTipoSangre() {
        return idTipoSangre;
    }

    public void setIdTipoSangre(TipoSangre idTipoSangre) {
        this.idTipoSangre = idTipoSangre;
    }

    public TipoContrato getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(TipoContrato idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public TipoVocero getIdTipoVocero() {
        return idTipoVocero;
    }

    public void setIdTipoVocero(TipoVocero idTipoVocero) {
        this.idTipoVocero = idTipoVocero;
    }

    public Eps getIdEps() {
        return idEps;
    }

    public void setIdEps(Eps idEps) {
        this.idEps = idEps;
    }

    public Especialidad getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Especialidad idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    @XmlTransient
    public List<UsuarioHasFicha> getUsuarioHasFichaList() {
        return usuarioHasFichaList;
    }

 
    @XmlTransient
    public List<ResultadoAprendizaje> getResultadoAprendizajeList() {
        return resultadoAprendizajeList;
    }

    public void setResultadoAprendizajeList(List<ResultadoAprendizaje> resultadoAprendizajeList) {
        this.resultadoAprendizajeList = resultadoAprendizajeList;
    }

  
    public void setVerificacionList(List<Verificacion> verificacionList) {
        this.verificacionList = verificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}




























