/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Junior Cabal
 */
@Entity
@Table(name = "instrumento_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstrumentoEvaluacion.findAll", query = "SELECT i FROM InstrumentoEvaluacion i"),
    @NamedQuery(name = "InstrumentoEvaluacion.findByIdInstrumentoEvaluacion", query = "SELECT i FROM InstrumentoEvaluacion i WHERE i.idInstrumentoEvaluacion = :idInstrumentoEvaluacion"),
    @NamedQuery(name = "InstrumentoEvaluacion.findByNombreInstrumentoEvaluacion", query = "SELECT i FROM InstrumentoEvaluacion i WHERE i.nombreInstrumentoEvaluacion = :nombreInstrumentoEvaluacion")})
public class InstrumentoEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_instrumento_evaluacion")
    private Integer idInstrumentoEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_instrumento_evaluacion")
    private String nombreInstrumentoEvaluacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstrumentoEvaluacion")
    private List<TecnicaDidactica> tecnicaDidacticaList;

    public InstrumentoEvaluacion() {
    }

    public InstrumentoEvaluacion(Integer idInstrumentoEvaluacion) {
        this.idInstrumentoEvaluacion = idInstrumentoEvaluacion;
    }

    public InstrumentoEvaluacion(Integer idInstrumentoEvaluacion, String nombreInstrumentoEvaluacion) {
        this.idInstrumentoEvaluacion = idInstrumentoEvaluacion;
        this.nombreInstrumentoEvaluacion = nombreInstrumentoEvaluacion;
    }

    public Integer getIdInstrumentoEvaluacion() {
        return idInstrumentoEvaluacion;
    }

    public void setIdInstrumentoEvaluacion(Integer idInstrumentoEvaluacion) {
        this.idInstrumentoEvaluacion = idInstrumentoEvaluacion;
    }

    public String getNombreInstrumentoEvaluacion() {
        return nombreInstrumentoEvaluacion;
    }

    public void setNombreInstrumentoEvaluacion(String nombreInstrumentoEvaluacion) {
        this.nombreInstrumentoEvaluacion = nombreInstrumentoEvaluacion;
    }

    @XmlTransient
    public List<TecnicaDidactica> getTecnicaDidacticaList() {
        return tecnicaDidacticaList;
    }

    public void setTecnicaDidacticaList(List<TecnicaDidactica> tecnicaDidacticaList) {
        this.tecnicaDidacticaList = tecnicaDidacticaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstrumentoEvaluacion != null ? idInstrumentoEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstrumentoEvaluacion)) {
            return false;
        }
        InstrumentoEvaluacion other = (InstrumentoEvaluacion) object;
        if ((this.idInstrumentoEvaluacion == null && other.idInstrumentoEvaluacion != null) || (this.idInstrumentoEvaluacion != null && !this.idInstrumentoEvaluacion.equals(other.idInstrumentoEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.InstrumentoEvaluacion[ idInstrumentoEvaluacion=" + idInstrumentoEvaluacion + " ]";
    }
    
}
