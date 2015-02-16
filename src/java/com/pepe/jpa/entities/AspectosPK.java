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
public class AspectosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_aspectos")
    private int idAspectos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ficha_id_ficha")
    private int fichaIdFicha;

    public AspectosPK() {
    }

    public AspectosPK(int idAspectos, int fichaIdFicha) {
        this.idAspectos = idAspectos;
        this.fichaIdFicha = fichaIdFicha;
    }

    public int getIdAspectos() {
        return idAspectos;
    }

    public void setIdAspectos(int idAspectos) {
        this.idAspectos = idAspectos;
    }

    public int getFichaIdFicha() {
        return fichaIdFicha;
    }

    public void setFichaIdFicha(int fichaIdFicha) {
        this.fichaIdFicha = fichaIdFicha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAspectos;
        hash += (int) fichaIdFicha;
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
        if (this.fichaIdFicha != other.fichaIdFicha) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.AspectosPK[ idAspectos=" + idAspectos + ", fichaIdFicha=" + fichaIdFicha + " ]";
    }
    
}
