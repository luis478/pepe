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
@Table(name = "ambiente_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AmbienteFormacion.findAll", query = "SELECT a FROM AmbienteFormacion a"),
    @NamedQuery(name = "AmbienteFormacion.findByIdAmbienteFormacion", query = "SELECT a FROM AmbienteFormacion a WHERE a.idAmbienteFormacion = :idAmbienteFormacion"),
    @NamedQuery(name = "AmbienteFormacion.findByNombreAmbienteFormacion", query = "SELECT a FROM AmbienteFormacion a WHERE a.nombreAmbienteFormacion = :nombreAmbienteFormacion")})
public class AmbienteFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ambiente_formacion")
    private Integer idAmbienteFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_ambiente_formacion")
    private String nombreAmbienteFormacion;
    @JoinTable(name = "recurso_has_ambiente_formacion", joinColumns = {
        @JoinColumn(name = "id_ambiente_formacion", referencedColumnName = "id_ambiente_formacion")}, inverseJoinColumns = {
        @JoinColumn(name = "id_recurso", referencedColumnName = "id_recurso")})
    @ManyToMany
    private List<Recurso> recursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAmbienteFormacion")
    private List<Evento> eventoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAmbienteFormacion")
    private List<Verificacion> verificacionList;

    public AmbienteFormacion() {
    }

    public AmbienteFormacion(Integer idAmbienteFormacion) {
        this.idAmbienteFormacion = idAmbienteFormacion;
    }

    public AmbienteFormacion(Integer idAmbienteFormacion, String nombreAmbienteFormacion) {
        this.idAmbienteFormacion = idAmbienteFormacion;
        this.nombreAmbienteFormacion = nombreAmbienteFormacion;
    }

    public Integer getIdAmbienteFormacion() {
        return idAmbienteFormacion;
    }

    public void setIdAmbienteFormacion(Integer idAmbienteFormacion) {
        this.idAmbienteFormacion = idAmbienteFormacion;
    }

    public String getNombreAmbienteFormacion() {
        return nombreAmbienteFormacion;
    }

    public void setNombreAmbienteFormacion(String nombreAmbienteFormacion) {
        this.nombreAmbienteFormacion = nombreAmbienteFormacion;
    }

    @XmlTransient
    public List<Recurso> getRecursoList() {
        return recursoList;
    }

    public void setRecursoList(List<Recurso> recursoList) {
        this.recursoList = recursoList;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @XmlTransient
    public List<Verificacion> getVerificacionList() {
        return verificacionList;
    }

    public void setVerificacionList(List<Verificacion> verificacionList) {
        this.verificacionList = verificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmbienteFormacion != null ? idAmbienteFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbienteFormacion)) {
            return false;
        }
        AmbienteFormacion other = (AmbienteFormacion) object;
        if ((this.idAmbienteFormacion == null && other.idAmbienteFormacion != null) || (this.idAmbienteFormacion != null && !this.idAmbienteFormacion.equals(other.idAmbienteFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreAmbienteFormacion().toUpperCase();
    }
    
}
