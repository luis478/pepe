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
@Table(name = "evidencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evidencia.findAll", query = "SELECT e FROM Evidencia e"),
    @NamedQuery(name = "Evidencia.findByIdEvidencia", query = "SELECT e FROM Evidencia e WHERE e.idEvidencia = :idEvidencia"),
    @NamedQuery(name = "Evidencia.findByNombreEvidencia", query = "SELECT e FROM Evidencia e WHERE e.nombreEvidencia = :nombreEvidencia"),
    @NamedQuery(name = "Evidencia.findByDescripcionEvidencia", query = "SELECT e FROM Evidencia e WHERE e.descripcionEvidencia = :descripcionEvidencia"),
    @NamedQuery(name = "Evidencia.findByObservacionEvidencia", query = "SELECT e FROM Evidencia e WHERE e.observacionEvidencia = :observacionEvidencia")})
public class Evidencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evidencia")
    private Integer idEvidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_evidencia")
    private String nombreEvidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion_evidencia")
    private String descripcionEvidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "observacion_evidencia")
    private String observacionEvidencia;
    @JoinColumn(name = "id_tipo_evidencia", referencedColumnName = "id_tipo_evidencia")
    @ManyToOne(optional = false)
    private TipoEvidencia idTipoEvidencia;
    @JoinColumn(name = "id_actividad_aprendizaje", referencedColumnName = "id_actividad_aprendizaje")
    @ManyToOne(optional = false)
    private ActividadAprendizaje idActividadAprendizaje;

    public Evidencia() {
    }

    public Evidencia(Integer idEvidencia) {
        this.idEvidencia = idEvidencia;
    }

    public Evidencia(Integer idEvidencia, String nombreEvidencia, String descripcionEvidencia, String observacionEvidencia) {
        this.idEvidencia = idEvidencia;
        this.nombreEvidencia = nombreEvidencia;
        this.descripcionEvidencia = descripcionEvidencia;
        this.observacionEvidencia = observacionEvidencia;
    }

    public Integer getIdEvidencia() {
        return idEvidencia;
    }

    public void setIdEvidencia(Integer idEvidencia) {
        this.idEvidencia = idEvidencia;
    }

    public String getNombreEvidencia() {
        return nombreEvidencia;
    }

    public void setNombreEvidencia(String nombreEvidencia) {
        this.nombreEvidencia = nombreEvidencia;
    }

    public String getDescripcionEvidencia() {
        return descripcionEvidencia;
    }

    public void setDescripcionEvidencia(String descripcionEvidencia) {
        this.descripcionEvidencia = descripcionEvidencia;
    }

    public String getObservacionEvidencia() {
        return observacionEvidencia;
    }

    public void setObservacionEvidencia(String observacionEvidencia) {
        this.observacionEvidencia = observacionEvidencia;
    }

    public TipoEvidencia getIdTipoEvidencia() {
        return idTipoEvidencia;
    }

    public void setIdTipoEvidencia(TipoEvidencia idTipoEvidencia) {
        this.idTipoEvidencia = idTipoEvidencia;
    }

    public ActividadAprendizaje getIdActividadAprendizaje() {
        return idActividadAprendizaje;
    }

    public void setIdActividadAprendizaje(ActividadAprendizaje idActividadAprendizaje) {
        this.idActividadAprendizaje = idActividadAprendizaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvidencia != null ? idEvidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evidencia)) {
            return false;
        }
        Evidencia other = (Evidencia) object;
        if ((this.idEvidencia == null && other.idEvidencia != null) || (this.idEvidencia != null && !this.idEvidencia.equals(other.idEvidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Evidencia[ idEvidencia=" + idEvidencia + " ]";
    }
    
}
