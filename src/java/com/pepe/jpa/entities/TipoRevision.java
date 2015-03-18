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
 * @author ADSI-DESAROLLO
 */
@Entity
@Table(name = "tipo_revision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRevision.findAll", query = "SELECT t FROM TipoRevision t"),
    @NamedQuery(name = "TipoRevision.findByIdTipoRevision", query = "SELECT t FROM TipoRevision t WHERE t.idTipoRevision = :idTipoRevision"),
    @NamedQuery(name = "TipoRevision.findByNombreTipoRevision", query = "SELECT t FROM TipoRevision t WHERE t.nombreTipoRevision = :nombreTipoRevision")})
public class TipoRevision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_revision")
    private Integer idTipoRevision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_revision")
    private String nombreTipoRevision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoRevision")
    private List<Revision> revisionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoRevision")
    private List<Variable> variableList;

    public TipoRevision() {
    }

    public TipoRevision(Integer idTipoRevision) {
        this.idTipoRevision = idTipoRevision;
    }

    public TipoRevision(Integer idTipoRevision, String nombreTipoRevision) {
        this.idTipoRevision = idTipoRevision;
        this.nombreTipoRevision = nombreTipoRevision;
    }

    public Integer getIdTipoRevision() {
        return idTipoRevision;
    }

    public void setIdTipoRevision(Integer idTipoRevision) {
        this.idTipoRevision = idTipoRevision;
    }

    public String getNombreTipoRevision() {
        return nombreTipoRevision;
    }

    public void setNombreTipoRevision(String nombreTipoRevision) {
        this.nombreTipoRevision = nombreTipoRevision;
    }

    @XmlTransient
    public List<Revision> getRevisionList() {
        return revisionList;
    }

    public void setRevisionList(List<Revision> revisionList) {
        this.revisionList = revisionList;
    }

    @XmlTransient
    public List<Variable> getVariableList() {
        return variableList;
    }

    public void setVariableList(List<Variable> variableList) {
        this.variableList = variableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRevision != null ? idTipoRevision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRevision)) {
            return false;
        }
        TipoRevision other = (TipoRevision) object;
        if ((this.idTipoRevision == null && other.idTipoRevision != null) || (this.idTipoRevision != null && !this.idTipoRevision.equals(other.idTipoRevision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoRevision[ idTipoRevision=" + idTipoRevision + " ]";
    }
    
}
