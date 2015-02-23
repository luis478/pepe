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
 * @author ADSI TARDE
 */
@Entity
@Table(name = "regional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regional.findAll", query = "SELECT r FROM Regional r"),
    @NamedQuery(name = "Regional.findByIdRegional", query = "SELECT r FROM Regional r WHERE r.idRegional = :idRegional"),
    @NamedQuery(name = "Regional.findByNombreRegional", query = "SELECT r FROM Regional r WHERE r.nombreRegional = :nombreRegional"),
    @NamedQuery(name = "Regional.findByCodigoRegional", query = "SELECT r FROM Regional r WHERE r.codigoRegional = :codigoRegional")})
public class Regional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_regional")
    private Integer idRegional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_regional")
    private String nombreRegional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo_regional")
    private String codigoRegional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRegional")
    private List<CentroFormacion> centroFormacionList;

    public Regional() {
    }

    public Regional(Integer idRegional) {
        this.idRegional = idRegional;
    }

    public Regional(Integer idRegional, String nombreRegional, String codigoRegional) {
        this.idRegional = idRegional;
        this.nombreRegional = nombreRegional;
        this.codigoRegional = codigoRegional;
    }

    public Integer getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(Integer idRegional) {
        this.idRegional = idRegional;
    }

    public String getNombreRegional() {
        return nombreRegional;
    }

    public void setNombreRegional(String nombreRegional) {
        this.nombreRegional = nombreRegional;
    }

    public String getCodigoRegional() {
        return codigoRegional;
    }

    public void setCodigoRegional(String codigoRegional) {
        this.codigoRegional = codigoRegional;
    }

    @XmlTransient
    public List<CentroFormacion> getCentroFormacionList() {
        return centroFormacionList;
    }

    public void setCentroFormacionList(List<CentroFormacion> centroFormacionList) {
        this.centroFormacionList = centroFormacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegional != null ? idRegional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regional)) {
            return false;
        }
        Regional other = (Regional) object;
        if ((this.idRegional == null && other.idRegional != null) || (this.idRegional != null && !this.idRegional.equals(other.idRegional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Regional[ idRegional=" + idRegional + " ]";
    }
    
}
