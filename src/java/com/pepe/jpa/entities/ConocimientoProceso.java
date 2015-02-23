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
 * @author ADSI TARDE
 */
@Entity
@Table(name = "conocimiento_proceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConocimientoProceso.findAll", query = "SELECT c FROM ConocimientoProceso c"),
    @NamedQuery(name = "ConocimientoProceso.findByIdConocimientoProceso", query = "SELECT c FROM ConocimientoProceso c WHERE c.idConocimientoProceso = :idConocimientoProceso"),
    @NamedQuery(name = "ConocimientoProceso.findByEstado", query = "SELECT c FROM ConocimientoProceso c WHERE c.estado = :estado")})
public class ConocimientoProceso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_conocimiento_proceso")
    private Integer idConocimientoProceso;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_conocimiento_proceso")
    private String nombreConocimientoProceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private short estado;
    @JoinColumn(name = "id_competencia", referencedColumnName = "id_competencia")
    @ManyToOne(optional = false)
    private Competencia idCompetencia;

    public ConocimientoProceso() {
    }

    public ConocimientoProceso(Integer idConocimientoProceso) {
        this.idConocimientoProceso = idConocimientoProceso;
    }

    public ConocimientoProceso(Integer idConocimientoProceso, String nombreConocimientoProceso, short estado) {
        this.idConocimientoProceso = idConocimientoProceso;
        this.nombreConocimientoProceso = nombreConocimientoProceso;
        this.estado = estado;
    }

    public Integer getIdConocimientoProceso() {
        return idConocimientoProceso;
    }

    public void setIdConocimientoProceso(Integer idConocimientoProceso) {
        this.idConocimientoProceso = idConocimientoProceso;
    }

    public String getNombreConocimientoProceso() {
        return nombreConocimientoProceso;
    }

    public void setNombreConocimientoProceso(String nombreConocimientoProceso) {
        this.nombreConocimientoProceso = nombreConocimientoProceso;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public Competencia getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Competencia idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConocimientoProceso != null ? idConocimientoProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConocimientoProceso)) {
            return false;
        }
        ConocimientoProceso other = (ConocimientoProceso) object;
        if ((this.idConocimientoProceso == null && other.idConocimientoProceso != null) || (this.idConocimientoProceso != null && !this.idConocimientoProceso.equals(other.idConocimientoProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.ConocimientoProceso[ idConocimientoProceso=" + idConocimientoProceso + " ]";
    }
    
}
