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
@Table(name = "variable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Variable.findAll", query = "SELECT v FROM Variable v"),
    @NamedQuery(name = "Variable.findByIdVariable", query = "SELECT v FROM Variable v WHERE v.idVariable = :idVariable")})
public class Variable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_variable")
    private Integer idVariable;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_variable")
    private String nombreVariable;
    @OneToMany(mappedBy = "idVariable")
    private List<Valoracion> valoracionList;

    public Variable() {
    }

    public Variable(Integer idVariable) {
        this.idVariable = idVariable;
    }

    public Variable(Integer idVariable, String nombreVariable) {
        this.idVariable = idVariable;
        this.nombreVariable = nombreVariable;
    }

    public Integer getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Integer idVariable) {
        this.idVariable = idVariable;
    }

    public String getNombreVariable() {
        return nombreVariable;
    }

    public void setNombreVariable(String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }

    @XmlTransient
    public List<Valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setValoracionList(List<Valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVariable != null ? idVariable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variable)) {
            return false;
        }
        Variable other = (Variable) object;
        if ((this.idVariable == null && other.idVariable != null) || (this.idVariable != null && !this.idVariable.equals(other.idVariable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Variable[ idVariable=" + idVariable + " ]";
    }
    
}
