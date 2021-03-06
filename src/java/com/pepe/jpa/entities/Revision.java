/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Junior Cabal
 */
@Entity
@Table(name = "revision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revision.findAll", query = "SELECT r FROM Revision r"),
    @NamedQuery(name = "Revision.findByIdRevision", query = "SELECT r FROM Revision r WHERE r.idRevision = :idRevision"),
    @NamedQuery(name = "Revision.findByFechaRevision", query = "SELECT r FROM Revision r WHERE r.fechaRevision = :fechaRevision"),
    @NamedQuery(name = "Revision.findByAmbienteApto", query = "SELECT r FROM Revision r WHERE r.ambienteApto = :ambienteApto")})
public class Revision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_revision")
    private Integer idRevision;
    @Lob
    @Size(max = 65535)
    @Column(name = "concepto")
    private String concepto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_revision")
    @Temporal(TemporalType.DATE)
    private Date fechaRevision;
    @Column(name = "ambiente_apto")
    private Boolean ambienteApto;
    @JoinTable(name = "revision_has_usuario", joinColumns = {
        @JoinColumn(name = "id_revision", referencedColumnName = "id_revision")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;
    @JoinColumn(name = "id_ambiente_formacion", referencedColumnName = "id_ambiente_formacion")
    @ManyToOne
    private AmbienteFormacion idAmbienteFormacion;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")})
    @ManyToOne
    private Ciudad ciudad;
    @JoinColumn(name = "id_tipo_revision", referencedColumnName = "id_tipo_revision")
    @ManyToOne(optional = false)
    private TipoRevision idTipoRevision;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRevision")
    private List<Valoracion> valoracionList;

    public Revision() {
    }

    public Revision(Integer idRevision) {
        this.idRevision = idRevision;
    }

    public Revision(Integer idRevision, Date fechaRevision) {
        this.idRevision = idRevision;
        this.fechaRevision = fechaRevision;
    }

    public Integer getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(Integer idRevision) {
        this.idRevision = idRevision;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public Boolean getAmbienteApto() {
        return ambienteApto;
    }

    public void setAmbienteApto(Boolean ambienteApto) {
        this.ambienteApto = ambienteApto;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public AmbienteFormacion getIdAmbienteFormacion() {
        return idAmbienteFormacion;
    }

    public void setIdAmbienteFormacion(AmbienteFormacion idAmbienteFormacion) {
        this.idAmbienteFormacion = idAmbienteFormacion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public TipoRevision getIdTipoRevision() {
        return idTipoRevision;
    }

    public void setIdTipoRevision(TipoRevision idTipoRevision) {
        this.idTipoRevision = idTipoRevision;
    }

    @XmlTransient
    public List<Valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setValoracionList(List<Valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRevision != null ? idRevision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revision)) {
            return false;
        }
        Revision other = (Revision) object;
        if ((this.idRevision == null && other.idRevision != null) || (this.idRevision != null && !this.idRevision.equals(other.idRevision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Revision[ idRevision=" + idRevision + " ]";
    }
    
}
