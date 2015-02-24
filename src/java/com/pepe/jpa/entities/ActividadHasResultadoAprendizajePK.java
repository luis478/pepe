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
public class ActividadHasResultadoAprendizajePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_actividad")
    private int idActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_resultado_aprendizaje")
    private int idResultadoAprendizaje;

    public ActividadHasResultadoAprendizajePK() {
    }

    public ActividadHasResultadoAprendizajePK(int idActividad, int idResultadoAprendizaje) {
        this.idActividad = idActividad;
        this.idResultadoAprendizaje = idResultadoAprendizaje;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
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
        hash += (int) idActividad;
        hash += (int) idResultadoAprendizaje;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadHasResultadoAprendizajePK)) {
            return false;
        }
        ActividadHasResultadoAprendizajePK other = (ActividadHasResultadoAprendizajePK) object;
        if (this.idActividad != other.idActividad) {
            return false;
        }
        if (this.idResultadoAprendizaje != other.idResultadoAprendizaje) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.ActividadHasResultadoAprendizajePK[ idActividad=" + idActividad + ", idResultadoAprendizaje=" + idResultadoAprendizaje + " ]";
    }
    
}