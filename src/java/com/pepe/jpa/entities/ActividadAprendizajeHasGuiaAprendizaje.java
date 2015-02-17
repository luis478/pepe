/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows 8
 */
@Entity
@Table(name = "actividad_aprendizaje_has_guia_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadAprendizajeHasGuiaAprendizaje.findAll", query = "SELECT a FROM ActividadAprendizajeHasGuiaAprendizaje a"),
    @NamedQuery(name = "ActividadAprendizajeHasGuiaAprendizaje.findByIdActividadAprendizaje", query = "SELECT a FROM ActividadAprendizajeHasGuiaAprendizaje a WHERE a.actividadAprendizajeHasGuiaAprendizajePK.idActividadAprendizaje = :idActividadAprendizaje"),
    @NamedQuery(name = "ActividadAprendizajeHasGuiaAprendizaje.findByIdGuiaAprendizaje", query = "SELECT a FROM ActividadAprendizajeHasGuiaAprendizaje a WHERE a.actividadAprendizajeHasGuiaAprendizajePK.idGuiaAprendizaje = :idGuiaAprendizaje")})
public class ActividadAprendizajeHasGuiaAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActividadAprendizajeHasGuiaAprendizajePK actividadAprendizajeHasGuiaAprendizajePK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_actividad_aprendizaje", referencedColumnName = "id_actividad_aprendizaje", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ActividadAprendizaje actividadAprendizaje;
    @JoinColumn(name = "id_guia_aprendizaje", referencedColumnName = "id_guia_aprendizaje", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GuiaAprendizaje guiaAprendizaje;

    public ActividadAprendizajeHasGuiaAprendizaje() {
    }

    public ActividadAprendizajeHasGuiaAprendizaje(ActividadAprendizajeHasGuiaAprendizajePK actividadAprendizajeHasGuiaAprendizajePK) {
        this.actividadAprendizajeHasGuiaAprendizajePK = actividadAprendizajeHasGuiaAprendizajePK;
    }

    public ActividadAprendizajeHasGuiaAprendizaje(ActividadAprendizajeHasGuiaAprendizajePK actividadAprendizajeHasGuiaAprendizajePK, String observacion) {
        this.actividadAprendizajeHasGuiaAprendizajePK = actividadAprendizajeHasGuiaAprendizajePK;
        this.observacion = observacion;
    }

    public ActividadAprendizajeHasGuiaAprendizaje(int idActividadAprendizaje, int idGuiaAprendizaje) {
        this.actividadAprendizajeHasGuiaAprendizajePK = new ActividadAprendizajeHasGuiaAprendizajePK(idActividadAprendizaje, idGuiaAprendizaje);
    }

    public ActividadAprendizajeHasGuiaAprendizajePK getActividadAprendizajeHasGuiaAprendizajePK() {
        return actividadAprendizajeHasGuiaAprendizajePK;
    }

    public void setActividadAprendizajeHasGuiaAprendizajePK(ActividadAprendizajeHasGuiaAprendizajePK actividadAprendizajeHasGuiaAprendizajePK) {
        this.actividadAprendizajeHasGuiaAprendizajePK = actividadAprendizajeHasGuiaAprendizajePK;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public ActividadAprendizaje getActividadAprendizaje() {
        return actividadAprendizaje;
    }

    public void setActividadAprendizaje(ActividadAprendizaje actividadAprendizaje) {
        this.actividadAprendizaje = actividadAprendizaje;
    }

    public GuiaAprendizaje getGuiaAprendizaje() {
        return guiaAprendizaje;
    }

    public void setGuiaAprendizaje(GuiaAprendizaje guiaAprendizaje) {
        this.guiaAprendizaje = guiaAprendizaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actividadAprendizajeHasGuiaAprendizajePK != null ? actividadAprendizajeHasGuiaAprendizajePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadAprendizajeHasGuiaAprendizaje)) {
            return false;
        }
        ActividadAprendizajeHasGuiaAprendizaje other = (ActividadAprendizajeHasGuiaAprendizaje) object;
        if ((this.actividadAprendizajeHasGuiaAprendizajePK == null && other.actividadAprendizajeHasGuiaAprendizajePK != null) || (this.actividadAprendizajeHasGuiaAprendizajePK != null && !this.actividadAprendizajeHasGuiaAprendizajePK.equals(other.actividadAprendizajeHasGuiaAprendizajePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.ActividadAprendizajeHasGuiaAprendizaje[ actividadAprendizajeHasGuiaAprendizajePK=" + actividadAprendizajeHasGuiaAprendizajePK + " ]";
    }
    
}
