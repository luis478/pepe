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
@Table(name = "actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findByActividadesProyecto", query = "SELECT a FROM Actividad a WHERE a.idProyecto = :idProyecto AND a.idFase = :idFase"),
    @NamedQuery(name = "Actividad.findByIdActividad", query = "SELECT a FROM Actividad a WHERE a.idActividad = :idActividad"),
    @NamedQuery(name = "Actividad.buscarActividadProyecto", query = "SELECT a FROM Actividad a WHERE a.idProyecto.idProyecto = :idProyecto"),
    @NamedQuery(name = "Actividad.buscarActividadProyecto1", query = "SELECT a FROM Actividad a WHERE a.idProyecto.idProyecto = :idProyecto AND a.idFase.idFase = 1"),
    @NamedQuery(name = "Actividad.buscarActividadProyecto2", query = "SELECT a FROM Actividad a WHERE a.idProyecto.idProyecto = :idProyecto AND a.idFase.idFase = 2"),
    @NamedQuery(name = "Actividad.buscarActividadProyecto3", query = "SELECT a FROM Actividad a WHERE a.idProyecto.idProyecto = :idProyecto AND a.idFase.idFase = 3"),
    @NamedQuery(name = "Actividad.buscarActividadProyecto4", query = "SELECT a FROM Actividad a WHERE a.idProyecto.idProyecto = :idProyecto AND a.idFase.idFase = 4"),
    @NamedQuery(name = "Actividad.findByDuracion", query = "SELECT a FROM Actividad a WHERE a.duracion = :duracion")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actividad")
    private Integer idActividad;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_actividad_proyecto")
    private String nombreActividadProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private int duracion;
    @JoinTable(name = "recurso_has_actividad_proyecto", joinColumns = {
        @JoinColumn(name = "id_actividad_proyecto", referencedColumnName = "id_actividad")}, inverseJoinColumns = {
        @JoinColumn(name = "id_recurso", referencedColumnName = "id_recurso")})
    @ManyToMany
    private List<Recurso> recursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividad")
    private List<ActividadAprendizaje> actividadAprendizajeList;
    @JoinColumn(name = "id_fase", referencedColumnName = "id_fase")
    @ManyToOne(optional = false)
    private Fase idFase;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActividadProyecto")
    private List<GuiaAprendizaje> guiaAprendizajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad")
    private List<ActividadHasResultadoAprendizaje> actividadHasResultadoAprendizajeList;

    public Actividad() {
    }

    public Actividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Actividad(Integer idActividad, String nombreActividadProyecto, int duracion) {
        this.idActividad = idActividad;
        this.nombreActividadProyecto = nombreActividadProyecto;
        this.duracion = duracion;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActividadProyecto() {
        return nombreActividadProyecto;
    }

    public void setNombreActividadProyecto(String nombreActividadProyecto) {
        this.nombreActividadProyecto = nombreActividadProyecto;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @XmlTransient
    public List<Recurso> getRecursoList() {
        return recursoList;
    }

    public void setRecursoList(List<Recurso> recursoList) {
        this.recursoList = recursoList;
    }

    @XmlTransient
    public List<ActividadAprendizaje> getActividadAprendizajeList() {
        return actividadAprendizajeList;
    }

    public void setActividadAprendizajeList(List<ActividadAprendizaje> actividadAprendizajeList) {
        this.actividadAprendizajeList = actividadAprendizajeList;
    }

    public Fase getIdFase() {
        return idFase;
    }

    public void setIdFase(Fase idFase) {
        this.idFase = idFase;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    @XmlTransient
    public List<GuiaAprendizaje> getGuiaAprendizajeList() {
        return guiaAprendizajeList;
    }

    public void setGuiaAprendizajeList(List<GuiaAprendizaje> guiaAprendizajeList) {
        this.guiaAprendizajeList = guiaAprendizajeList;
    }

    @XmlTransient
    public List<ActividadHasResultadoAprendizaje> getActividadHasResultadoAprendizajeList() {
        return actividadHasResultadoAprendizajeList;
    }

    public void setActividadHasResultadoAprendizajeList(List<ActividadHasResultadoAprendizaje> actividadHasResultadoAprendizajeList) {
        this.actividadHasResultadoAprendizajeList = actividadHasResultadoAprendizajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividad != null ? idActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreActividadProyecto();
    }

}
