/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Junior Cabal
 */
@Entity
@Table(name = "criterios_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriteriosEvaluacion.findAll", query = "SELECT c FROM CriteriosEvaluacion c"),
    @NamedQuery(name = "CriteriosEvaluacion.findByIdCriteriosEvaluacion", query = "SELECT c FROM CriteriosEvaluacion c WHERE c.idCriteriosEvaluacion = :idCriteriosEvaluacion"),
    @NamedQuery(name = "CriteriosEvaluacion.findByEstado", query = "SELECT c FROM CriteriosEvaluacion c WHERE c.estado = :estado")})
public class CriteriosEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_criterios_evaluacion")
    private Integer idCriteriosEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_criterios_evaluacion")
    private String nombreCriteriosEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "id_competencia", referencedColumnName = "id_competencia")
    @ManyToOne(optional = false)
    private Competencia idCompetencia;

    public CriteriosEvaluacion() {
    }

    public CriteriosEvaluacion(Integer idCriteriosEvaluacion) {
        this.idCriteriosEvaluacion = idCriteriosEvaluacion;
    }

    public CriteriosEvaluacion(Integer idCriteriosEvaluacion, String nombreCriteriosEvaluacion, boolean estado) {
        this.idCriteriosEvaluacion = idCriteriosEvaluacion;
        this.nombreCriteriosEvaluacion = nombreCriteriosEvaluacion;
        this.estado = estado;
    }

    public Integer getIdCriteriosEvaluacion() {
        return idCriteriosEvaluacion;
    }

    public void setIdCriteriosEvaluacion(Integer idCriteriosEvaluacion) {
        this.idCriteriosEvaluacion = idCriteriosEvaluacion;
    }

    public String getNombreCriteriosEvaluacion() {
        return nombreCriteriosEvaluacion;
    }

    public void setNombreCriteriosEvaluacion(String nombreCriteriosEvaluacion) {
        this.nombreCriteriosEvaluacion = nombreCriteriosEvaluacion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Competencia getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Competencia idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriteriosEvaluacion != null ? idCriteriosEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosEvaluacion)) {
            return false;
        }
        CriteriosEvaluacion other = (CriteriosEvaluacion) object;
        if ((this.idCriteriosEvaluacion == null && other.idCriteriosEvaluacion != null) || (this.idCriteriosEvaluacion != null && !this.idCriteriosEvaluacion.equals(other.idCriteriosEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreCriteriosEvaluacion().toUpperCase();
    }
    
}
