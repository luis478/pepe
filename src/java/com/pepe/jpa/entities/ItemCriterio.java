/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Junior Cabal
 */
@Entity
@Table(name = "item_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemCriterio.findAll", query = "SELECT i FROM ItemCriterio i"),
    @NamedQuery(name = "ItemCriterio.findByIdItemCriterio", query = "SELECT i FROM ItemCriterio i WHERE i.idItemCriterio = :idItemCriterio"),
    @NamedQuery(name = "ItemCriterio.findByValoracionItem", query = "SELECT i FROM ItemCriterio i WHERE i.valoracionItem = :valoracionItem")})
public class ItemCriterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item_criterio")
    private Integer idItemCriterio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valoracion_item")
    private short valoracionItem;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_nombre_criterio", referencedColumnName = "id_criterio")
    @ManyToOne(optional = false)
    private Criterio idNombreCriterio;
    @JoinColumn(name = "id_descripcion_criterio1", referencedColumnName = "id_descripcion_criterio1")
    @ManyToOne
    private DescripcionCriterio1 idDescripcionCriterio1;
    @JoinColumn(name = "id_descripcion_criterio2", referencedColumnName = "id_descripcion_criterio2")
    @ManyToOne
    private DescripcionCriterio2 idDescripcionCriterio2;
    @JoinColumn(name = "id_descripcion_criterio3", referencedColumnName = "id_descripcion_criterio3")
    @ManyToOne
    private DescripcionCriterio3 idDescripcionCriterio3;
    @JoinColumn(name = "id_descripcion_criterio4", referencedColumnName = "id_descripcion_criterio4")
    @ManyToOne
    private DescripcionCriterio4 idDescripcionCriterio4;

    public ItemCriterio() {
    }

    public ItemCriterio(Integer idItemCriterio) {
        this.idItemCriterio = idItemCriterio;
    }

    public ItemCriterio(Integer idItemCriterio, short valoracionItem) {
        this.idItemCriterio = idItemCriterio;
        this.valoracionItem = valoracionItem;
    }

    public Integer getIdItemCriterio() {
        return idItemCriterio;
    }

    public void setIdItemCriterio(Integer idItemCriterio) {
        this.idItemCriterio = idItemCriterio;
    }

    public short getValoracionItem() {
        return valoracionItem;
    }

    public void setValoracionItem(short valoracionItem) {
        this.valoracionItem = valoracionItem;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Criterio getIdNombreCriterio() {
        return idNombreCriterio;
    }

    public void setIdNombreCriterio(Criterio idNombreCriterio) {
        this.idNombreCriterio = idNombreCriterio;
    }

    public DescripcionCriterio1 getIdDescripcionCriterio1() {
        return idDescripcionCriterio1;
    }

    public void setIdDescripcionCriterio1(DescripcionCriterio1 idDescripcionCriterio1) {
        this.idDescripcionCriterio1 = idDescripcionCriterio1;
    }

    public DescripcionCriterio2 getIdDescripcionCriterio2() {
        return idDescripcionCriterio2;
    }

    public void setIdDescripcionCriterio2(DescripcionCriterio2 idDescripcionCriterio2) {
        this.idDescripcionCriterio2 = idDescripcionCriterio2;
    }

    public DescripcionCriterio3 getIdDescripcionCriterio3() {
        return idDescripcionCriterio3;
    }

    public void setIdDescripcionCriterio3(DescripcionCriterio3 idDescripcionCriterio3) {
        this.idDescripcionCriterio3 = idDescripcionCriterio3;
    }

    public DescripcionCriterio4 getIdDescripcionCriterio4() {
        return idDescripcionCriterio4;
    }

    public void setIdDescripcionCriterio4(DescripcionCriterio4 idDescripcionCriterio4) {
        this.idDescripcionCriterio4 = idDescripcionCriterio4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemCriterio != null ? idItemCriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemCriterio)) {
            return false;
        }
        ItemCriterio other = (ItemCriterio) object;
        if ((this.idItemCriterio == null && other.idItemCriterio != null) || (this.idItemCriterio != null && !this.idItemCriterio.equals(other.idItemCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.ItemCriterio[ idItemCriterio=" + idItemCriterio + " ]";
    }
    
}
