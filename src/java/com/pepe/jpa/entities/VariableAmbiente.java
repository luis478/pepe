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
@Table(name = "variable_ambiente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VariableAmbiente.findAll", query = "SELECT v FROM VariableAmbiente v"),
    @NamedQuery(name = "VariableAmbiente.findByIdVariableAmbiente", query = "SELECT v FROM VariableAmbiente v WHERE v.idVariableAmbiente = :idVariableAmbiente"),
    @NamedQuery(name = "VariableAmbiente.findByNombreVariableAmbiente", query = "SELECT v FROM VariableAmbiente v WHERE v.nombreVariableAmbiente = :nombreVariableAmbiente")})
public class VariableAmbiente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_variable_ambiente")
    private Integer idVariableAmbiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_variable_ambiente")
    private String nombreVariableAmbiente;
    @OneToMany(mappedBy = "idVariableAmbiente")
    private List<Valoracion> valoracionList;

    public VariableAmbiente() {
    }

    public VariableAmbiente(Integer idVariableAmbiente) {
        this.idVariableAmbiente = idVariableAmbiente;
    }

    public VariableAmbiente(Integer idVariableAmbiente, String nombreVariableAmbiente) {
        this.idVariableAmbiente = idVariableAmbiente;
        this.nombreVariableAmbiente = nombreVariableAmbiente;
    }

    public Integer getIdVariableAmbiente() {
        return idVariableAmbiente;
    }

    public void setIdVariableAmbiente(Integer idVariableAmbiente) {
        this.idVariableAmbiente = idVariableAmbiente;
    }

    public String getNombreVariableAmbiente() {
        return nombreVariableAmbiente;
    }

    public void setNombreVariableAmbiente(String nombreVariableAmbiente) {
        this.nombreVariableAmbiente = nombreVariableAmbiente;
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
        hash += (idVariableAmbiente != null ? idVariableAmbiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VariableAmbiente)) {
            return false;
        }
        VariableAmbiente other = (VariableAmbiente) object;
        if ((this.idVariableAmbiente == null && other.idVariableAmbiente != null) || (this.idVariableAmbiente != null && !this.idVariableAmbiente.equals(other.idVariableAmbiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.VariableAmbiente[ idVariableAmbiente=" + idVariableAmbiente + " ]";
    }
    
}
