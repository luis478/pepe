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
 * @author Luis Carlos
 */
@Embeddable
public class CriterioSeguimientoHasAcompanamientoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_criterio_seguimiento")
    private int idCriterioSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_acompanamiento")
    private int idAcompanamiento;

    public CriterioSeguimientoHasAcompanamientoPK() {
    }

    public CriterioSeguimientoHasAcompanamientoPK(int idCriterioSeguimiento, int idAcompanamiento) {
        this.idCriterioSeguimiento = idCriterioSeguimiento;
        this.idAcompanamiento = idAcompanamiento;
    }

    public int getIdCriterioSeguimiento() {
        return idCriterioSeguimiento;
    }

    public void setIdCriterioSeguimiento(int idCriterioSeguimiento) {
        this.idCriterioSeguimiento = idCriterioSeguimiento;
    }

    public int getIdAcompanamiento() {
        return idAcompanamiento;
    }

    public void setIdAcompanamiento(int idAcompanamiento) {
        this.idAcompanamiento = idAcompanamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCriterioSeguimiento;
        hash += (int) idAcompanamiento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioSeguimientoHasAcompanamientoPK)) {
            return false;
        }
        CriterioSeguimientoHasAcompanamientoPK other = (CriterioSeguimientoHasAcompanamientoPK) object;
        if (this.idCriterioSeguimiento != other.idCriterioSeguimiento) {
            return false;
        }
        if (this.idAcompanamiento != other.idAcompanamiento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.CriterioSeguimientoHasAcompanamientoPK[ idCriterioSeguimiento=" + idCriterioSeguimiento + ", idAcompanamiento=" + idAcompanamiento + " ]";
    }
    
}
