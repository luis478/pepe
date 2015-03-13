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
@Table(name = "descripcion_criterio4")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescripcionCriterio4.findAll", query = "SELECT d FROM DescripcionCriterio4 d"),
    @NamedQuery(name = "DescripcionCriterio4.findByIdDescripcionCriterio4", query = "SELECT d FROM DescripcionCriterio4 d WHERE d.idDescripcionCriterio4 = :idDescripcionCriterio4")})
public class DescripcionCriterio4 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_descripcion_criterio4")
    private Integer idDescripcionCriterio4;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descrpcion")
    private String descrpcion;
    @OneToMany(mappedBy = "idDescripcionCriterio4")
    private List<ItemCriterio> itemCriterioList;

    public DescripcionCriterio4() {
    }

    public DescripcionCriterio4(Integer idDescripcionCriterio4) {
        this.idDescripcionCriterio4 = idDescripcionCriterio4;
    }

    public DescripcionCriterio4(Integer idDescripcionCriterio4, String descrpcion) {
        this.idDescripcionCriterio4 = idDescripcionCriterio4;
        this.descrpcion = descrpcion;
    }

    public Integer getIdDescripcionCriterio4() {
        return idDescripcionCriterio4;
    }

    public void setIdDescripcionCriterio4(Integer idDescripcionCriterio4) {
        this.idDescripcionCriterio4 = idDescripcionCriterio4;
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
        hash += (idDescripcionCriterio4 != null ? idDescripcionCriterio4.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescripcionCriterio4)) {
            return false;
        }
        DescripcionCriterio4 other = (DescripcionCriterio4) object;
        if ((this.idDescripcionCriterio4 == null && other.idDescripcionCriterio4 != null) || (this.idDescripcionCriterio4 != null && !this.idDescripcionCriterio4.equals(other.idDescripcionCriterio4))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.DescripcionCriterio4[ idDescripcionCriterio4=" + idDescripcionCriterio4 + " ]";
    }
    
}
