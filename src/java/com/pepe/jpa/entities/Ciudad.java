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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
 * @author Luis Carlos
 */
@Entity
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.idCiudad = :idCiudad"),
    @NamedQuery(name = "Ciudad.findByNombreCiudad", query = "SELECT c FROM Ciudad c WHERE c.nombreCiudad = :nombreCiudad"),
    @NamedQuery(name = "Ciudad.findByIdDepartamento", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.idDepartamento = :idDepartamento")})
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CiudadPK ciudadPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_ciudad")
    private String nombreCiudad;
    @JoinTable(name = "usuario_has_ciudad", joinColumns = {
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<VisitaTecnica> visitaTecnicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<CentroFormacion> centroFormacionList;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departamento departamento;

    public Ciudad() {
    }

    public Ciudad(CiudadPK ciudadPK) {
        this.ciudadPK = ciudadPK;
    }

    public Ciudad(CiudadPK ciudadPK, String nombreCiudad) {
        this.ciudadPK = ciudadPK;
        this.nombreCiudad = nombreCiudad;
    }

    public Ciudad(int idCiudad, int idDepartamento) {
        this.ciudadPK = new CiudadPK(idCiudad, idDepartamento);
    }

    public CiudadPK getCiudadPK() {
        return ciudadPK;
    }

    public void setCiudadPK(CiudadPK ciudadPK) {
        this.ciudadPK = ciudadPK;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<VisitaTecnica> getVisitaTecnicaList() {
        return visitaTecnicaList;
    }

    public void setVisitaTecnicaList(List<VisitaTecnica> visitaTecnicaList) {
        this.visitaTecnicaList = visitaTecnicaList;
    }

    @XmlTransient
    public List<CentroFormacion> getCentroFormacionList() {
        return centroFormacionList;
    }

    public void setCentroFormacionList(List<CentroFormacion> centroFormacionList) {
        this.centroFormacionList = centroFormacionList;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudadPK != null ? ciudadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.ciudadPK == null && other.ciudadPK != null) || (this.ciudadPK != null && !this.ciudadPK.equals(other.ciudadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Ciudad[ ciudadPK=" + ciudadPK + " ]";
    }
    
}
