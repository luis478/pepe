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
@Table(name = "fase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fase.findAll", query = "SELECT f FROM Fase f"),
    @NamedQuery(name = "Fase.findByIdFase", query = "SELECT f FROM Fase f WHERE f.idFase = :idFase"),
    @NamedQuery(name = "Fase.findByFase", query = "SELECT f FROM Fase f WHERE f.fase = :fase")})
public class Fase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fase")
    private Integer idFase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fase")
    private String fase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFase")
    private List<Actividad> actividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFase")
    private List<Acompanamiento> acompanamientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fase")
    private List<EvaluacionSeguimiento> evaluacionSeguimientoList;

    public Fase() {
    }

    public Fase(Integer idFase) {
        this.idFase = idFase;
    }

    public Fase(Integer idFase, String fase) {
        this.idFase = idFase;
        this.fase = fase;
    }

    public Integer getIdFase() {
        return idFase;
    }

    public void setIdFase(Integer idFase) {
        this.idFase = idFase;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @XmlTransient
    public List<Acompanamiento> getAcompanamientoList() {
        return acompanamientoList;
    }

    public void setAcompanamientoList(List<Acompanamiento> acompanamientoList) {
        this.acompanamientoList = acompanamientoList;
    }

    @XmlTransient
    public List<EvaluacionSeguimiento> getEvaluacionSeguimientoList() {
        return evaluacionSeguimientoList;
    }

    public void setEvaluacionSeguimientoList(List<EvaluacionSeguimiento> evaluacionSeguimientoList) {
        this.evaluacionSeguimientoList = evaluacionSeguimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFase != null ? idFase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fase)) {
            return false;
        }
        Fase other = (Fase) object;
        if ((this.idFase == null && other.idFase != null) || (this.idFase != null && !this.idFase.equals(other.idFase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Fase[ idFase=" + idFase + " ]";
    }
    
}
