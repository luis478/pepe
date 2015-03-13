/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "evidencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evidencia.findAll", query = "SELECT e FROM Evidencia e"),
    @NamedQuery(name = "Evidencia.findByIdEvidencia", query = "SELECT e FROM Evidencia e WHERE e.idEvidencia = :idEvidencia")})
public class Evidencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evidencia")
    private Integer idEvidencia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_evidencia")
    private String nombreEvidencia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion_evidencia")
    private String descripcionEvidencia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observacion_evidencia")
    private String observacionEvidencia;
    @JoinTable(name = "evidencia_has_tecnica_didactica", joinColumns = {
        @JoinColumn(name = "id_evidencia", referencedColumnName = "id_evidencia")}, inverseJoinColumns = {
        @JoinColumn(name = "id_tecnica_didactica", referencedColumnName = "id_tecnica_didactica")})
    @ManyToMany
    private List<TecnicaDidactica> tecnicaDidacticaList;
    @JoinColumn(name = "id_actividad_aprendizaje", referencedColumnName = "id_actividad_aprendizaje")
    @ManyToOne(optional = false)
    private ActividadAprendizaje idActividadAprendizaje;
    @JoinColumn(name = "id_tipo_entrega", referencedColumnName = "id_tipo_entrega")
    @ManyToOne(optional = false)
    private TipoEntrega idTipoEntrega;
    @JoinColumn(name = "id_tecnica_evaluacion", referencedColumnName = "id_tecnica_evaluacion")
    @ManyToOne(optional = false)
    private TecnicaEvaluacion idTecnicaEvaluacion;
    @JoinColumn(name = "id_tipo_evidencia", referencedColumnName = "id_tipo_evidencia")
    @ManyToOne(optional = false)
    private TipoEvidencia idTipoEvidencia;

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

    @XmlTransient
    public List<TecnicaDidactica> getTecnicaDidacticaList() {
        return tecnicaDidacticaList;
    }

    public void setTecnicaDidacticaList(List<TecnicaDidactica> tecnicaDidacticaList) {
        this.tecnicaDidacticaList = tecnicaDidacticaList;
    }

    public ActividadAprendizaje getIdActividadAprendizaje() {
        return idActividadAprendizaje;
    }

    public void setIdActividadAprendizaje(ActividadAprendizaje idActividadAprendizaje) {
        this.idActividadAprendizaje = idActividadAprendizaje;
    }

    public TipoEntrega getIdTipoEntrega() {
        return idTipoEntrega;
    }

    public void setIdTipoEntrega(TipoEntrega idTipoEntrega) {
        this.idTipoEntrega = idTipoEntrega;
    }

    public TecnicaEvaluacion getIdTecnicaEvaluacion() {
        return idTecnicaEvaluacion;
    }

    public void setIdTecnicaEvaluacion(TecnicaEvaluacion idTecnicaEvaluacion) {
        this.idTecnicaEvaluacion = idTecnicaEvaluacion;
    }

    public TipoEvidencia getIdTipoEvidencia() {
        return idTipoEvidencia;
    }

    public void setIdTipoEvidencia(TipoEvidencia idTipoEvidencia) {
        this.idTipoEvidencia = idTipoEvidencia;
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
