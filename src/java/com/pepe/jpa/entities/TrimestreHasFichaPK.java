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
 * @author Adsit
 */
@Embeddable
public class TrimestreHasFichaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_trimestre")
    private int idTrimestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ficha")
    private int idFicha;

    public TrimestreHasFichaPK() {
    }

    public TrimestreHasFichaPK(int idTrimestre, int idFicha) {
        this.idTrimestre = idTrimestre;
        this.idFicha = idFicha;
    }

    public int getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(int idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public int getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTrimestre;
        hash += (int) idFicha;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrimestreHasFichaPK)) {
            return false;
        }
        TrimestreHasFichaPK other = (TrimestreHasFichaPK) object;
        if (this.idTrimestre != other.idTrimestre) {
            return false;
        }
        if (this.idFicha != other.idFicha) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TrimestreHasFichaPK[ idTrimestre=" + idTrimestre + ", idFicha=" + idFicha + " ]";
    }
    
}
