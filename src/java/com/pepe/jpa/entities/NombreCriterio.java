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
import javax.persistence.Lob;
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
@Table(name = "nombre_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NombreCriterio.findAll", query = "SELECT n FROM NombreCriterio n"),
    @NamedQuery(name = "NombreCriterio.findByIdNombreCriterio", query = "SELECT n FROM NombreCriterio n WHERE n.idNombreCriterio = :idNombreCriterio")})
public class NombreCriterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nombre_criterio")
    private Integer idNombreCriterio;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_criterio")
    private String nombreCriterio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNombreCriterio")
    private List<CriterioSeguimientoHasAcompanamiento> criterioSeguimientoHasAcompanamientoList;

    public NombreCriterio() {
    }

    public NombreCriterio(Integer idNombreCriterio) {
        this.idNombreCriterio = idNombreCriterio;
    }

    public NombreCriterio(Integer idNombreCriterio, String nombreCriterio) {
        this.idNombreCriterio = idNombreCriterio;
        this.nombreCriterio = nombreCriterio;
    }

    public Integer getIdNombreCriterio() {
        return idNombreCriterio;
    }

    public void setIdNombreCriterio(Integer idNombreCriterio) {
        this.idNombreCriterio = idNombreCriterio;
    }

    public String getNombreCriterio() {
        return nombreCriterio;
    }

    public void setNombreCriterio(String nombreCriterio) {
        this.nombreCriterio = nombreCriterio;
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
        hash += (idNombreCriterio != null ? idNombreCriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NombreCriterio)) {
            return false;
        }
        NombreCriterio other = (NombreCriterio) object;
        if ((this.idNombreCriterio == null && other.idNombreCriterio != null) || (this.idNombreCriterio != null && !this.idNombreCriterio.equals(other.idNombreCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.NombreCriterio[ idNombreCriterio=" + idNombreCriterio + " ]";
    }
    
}
