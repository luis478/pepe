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
 * @author Junior Cabal
 */
@Embeddable
public class ActividadAprendizajeHasGuiaAprendizajePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_actividad_aprendizaje")
    private int idActividadAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_guia_aprendizaje")
    private int idGuiaAprendizaje;

    public ActividadAprendizajeHasGuiaAprendizajePK() {
    }

    public ActividadAprendizajeHasGuiaAprendizajePK(int idActividadAprendizaje, int idGuiaAprendizaje) {
        this.idActividadAprendizaje = idActividadAprendizaje;
        this.idGuiaAprendizaje = idGuiaAprendizaje;
    }

    public int getIdActividadAprendizaje() {
        return idActividadAprendizaje;
    }

    public void setIdActividadAprendizaje(int idActividadAprendizaje) {
        this.idActividadAprendizaje = idActividadAprendizaje;
    }

    public int getIdGuiaAprendizaje() {
        return idGuiaAprendizaje;
    }

    public void setIdGuiaAprendizaje(int idGuiaAprendizaje) {
        this.idGuiaAprendizaje = idGuiaAprendizaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idActividadAprendizaje;
        hash += (int) idGuiaAprendizaje;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadAprendizajeHasGuiaAprendizajePK)) {
            return false;
        }
        ActividadAprendizajeHasGuiaAprendizajePK other = (ActividadAprendizajeHasGuiaAprendizajePK) object;
        if (this.idActividadAprendizaje != other.idActividadAprendizaje) {
            return false;
        }
        if (this.idGuiaAprendizaje != other.idGuiaAprendizaje) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.ActividadAprendizajeHasGuiaAprendizajePK[ idActividadAprendizaje=" + idActividadAprendizaje + ", idGuiaAprendizaje=" + idGuiaAprendizaje + " ]";
    }
    
}
