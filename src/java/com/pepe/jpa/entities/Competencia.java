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
import javax.persistence.Lob;
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
@Table(name = "competencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competencia.findAll", query = "SELECT c FROM Competencia c"),
    @NamedQuery(name = "Competencia.findByIdCompetencia", query = "SELECT c FROM Competencia c WHERE c.idCompetencia = :idCompetencia"),
    @NamedQuery(name = "Competencia.findByEstado", query = "SELECT c FROM Competencia c WHERE c.estado = :estado"),
    @NamedQuery(name = "Competencia.findByCodigo", query = "SELECT c FROM Competencia c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Competencia.findByDuracionEstimadaHoras", query = "SELECT c FROM Competencia c WHERE c.duracionEstimadaHoras = :duracionEstimadaHoras")})
public class Competencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_competencia")
    private Integer idCompetencia;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre_competencia")
    private String nombreCompetencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion_estimada_horas")
    private int duracionEstimadaHoras;
    @JoinTable(name = "programa_has_competencia", joinColumns = {
        @JoinColumn(name = "id_competencia", referencedColumnName = "id_competencia")}, inverseJoinColumns = {
        @JoinColumn(name = "programa_codigo", referencedColumnName = "codigo"),
        @JoinColumn(name = "programa_version", referencedColumnName = "version")})
    @ManyToMany
    private List<Programa> programaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompetencia")
    private List<ConocimientoConceptoPrincipios> conocimientoConceptoPrincipiosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompetencia")
    private List<CriteriosEvaluacion> criteriosEvaluacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompetencia")
    private List<ConocimientoProceso> conocimientoProcesoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCompetencia")
    private List<ResultadoAprendizaje> resultadoAprendizajeList;

    public Competencia() {
    }

    public Competencia(Integer idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public Competencia(Integer idCompetencia, String nombreCompetencia, boolean estado, String codigo, int duracionEstimadaHoras) {
        this.idCompetencia = idCompetencia;
        this.nombreCompetencia = nombreCompetencia;
        this.estado = estado;
        this.codigo = codigo;
        this.duracionEstimadaHoras = duracionEstimadaHoras;
    }

    public Integer getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Integer idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public String getNombreCompetencia() {
        return nombreCompetencia;
    }

    public void setNombreCompetencia(String nombreCompetencia) {
        this.nombreCompetencia = nombreCompetencia;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getDuracionEstimadaHoras() {
        return duracionEstimadaHoras;
    }

    public void setDuracionEstimadaHoras(int duracionEstimadaHoras) {
        this.duracionEstimadaHoras = duracionEstimadaHoras;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    @XmlTransient
    public List<ConocimientoConceptoPrincipios> getConocimientoConceptoPrincipiosList() {
        return conocimientoConceptoPrincipiosList;
    }

    public void setConocimientoConceptoPrincipiosList(List<ConocimientoConceptoPrincipios> conocimientoConceptoPrincipiosList) {
        this.conocimientoConceptoPrincipiosList = conocimientoConceptoPrincipiosList;
    }

    @XmlTransient
    public List<CriteriosEvaluacion> getCriteriosEvaluacionList() {
        return criteriosEvaluacionList;
    }

    public void setCriteriosEvaluacionList(List<CriteriosEvaluacion> criteriosEvaluacionList) {
        this.criteriosEvaluacionList = criteriosEvaluacionList;
    }

    @XmlTransient
    public List<ConocimientoProceso> getConocimientoProcesoList() {
        return conocimientoProcesoList;
    }

    public void setConocimientoProcesoList(List<ConocimientoProceso> conocimientoProcesoList) {
        this.conocimientoProcesoList = conocimientoProcesoList;
    }

    @XmlTransient
    public List<ResultadoAprendizaje> getResultadoAprendizajeList() {
        return resultadoAprendizajeList;
    }

    public void setResultadoAprendizajeList(List<ResultadoAprendizaje> resultadoAprendizajeList) {
        this.resultadoAprendizajeList = resultadoAprendizajeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompetencia != null ? idCompetencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competencia)) {
            return false;
        }
        Competencia other = (Competencia) object;
        if ((this.idCompetencia == null && other.idCompetencia != null) || (this.idCompetencia != null && !this.idCompetencia.equals(other.idCompetencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreCompetencia().toUpperCase();
    }
    
}
