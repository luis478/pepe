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
 * @author Junior Cabal
 */
@Entity
@Table(name = "valoracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoracion.findAll", query = "SELECT v FROM Valoracion v"),
    @NamedQuery(name = "Valoracion.findByIdValoracion", query = "SELECT v FROM Valoracion v WHERE v.idValoracion = :idValoracion"),
    @NamedQuery(name = "Valoracion.findByCumple", query = "SELECT v FROM Valoracion v WHERE v.cumple = :cumple")})
public class Valoracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_valoracion")
    private Integer idValoracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cumple")
    private boolean cumple;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_revision", referencedColumnName = "id_revision")
    @ManyToOne(optional = false)
    private Revision idRevision;
    @JoinColumn(name = "id_variable", referencedColumnName = "id_variable")
    @ManyToOne
    private Variable idVariable;
    @JoinColumn(name = "id_variable_ambiente", referencedColumnName = "id_variable_ambiente")
    @ManyToOne
    private VariableAmbiente idVariableAmbiente;

    public Valoracion() {
    }

    public Valoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public Valoracion(Integer idValoracion, boolean cumple, String observacion) {
        this.idValoracion = idValoracion;
        this.cumple = cumple;
        this.observacion = observacion;
    }

    public Integer getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public boolean getCumple() {
        return cumple;
    }

    public void setCumple(boolean cumple) {
        this.cumple = cumple;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Revision getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(Revision idRevision) {
        this.idRevision = idRevision;
    }

    public Variable getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Variable idVariable) {
        this.idVariable = idVariable;
    }

    public VariableAmbiente getIdVariableAmbiente() {
        return idVariableAmbiente;
    }

    public void setIdVariableAmbiente(VariableAmbiente idVariableAmbiente) {
        this.idVariableAmbiente = idVariableAmbiente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValoracion != null ? idValoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.idValoracion == null && other.idValoracion != null) || (this.idValoracion != null && !this.idValoracion.equals(other.idValoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Valoracion[ idValoracion=" + idValoracion + " ]";
    }
    
}
