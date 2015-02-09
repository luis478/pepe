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
 * @author Windows 8
 */
@Entity
@Table(name = "tipo_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFormacion.findAll", query = "SELECT t FROM TipoFormacion t"),
    @NamedQuery(name = "TipoFormacion.findByIdTipoFormacion", query = "SELECT t FROM TipoFormacion t WHERE t.idTipoFormacion = :idTipoFormacion"),
    @NamedQuery(name = "TipoFormacion.findByTipoFormacion", query = "SELECT t FROM TipoFormacion t WHERE t.tipoFormacion = :tipoFormacion")})
public class TipoFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_formacion")
    private Integer idTipoFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_formacion")
    private String tipoFormacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoFormacion")
    private List<Programa> programaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoFormacion")
    private List<Ficha> fichaList;

    public TipoFormacion() {
    }

    public TipoFormacion(Integer idTipoFormacion) {
        this.idTipoFormacion = idTipoFormacion;
    }

    public TipoFormacion(Integer idTipoFormacion, String tipoFormacion) {
        this.idTipoFormacion = idTipoFormacion;
        this.tipoFormacion = tipoFormacion;
    }

    public Integer getIdTipoFormacion() {
        return idTipoFormacion;
    }

    public void setIdTipoFormacion(Integer idTipoFormacion) {
        this.idTipoFormacion = idTipoFormacion;
    }

    public String getTipoFormacion() {
        return tipoFormacion;
    }

    public void setTipoFormacion(String tipoFormacion) {
        this.tipoFormacion = tipoFormacion;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    @XmlTransient
    public List<Ficha> getFichaList() {
        return fichaList;
    }

    public void setFichaList(List<Ficha> fichaList) {
        this.fichaList = fichaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoFormacion != null ? idTipoFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFormacion)) {
            return false;
        }
        TipoFormacion other = (TipoFormacion) object;
        if ((this.idTipoFormacion == null && other.idTipoFormacion != null) || (this.idTipoFormacion != null && !this.idTipoFormacion.equals(other.idTipoFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoFormacion[ idTipoFormacion=" + idTipoFormacion + " ]";
    }
    
}
