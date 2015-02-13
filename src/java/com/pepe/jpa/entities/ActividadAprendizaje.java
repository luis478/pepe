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
 * @author Windows 8
 */
@Entity
@Table(name = "actividad_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadAprendizaje.findAll", query = "SELECT a FROM ActividadAprendizaje a"),
    @NamedQuery(name = "ActividadAprendizaje.findByIdActividadAprendizaje", query = "SELECT a FROM ActividadAprendizaje a WHERE a.idActividadAprendizaje = :idActividadAprendizaje"),
    @NamedQuery(name = "ActividadAprendizaje.findByNombreActividadAprendizaje", query = "SELECT a FROM ActividadAprendizaje a WHERE a.nombreActividadAprendizaje = :nombreActividadAprendizaje"),
    @NamedQuery(name = "ActividadAprendizaje.findByDuracionActividadAprendizaje", query = "SELECT a FROM ActividadAprendizaje a WHERE a.duracionActividadAprendizaje = :duracionActividadAprendizaje"),
    @NamedQuery(name = "ActividadAprendizaje.findByObservaciones", query = "SELECT a FROM ActividadAprendizaje a WHERE a.observaciones = :observaciones")})
public class ActividadAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actividad_aprendizaje")
    private Integer idActividadAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_actividad_aprendizaje")
    private String nombreActividadAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion_actividad_aprendizaje")
    private int duracionActividadAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinTable(name = "actividad_aprendizaje_has_usuario", joinColumns = {
        @JoinColumn(name = "id_actividad_aprendizaje", referencedColumnName = "id_actividad_aprendizaje")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad")
    @ManyToOne(optional = false)
    private Actividad idActividad;
    @JoinColumn(name = "id_tecnica_didactica", referencedColumnName = "id_tecnica_didactica")
    @ManyToOne(optional = false)
    private TecnicaDidactica idTecnicaDidactica;
    @JoinColumn(name = "id_tipo_actividad_aprendizaje", referencedColumnName = "id_tipo_actividad_aprendizaje")
    @ManyToOne(optional = false)
    private TipoActividadAprendizaje idTipoActividadAprendizaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadAprendizaje")
    private List<Evidencia> evidenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadAprendizaje")
    private List<ActividadAprendizajeHasResultadoAprendizaje> actividadAprendizajeHasResultadoAprendizajeList;

    public ActividadAprendizaje() {
    }

    public ActividadAprendizaje(Integer idActividadAprendizaje) {
        this.idActividadAprendizaje = idActividadAprendizaje;
    }

    public ActividadAprendizaje(Integer idActividadAprendizaje, String nombreActividadAprendizaje, int duracionActividadAprendizaje, String observaciones) {
        this.idActividadAprendizaje = idActividadAprendizaje;
        this.nombreActividadAprendizaje = nombreActividadAprendizaje;
        this.duracionActividadAprendizaje = duracionActividadAprendizaje;
        this.observaciones = observaciones;
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

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Actividad getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Actividad idActividad) {
        this.idActividad = idActividad;
    }

    public TecnicaDidactica getIdTecnicaDidactica() {
        return idTecnicaDidactica;
    }

    public void setIdTecnicaDidactica(TecnicaDidactica idTecnicaDidactica) {
        this.idTecnicaDidactica = idTecnicaDidactica;
    }

    public TipoActividadAprendizaje getIdTipoActividadAprendizaje() {
        return idTipoActividadAprendizaje;
    }

    public void setIdTipoActividadAprendizaje(TipoActividadAprendizaje idTipoActividadAprendizaje) {
        this.idTipoActividadAprendizaje = idTipoActividadAprendizaje;
    }

    @XmlTransient
    public List<Evidencia> getEvidenciaList() {
        return evidenciaList;
    }

    public void setEvidenciaList(List<Evidencia> evidenciaList) {
        this.evidenciaList = evidenciaList;
    }

    @XmlTransient
    public List<ActividadAprendizajeHasResultadoAprendizaje> getActividadAprendizajeHasResultadoAprendizajeList() {
        return actividadAprendizajeHasResultadoAprendizajeList;
    }

    public void setActividadAprendizajeHasResultadoAprendizajeList(List<ActividadAprendizajeHasResultadoAprendizaje> actividadAprendizajeHasResultadoAprendizajeList) {
        this.actividadAprendizajeHasResultadoAprendizajeList = actividadAprendizajeHasResultadoAprendizajeList;
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
        return "com.pepe.jpa.entities.ActividadAprendizaje[ idActividadAprendizaje=" + idActividadAprendizaje + " ]";
    }
    
}
