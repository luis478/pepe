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
 * @author Adsit
 */
@Entity
@Table(name = "trimestre_has_ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrimestreHasFicha.findAll", query = "SELECT t FROM TrimestreHasFicha t"),
    @NamedQuery(name = "TrimestreHasFicha.findByIdTrimestre", query = "SELECT t FROM TrimestreHasFicha t WHERE t.trimestreHasFichaPK.idTrimestre = :idTrimestre"),
    @NamedQuery(name = "TrimestreHasFicha.findByIdFicha", query = "SELECT t FROM TrimestreHasFicha t WHERE t.trimestreHasFichaPK.idFicha = :idFicha")})
public class TrimestreHasFicha implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrimestreHasFichaPK trimestreHasFichaPK;
    @JoinColumn(name = "id_trimestre", referencedColumnName = "id_trimestre", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trimestre trimestre;

    public TrimestreHasFicha() {
    }

    public TrimestreHasFicha(TrimestreHasFichaPK trimestreHasFichaPK) {
        this.trimestreHasFichaPK = trimestreHasFichaPK;
    }

    public TrimestreHasFicha(int idTrimestre, int idFicha) {
        this.trimestreHasFichaPK = new TrimestreHasFichaPK(idTrimestre, idFicha);
    }

    public TrimestreHasFichaPK getTrimestreHasFichaPK() {
        return trimestreHasFichaPK;
    }

    public void setTrimestreHasFichaPK(TrimestreHasFichaPK trimestreHasFichaPK) {
        this.trimestreHasFichaPK = trimestreHasFichaPK;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trimestreHasFichaPK != null ? trimestreHasFichaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrimestreHasFicha)) {
            return false;
        }
        TrimestreHasFicha other = (TrimestreHasFicha) object;
        if ((this.trimestreHasFichaPK == null && other.trimestreHasFichaPK != null) || (this.trimestreHasFichaPK != null && !this.trimestreHasFichaPK.equals(other.trimestreHasFichaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TrimestreHasFicha[ trimestreHasFichaPK=" + trimestreHasFichaPK + " ]";
    }
    
}
