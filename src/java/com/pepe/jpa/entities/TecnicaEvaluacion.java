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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "tecnica_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TecnicaEvaluacion.findAll", query = "SELECT t FROM TecnicaEvaluacion t"),
    @NamedQuery(name = "TecnicaEvaluacion.findByIdTecnicaEvaluacion", query = "SELECT t FROM TecnicaEvaluacion t WHERE t.idTecnicaEvaluacion = :idTecnicaEvaluacion"),
    @NamedQuery(name = "TecnicaEvaluacion.findByTecnicaEvaluacion", query = "SELECT t FROM TecnicaEvaluacion t WHERE t.tecnicaEvaluacion = :tecnicaEvaluacion")})
public class TecnicaEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tecnica_evaluacion")
    private Integer idTecnicaEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "tecnica_evaluacion")
    private String tecnicaEvaluacion;
    @JoinTable(name = "tipo_evidencia_has_tecnica_evaluacion", joinColumns = {
        @JoinColumn(name = "id_tecnica_evaluacion", referencedColumnName = "id_tecnica_evaluacion")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tipo_evidencia", referencedColumnName = "id_tipo_evidencia")})
    @ManyToMany
    private List<TipoEvidencia> tipoEvidenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTecnicaEvaluacion")
    private List<Evidencia> evidenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTecnicaEvaluacion")
    private List<InstrumentoEvaluacion> instrumentoEvaluacionList;

    public TecnicaEvaluacion() {
    }

    public TecnicaEvaluacion(Integer idTecnicaEvaluacion) {
        this.idTecnicaEvaluacion = idTecnicaEvaluacion;
    }

    public TecnicaEvaluacion(Integer idTecnicaEvaluacion, String tecnicaEvaluacion) {
        this.idTecnicaEvaluacion = idTecnicaEvaluacion;
        this.tecnicaEvaluacion = tecnicaEvaluacion;
    }

    public Integer getIdTecnicaEvaluacion() {
        return idTecnicaEvaluacion;
    }

    public void setIdTecnicaEvaluacion(Integer idTecnicaEvaluacion) {
        this.idTecnicaEvaluacion = idTecnicaEvaluacion;
    }

    public String getTecnicaEvaluacion() {
        return tecnicaEvaluacion;
    }

    public void setTecnicaEvaluacion(String tecnicaEvaluacion) {
        this.tecnicaEvaluacion = tecnicaEvaluacion;
    }

    @XmlTransient
    public List<TipoEvidencia> getTipoEvidenciaList() {
        return tipoEvidenciaList;
    }

    public void setTipoEvidenciaList(List<TipoEvidencia> tipoEvidenciaList) {
        this.tipoEvidenciaList = tipoEvidenciaList;
    }

    @XmlTransient
    public List<Evidencia> getEvidenciaList() {
        return evidenciaList;
    }

    public void setEvidenciaList(List<Evidencia> evidenciaList) {
        this.evidenciaList = evidenciaList;
    }

    @XmlTransient
    public List<InstrumentoEvaluacion> getInstrumentoEvaluacionList() {
        return instrumentoEvaluacionList;
    }

    public void setInstrumentoEvaluacionList(List<InstrumentoEvaluacion> instrumentoEvaluacionList) {
        this.instrumentoEvaluacionList = instrumentoEvaluacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTecnicaEvaluacion != null ? idTecnicaEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnicaEvaluacion)) {
            return false;
        }
        TecnicaEvaluacion other = (TecnicaEvaluacion) object;
        if ((this.idTecnicaEvaluacion == null && other.idTecnicaEvaluacion != null) || (this.idTecnicaEvaluacion != null && !this.idTecnicaEvaluacion.equals(other.idTecnicaEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TecnicaEvaluacion[ idTecnicaEvaluacion=" + idTecnicaEvaluacion + " ]";
    }
    
}
