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
@Table(name = "tipo_evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEvaluacion.findAll", query = "SELECT t FROM TipoEvaluacion t"),
    @NamedQuery(name = "TipoEvaluacion.findByIdTipoEvaluacion", query = "SELECT t FROM TipoEvaluacion t WHERE t.idTipoEvaluacion = :idTipoEvaluacion"),
    @NamedQuery(name = "TipoEvaluacion.findByNombreTipoEvaluacion", query = "SELECT t FROM TipoEvaluacion t WHERE t.nombreTipoEvaluacion = :nombreTipoEvaluacion")})
public class TipoEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_evaluacion")
    private Integer idTipoEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo_evaluacion")
    private String nombreTipoEvaluacion;
    @ManyToMany(mappedBy = "tipoEvaluacionList")
    private List<TecnicaDidactica> tecnicaDidacticaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEvaluacion")
    private List<Evidencia> evidenciaList;

    public TipoEvaluacion() {
    }

    public TipoEvaluacion(Integer idTipoEvaluacion) {
        this.idTipoEvaluacion = idTipoEvaluacion;
    }

    public TipoEvaluacion(Integer idTipoEvaluacion, String nombreTipoEvaluacion) {
        this.idTipoEvaluacion = idTipoEvaluacion;
        this.nombreTipoEvaluacion = nombreTipoEvaluacion;
    }

    public Integer getIdTipoEvaluacion() {
        return idTipoEvaluacion;
    }

    public void setIdTipoEvaluacion(Integer idTipoEvaluacion) {
        this.idTipoEvaluacion = idTipoEvaluacion;
    }

    public String getNombreTipoEvaluacion() {
        return nombreTipoEvaluacion;
    }

    public void setNombreTipoEvaluacion(String nombreTipoEvaluacion) {
        this.nombreTipoEvaluacion = nombreTipoEvaluacion;
    }

    @XmlTransient
    public List<TecnicaDidactica> getTecnicaDidacticaList() {
        return tecnicaDidacticaList;
    }

    public void setTecnicaDidacticaList(List<TecnicaDidactica> tecnicaDidacticaList) {
        this.tecnicaDidacticaList = tecnicaDidacticaList;
    }

    @XmlTransient
    public List<Evidencia> getEvidenciaList() {
        return evidenciaList;
    }

    public void setEvidenciaList(List<Evidencia> evidenciaList) {
        this.evidenciaList = evidenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEvaluacion != null ? idTipoEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvaluacion)) {
            return false;
        }
        TipoEvaluacion other = (TipoEvaluacion) object;
        if ((this.idTipoEvaluacion == null && other.idTipoEvaluacion != null) || (this.idTipoEvaluacion != null && !this.idTipoEvaluacion.equals(other.idTipoEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoEvaluacion[ idTipoEvaluacion=" + idTipoEvaluacion + " ]";
    }
    
}
