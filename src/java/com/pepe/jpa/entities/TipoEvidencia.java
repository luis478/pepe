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
 * @author Luis Carlos
 */
@Entity
@Table(name = "tipo_evidencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEvidencia.findAll", query = "SELECT t FROM TipoEvidencia t"),
    @NamedQuery(name = "TipoEvidencia.findByIdTipoEvidencia", query = "SELECT t FROM TipoEvidencia t WHERE t.idTipoEvidencia = :idTipoEvidencia"),
    @NamedQuery(name = "TipoEvidencia.findByTipoEvidencia", query = "SELECT t FROM TipoEvidencia t WHERE t.tipoEvidencia = :tipoEvidencia")})
public class TipoEvidencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_evidencia")
    private Integer idTipoEvidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_evidencia")
    private String tipoEvidencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEvidencia")
    private List<Evidencia> evidenciaList;

    public TipoEvidencia() {
    }

    public TipoEvidencia(Integer idTipoEvidencia) {
        this.idTipoEvidencia = idTipoEvidencia;
    }

    public TipoEvidencia(Integer idTipoEvidencia, String tipoEvidencia) {
        this.idTipoEvidencia = idTipoEvidencia;
        this.tipoEvidencia = tipoEvidencia;
    }

    public Integer getIdTipoEvidencia() {
        return idTipoEvidencia;
    }

    public void setIdTipoEvidencia(Integer idTipoEvidencia) {
        this.idTipoEvidencia = idTipoEvidencia;
    }

    public String getTipoEvidencia() {
        return tipoEvidencia;
    }

    public void setTipoEvidencia(String tipoEvidencia) {
        this.tipoEvidencia = tipoEvidencia;
    }

    @XmlTransient
    public List<Evidencia> getEvidenciaList() {
        return evidenciaList;
    }

    public void setEvidenciaList(List<Evidencia> evidenciaList) {
        this.evidenciaList = evidenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEvidencia != null ? idTipoEvidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvidencia)) {
            return false;
        }
        TipoEvidencia other = (TipoEvidencia) object;
        if ((this.idTipoEvidencia == null && other.idTipoEvidencia != null) || (this.idTipoEvidencia != null && !this.idTipoEvidencia.equals(other.idTipoEvidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoEvidencia[ idTipoEvidencia=" + idTipoEvidencia + " ]";
    }
    
}
