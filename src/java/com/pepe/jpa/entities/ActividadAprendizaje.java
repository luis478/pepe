/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Junior Cabal
 */
@Entity
@Table(name = "actividad_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadAprendizaje.findAll", query = "SELECT a FROM ActividadAprendizaje a"),
    @NamedQuery(name = "ActividadAprendizaje.findByConsultaActividad", query = "SELECT a FROM ActividadAprendizaje a WHERE a.idActividad = :idActividad"),
    @NamedQuery(name = "ActividadAprendizaje.findByFase", query = "SELECT a FROM ActividadAprendizaje a WHERE a.idActividad.idProyecto = :idProyecto AND a.idActividad.idFase = :idFase"),
    @NamedQuery(name = "ActividadAprendizaje.findByIdActividadAprendizaje", query = "SELECT a FROM ActividadAprendizaje a WHERE a.idActividadAprendizaje = :idActividadAprendizaje"),
    @NamedQuery(name = "ActividadAprendizaje.findByDuracionActividadAprendizaje", query = "SELECT a FROM ActividadAprendizaje a WHERE a.duracionActividadAprendizaje = :duracionActividadAprendizaje")})
public class ActividadAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actividad_aprendizaje")
    private Integer idActividadAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_actividad_aprendizaje")
    private String nombreActividadAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion_actividad_aprendizaje")
    private int duracionActividadAprendizaje;
    @Basic(optional = false)
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "actividad_aprendizaje_has_recurso", joinColumns = {
        @JoinColumn(name = "id_actividad_aprendizaje", referencedColumnName = "id_actividad_aprendizaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_recurso", referencedColumnName = "id_recurso")})
    @ManyToMany
    private List<Recurso> recursoList;
    @JoinTable(name = "actividad_aprendizaje_has_tecnica_didactica", joinColumns = {
        @JoinColumn(name = "id_actividad_aprendizaje", referencedColumnName = "id_actividad_aprendizaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tecnica_didactica", referencedColumnName = "id_tecnica_didactica")})
    @ManyToMany
    private List<TecnicaDidactica> tecnicaDidacticaList;
    @JoinTable(name = "actividad_aprendizaje_has_resultado_aprendizaje", joinColumns = {
        @JoinColumn(name = "id_actividad_aprendizaje", referencedColumnName = "id_actividad_aprendizaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje")})
    @ManyToMany
    private List<ResultadoAprendizaje> resultadoAprendizajeList;
    @JoinTable(name = "actividad_aprendizaje_has_usuario", joinColumns = {
        @JoinColumn(name = "id_actividad_aprendizaje", referencedColumnName = "id_actividad_aprendizaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @JoinColumn(name = "id_tipo_actividad_aprendizaje", referencedColumnName = "id_tipo_actividad_aprendizaje")
    @ManyToOne(optional = false)
    private TipoActividadAprendizaje idTipoActividadAprendizaje;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad")
    @ManyToOne(optional = false)
    private Actividad idActividad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadAprendizaje")
    private List<ActividadAprendizajeHasGuiaAprendizaje> actividadAprendizajeHasGuiaAprendizajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadAprendizaje")
    private List<Evidencia> evidenciaList;

    public ActividadAprendizaje() {
    }

    public ActividadAprendizaje(Integer idActividadAprendizaje) {
        this.idActividadAprendizaje = idActividadAprendizaje;
    }

    public ActividadAprendizaje(Integer idActividadAprendizaje, String nombreActividadAprendizaje, int duracionActividadAprendizaje, String observaciones, String descripcion) {
        this.idActividadAprendizaje = idActividadAprendizaje;
        this.nombreActividadAprendizaje = nombreActividadAprendizaje;
        this.duracionActividadAprendizaje = duracionActividadAprendizaje;
        this.observaciones = observaciones;
        this.descripcion = descripcion;
    }

    public Integer getIdActividadAprendizaje() {
        return idActividadAprendizaje;
    }

    public void setIdActividadAprendizaje(Integer idActividadAprendizaje) {
        this.idActividadAprendizaje = idActividadAprendizaje;
    }

    public String getNombreActividadAprendizaje() {
        return nombreActividadAprendizaje;
    }

    public void setNombreActividadAprendizaje(String nombreActividadAprendizaje) {
        this.nombreActividadAprendizaje = nombreActividadAprendizaje;
    }

    public int getDuracionActividadAprendizaje() {
        return duracionActividadAprendizaje;
    }

    public void setDuracionActividadAprendizaje(int duracionActividadAprendizaje) {
        this.duracionActividadAprendizaje = duracionActividadAprendizaje;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Recurso> getRecursoList() {
        return recursoList;
    }

    public void setRecursoList(List<Recurso> recursoList) {
        this.recursoList = recursoList;
    }

    @XmlTransient
    public List<TecnicaDidactica> getTecnicaDidacticaList() {
        return tecnicaDidacticaList;
    }

    public void setTecnicaDidacticaList(List<TecnicaDidactica> tecnicaDidacticaList) {
        this.tecnicaDidacticaList = tecnicaDidacticaList;
    }

    @XmlTransient
    public List<ResultadoAprendizaje> getResultadoAprendizajeList() {
        return resultadoAprendizajeList;
    }

    public void setResultadoAprendizajeList(List<ResultadoAprendizaje> resultadoAprendizajeList) {
        this.resultadoAprendizajeList = resultadoAprendizajeList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public TipoActividadAprendizaje getIdTipoActividadAprendizaje() {
        return idTipoActividadAprendizaje;
    }

    public void setIdTipoActividadAprendizaje(TipoActividadAprendizaje idTipoActividadAprendizaje) {
        this.idTipoActividadAprendizaje = idTipoActividadAprendizaje;
    }

    public Actividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Actividad idActividad) {
        this.idActividad = idActividad;
    }

    @XmlTransient
    public List<ActividadAprendizajeHasGuiaAprendizaje> getActividadAprendizajeHasGuiaAprendizajeList() {
        return actividadAprendizajeHasGuiaAprendizajeList;
    }

    public void setActividadAprendizajeHasGuiaAprendizajeList(List<ActividadAprendizajeHasGuiaAprendizaje> actividadAprendizajeHasGuiaAprendizajeList) {
        this.actividadAprendizajeHasGuiaAprendizajeList = actividadAprendizajeHasGuiaAprendizajeList;
    }

    @XmlTransient
    public List<Evidencia> getEvidenciaList() {
        return evidenciaList;
    }

    public void setEvidenciaList(List<Evidencia> evidenciaList) {
        this.evidenciaList = evidenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividadAprendizaje != null ? idActividadAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadAprendizaje)) {
            return false;
        }
        ActividadAprendizaje other = (ActividadAprendizaje) object;
        if ((this.idActividadAprendizaje == null && other.idActividadAprendizaje != null) || (this.idActividadAprendizaje != null && !this.idActividadAprendizaje.equals(other.idActividadAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreActividadAprendizaje();
    }
    
}
