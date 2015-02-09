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
public class EvaluacionSeguimientoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_evaluacion_seguimiento")
    private int idEvaluacionSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_fase")
    private int idFase;

    public EvaluacionSeguimientoPK() {
    }

    public EvaluacionSeguimientoPK(int idEvaluacionSeguimiento, int idFase) {
        this.idEvaluacionSeguimiento = idEvaluacionSeguimiento;
        this.idFase = idFase;
    }

    public int getIdEvaluacionSeguimiento() {
        return idEvaluacionSeguimiento;
    }

    public void setIdEvaluacionSeguimiento(int idEvaluacionSeguimiento) {
        this.idEvaluacionSeguimiento = idEvaluacionSeguimiento;
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEvaluacionSeguimiento;
        hash += (int) idFase;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionSeguimientoPK)) {
            return false;
        }
        EvaluacionSeguimientoPK other = (EvaluacionSeguimientoPK) object;
        if (this.idEvaluacionSeguimiento != other.idEvaluacionSeguimiento) {
            return false;
        }
        if (this.idFase != other.idFase) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.EvaluacionSeguimientoPK[ idEvaluacionSeguimiento=" + idEvaluacionSeguimiento + ", idFase=" + idFase + " ]";
    }
    
}
