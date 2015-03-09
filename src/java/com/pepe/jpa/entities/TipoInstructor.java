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
@Table(name = "tipo_instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoInstructor.findAll", query = "SELECT t FROM TipoInstructor t"),
    @NamedQuery(name = "TipoInstructor.findByIdTipoInstructor", query = "SELECT t FROM TipoInstructor t WHERE t.idTipoInstructor = :idTipoInstructor"),
    @NamedQuery(name = "TipoInstructor.findByNombreTipoInstructor", query = "SELECT t FROM TipoInstructor t WHERE t.nombreTipoInstructor = :nombreTipoInstructor")})
public class TipoInstructor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_instructor")
    private Integer idTipoInstructor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_tipo_instructor")
    private String nombreTipoInstructor;
    @OneToMany(mappedBy = "idTipoInstructor")
    private List<UsuarioHasFicha> usuarioHasFichaList;

    public TipoInstructor() {
    }

    public TipoInstructor(Integer idTipoInstructor) {
        this.idTipoInstructor = idTipoInstructor;
    }

    public TipoInstructor(Integer idTipoInstructor, String nombreTipoInstructor) {
        this.idTipoInstructor = idTipoInstructor;
        this.nombreTipoInstructor = nombreTipoInstructor;
    }

    public Integer getIdTipoInstructor() {
        return idTipoInstructor;
    }

    public void setIdTipoInstructor(Integer idTipoInstructor) {
        this.idTipoInstructor = idTipoInstructor;
    }

    public String getNombreTipoInstructor() {
        return nombreTipoInstructor;
    }

    public void setNombreTipoInstructor(String nombreTipoInstructor) {
        this.nombreTipoInstructor = nombreTipoInstructor;
    }

    @XmlTransient
    public List<UsuarioHasFicha> getUsuarioHasFichaList() {
        return usuarioHasFichaList;
    }

    public void setUsuarioHasFichaList(List<UsuarioHasFicha> usuarioHasFichaList) {
        this.usuarioHasFichaList = usuarioHasFichaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoInstructor != null ? idTipoInstructor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInstructor)) {
            return false;
        }
        TipoInstructor other = (TipoInstructor) object;
        if ((this.idTipoInstructor == null && other.idTipoInstructor != null) || (this.idTipoInstructor != null && !this.idTipoInstructor.equals(other.idTipoInstructor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoInstructor[ idTipoInstructor=" + idTipoInstructor + " ]";
    }
    
}
