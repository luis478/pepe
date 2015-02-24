/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ADSI TARDE
 */
@Embeddable
public class TipoMaterialHasRubroPresupuestalPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_material")
    private int idTipoMaterial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_rubro_presupuestal")
    private int idRubroPresupuestal;

    public TipoMaterialHasRubroPresupuestalPK() {
    }

    public TipoMaterialHasRubroPresupuestalPK(int idTipoMaterial, int idRubroPresupuestal) {
        this.idTipoMaterial = idTipoMaterial;
        this.idRubroPresupuestal = idRubroPresupuestal;
    }

    public int getIdTipoMaterial() {
        return idTipoMaterial;
    }

    public void setIdTipoMaterial(int idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    public int getIdRubroPresupuestal() {
        return idRubroPresupuestal;
    }

    public void setIdRubroPresupuestal(int idRubroPresupuestal) {
        this.idRubroPresupuestal = idRubroPresupuestal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTipoMaterial;
        hash += (int) idRubroPresupuestal;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMaterialHasRubroPresupuestalPK)) {
            return false;
        }
        TipoMaterialHasRubroPresupuestalPK other = (TipoMaterialHasRubroPresupuestalPK) object;
        if (this.idTipoMaterial != other.idTipoMaterial) {
            return false;
        }
        if (this.idRubroPresupuestal != other.idRubroPresupuestal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoMaterialHasRubroPresupuestalPK[ idTipoMaterial=" + idTipoMaterial + ", idRubroPresupuestal=" + idRubroPresupuestal + " ]";
    }
    
}
