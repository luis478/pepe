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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
 * @author ADSI TARDE
 */
@Entity
@Table(name = "centro_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroFormacion.findAll", query = "SELECT c FROM CentroFormacion c"),
    @NamedQuery(name = "CentroFormacion.findByIdCentroFormacion", query = "SELECT c FROM CentroFormacion c WHERE c.idCentroFormacion = :idCentroFormacion"),
    @NamedQuery(name = "CentroFormacion.findByCodigoCentroFormacion", query = "SELECT c FROM CentroFormacion c WHERE c.codigoCentroFormacion = :codigoCentroFormacion")})
public class CentroFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_centro_formacion")
    private Integer idCentroFormacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_centro_formacion")
    private String nombreCentroFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo_centro_formacion")
    private String codigoCentroFormacion;
    @JoinTable(name = "usuario_has_centro_formacion", joinColumns = {
        @JoinColumn(name = "id_centro_formacion", referencedColumnName = "id_centro_formacion")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCentroFormacion")
    private List<Ficha> fichaList;
    @JoinColumn(name = "id_regional", referencedColumnName = "id_regional")
    @ManyToOne(optional = false)
    private Regional idRegional;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")})
    @ManyToOne(optional = false)
    private Ciudad ciudad;

    public CentroFormacion() {
    }

    public CentroFormacion(Integer idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    public CentroFormacion(Integer idCentroFormacion, String nombreCentroFormacion, String codigoCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
        this.nombreCentroFormacion = nombreCentroFormacion;
        this.codigoCentroFormacion = codigoCentroFormacion;
    }

    public Integer getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(Integer idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    public String getNombreCentroFormacion() {
        return nombreCentroFormacion;
    }

    public void setNombreCentroFormacion(String nombreCentroFormacion) {
        this.nombreCentroFormacion = nombreCentroFormacion;
    }

    public String getCodigoCentroFormacion() {
        return codigoCentroFormacion;
    }

    public void setCodigoCentroFormacion(String codigoCentroFormacion) {
        this.codigoCentroFormacion = codigoCentroFormacion;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Ficha> getFichaList() {
        return fichaList;
    }

    public void setFichaList(List<Ficha> fichaList) {
        this.fichaList = fichaList;
    }

    public Regional getIdRegional() {
        return idRegional;
    }

    public void setIdRegional(Regional idRegional) {
        this.idRegional = idRegional;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentroFormacion != null ? idCentroFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroFormacion)) {
            return false;
        }
        CentroFormacion other = (CentroFormacion) object;
        if ((this.idCentroFormacion == null && other.idCentroFormacion != null) || (this.idCentroFormacion != null && !this.idCentroFormacion.equals(other.idCentroFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.CentroFormacion[ idCentroFormacion=" + idCentroFormacion + " ]";
    }
    
}
