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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Junior Cabal
 */
@Entity
@Table(name = "criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Criterio.findAll", query = "SELECT c FROM Criterio c"),
    @NamedQuery(name = "Criterio.findByIdCriterio", query = "SELECT c FROM Criterio c WHERE c.idCriterio = :idCriterio")})
public class Criterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_criterio")
    private Integer idCriterio;
    @JoinColumn(name = "id_acompanamiento", referencedColumnName = "id_acompanamiento")
    @ManyToOne(optional = false)
    private Acompanamiento idAcompanamiento;
    @JoinColumn(name = "id_fase", referencedColumnName = "id_fase")
    @ManyToOne(optional = false)
    private Fase idFase;
    @JoinColumn(name = "id_tipo_criterio", referencedColumnName = "id_tipo_criterio")
    @ManyToOne(optional = false)
    private TipoCriterio idTipoCriterio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNombreCriterio")
    private List<ItemCriterio> itemCriterioList;

    public Criterio() {
    }

    public Criterio(Integer idCriterio) {
        this.idCriterio = idCriterio;
    }

    public Integer getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Integer idCriterio) {
        this.idCriterio = idCriterio;
    }

    public Acompanamiento getIdAcompanamiento() {
        return idAcompanamiento;
    }

    public void setIdAcompanamiento(Acompanamiento idAcompanamiento) {
        this.idAcompanamiento = idAcompanamiento;
    }

    public Fase getIdFase() {
        return idFase;
    }

    public void setIdFase(Fase idFase) {
        this.idFase = idFase;
    }

    public TipoCriterio getIdTipoCriterio() {
        return idTipoCriterio;
    }

    public void setIdTipoCriterio(TipoCriterio idTipoCriterio) {
        this.idTipoCriterio = idTipoCriterio;
    }

    @XmlTransient
    public List<ItemCriterio> getItemCriterioList() {
        return itemCriterioList;
    }

    public void setItemCriterioList(List<ItemCriterio> itemCriterioList) {
        this.itemCriterioList = itemCriterioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriterio != null ? idCriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criterio)) {
            return false;
        }
        Criterio other = (Criterio) object;
        if ((this.idCriterio == null && other.idCriterio != null) || (this.idCriterio != null && !this.idCriterio.equals(other.idCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Criterio[ idCriterio=" + idCriterio + " ]";
    }
    
}
