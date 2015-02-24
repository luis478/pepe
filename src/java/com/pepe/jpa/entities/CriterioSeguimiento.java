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
 * @author ADSI TARDE
 */
@Entity
@Table(name = "criterio_seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriterioSeguimiento.findAll", query = "SELECT c FROM CriterioSeguimiento c"),
    @NamedQuery(name = "CriterioSeguimiento.findByIdCriterioSeguimiento", query = "SELECT c FROM CriterioSeguimiento c WHERE c.idCriterioSeguimiento = :idCriterioSeguimiento")})
public class CriterioSeguimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_criterio_seguimiento")
    private Integer idCriterioSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descrpcion")
    private String descrpcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criterioSeguimiento")
    private List<CriterioSeguimientoHasAcompanamiento> criterioSeguimientoHasAcompanamientoList;

    public CriterioSeguimiento() {
    }

    public CriterioSeguimiento(Integer idCriterioSeguimiento) {
        this.idCriterioSeguimiento = idCriterioSeguimiento;
    }

    public CriterioSeguimiento(Integer idCriterioSeguimiento, String descrpcion) {
        this.idCriterioSeguimiento = idCriterioSeguimiento;
        this.descrpcion = descrpcion;
    }

    public Integer getIdCriterioSeguimiento() {
        return idCriterioSeguimiento;
    }

    public void setIdCriterioSeguimiento(Integer idCriterioSeguimiento) {
        this.idCriterioSeguimiento = idCriterioSeguimiento;
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }

    @XmlTransient
    public List<CriterioSeguimientoHasAcompanamiento> getCriterioSeguimientoHasAcompanamientoList() {
        return criterioSeguimientoHasAcompanamientoList;
    }

    public void setCriterioSeguimientoHasAcompanamientoList(List<CriterioSeguimientoHasAcompanamiento> criterioSeguimientoHasAcompanamientoList) {
        this.criterioSeguimientoHasAcompanamientoList = criterioSeguimientoHasAcompanamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCriterioSeguimiento != null ? idCriterioSeguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioSeguimiento)) {
            return false;
        }
        CriterioSeguimiento other = (CriterioSeguimiento) object;
        if ((this.idCriterioSeguimiento == null && other.idCriterioSeguimiento != null) || (this.idCriterioSeguimiento != null && !this.idCriterioSeguimiento.equals(other.idCriterioSeguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.CriterioSeguimiento[ idCriterioSeguimiento=" + idCriterioSeguimiento + " ]";
    }
    
}
