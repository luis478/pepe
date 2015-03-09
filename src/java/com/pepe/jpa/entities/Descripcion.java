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
@Table(name = "descripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descripcion.findAll", query = "SELECT d FROM Descripcion d"),
    @NamedQuery(name = "Descripcion.findByIdDescripcion", query = "SELECT d FROM Descripcion d WHERE d.idDescripcion = :idDescripcion"),
    @NamedQuery(name = "Descripcion.findByNombreDescripcion", query = "SELECT d FROM Descripcion d WHERE d.nombreDescripcion = :nombreDescripcion")})
public class Descripcion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_descripcion")
    private Integer idDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_descripcion")
    private String nombreDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDescripcion")
    private List<Variable> variableList;

    public Descripcion() {
    }

    public Descripcion(Integer idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public Descripcion(Integer idDescripcion, String nombreDescripcion) {
        this.idDescripcion = idDescripcion;
        this.nombreDescripcion = nombreDescripcion;
    }

    public Integer getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(Integer idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public String getNombreDescripcion() {
        return nombreDescripcion;
    }

    public void setNombreDescripcion(String nombreDescripcion) {
        this.nombreDescripcion = nombreDescripcion;
    }

    @XmlTransient
    public List<Variable> getVariableList() {
        return variableList;
    }

    public void setVariableList(List<Variable> variableList) {
        this.variableList = variableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDescripcion != null ? idDescripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descripcion)) {
            return false;
        }
        Descripcion other = (Descripcion) object;
        if ((this.idDescripcion == null && other.idDescripcion != null) || (this.idDescripcion != null && !this.idDescripcion.equals(other.idDescripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Descripcion[ idDescripcion=" + idDescripcion + " ]";
    }
    
}
