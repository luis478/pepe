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
@Table(name = "descripcion_criterio3")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescripcionCriterio3.findAll", query = "SELECT d FROM DescripcionCriterio3 d"),
    @NamedQuery(name = "DescripcionCriterio3.findByIdDescripcionCriterio3", query = "SELECT d FROM DescripcionCriterio3 d WHERE d.idDescripcionCriterio3 = :idDescripcionCriterio3")})
public class DescripcionCriterio3 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_descripcion_criterio3")
    private Integer idDescripcionCriterio3;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descrpcion")
    private String descrpcion;
    @OneToMany(mappedBy = "idDescripcionCriterio3")
    private List<ItemCriterio> itemCriterioList;

    public DescripcionCriterio3() {
    }

    public DescripcionCriterio3(Integer idDescripcionCriterio3) {
        this.idDescripcionCriterio3 = idDescripcionCriterio3;
    }

    public DescripcionCriterio3(Integer idDescripcionCriterio3, String descrpcion) {
        this.idDescripcionCriterio3 = idDescripcionCriterio3;
        this.descrpcion = descrpcion;
    }

    public Integer getIdDescripcionCriterio3() {
        return idDescripcionCriterio3;
    }

    public void setIdDescripcionCriterio3(Integer idDescripcionCriterio3) {
        this.idDescripcionCriterio3 = idDescripcionCriterio3;
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
        hash += (idDescripcionCriterio3 != null ? idDescripcionCriterio3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescripcionCriterio3)) {
            return false;
        }
        DescripcionCriterio3 other = (DescripcionCriterio3) object;
        if ((this.idDescripcionCriterio3 == null && other.idDescripcionCriterio3 != null) || (this.idDescripcionCriterio3 != null && !this.idDescripcionCriterio3.equals(other.idDescripcionCriterio3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.DescripcionCriterio3[ idDescripcionCriterio3=" + idDescripcionCriterio3 + " ]";
    }
    
}
