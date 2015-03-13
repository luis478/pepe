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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "tecnica_didactica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TecnicaDidactica.findAll", query = "SELECT t FROM TecnicaDidactica t"),
    @NamedQuery(name = "TecnicaDidactica.findByIdTecnicaDidactica", query = "SELECT t FROM TecnicaDidactica t WHERE t.idTecnicaDidactica = :idTecnicaDidactica"),
    @NamedQuery(name = "TecnicaDidactica.findByNombreTecnicaDidactica", query = "SELECT t FROM TecnicaDidactica t WHERE t.nombreTecnicaDidactica = :nombreTecnicaDidactica")})
public class TecnicaDidactica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tecnica_didactica")
    private Integer idTecnicaDidactica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tecnica_didactica")
    private String nombreTecnicaDidactica;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion_tecnica_didactica")
    private String descripcionTecnicaDidactica;
    @ManyToMany(mappedBy = "tecnicaDidacticaList")
    private List<ActividadAprendizaje> actividadAprendizajeList;
    @ManyToMany(mappedBy = "tecnicaDidacticaList")
    private List<Evidencia> evidenciaList;

    public TecnicaDidactica() {
    }

    public TecnicaDidactica(Integer idTecnicaDidactica) {
        this.idTecnicaDidactica = idTecnicaDidactica;
    }

    public TecnicaDidactica(Integer idTecnicaDidactica, String nombreTecnicaDidactica, String descripcionTecnicaDidactica) {
        this.idTecnicaDidactica = idTecnicaDidactica;
        this.nombreTecnicaDidactica = nombreTecnicaDidactica;
        this.descripcionTecnicaDidactica = descripcionTecnicaDidactica;
    }

    public Integer getIdTecnicaDidactica() {
        return idTecnicaDidactica;
    }

    public void setIdTecnicaDidactica(Integer idTecnicaDidactica) {
        this.idTecnicaDidactica = idTecnicaDidactica;
    }

    public String getNombreTecnicaDidactica() {
        return nombreTecnicaDidactica;
    }

    public void setNombreTecnicaDidactica(String nombreTecnicaDidactica) {
        this.nombreTecnicaDidactica = nombreTecnicaDidactica;
    }

    public String getDescripcionTecnicaDidactica() {
        return descripcionTecnicaDidactica;
    }

    public void setDescripcionTecnicaDidactica(String descripcionTecnicaDidactica) {
        this.descripcionTecnicaDidactica = descripcionTecnicaDidactica;
    }

    @XmlTransient
    public List<ActividadAprendizaje> getActividadAprendizajeList() {
        return actividadAprendizajeList;
    }

    public void setActividadAprendizajeList(List<ActividadAprendizaje> actividadAprendizajeList) {
        this.actividadAprendizajeList = actividadAprendizajeList;
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
        hash += (idTecnicaDidactica != null ? idTecnicaDidactica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnicaDidactica)) {
            return false;
        }
        TecnicaDidactica other = (TecnicaDidactica) object;
        if ((this.idTecnicaDidactica == null && other.idTecnicaDidactica != null) || (this.idTecnicaDidactica != null && !this.idTecnicaDidactica.equals(other.idTecnicaDidactica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TecnicaDidactica[ idTecnicaDidactica=" + idTecnicaDidactica + " ]";
    }
    
}
