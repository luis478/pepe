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
import javax.persistence.Lob;
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
 * @author Luis Carlos
 */
@Entity
@Table(name = "tipo_actividad_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoActividadAprendizaje.findAll", query = "SELECT t FROM TipoActividadAprendizaje t"),
    @NamedQuery(name = "TipoActividadAprendizaje.findByIdTipoActividadAprendizaje", query = "SELECT t FROM TipoActividadAprendizaje t WHERE t.idTipoActividadAprendizaje = :idTipoActividadAprendizaje")})
public class TipoActividadAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_actividad_aprendizaje")
    private Integer idTipoActividadAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_tipo_actividad_aprendizaje")
    private String nombreTipoActividadAprendizaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoActividadAprendizaje")
    private List<ActividadAprendizaje> actividadAprendizajeList;

    public TipoActividadAprendizaje() {
    }

    public TipoActividadAprendizaje(Integer idTipoActividadAprendizaje) {
        this.idTipoActividadAprendizaje = idTipoActividadAprendizaje;
    }

    public TipoActividadAprendizaje(Integer idTipoActividadAprendizaje, String nombreTipoActividadAprendizaje) {
        this.idTipoActividadAprendizaje = idTipoActividadAprendizaje;
        this.nombreTipoActividadAprendizaje = nombreTipoActividadAprendizaje;
    }

    public Integer getIdTipoActividadAprendizaje() {
        return idTipoActividadAprendizaje;
    }

    public void setIdTipoActividadAprendizaje(Integer idTipoActividadAprendizaje) {
        this.idTipoActividadAprendizaje = idTipoActividadAprendizaje;
    }

    public String getNombreTipoActividadAprendizaje() {
        return nombreTipoActividadAprendizaje;
    }

    public void setNombreTipoActividadAprendizaje(String nombreTipoActividadAprendizaje) {
        this.nombreTipoActividadAprendizaje = nombreTipoActividadAprendizaje;
    }

    @XmlTransient
    public List<ActividadAprendizaje> getActividadAprendizajeList() {
        return actividadAprendizajeList;
    }

    public void setActividadAprendizajeList(List<ActividadAprendizaje> actividadAprendizajeList) {
        this.actividadAprendizajeList = actividadAprendizajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoActividadAprendizaje != null ? idTipoActividadAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoActividadAprendizaje)) {
            return false;
        }
        TipoActividadAprendizaje other = (TipoActividadAprendizaje) object;
        if ((this.idTipoActividadAprendizaje == null && other.idTipoActividadAprendizaje != null) || (this.idTipoActividadAprendizaje != null && !this.idTipoActividadAprendizaje.equals(other.idTipoActividadAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.TipoActividadAprendizaje[ idTipoActividadAprendizaje=" + idTipoActividadAprendizaje + " ]";
    }
    
}
