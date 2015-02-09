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
 * @author Windows 8
 */
@Entity
@Table(name = "evidencia_encontrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvidenciaEncontrada.findAll", query = "SELECT e FROM EvidenciaEncontrada e"),
    @NamedQuery(name = "EvidenciaEncontrada.findByIdEvidenciaEncontrada", query = "SELECT e FROM EvidenciaEncontrada e WHERE e.idEvidenciaEncontrada = :idEvidenciaEncontrada")})
public class EvidenciaEncontrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evidencia_encontrada")
    private Integer idEvidenciaEncontrada;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvidenciaEncontrada")
    private List<CriterioSeguimientoHasAcompañamiento> criterioSeguimientoHasAcompañamientoList;

    public EvidenciaEncontrada() {
    }

    public EvidenciaEncontrada(Integer idEvidenciaEncontrada) {
        this.idEvidenciaEncontrada = idEvidenciaEncontrada;
    }

    public EvidenciaEncontrada(Integer idEvidenciaEncontrada, String descripcion) {
        this.idEvidenciaEncontrada = idEvidenciaEncontrada;
        this.descripcion = descripcion;
    }

    public Integer getIdEvidenciaEncontrada() {
        return idEvidenciaEncontrada;
    }

    public void setIdEvidenciaEncontrada(Integer idEvidenciaEncontrada) {
        this.idEvidenciaEncontrada = idEvidenciaEncontrada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<CriterioSeguimientoHasAcompañamiento> getCriterioSeguimientoHasAcompañamientoList() {
        return criterioSeguimientoHasAcompañamientoList;
    }

    public void setCriterioSeguimientoHasAcompañamientoList(List<CriterioSeguimientoHasAcompañamiento> criterioSeguimientoHasAcompañamientoList) {
        this.criterioSeguimientoHasAcompañamientoList = criterioSeguimientoHasAcompañamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvidenciaEncontrada != null ? idEvidenciaEncontrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvidenciaEncontrada)) {
            return false;
        }
        EvidenciaEncontrada other = (EvidenciaEncontrada) object;
        if ((this.idEvidenciaEncontrada == null && other.idEvidenciaEncontrada != null) || (this.idEvidenciaEncontrada != null && !this.idEvidenciaEncontrada.equals(other.idEvidenciaEncontrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.EvidenciaEncontrada[ idEvidenciaEncontrada=" + idEvidenciaEncontrada + " ]";
    }
    
}
