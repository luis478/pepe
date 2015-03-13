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
@Table(name = "tipo_ambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAmbiente.findAll", query = "SELECT t FROM TipoAmbiente t"),
    @NamedQuery(name = "TipoAmbiente.findByIdTipoAmbiente", query = "SELECT t FROM TipoAmbiente t WHERE t.idTipoAmbiente = :idTipoAmbiente"),
    @NamedQuery(name = "TipoAmbiente.findByNombreTipoAmbiente", query = "SELECT t FROM TipoAmbiente t WHERE t.nombreTipoAmbiente = :nombreTipoAmbiente")})
public class TipoAmbiente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_ambiente")
    private Integer idTipoAmbiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_ambiente")
    private String nombreTipoAmbiente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoAmbiente")
    private List<AmbienteFormacion> ambienteFormacionList;

    public TipoAmbiente() {
    }

    public TipoAmbiente(Integer idTipoAmbiente) {
        this.idTipoAmbiente = idTipoAmbiente;
    }

    public TipoAmbiente(Integer idTipoAmbiente, String nombreTipoAmbiente) {
        this.idTipoAmbiente = idTipoAmbiente;
        this.nombreTipoAmbiente = nombreTipoAmbiente;
    }

    public Integer getIdTipoAmbiente() {
        return idTipoAmbiente;
    }

    public void setIdTipoAmbiente(Integer idTipoAmbiente) {
        this.idTipoAmbiente = idTipoAmbiente;
    }

    public String getNombreTipoAmbiente() {
        return nombreTipoAmbiente;
    }

    public void setNombreTipoAmbiente(String nombreTipoAmbiente) {
        this.nombreTipoAmbiente = nombreTipoAmbiente;
    }

    @XmlTransient
    public List<AmbienteFormacion> getAmbienteFormacionList() {
        return ambienteFormacionList;
    }

    public void setAmbienteFormacionList(List<AmbienteFormacion> ambienteFormacionList) {
        this.ambienteFormacionList = ambienteFormacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAmbiente != null ? idTipoAmbiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAmbiente)) {
            return false;
        }
        TipoAmbiente other = (TipoAmbiente) object;
        if ((this.idTipoAmbiente == null && other.idTipoAmbiente != null) || (this.idTipoAmbiente != null && !this.idTipoAmbiente.equals(other.idTipoAmbiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoAmbiente[ idTipoAmbiente=" + idTipoAmbiente + " ]";
    }
    
}
