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
@Table(name = "tipo_contrato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContrato.findAll", query = "SELECT t FROM TipoContrato t"),
    @NamedQuery(name = "TipoContrato.findByIdTipoContrato", query = "SELECT t FROM TipoContrato t WHERE t.idTipoContrato = :idTipoContrato"),
    @NamedQuery(name = "TipoContrato.findByNombreTipoContrato", query = "SELECT t FROM TipoContrato t WHERE t.nombreTipoContrato = :nombreTipoContrato")})
public class TipoContrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_contrato")
    private Integer idTipoContrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_contrato")
    private String nombreTipoContrato;
    @OneToMany(mappedBy = "idTipoContrato")
    private List<Usuario> usuarioList;

    public TipoContrato() {
    }

    public TipoContrato(Integer idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public TipoContrato(Integer idTipoContrato, String nombreTipoContrato) {
        this.idTipoContrato = idTipoContrato;
        this.nombreTipoContrato = nombreTipoContrato;
    }

    public Integer getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(Integer idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public String getNombreTipoContrato() {
        return nombreTipoContrato;
    }

    public void setNombreTipoContrato(String nombreTipoContrato) {
        this.nombreTipoContrato = nombreTipoContrato;
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
        hash += (idTipoContrato != null ? idTipoContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoContrato)) {
            return false;
        }
        TipoContrato other = (TipoContrato) object;
        if ((this.idTipoContrato == null && other.idTipoContrato != null) || (this.idTipoContrato != null && !this.idTipoContrato.equals(other.idTipoContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoContrato[ idTipoContrato=" + idTipoContrato + " ]";
    }
    
}
