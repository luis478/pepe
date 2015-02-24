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
@Table(name = "conocimiento_concepto_principios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConocimientoConceptoPrincipios.findAll", query = "SELECT c FROM ConocimientoConceptoPrincipios c"),
    @NamedQuery(name = "ConocimientoConceptoPrincipios.findByIdConocimientoConceptoPrincipios", query = "SELECT c FROM ConocimientoConceptoPrincipios c WHERE c.idConocimientoConceptoPrincipios = :idConocimientoConceptoPrincipios"),
    @NamedQuery(name = "ConocimientoConceptoPrincipios.consultarCCP", query = "SELECT c FROM ConocimientoConceptoPrincipios c WHERE c.idCompetencia.idCompetencia = :idCompetencia AND c.estado = 1"),
    @NamedQuery(name = "ConocimientoConceptoPrincipios.findByEstado", query = "SELECT c FROM ConocimientoConceptoPrincipios c WHERE c.estado = :estado")})
public class ConocimientoConceptoPrincipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_conocimiento_concepto_principios")
    private Integer idConocimientoConceptoPrincipios;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_conocimiento_concepto_principiosl")
    private String nombreConocimientoConceptoPrincipiosl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private short estado;
    @JoinColumn(name = "id_competencia", referencedColumnName = "id_competencia")
    @ManyToOne(optional = false)
    private Competencia idCompetencia;

    public ConocimientoConceptoPrincipios() {
    }

    public ConocimientoConceptoPrincipios(Integer idConocimientoConceptoPrincipios) {
        this.idConocimientoConceptoPrincipios = idConocimientoConceptoPrincipios;
    }

    public ConocimientoConceptoPrincipios(Integer idConocimientoConceptoPrincipios, String nombreConocimientoConceptoPrincipiosl, short estado) {
        this.idConocimientoConceptoPrincipios = idConocimientoConceptoPrincipios;
        this.nombreConocimientoConceptoPrincipiosl = nombreConocimientoConceptoPrincipiosl;
        this.estado = estado;
    }

    public Integer getIdConocimientoConceptoPrincipios() {
        return idConocimientoConceptoPrincipios;
    }

    public void setIdConocimientoConceptoPrincipios(Integer idConocimientoConceptoPrincipios) {
        this.idConocimientoConceptoPrincipios = idConocimientoConceptoPrincipios;
    }

    public String getNombreConocimientoConceptoPrincipiosl() {
        return nombreConocimientoConceptoPrincipiosl;
    }

    public void setNombreConocimientoConceptoPrincipiosl(String nombreConocimientoConceptoPrincipiosl) {
        this.nombreConocimientoConceptoPrincipiosl = nombreConocimientoConceptoPrincipiosl;
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
        hash += (idConocimientoConceptoPrincipios != null ? idConocimientoConceptoPrincipios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConocimientoConceptoPrincipios)) {
            return false;
        }
        ConocimientoConceptoPrincipios other = (ConocimientoConceptoPrincipios) object;
        if ((this.idConocimientoConceptoPrincipios == null && other.idConocimientoConceptoPrincipios != null) || (this.idConocimientoConceptoPrincipios != null && !this.idConocimientoConceptoPrincipios.equals(other.idConocimientoConceptoPrincipios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.ConocimientoConceptoPrincipios[ idConocimientoConceptoPrincipios=" + idConocimientoConceptoPrincipios + " ]";
    }
    
}
