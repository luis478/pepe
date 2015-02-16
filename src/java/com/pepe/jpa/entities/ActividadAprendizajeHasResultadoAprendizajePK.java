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
public class ActividadAprendizajeHasResultadoAprendizajePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_actividad_aprendizaje")
    private int idActividadAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_resultado_aprendizaje")
    private int idResultadoAprendizaje;

    public ActividadAprendizajeHasResultadoAprendizajePK() {
    }

    public ActividadAprendizajeHasResultadoAprendizajePK(int idActividadAprendizaje, int idResultadoAprendizaje) {
        this.idActividadAprendizaje = idActividadAprendizaje;
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public int getIdActividadAprendizaje() {
        return idActividadAprendizaje;
    }

    public void setIdActividadAprendizaje(int idActividadAprendizaje) {
        this.idActividadAprendizaje = idActividadAprendizaje;
    }

    public int getIdResultadoAprendizaje() {
        return idResultadoAprendizaje;
    }

    public void setIdResultadoAprendizaje(int idResultadoAprendizaje) {
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idActividadAprendizaje;
        hash += (int) idResultadoAprendizaje;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadAprendizajeHasResultadoAprendizajePK)) {
            return false;
        }
        ActividadAprendizajeHasResultadoAprendizajePK other = (ActividadAprendizajeHasResultadoAprendizajePK) object;
        if (this.idActividadAprendizaje != other.idActividadAprendizaje) {
            return false;
        }
        if (this.idResultadoAprendizaje != other.idResultadoAprendizaje) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.ActividadAprendizajeHasResultadoAprendizajePK[ idActividadAprendizaje=" + idActividadAprendizaje + ", idResultadoAprendizaje=" + idResultadoAprendizaje + " ]";
    }
    
}
