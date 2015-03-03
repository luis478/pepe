/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Junior Cabal
 */
@Entity
@Table(name = "evaluacion_seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluacionSeguimiento.findAll", query = "SELECT e FROM EvaluacionSeguimiento e"),
    @NamedQuery(name = "EvaluacionSeguimiento.findByIdEvaluacionSeguimiento", query = "SELECT e FROM EvaluacionSeguimiento e WHERE e.evaluacionSeguimientoPK.idEvaluacionSeguimiento = :idEvaluacionSeguimiento"),
    @NamedQuery(name = "EvaluacionSeguimiento.findByIdFase", query = "SELECT e FROM EvaluacionSeguimiento e WHERE e.evaluacionSeguimientoPK.idFase = :idFase")})
public class EvaluacionSeguimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluacionSeguimientoPK evaluacionSeguimientoPK;
    @JoinColumn(name = "id_fase", referencedColumnName = "id_fase", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fase fase;

    public EvaluacionSeguimiento() {
    }

    public EvaluacionSeguimiento(EvaluacionSeguimientoPK evaluacionSeguimientoPK) {
        this.evaluacionSeguimientoPK = evaluacionSeguimientoPK;
    }

    public EvaluacionSeguimiento(int idEvaluacionSeguimiento, int idFase) {
        this.evaluacionSeguimientoPK = new EvaluacionSeguimientoPK(idEvaluacionSeguimiento, idFase);
    }

    public EvaluacionSeguimientoPK getEvaluacionSeguimientoPK() {
        return evaluacionSeguimientoPK;
    }

    public void setEvaluacionSeguimientoPK(EvaluacionSeguimientoPK evaluacionSeguimientoPK) {
        this.evaluacionSeguimientoPK = evaluacionSeguimientoPK;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluacionSeguimientoPK != null ? evaluacionSeguimientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionSeguimiento)) {
            return false;
        }
        EvaluacionSeguimiento other = (EvaluacionSeguimiento) object;
        if ((this.evaluacionSeguimientoPK == null && other.evaluacionSeguimientoPK != null) || (this.evaluacionSeguimientoPK != null && !this.evaluacionSeguimientoPK.equals(other.evaluacionSeguimientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.EvaluacionSeguimiento[ evaluacionSeguimientoPK=" + evaluacionSeguimientoPK + " ]";
    }
    
}
