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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Junior Cabal
 */
@Entity
@Table(name = "acompanamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acompanamiento.findAll", query = "SELECT a FROM Acompanamiento a"),
    @NamedQuery(name = "Acompanamiento.findByIdAcompanamiento", query = "SELECT a FROM Acompanamiento a WHERE a.idAcompanamiento = :idAcompanamiento"),
    @NamedQuery(name = "Acompanamiento.findByFechaInicio", query = "SELECT a FROM Acompanamiento a WHERE a.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Acompanamiento.findByFachaFin", query = "SELECT a FROM Acompanamiento a WHERE a.fachaFin = :fachaFin")})
public class Acompanamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acompanamiento")
    private Integer idAcompanamiento;
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
    @JoinTable(name = "usuario_has_acompanamiento", joinColumns = {
        @JoinColumn(name = "id_acompanamiento", referencedColumnName = "id_acompanamiento")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @JoinColumn(name = "id_fase", referencedColumnName = "id_fase")
    @ManyToOne(optional = false)
    private Fase idFase;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha")
    @ManyToOne(optional = false)
    private Ficha idFicha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acompanamiento")
    private List<CriterioSeguimientoHasAcompanamiento> criterioSeguimientoHasAcompanamientoList;

    public Acompanamiento() {
    }

    public Acompanamiento(Integer idAcompanamiento) {
        this.idAcompanamiento = idAcompanamiento;
    }

    public Acompanamiento(Integer idAcompanamiento, Date fechaInicio, Date fachaFin) {
        this.idAcompanamiento = idAcompanamiento;
        this.fechaInicio = fechaInicio;
        this.fachaFin = fachaFin;
    }

    public Integer getIdAcompanamiento() {
        return idAcompanamiento;
    }

    public void setIdAcompanamiento(Integer idAcompanamiento) {
        this.idAcompanamiento = idAcompanamiento;
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
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Fase getIdFase() {
        return idFase;
    }

    public void setIdFase(Fase idFase) {
        this.idFase = idFase;
    }

    public Ficha getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Ficha idFicha) {
        this.idFicha = idFicha;
    }

    @XmlTransient
    public List<CriterioSeguimientoHasAcompanamiento> getCriterioSeguimientoHasAcompanamientoList() {
        return criterioSeguimientoHasAcompanamientoList;
    }

    public void setCriterioSeguimientoHasAcompanamientoList(List<CriterioSeguimientoHasAcompanamiento> criterioSeguimientoHasAcompanamientoList) {
        this.criterioSeguimientoHasAcompanamientoList = criterioSeguimientoHasAcompanamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcompanamiento != null ? idAcompanamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acompanamiento)) {
            return false;
        }
        Acompanamiento other = (Acompanamiento) object;
        if ((this.idAcompanamiento == null && other.idAcompanamiento != null) || (this.idAcompanamiento != null && !this.idAcompanamiento.equals(other.idAcompanamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Acompanamiento[ idAcompanamiento=" + idAcompanamiento + " ]";
    }
    
}
