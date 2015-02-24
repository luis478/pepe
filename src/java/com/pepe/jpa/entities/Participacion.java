/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adsit
 */
@Entity
@Table(name = "participacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participacion.findAll", query = "SELECT p FROM Participacion p"),
    @NamedQuery(name = "Participacion.findByIdParticipacion", query = "SELECT p FROM Participacion p WHERE p.idParticipacion = :idParticipacion")})
public class Participacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_participacion")
    private Integer idParticipacion;

    public Participacion() {
    }

    public Participacion(Integer idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public Integer getIdParticipacion() {
        return idParticipacion;
    }

    public void setIdParticipacion(Integer idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParticipacion != null ? idParticipacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participacion)) {
            return false;
        }
        Participacion other = (Participacion) object;
        if ((this.idParticipacion == null && other.idParticipacion != null) || (this.idParticipacion != null && !this.idParticipacion.equals(other.idParticipacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Participacion[ idParticipacion=" + idParticipacion + " ]";
    }
    
}
