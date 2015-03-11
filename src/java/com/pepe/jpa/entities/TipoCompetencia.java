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
@Table(name = "tipo_competencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCompetencia.findAll", query = "SELECT t FROM TipoCompetencia t"),
    @NamedQuery(name = "TipoCompetencia.findByIdTipoCompetencia", query = "SELECT t FROM TipoCompetencia t WHERE t.idTipoCompetencia = :idTipoCompetencia"),
    @NamedQuery(name = "TipoCompetencia.findByTipoCompetencia", query = "SELECT t FROM TipoCompetencia t WHERE t.tipoCompetencia = :tipoCompetencia")})
public class TipoCompetencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_competencia")
    private Integer idTipoCompetencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_competencia")
    private String tipoCompetencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCompetencia")
    private List<Competencia> competenciaList;

    public TipoCompetencia() {
    }

    public TipoCompetencia(Integer idTipoCompetencia) {
        this.idTipoCompetencia = idTipoCompetencia;
    }

    public TipoCompetencia(Integer idTipoCompetencia, String tipoCompetencia) {
        this.idTipoCompetencia = idTipoCompetencia;
        this.tipoCompetencia = tipoCompetencia;
    }

    public Integer getIdTipoCompetencia() {
        return idTipoCompetencia;
    }

    public void setIdTipoCompetencia(Integer idTipoCompetencia) {
        this.idTipoCompetencia = idTipoCompetencia;
    }

    public String getTipoCompetencia() {
        return tipoCompetencia;
    }

    public void setTipoCompetencia(String tipoCompetencia) {
        this.tipoCompetencia = tipoCompetencia;
    }

    @XmlTransient
    public List<Competencia> getCompetenciaList() {
        return competenciaList;
    }

    public void setCompetenciaList(List<Competencia> competenciaList) {
        this.competenciaList = competenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCompetencia != null ? idTipoCompetencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCompetencia)) {
            return false;
        }
        TipoCompetencia other = (TipoCompetencia) object;
        if ((this.idTipoCompetencia == null && other.idTipoCompetencia != null) || (this.idTipoCompetencia != null && !this.idTipoCompetencia.equals(other.idTipoCompetencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoCompetencia[ idTipoCompetencia=" + idTipoCompetencia + " ]";
    }
    
}
