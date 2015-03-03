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
 * @author Luis Carlos
 */
@Entity
@Table(name = "tipo_vocero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVocero.findAll", query = "SELECT t FROM TipoVocero t"),
    @NamedQuery(name = "TipoVocero.findByIdTipoVocero", query = "SELECT t FROM TipoVocero t WHERE t.idTipoVocero = :idTipoVocero"),
    @NamedQuery(name = "TipoVocero.findByNombreTipoVocero", query = "SELECT t FROM TipoVocero t WHERE t.nombreTipoVocero = :nombreTipoVocero")})
public class TipoVocero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_vocero")
    private Integer idTipoVocero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_vocero")
    private String nombreTipoVocero;
    @OneToMany(mappedBy = "idTipoVocero")
    private List<Usuario> usuarioList;

    public TipoVocero() {
    }

    public TipoVocero(Integer idTipoVocero) {
        this.idTipoVocero = idTipoVocero;
    }

    public TipoVocero(Integer idTipoVocero, String nombreTipoVocero) {
        this.idTipoVocero = idTipoVocero;
        this.nombreTipoVocero = nombreTipoVocero;
    }

    public Integer getIdTipoVocero() {
        return idTipoVocero;
    }

    public void setIdTipoVocero(Integer idTipoVocero) {
        this.idTipoVocero = idTipoVocero;
    }

    public String getNombreTipoVocero() {
        return nombreTipoVocero;
    }

    public void setNombreTipoVocero(String nombreTipoVocero) {
        this.nombreTipoVocero = nombreTipoVocero;
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
        hash += (idTipoVocero != null ? idTipoVocero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVocero)) {
            return false;
        }
        TipoVocero other = (TipoVocero) object;
        if ((this.idTipoVocero == null && other.idTipoVocero != null) || (this.idTipoVocero != null && !this.idTipoVocero.equals(other.idTipoVocero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreTipoVocero().toUpperCase();
    }
    
}
