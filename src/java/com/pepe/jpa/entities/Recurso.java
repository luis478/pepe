/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "recurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recurso.findAll", query = "SELECT r FROM Recurso r"),
    @NamedQuery(name = "Recurso.findByIdRecurso", query = "SELECT r FROM Recurso r WHERE r.idRecurso = :idRecurso"),
    @NamedQuery(name = "Recurso.findByCantidad", query = "SELECT r FROM Recurso r WHERE r.cantidad = :cantidad"),
    @NamedQuery(name = "Recurso.findByValorUnitario", query = "SELECT r FROM Recurso r WHERE r.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Recurso.findByCodigoOrions", query = "SELECT r FROM Recurso r WHERE r.codigoOrions = :codigoOrions")})
public class Recurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_recurso")
    private Integer idRecurso;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unitario")
    private double valorUnitario;
    @Size(max = 45)
    @Column(name = "codigo_orions")
    private String codigoOrions;
    @ManyToMany(mappedBy = "recursoList")
    private List<ActividadAprendizaje> actividadAprendizajeList;
    @ManyToMany(mappedBy = "recursoList")
    private List<Actividad> actividadList;
    @ManyToMany(mappedBy = "recursoList")
    private List<Proyecto> proyectoList;
    @JoinColumn(name = "id_fuente_recursos", referencedColumnName = "id_fuente_recursos")
    @ManyToOne(optional = false)
    private FuenteRecursos idFuenteRecursos;
    @JoinColumn(name = "id_rubro_presupuestal", referencedColumnName = "id_tipo_rubro")
    @ManyToOne
    private TipoRubro idRubroPresupuestal;
    @JoinColumn(name = "id_tipo_recurso", referencedColumnName = "id_tipo_recurso")
    @ManyToOne(optional = false)
    private TipoRecurso idTipoRecurso;
    @JoinColumn(name = "id_unidad_medida", referencedColumnName = "id_unidad_medida")
    @ManyToOne(optional = false)
    private UnidadMedida idUnidadMedida;

    public Recurso() {
    }

    public Recurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Recurso(Integer idRecurso, String nombre, int cantidad, double valorUnitario) {
        this.idRecurso = idRecurso;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    public Integer getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getCodigoOrions() {
        return codigoOrions;
    }

    public void setCodigoOrions(String codigoOrions) {
        this.codigoOrions = codigoOrions;
    }

    @XmlTransient
    public List<ActividadAprendizaje> getActividadAprendizajeList() {
        return actividadAprendizajeList;
    }

    public void setActividadAprendizajeList(List<ActividadAprendizaje> actividadAprendizajeList) {
        this.actividadAprendizajeList = actividadAprendizajeList;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public FuenteRecursos getIdFuenteRecursos() {
        return idFuenteRecursos;
    }

    public void setIdFuenteRecursos(FuenteRecursos idFuenteRecursos) {
        this.idFuenteRecursos = idFuenteRecursos;
    }

    public TipoRubro getIdRubroPresupuestal() {
        return idRubroPresupuestal;
    }

    public void setIdRubroPresupuestal(TipoRubro idRubroPresupuestal) {
        this.idRubroPresupuestal = idRubroPresupuestal;
    }

    public TipoRecurso getIdTipoRecurso() {
        return idTipoRecurso;
    }

    public void setIdTipoRecurso(TipoRecurso idTipoRecurso) {
        this.idTipoRecurso = idTipoRecurso;
    }

    public UnidadMedida getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(UnidadMedida idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecurso != null ? idRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recurso)) {
            return false;
        }
        Recurso other = (Recurso) object;
        if ((this.idRecurso == null && other.idRecurso != null) || (this.idRecurso != null && !this.idRecurso.equals(other.idRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Recurso[ idRecurso=" + idRecurso + " ]";
    }
}