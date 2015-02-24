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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @author ADSI TARDE
 */
@Entity
@Table(name = "material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findByIdMaterial", query = "SELECT m FROM Material m WHERE m.idMaterial = :idMaterial"),
    @NamedQuery(name = "Material.findByCantidad", query = "SELECT m FROM Material m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "Material.findByValorUnitario", query = "SELECT m FROM Material m WHERE m.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Material.findByCodigoOrions", query = "SELECT m FROM Material m WHERE m.codigoOrions = :codigoOrions")})
public class Material implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_material")
    private Integer idMaterial;
    @Lob
    @Size(max = 65535)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_unitario")
    private Double valorUnitario;
    @Size(max = 45)
    @Column(name = "codigo_orions")
    private String codigoOrions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "material")
    private List<RecursoHasMaterial> recursoHasMaterialList;
    @JoinColumn(name = "id_tipo_material", referencedColumnName = "id_tipo_material")
    @ManyToOne(optional = false)
    private TipoMaterial idTipoMaterial;

    public Material() {
    }

    public Material(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Material(Integer idMaterial, int cantidad) {
        this.idMaterial = idMaterial;
        this.cantidad = cantidad;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getCodigoOrions() {
        return codigoOrions;
    }

    public void setCodigoOrions(String codigoOrions) {
        this.codigoOrions = codigoOrions;
    }

    @XmlTransient
    public List<RecursoHasMaterial> getRecursoHasMaterialList() {
        return recursoHasMaterialList;
    }

    public void setRecursoHasMaterialList(List<RecursoHasMaterial> recursoHasMaterialList) {
        this.recursoHasMaterialList = recursoHasMaterialList;
    }

    public TipoMaterial getIdTipoMaterial() {
        return idTipoMaterial;
    }

    public void setIdTipoMaterial(TipoMaterial idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterial != null ? idMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.idMaterial == null && other.idMaterial != null) || (this.idMaterial != null && !this.idMaterial.equals(other.idMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Material[ idMaterial=" + idMaterial + " ]";
    }
    
}
