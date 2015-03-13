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
@Table(name = "descripcion_aspectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescripcionAspectos.findAll", query = "SELECT d FROM DescripcionAspectos d"),
    @NamedQuery(name = "DescripcionAspectos.findByIdDescripcionAspectos", query = "SELECT d FROM DescripcionAspectos d WHERE d.idDescripcionAspectos = :idDescripcionAspectos")})
public class DescripcionAspectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_descripcion_aspectos")
    private Integer idDescripcionAspectos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDescripcionAspectos")
    private List<Aspectos> aspectosList;

    public DescripcionAspectos() {
    }

    public DescripcionAspectos(Integer idDescripcionAspectos) {
        this.idDescripcionAspectos = idDescripcionAspectos;
    }

    public DescripcionAspectos(Integer idDescripcionAspectos, String descripcion) {
        this.idDescripcionAspectos = idDescripcionAspectos;
        this.descripcion = descripcion;
    }

    public Integer getIdDescripcionAspectos() {
        return idDescripcionAspectos;
    }

    public void setIdDescripcionAspectos(Integer idDescripcionAspectos) {
        this.idDescripcionAspectos = idDescripcionAspectos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Aspectos> getAspectosList() {
        return aspectosList;
    }

    public void setAspectosList(List<Aspectos> aspectosList) {
        this.aspectosList = aspectosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDescripcionAspectos != null ? idDescripcionAspectos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescripcionAspectos)) {
            return false;
        }
        DescripcionAspectos other = (DescripcionAspectos) object;
        if ((this.idDescripcionAspectos == null && other.idDescripcionAspectos != null) || (this.idDescripcionAspectos != null && !this.idDescripcionAspectos.equals(other.idDescripcionAspectos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.DescripcionAspectos[ idDescripcionAspectos=" + idDescripcionAspectos + " ]";
    }
    
}
