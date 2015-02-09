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
 * @author Windows 8
 */
@Embeddable
public class CriterioSeguimientoHasAcompañamientoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_criterio_seguimiento")
    private int idCriterioSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_acompa\u00f1amiento")
    private int idAcompañamiento;

    public CriterioSeguimientoHasAcompañamientoPK() {
    }

    public CriterioSeguimientoHasAcompañamientoPK(int idCriterioSeguimiento, int idAcompañamiento) {
        this.idCriterioSeguimiento = idCriterioSeguimiento;
        this.idAcompañamiento = idAcompañamiento;
    }

    public int getIdCriterioSeguimiento() {
        return idCriterioSeguimiento;
    }

    public void setIdCriterioSeguimiento(int idCriterioSeguimiento) {
        this.idCriterioSeguimiento = idCriterioSeguimiento;
    }

    public int getIdAcompañamiento() {
        return idAcompañamiento;
    }

    public void setIdAcompañamiento(int idAcompañamiento) {
        this.idAcompañamiento = idAcompañamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCriterioSeguimiento;
        hash += (int) idAcompañamiento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioSeguimientoHasAcompañamientoPK)) {
            return false;
        }
        CriterioSeguimientoHasAcompañamientoPK other = (CriterioSeguimientoHasAcompañamientoPK) object;
        if (this.idCriterioSeguimiento != other.idCriterioSeguimiento) {
            return false;
        }
        if (this.idAcompañamiento != other.idAcompañamiento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.CriterioSeguimientoHasAcompa\u00f1amientoPK[ idCriterioSeguimiento=" + idCriterioSeguimiento + ", idAcompa\u00f1amiento=" + idAcompañamiento + " ]";
    }
    
}
