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
 * @author Luis Carlos
 */
@Entity
@Table(name = "tipo_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMaterial.findAll", query = "SELECT t FROM TipoMaterial t"),
    @NamedQuery(name = "TipoMaterial.findByIdTipoMaterial", query = "SELECT t FROM TipoMaterial t WHERE t.idTipoMaterial = :idTipoMaterial")})
public class TipoMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_material")
    private Integer idTipoMaterial;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_tipo_material")
    private String nombreTipoMaterial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoMaterial")
    private List<TipoMaterialHasRubroPresupuestal> tipoMaterialHasRubroPresupuestalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMaterial")
    private List<Material> materialList;

    public TipoMaterial() {
    }

    public TipoMaterial(Integer idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    public TipoMaterial(Integer idTipoMaterial, String nombreTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
        this.nombreTipoMaterial = nombreTipoMaterial;
    }

    public Integer getIdTipoMaterial() {
        return idTipoMaterial;
    }

    public void setIdTipoMaterial(Integer idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    public String getNombreTipoMaterial() {
        return nombreTipoMaterial;
    }

    public void setNombreTipoMaterial(String nombreTipoMaterial) {
        this.nombreTipoMaterial = nombreTipoMaterial;
    }

    @XmlTransient
    public List<TipoMaterialHasRubroPresupuestal> getTipoMaterialHasRubroPresupuestalList() {
        return tipoMaterialHasRubroPresupuestalList;
    }

    public void setTipoMaterialHasRubroPresupuestalList(List<TipoMaterialHasRubroPresupuestal> tipoMaterialHasRubroPresupuestalList) {
        this.tipoMaterialHasRubroPresupuestalList = tipoMaterialHasRubroPresupuestalList;
    }

    @XmlTransient
    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMaterial != null ? idTipoMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMaterial)) {
            return false;
        }
        TipoMaterial other = (TipoMaterial) object;
        if ((this.idTipoMaterial == null && other.idTipoMaterial != null) || (this.idTipoMaterial != null && !this.idTipoMaterial.equals(other.idTipoMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoMaterial[ idTipoMaterial=" + idTipoMaterial + " ]";
    }
    
}
