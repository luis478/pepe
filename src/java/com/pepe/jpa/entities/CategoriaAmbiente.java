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
@Table(name = "categoria_ambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaAmbiente.findAll", query = "SELECT c FROM CategoriaAmbiente c"),
    @NamedQuery(name = "CategoriaAmbiente.findByIdCategoriaAmbiente", query = "SELECT c FROM CategoriaAmbiente c WHERE c.idCategoriaAmbiente = :idCategoriaAmbiente"),
    @NamedQuery(name = "CategoriaAmbiente.findByNombreCategoriaAmbiente", query = "SELECT c FROM CategoriaAmbiente c WHERE c.nombreCategoriaAmbiente = :nombreCategoriaAmbiente")})
public class CategoriaAmbiente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria_ambiente")
    private Integer idCategoriaAmbiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_categoria_ambiente")
    private String nombreCategoriaAmbiente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaAmbienteIdCategoriaAmbiente")
    private List<AmbienteFormacion> ambienteFormacionList;

    public CategoriaAmbiente() {
    }

    public CategoriaAmbiente(Integer idCategoriaAmbiente) {
        this.idCategoriaAmbiente = idCategoriaAmbiente;
    }

    public CategoriaAmbiente(Integer idCategoriaAmbiente, String nombreCategoriaAmbiente) {
        this.idCategoriaAmbiente = idCategoriaAmbiente;
        this.nombreCategoriaAmbiente = nombreCategoriaAmbiente;
    }

    public Integer getIdCategoriaAmbiente() {
        return idCategoriaAmbiente;
    }

    public void setIdCategoriaAmbiente(Integer idCategoriaAmbiente) {
        this.idCategoriaAmbiente = idCategoriaAmbiente;
    }

    public String getNombreCategoriaAmbiente() {
        return nombreCategoriaAmbiente;
    }

    public void setNombreCategoriaAmbiente(String nombreCategoriaAmbiente) {
        this.nombreCategoriaAmbiente = nombreCategoriaAmbiente;
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
        hash += (idCategoriaAmbiente != null ? idCategoriaAmbiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaAmbiente)) {
            return false;
        }
        CategoriaAmbiente other = (CategoriaAmbiente) object;
        if ((this.idCategoriaAmbiente == null && other.idCategoriaAmbiente != null) || (this.idCategoriaAmbiente != null && !this.idCategoriaAmbiente.equals(other.idCategoriaAmbiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.CategoriaAmbiente[ idCategoriaAmbiente=" + idCategoriaAmbiente + " ]";
    }
    
}
