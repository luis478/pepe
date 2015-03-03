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
@Table(name = "estilo_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstiloAprendizaje.findAll", query = "SELECT e FROM EstiloAprendizaje e"),
    @NamedQuery(name = "EstiloAprendizaje.findByIdEstiloAprendizaje", query = "SELECT e FROM EstiloAprendizaje e WHERE e.idEstiloAprendizaje = :idEstiloAprendizaje"),
    @NamedQuery(name = "EstiloAprendizaje.findByEstiloAprendizaje", query = "SELECT e FROM EstiloAprendizaje e WHERE e.estiloAprendizaje = :estiloAprendizaje")})
public class EstiloAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estilo_aprendizaje")
    private Integer idEstiloAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estilo_aprendizaje")
    private String estiloAprendizaje;
    @OneToMany(mappedBy = "idEstiloAprendizaje")
    private List<Usuario> usuarioList;

    public EstiloAprendizaje() {
    }

    public EstiloAprendizaje(Integer idEstiloAprendizaje) {
        this.idEstiloAprendizaje = idEstiloAprendizaje;
    }

    public EstiloAprendizaje(Integer idEstiloAprendizaje, String estiloAprendizaje) {
        this.idEstiloAprendizaje = idEstiloAprendizaje;
        this.estiloAprendizaje = estiloAprendizaje;
    }

    public Integer getIdEstiloAprendizaje() {
        return idEstiloAprendizaje;
    }

    public void setIdEstiloAprendizaje(Integer idEstiloAprendizaje) {
        this.idEstiloAprendizaje = idEstiloAprendizaje;
    }

    public String getEstiloAprendizaje() {
        return estiloAprendizaje;
    }

    public void setEstiloAprendizaje(String estiloAprendizaje) {
        this.estiloAprendizaje = estiloAprendizaje;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstiloAprendizaje != null ? idEstiloAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstiloAprendizaje)) {
            return false;
        }
        EstiloAprendizaje other = (EstiloAprendizaje) object;
        if ((this.idEstiloAprendizaje == null && other.idEstiloAprendizaje != null) || (this.idEstiloAprendizaje != null && !this.idEstiloAprendizaje.equals(other.idEstiloAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.EstiloAprendizaje[ idEstiloAprendizaje=" + idEstiloAprendizaje + " ]";
    }
    
}
