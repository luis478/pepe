/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Windows 8
 */
@Entity
@Table(name = "actividad_aprendizaje_has_resultado_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadAprendizajeHasResultadoAprendizaje.findAll", query = "SELECT a FROM ActividadAprendizajeHasResultadoAprendizaje a"),
    @NamedQuery(name = "ActividadAprendizajeHasResultadoAprendizaje.findByIdActividadAprendizaje", query = "SELECT a FROM ActividadAprendizajeHasResultadoAprendizaje a WHERE a.actividadAprendizajeHasResultadoAprendizajePK.idActividadAprendizaje = :idActividadAprendizaje"),
    @NamedQuery(name = "ActividadAprendizajeHasResultadoAprendizaje.findByIdResultadoAprendizaje", query = "SELECT a FROM ActividadAprendizajeHasResultadoAprendizaje a WHERE a.actividadAprendizajeHasResultadoAprendizajePK.idResultadoAprendizaje = :idResultadoAprendizaje")})
public class ActividadAprendizajeHasResultadoAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActividadAprendizajeHasResultadoAprendizajePK actividadAprendizajeHasResultadoAprendizajePK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadAprendizajeHasResultadoAprendizaje")
    private List<Evento> eventoList;
    @JoinColumn(name = "id_actividad_aprendizaje", referencedColumnName = "id_actividad_aprendizaje", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ActividadAprendizaje actividadAprendizaje;
    @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ResultadoAprendizaje resultadoAprendizaje;

    public ActividadAprendizajeHasResultadoAprendizaje() {
    }

    public ActividadAprendizajeHasResultadoAprendizaje(ActividadAprendizajeHasResultadoAprendizajePK actividadAprendizajeHasResultadoAprendizajePK) {
        this.actividadAprendizajeHasResultadoAprendizajePK = actividadAprendizajeHasResultadoAprendizajePK;
    }

    public ActividadAprendizajeHasResultadoAprendizaje(int idActividadAprendizaje, int idResultadoAprendizaje) {
        this.actividadAprendizajeHasResultadoAprendizajePK = new ActividadAprendizajeHasResultadoAprendizajePK(idActividadAprendizaje, idResultadoAprendizaje);
    }

    public ActividadAprendizajeHasResultadoAprendizajePK getActividadAprendizajeHasResultadoAprendizajePK() {
        return actividadAprendizajeHasResultadoAprendizajePK;
    }

    public void setActividadAprendizajeHasResultadoAprendizajePK(ActividadAprendizajeHasResultadoAprendizajePK actividadAprendizajeHasResultadoAprendizajePK) {
        this.actividadAprendizajeHasResultadoAprendizajePK = actividadAprendizajeHasResultadoAprendizajePK;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    public ActividadAprendizaje getActividadAprendizaje() {
        return actividadAprendizaje;
    }

    public void setActividadAprendizaje(ActividadAprendizaje actividadAprendizaje) {
        this.actividadAprendizaje = actividadAprendizaje;
    }

    public ResultadoAprendizaje getResultadoAprendizaje() {
        return resultadoAprendizaje;
    }

    public void setResultadoAprendizaje(ResultadoAprendizaje resultadoAprendizaje) {
        this.resultadoAprendizaje = resultadoAprendizaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actividadAprendizajeHasResultadoAprendizajePK != null ? actividadAprendizajeHasResultadoAprendizajePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadAprendizajeHasResultadoAprendizaje)) {
            return false;
        }
        ActividadAprendizajeHasResultadoAprendizaje other = (ActividadAprendizajeHasResultadoAprendizaje) object;
        if ((this.actividadAprendizajeHasResultadoAprendizajePK == null && other.actividadAprendizajeHasResultadoAprendizajePK != null) || (this.actividadAprendizajeHasResultadoAprendizajePK != null && !this.actividadAprendizajeHasResultadoAprendizajePK.equals(other.actividadAprendizajeHasResultadoAprendizajePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.ActividadAprendizajeHasResultadoAprendizaje[ actividadAprendizajeHasResultadoAprendizajePK=" + actividadAprendizajeHasResultadoAprendizajePK + " ]";
    }
    
}
