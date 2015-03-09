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
@Table(name = "tipo_rubro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRubro.findAll", query = "SELECT t FROM TipoRubro t"),
    @NamedQuery(name = "TipoRubro.findByIdTipoRubro", query = "SELECT t FROM TipoRubro t WHERE t.idTipoRubro = :idTipoRubro")})
public class TipoRubro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_rubro")
    private Integer idTipoRubro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_tipo_rubro")
    private String nombreTipoRubro;
    @OneToMany(mappedBy = "idRubroPresupuestal")
    private List<Recurso> recursoList;

    public TipoRubro() {
    }

    public TipoRubro(Integer idTipoRubro) {
        this.idTipoRubro = idTipoRubro;
    }

    public TipoRubro(Integer idTipoRubro, String nombreTipoRubro) {
        this.idTipoRubro = idTipoRubro;
        this.nombreTipoRubro = nombreTipoRubro;
    }

    public Integer getIdTipoRubro() {
        return idTipoRubro;
    }

    public void setIdTipoRubro(Integer idTipoRubro) {
        this.idTipoRubro = idTipoRubro;
    }

    public String getNombreTipoRubro() {
        return nombreTipoRubro;
    }

    public void setNombreTipoRubro(String nombreTipoRubro) {
        this.nombreTipoRubro = nombreTipoRubro;
    }

    @XmlTransient
    public List<Recurso> getRecursoList() {
        return recursoList;
    }

    public void setRecursoList(List<Recurso> recursoList) {
        this.recursoList = recursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRubro != null ? idTipoRubro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRubro)) {
            return false;
        }
        TipoRubro other = (TipoRubro) object;
        if ((this.idTipoRubro == null && other.idTipoRubro != null) || (this.idTipoRubro != null && !this.idTipoRubro.equals(other.idTipoRubro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoRubro[ idTipoRubro=" + idTipoRubro + " ]";
    }
    
}
