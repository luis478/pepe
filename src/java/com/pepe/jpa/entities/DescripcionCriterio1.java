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
@Table(name = "descripcion_criterio1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescripcionCriterio1.findAll", query = "SELECT d FROM DescripcionCriterio1 d"),
    @NamedQuery(name = "DescripcionCriterio1.findByIdDescripcionCriterio1", query = "SELECT d FROM DescripcionCriterio1 d WHERE d.idDescripcionCriterio1 = :idDescripcionCriterio1")})
public class DescripcionCriterio1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_descripcion_criterio1")
    private Integer idDescripcionCriterio1;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descrpcion")
    private String descrpcion;
    @OneToMany(mappedBy = "idDescripcionCriterio1")
    private List<ItemCriterio> itemCriterioList;

    public DescripcionCriterio1() {
    }

    public DescripcionCriterio1(Integer idDescripcionCriterio1) {
        this.idDescripcionCriterio1 = idDescripcionCriterio1;
    }

    public DescripcionCriterio1(Integer idDescripcionCriterio1, String descrpcion) {
        this.idDescripcionCriterio1 = idDescripcionCriterio1;
        this.descrpcion = descrpcion;
    }

    public Integer getIdDescripcionCriterio1() {
        return idDescripcionCriterio1;
    }

    public void setIdDescripcionCriterio1(Integer idDescripcionCriterio1) {
        this.idDescripcionCriterio1 = idDescripcionCriterio1;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
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
        hash += (idDescripcionCriterio1 != null ? idDescripcionCriterio1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescripcionCriterio1)) {
            return false;
        }
        DescripcionCriterio1 other = (DescripcionCriterio1) object;
        if ((this.idDescripcionCriterio1 == null && other.idDescripcionCriterio1 != null) || (this.idDescripcionCriterio1 != null && !this.idDescripcionCriterio1.equals(other.idDescripcionCriterio1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.DescripcionCriterio1[ idDescripcionCriterio1=" + idDescripcionCriterio1 + " ]";
    }
    
}
