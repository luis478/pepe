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
@Table(name = "perfil_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilEntrada.findAll", query = "SELECT p FROM PerfilEntrada p"),
    @NamedQuery(name = "PerfilEntrada.findByIdPerfilEntrada", query = "SELECT p FROM PerfilEntrada p WHERE p.idPerfilEntrada = :idPerfilEntrada"),
    @NamedQuery(name = "PerfilEntrada.findByNombrePerfilEntrada", query = "SELECT p FROM PerfilEntrada p WHERE p.nombrePerfilEntrada = :nombrePerfilEntrada")})
public class PerfilEntrada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfil_entrada")
    private Integer idPerfilEntrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_perfil_entrada")
    private String nombrePerfilEntrada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfilEntrada")
    private List<Programa> programaList;

    public PerfilEntrada() {
    }

    public PerfilEntrada(Integer idPerfilEntrada) {
        this.idPerfilEntrada = idPerfilEntrada;
    }

    public PerfilEntrada(Integer idPerfilEntrada, String nombrePerfilEntrada) {
        this.idPerfilEntrada = idPerfilEntrada;
        this.nombrePerfilEntrada = nombrePerfilEntrada;
    }

    public Integer getIdPerfilEntrada() {
        return idPerfilEntrada;
    }

    public void setIdPerfilEntrada(Integer idPerfilEntrada) {
        this.idPerfilEntrada = idPerfilEntrada;
    }

    public String getNombrePerfilEntrada() {
        return nombrePerfilEntrada;
    }

    public void setNombrePerfilEntrada(String nombrePerfilEntrada) {
        this.nombrePerfilEntrada = nombrePerfilEntrada;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfilEntrada != null ? idPerfilEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilEntrada)) {
            return false;
        }
        PerfilEntrada other = (PerfilEntrada) object;
        if ((this.idPerfilEntrada == null && other.idPerfilEntrada != null) || (this.idPerfilEntrada != null && !this.idPerfilEntrada.equals(other.idPerfilEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.PerfilEntrada[ idPerfilEntrada=" + idPerfilEntrada + " ]";
    }
    
}
