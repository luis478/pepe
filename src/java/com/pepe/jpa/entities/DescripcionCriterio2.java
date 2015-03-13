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
@Table(name = "descripcion_criterio2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescripcionCriterio2.findAll", query = "SELECT d FROM DescripcionCriterio2 d"),
    @NamedQuery(name = "DescripcionCriterio2.findByIdDescripcionCriterio2", query = "SELECT d FROM DescripcionCriterio2 d WHERE d.idDescripcionCriterio2 = :idDescripcionCriterio2")})
public class DescripcionCriterio2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_descripcion_criterio2")
    private Integer idDescripcionCriterio2;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descrpcion")
    private String descrpcion;
    @OneToMany(mappedBy = "idDescripcionCriterio2")
    private List<ItemCriterio> itemCriterioList;

    public DescripcionCriterio2() {
    }

    public DescripcionCriterio2(Integer idDescripcionCriterio2) {
        this.idDescripcionCriterio2 = idDescripcionCriterio2;
    }

    public DescripcionCriterio2(Integer idDescripcionCriterio2, String descrpcion) {
        this.idDescripcionCriterio2 = idDescripcionCriterio2;
        this.descrpcion = descrpcion;
    }

    public Integer getIdDescripcionCriterio2() {
        return idDescripcionCriterio2;
    }

    public void setIdDescripcionCriterio2(Integer idDescripcionCriterio2) {
        this.idDescripcionCriterio2 = idDescripcionCriterio2;
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
        hash += (idDescripcionCriterio2 != null ? idDescripcionCriterio2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescripcionCriterio2)) {
            return false;
        }
        DescripcionCriterio2 other = (DescripcionCriterio2) object;
        if ((this.idDescripcionCriterio2 == null && other.idDescripcionCriterio2 != null) || (this.idDescripcionCriterio2 != null && !this.idDescripcionCriterio2.equals(other.idDescripcionCriterio2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.DescripcionCriterio2[ idDescripcionCriterio2=" + idDescripcionCriterio2 + " ]";
    }
    
}
