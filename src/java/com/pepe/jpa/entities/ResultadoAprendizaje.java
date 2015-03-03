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
@Table(name = "resultado_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoAprendizaje.findAll", query = "SELECT r FROM ResultadoAprendizaje r"),
    @NamedQuery(name = "ResultadoAprendizaje.findByIdResultadoAprendizaje", query = "SELECT r FROM ResultadoAprendizaje r WHERE r.idResultadoAprendizaje = :idResultadoAprendizaje"),
    @NamedQuery(name = "ResultadoAprendizaje.findByEstado", query = "SELECT r FROM ResultadoAprendizaje r WHERE r.estado = :estado")})
public class ResultadoAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_resultado_aprendizaje")
    private Integer idResultadoAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_resultado_aprendizaje")
    private String nombreResultadoAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @ManyToMany(mappedBy = "resultadoAprendizajeList")
    private List<ActividadAprendizaje> actividadAprendizajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resultadoAprendizaje")
    private List<ActividadHasResultadoAprendizaje> actividadHasResultadoAprendizajeList;
    @JoinColumn(name = "id_competencia", referencedColumnName = "id_competencia")
    @ManyToOne(optional = false)
    private Competencia idCompetencia;
    @JoinColumn(name = "id_tipo_resultado_aprendizaje", referencedColumnName = "id_tipo_resultado_aprendizaje")
    @ManyToOne(optional = false)
    private TipoResultadoAprendizaje idTipoResultadoAprendizaje;

    public ResultadoAprendizaje() {
    }

    public ResultadoAprendizaje(Integer idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public ResultadoAprendizaje(Integer idResultadoAprendizaje, String nombreResultadoAprendizaje, boolean estado) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
        this.nombreResultadoAprendizaje = nombreResultadoAprendizaje;
        this.estado = estado;
    }

    public Integer getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(Integer idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public String getNombreResultadoAprendizaje() {
        return nombreResultadoAprendizaje;
    }

    public void setNombreResultadoAprendizaje(String nombreResultadoAprendizaje) {
        this.nombreResultadoAprendizaje = nombreResultadoAprendizaje;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<ActividadAprendizaje> getActividadAprendizajeList() {
        return actividadAprendizajeList;
    }

    public void setActividadAprendizajeList(List<ActividadAprendizaje> actividadAprendizajeList) {
        this.actividadAprendizajeList = actividadAprendizajeList;
    }

    @XmlTransient
    public List<ActividadHasResultadoAprendizaje> getActividadHasResultadoAprendizajeList() {
        return actividadHasResultadoAprendizajeList;
    }

    public void setActividadHasResultadoAprendizajeList(List<ActividadHasResultadoAprendizaje> actividadHasResultadoAprendizajeList) {
        this.actividadHasResultadoAprendizajeList = actividadHasResultadoAprendizajeList;
    }

    public Competencia getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Competencia idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public TipoResultadoAprendizaje getIdTipoResultadoAprendizaje() {
        return idTipoResultadoAprendizaje;
    }

    public void setIdTipoResultadoAprendizaje(TipoResultadoAprendizaje idTipoResultadoAprendizaje) {
        this.idTipoResultadoAprendizaje = idTipoResultadoAprendizaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultadoAprendizaje != null ? idResultadoAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoAprendizaje)) {
            return false;
        }
        ResultadoAprendizaje other = (ResultadoAprendizaje) object;
        if ((this.idResultadoAprendizaje == null && other.idResultadoAprendizaje != null) || (this.idResultadoAprendizaje != null && !this.idResultadoAprendizaje.equals(other.idResultadoAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreResultadoAprendizaje().toUpperCase();
    }
    
}
