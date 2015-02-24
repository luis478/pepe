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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis Carlos
 */
@Entity
@Table(name = "trimestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trimestre.findAll", query = "SELECT t FROM Trimestre t"),
    @NamedQuery(name = "Trimestre.findByIdTrimestre", query = "SELECT t FROM Trimestre t WHERE t.idTrimestre = :idTrimestre"),
    @NamedQuery(name = "Trimestre.findByFechaInicio", query = "SELECT t FROM Trimestre t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Trimestre.findByFechaFin", query = "SELECT t FROM Trimestre t WHERE t.fechaFin = :fechaFin")})
public class Trimestre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trimestre")
    private Integer idTrimestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @ManyToMany(mappedBy = "trimestreList")
    private List<Evento> eventoList;
    @ManyToMany(mappedBy = "trimestreList")
    private List<Ficha> fichaList;

    public Trimestre() {
    }

    public Trimestre(Integer idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public Trimestre(Integer idTrimestre, Date fechaInicio, Date fechaFin) {
        this.idTrimestre = idTrimestre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(Integer idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @XmlTransient
    public List<Ficha> getFichaList() {
        return fichaList;
    }

    public void setFichaList(List<Ficha> fichaList) {
        this.fichaList = fichaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrimestre != null ? idTrimestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trimestre)) {
            return false;
        }
        Trimestre other = (Trimestre) object;
        if ((this.idTrimestre == null && other.idTrimestre != null) || (this.idTrimestre != null && !this.idTrimestre.equals(other.idTrimestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Trimestre[ idTrimestre=" + idTrimestre + " ]";
    }
    
}
