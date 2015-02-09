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
public class GuiaAprendizajePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_guia_aprendizaje")
    private int idGuiaAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_fase")
    private int idFase;

    public GuiaAprendizajePK() {
    }

    public GuiaAprendizajePK(int idGuiaAprendizaje, int idFase) {
        this.idGuiaAprendizaje = idGuiaAprendizaje;
        this.idFase = idFase;
    }

    public int getIdGuiaAprendizaje() {
        return idGuiaAprendizaje;
    }

    public void setIdGuiaAprendizaje(int idGuiaAprendizaje) {
        this.idGuiaAprendizaje = idGuiaAprendizaje;
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
        hash += (int) idGuiaAprendizaje;
        hash += (int) idFase;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaAprendizajePK)) {
            return false;
        }
        GuiaAprendizajePK other = (GuiaAprendizajePK) object;
        if (this.idGuiaAprendizaje != other.idGuiaAprendizaje) {
            return false;
        }
        if (this.idFase != other.idFase) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.GuiaAprendizajePK[ idGuiaAprendizaje=" + idGuiaAprendizaje + ", idFase=" + idFase + " ]";
    }
    
}
