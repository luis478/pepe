/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Windows 8
 */
@Entity
@Table(name = "acompa\u00f1amiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acompa\u00f1amiento.findAll", query = "SELECT a FROM Acompa\u00f1amiento a"),
    @NamedQuery(name = "Acompa\u00f1amiento.findByIdAcompa\u00f1amiento", query = "SELECT a FROM Acompa\u00f1amiento a WHERE a.idAcompa\u00f1amiento = :idAcompa\u00f1amiento"),
    @NamedQuery(name = "Acompa\u00f1amiento.findByFechaInicio", query = "SELECT a FROM Acompa\u00f1amiento a WHERE a.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Acompa\u00f1amiento.findByFachaFin", query = "SELECT a FROM Acompa\u00f1amiento a WHERE a.fachaFin = :fachaFin")})
public class Acompañamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acompa\u00f1amiento")
    private Integer idAcompañamiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "facha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fachaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acompa\u00f1amiento")
    private List<CriterioSeguimientoHasAcompañamiento> criterioSeguimientoHasAcompañamientoList;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha")
    @ManyToOne(optional = false)
    private Ficha idFicha;
    @JoinColumn(name = "id_fase", referencedColumnName = "id_fase")
    @ManyToOne(optional = false)
    private Fase idFase;
    @JoinColumn(name = "id_ambiente_formacion", referencedColumnName = "id_ambiente_formacion")
    @ManyToOne(optional = false)
    private AmbienteFormacion idAmbienteFormacion;

    public Acompañamiento() {
    }

    public Acompañamiento(Integer idAcompañamiento) {
        this.idAcompañamiento = idAcompañamiento;
    }

    public Acompañamiento(Integer idAcompañamiento, Date fechaInicio, Date fachaFin) {
        this.idAcompañamiento = idAcompañamiento;
        this.fechaInicio = fechaInicio;
        this.fachaFin = fachaFin;
    }

    public Integer getIdAcompañamiento() {
        return idAcompañamiento;
    }

    public void setIdAcompañamiento(Integer idAcompañamiento) {
        this.idAcompañamiento = idAcompañamiento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFachaFin() {
        return fachaFin;
    }

    public void setFachaFin(Date fachaFin) {
        this.fachaFin = fachaFin;
    }

    @XmlTransient
    public List<CriterioSeguimientoHasAcompañamiento> getCriterioSeguimientoHasAcompañamientoList() {
        return criterioSeguimientoHasAcompañamientoList;
    }

    public void setCriterioSeguimientoHasAcompañamientoList(List<CriterioSeguimientoHasAcompañamiento> criterioSeguimientoHasAcompañamientoList) {
        this.criterioSeguimientoHasAcompañamientoList = criterioSeguimientoHasAcompañamientoList;
    }

    public Ficha getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Ficha idFicha) {
        this.idFicha = idFicha;
    }

    public Fase getIdFase() {
        return idFase;
    }

    public void setIdFase(Fase idFase) {
        this.idFase = idFase;
    }

    public AmbienteFormacion getIdAmbienteFormacion() {
        return idAmbienteFormacion;
    }

    public void setIdAmbienteFormacion(AmbienteFormacion idAmbienteFormacion) {
        this.idAmbienteFormacion = idAmbienteFormacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcompañamiento != null ? idAcompañamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acompañamiento)) {
            return false;
        }
        Acompañamiento other = (Acompañamiento) object;
        if ((this.idAcompañamiento == null && other.idAcompañamiento != null) || (this.idAcompañamiento != null && !this.idAcompañamiento.equals(other.idAcompañamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Acompa\u00f1amiento[ idAcompa\u00f1amiento=" + idAcompañamiento + " ]";
    }
    
}
