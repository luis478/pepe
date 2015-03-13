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
@Table(name = "tipo_entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEntrega.findAll", query = "SELECT t FROM TipoEntrega t"),
    @NamedQuery(name = "TipoEntrega.findByIdTipoEntrega", query = "SELECT t FROM TipoEntrega t WHERE t.idTipoEntrega = :idTipoEntrega"),
    @NamedQuery(name = "TipoEntrega.findByTipoEntrega", query = "SELECT t FROM TipoEntrega t WHERE t.tipoEntrega = :tipoEntrega")})
public class TipoEntrega implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_entrega")
    private Integer idTipoEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_entrega")
    private String tipoEntrega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEntrega")
    private List<Evidencia> evidenciaList;

    public TipoEntrega() {
    }

    public TipoEntrega(Integer idTipoEntrega) {
        this.idTipoEntrega = idTipoEntrega;
    }

    public TipoEntrega(Integer idTipoEntrega, String tipoEntrega) {
        this.idTipoEntrega = idTipoEntrega;
        this.tipoEntrega = tipoEntrega;
    }

    public Integer getIdTipoEntrega() {
        return idTipoEntrega;
    }

    public void setIdTipoEntrega(Integer idTipoEntrega) {
        this.idTipoEntrega = idTipoEntrega;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    @XmlTransient
    public List<Evidencia> getEvidenciaList() {
        return evidenciaList;
    }

    public void setEvidenciaList(List<Evidencia> evidenciaList) {
        this.evidenciaList = evidenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEntrega != null ? idTipoEntrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEntrega)) {
            return false;
        }
        TipoEntrega other = (TipoEntrega) object;
        if ((this.idTipoEntrega == null && other.idTipoEntrega != null) || (this.idTipoEntrega != null && !this.idTipoEntrega.equals(other.idTipoEntrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoEntrega[ idTipoEntrega=" + idTipoEntrega + " ]";
    }
    
}
