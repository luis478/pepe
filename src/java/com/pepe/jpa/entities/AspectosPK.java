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
public class AspectosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_aspectos")
    private int idAspectos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ficha")
    private int idFicha;

    public AspectosPK() {
    }

    public AspectosPK(int idAspectos, int idFicha) {
        this.idAspectos = idAspectos;
        this.idFicha = idFicha;
    }

    public int getIdAspectos() {
        return idAspectos;
    }

    public void setIdAspectos(int idAspectos) {
        this.idAspectos = idAspectos;
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
        hash += (int) idAspectos;
        hash += (int) idFicha;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AspectosPK)) {
            return false;
        }
        AspectosPK other = (AspectosPK) object;
        if (this.idAspectos != other.idAspectos) {
            return false;
        }
        if (this.idFicha != other.idFicha) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.AspectosPK[ idAspectos=" + idAspectos + ", idFicha=" + idFicha + " ]";
    }
    
}
