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
@Table(name = "aspectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aspectos.findAll", query = "SELECT a FROM Aspectos a"),
    @NamedQuery(name = "Aspectos.findByIdAspectos", query = "SELECT a FROM Aspectos a WHERE a.idAspectos = :idAspectos"),
    @NamedQuery(name = "Aspectos.findByCumple", query = "SELECT a FROM Aspectos a WHERE a.cumple = :cumple")})
public class Aspectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aspectos")
    private Integer idAspectos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cumple")
    private boolean cumple;
    @JoinTable(name = "usuario_has_aspectos", joinColumns = {
        @JoinColumn(name = "id_aspectos", referencedColumnName = "id_aspectos")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAspectos")
    private List<Fase> faseList;

    public Aspectos() {
    }

    public Aspectos(Integer idAspectos) {
        this.idAspectos = idAspectos;
    }

    public Aspectos(Integer idAspectos, String descripcion, boolean cumple) {
        this.idAspectos = idAspectos;
        this.descripcion = descripcion;
        this.cumple = cumple;
    }

    public Integer getIdAspectos() {
        return idAspectos;
    }

    public void setIdAspectos(Integer idAspectos) {
        this.idAspectos = idAspectos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getCumple() {
        return cumple;
    }

    public void setCumple(boolean cumple) {
        this.cumple = cumple;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Fase> getFaseList() {
        return faseList;
    }

    public void setFaseList(List<Fase> faseList) {
        this.faseList = faseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAspectos != null ? idAspectos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aspectos)) {
            return false;
        }
        Aspectos other = (Aspectos) object;
        if ((this.idAspectos == null && other.idAspectos != null) || (this.idAspectos != null && !this.idAspectos.equals(other.idAspectos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Aspectos[ idAspectos=" + idAspectos + " ]";
    }
    
}
