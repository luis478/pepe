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
 * @author ADSI TARDE
 */
@Entity
@Table(name = "rubro_presupuestal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RubroPresupuestal.findAll", query = "SELECT r FROM RubroPresupuestal r"),
    @NamedQuery(name = "RubroPresupuestal.findByIdRubroPresupuestal", query = "SELECT r FROM RubroPresupuestal r WHERE r.idRubroPresupuestal = :idRubroPresupuestal")})
public class RubroPresupuestal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rubro_presupuestal")
    private Integer idRubroPresupuestal;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_rubro_presupuestal")
    private String nombreRubroPresupuestal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rubroPresupuestal")
    private List<TipoMaterialHasRubroPresupuestal> tipoMaterialHasRubroPresupuestalList;

    public RubroPresupuestal() {
    }

    public RubroPresupuestal(Integer idRubroPresupuestal) {
        this.idRubroPresupuestal = idRubroPresupuestal;
    }

    public RubroPresupuestal(Integer idRubroPresupuestal, String nombreRubroPresupuestal) {
        this.idRubroPresupuestal = idRubroPresupuestal;
        this.nombreRubroPresupuestal = nombreRubroPresupuestal;
    }

    public Integer getIdRubroPresupuestal() {
        return idRubroPresupuestal;
    }

    public void setIdRubroPresupuestal(Integer idRubroPresupuestal) {
        this.idRubroPresupuestal = idRubroPresupuestal;
    }

    public String getNombreRubroPresupuestal() {
        return nombreRubroPresupuestal;
    }

    public void setNombreRubroPresupuestal(String nombreRubroPresupuestal) {
        this.nombreRubroPresupuestal = nombreRubroPresupuestal;
    }

    @XmlTransient
    public List<TipoMaterialHasRubroPresupuestal> getTipoMaterialHasRubroPresupuestalList() {
        return tipoMaterialHasRubroPresupuestalList;
    }

    public void setTipoMaterialHasRubroPresupuestalList(List<TipoMaterialHasRubroPresupuestal> tipoMaterialHasRubroPresupuestalList) {
        this.tipoMaterialHasRubroPresupuestalList = tipoMaterialHasRubroPresupuestalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRubroPresupuestal != null ? idRubroPresupuestal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RubroPresupuestal)) {
            return false;
        }
        RubroPresupuestal other = (RubroPresupuestal) object;
        if ((this.idRubroPresupuestal == null && other.idRubroPresupuestal != null) || (this.idRubroPresupuestal != null && !this.idRubroPresupuestal.equals(other.idRubroPresupuestal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.RubroPresupuestal[ idRubroPresupuestal=" + idRubroPresupuestal + " ]";
    }
    
}
