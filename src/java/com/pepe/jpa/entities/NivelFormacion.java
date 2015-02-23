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
@Table(name = "nivel_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelFormacion.findAll", query = "SELECT n FROM NivelFormacion n"),
    @NamedQuery(name = "NivelFormacion.findByIdNivelFormacion", query = "SELECT n FROM NivelFormacion n WHERE n.idNivelFormacion = :idNivelFormacion"),
    @NamedQuery(name = "NivelFormacion.findByNivelFormacion", query = "SELECT n FROM NivelFormacion n WHERE n.nivelFormacion = :nivelFormacion")})
public class NivelFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nivel_formacion")
    private Integer idNivelFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nivel_formacion")
    private String nivelFormacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNivelFormacion")
    private List<Programa> programaList;

    public NivelFormacion() {
    }

    public NivelFormacion(Integer idNivelFormacion) {
        this.idNivelFormacion = idNivelFormacion;
    }

    public NivelFormacion(Integer idNivelFormacion, String nivelFormacion) {
        this.idNivelFormacion = idNivelFormacion;
        this.nivelFormacion = nivelFormacion;
    }

    public Integer getIdNivelFormacion() {
        return idNivelFormacion;
    }

    public void setIdNivelFormacion(Integer idNivelFormacion) {
        this.idNivelFormacion = idNivelFormacion;
    }

    public String getNivelFormacion() {
        return nivelFormacion;
    }

    public void setNivelFormacion(String nivelFormacion) {
        this.nivelFormacion = nivelFormacion;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelFormacion != null ? idNivelFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelFormacion)) {
            return false;
        }
        NivelFormacion other = (NivelFormacion) object;
        if ((this.idNivelFormacion == null && other.idNivelFormacion != null) || (this.idNivelFormacion != null && !this.idNivelFormacion.equals(other.idNivelFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.NivelFormacion[ idNivelFormacion=" + idNivelFormacion + " ]";
    }
    
}
