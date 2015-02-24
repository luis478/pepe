/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Carlos
 */
@Entity
@Table(name = "tipo_material_has_rubro_presupuestal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMaterialHasRubroPresupuestal.findAll", query = "SELECT t FROM TipoMaterialHasRubroPresupuestal t"),
    @NamedQuery(name = "TipoMaterialHasRubroPresupuestal.findByIdTipoMaterial", query = "SELECT t FROM TipoMaterialHasRubroPresupuestal t WHERE t.tipoMaterialHasRubroPresupuestalPK.idTipoMaterial = :idTipoMaterial"),
    @NamedQuery(name = "TipoMaterialHasRubroPresupuestal.findByIdRubroPresupuestal", query = "SELECT t FROM TipoMaterialHasRubroPresupuestal t WHERE t.tipoMaterialHasRubroPresupuestalPK.idRubroPresupuestal = :idRubroPresupuestal"),
    @NamedQuery(name = "TipoMaterialHasRubroPresupuestal.findByValorTotal", query = "SELECT t FROM TipoMaterialHasRubroPresupuestal t WHERE t.valorTotal = :valorTotal")})
public class TipoMaterialHasRubroPresupuestal implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoMaterialHasRubroPresupuestalPK tipoMaterialHasRubroPresupuestalPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "valor_total")
    private String valorTotal;
    @JoinColumn(name = "id_rubro_presupuestal", referencedColumnName = "id_rubro_presupuestal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RubroPresupuestal rubroPresupuestal;
    @JoinColumn(name = "id_tipo_material", referencedColumnName = "id_tipo_material", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoMaterial tipoMaterial;

    public TipoMaterialHasRubroPresupuestal() {
    }

    public TipoMaterialHasRubroPresupuestal(TipoMaterialHasRubroPresupuestalPK tipoMaterialHasRubroPresupuestalPK) {
        this.tipoMaterialHasRubroPresupuestalPK = tipoMaterialHasRubroPresupuestalPK;
    }

    public TipoMaterialHasRubroPresupuestal(TipoMaterialHasRubroPresupuestalPK tipoMaterialHasRubroPresupuestalPK, String valorTotal) {
        this.tipoMaterialHasRubroPresupuestalPK = tipoMaterialHasRubroPresupuestalPK;
        this.valorTotal = valorTotal;
    }

    public TipoMaterialHasRubroPresupuestal(int idTipoMaterial, int idRubroPresupuestal) {
        this.tipoMaterialHasRubroPresupuestalPK = new TipoMaterialHasRubroPresupuestalPK(idTipoMaterial, idRubroPresupuestal);
    }

    public TipoMaterialHasRubroPresupuestalPK getTipoMaterialHasRubroPresupuestalPK() {
        return tipoMaterialHasRubroPresupuestalPK;
    }

    public void setTipoMaterialHasRubroPresupuestalPK(TipoMaterialHasRubroPresupuestalPK tipoMaterialHasRubroPresupuestalPK) {
        this.tipoMaterialHasRubroPresupuestalPK = tipoMaterialHasRubroPresupuestalPK;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public RubroPresupuestal getRubroPresupuestal() {
        return rubroPresupuestal;
    }

    public void setRubroPresupuestal(RubroPresupuestal rubroPresupuestal) {
        this.rubroPresupuestal = rubroPresupuestal;
    }

    public TipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoMaterialHasRubroPresupuestalPK != null ? tipoMaterialHasRubroPresupuestalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMaterialHasRubroPresupuestal)) {
            return false;
        }
        TipoMaterialHasRubroPresupuestal other = (TipoMaterialHasRubroPresupuestal) object;
        if ((this.tipoMaterialHasRubroPresupuestalPK == null && other.tipoMaterialHasRubroPresupuestalPK != null) || (this.tipoMaterialHasRubroPresupuestalPK != null && !this.tipoMaterialHasRubroPresupuestalPK.equals(other.tipoMaterialHasRubroPresupuestalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoMaterialHasRubroPresupuestal[ tipoMaterialHasRubroPresupuestalPK=" + tipoMaterialHasRubroPresupuestalPK + " ]";
    }
    
}
