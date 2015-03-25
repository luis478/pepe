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
import javax.persistence.Lob;
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
@Table(name = "tipo_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCriterio.findAll", query = "SELECT t FROM TipoCriterio t"),
    @NamedQuery(name = "TipoCriterio.findByIdTipoCriterio", query = "SELECT t FROM TipoCriterio t WHERE t.idTipoCriterio = :idTipoCriterio")})
public class TipoCriterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_criterio")
    private Integer idTipoCriterio;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_criterio")
    private String nombreCriterio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCriterio")
    private List<Criterio> criterioList;

    public TipoCriterio() {
    }

    public TipoCriterio(Integer idTipoCriterio) {
        this.idTipoCriterio = idTipoCriterio;
    }

    public TipoCriterio(Integer idTipoCriterio, String nombreCriterio) {
        this.idTipoCriterio = idTipoCriterio;
        this.nombreCriterio = nombreCriterio;
    }

    public Integer getIdTipoCriterio() {
        return idTipoCriterio;
    }

    public void setIdTipoCriterio(Integer idTipoCriterio) {
        this.idTipoCriterio = idTipoCriterio;
    }

    public String getNombreCriterio() {
        return nombreCriterio;
    }

    public void setNombreCriterio(String nombreCriterio) {
        this.nombreCriterio = nombreCriterio;
    }

    @XmlTransient
    public List<Criterio> getCriterioList() {
        return criterioList;
    }

    public void setCriterioList(List<Criterio> criterioList) {
        this.criterioList = criterioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCriterio != null ? idTipoCriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCriterio)) {
            return false;
        }
        TipoCriterio other = (TipoCriterio) object;
        if ((this.idTipoCriterio == null && other.idTipoCriterio != null) || (this.idTipoCriterio != null && !this.idTipoCriterio.equals(other.idTipoCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCriterio;
    }
    
}
