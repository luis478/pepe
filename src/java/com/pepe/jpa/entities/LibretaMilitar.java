/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 * @author ADSI TARDE
 */
@Entity
@Table(name = "libreta_militar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibretaMilitar.findAll", query = "SELECT l FROM LibretaMilitar l"),
    @NamedQuery(name = "LibretaMilitar.findByIdLibretaMilitar", query = "SELECT l FROM LibretaMilitar l WHERE l.idLibretaMilitar = :idLibretaMilitar"),
    @NamedQuery(name = "LibretaMilitar.findByNombreLibretaMilitar", query = "SELECT l FROM LibretaMilitar l WHERE l.nombreLibretaMilitar = :nombreLibretaMilitar")})
public class LibretaMilitar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_libreta_militar")
    private Integer idLibretaMilitar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_libreta_militar")
    private String nombreLibretaMilitar;
    @OneToMany(mappedBy = "idLibretaMilitar")
    private List<Usuario> usuarioList;

    public LibretaMilitar() {
    }

    public LibretaMilitar(Integer idLibretaMilitar) {
        this.idLibretaMilitar = idLibretaMilitar;
    }

    public LibretaMilitar(Integer idLibretaMilitar, String nombreLibretaMilitar) {
        this.idLibretaMilitar = idLibretaMilitar;
        this.nombreLibretaMilitar = nombreLibretaMilitar;
    }

    public Integer getIdLibretaMilitar() {
        return idLibretaMilitar;
    }

    public void setIdLibretaMilitar(Integer idLibretaMilitar) {
        this.idLibretaMilitar = idLibretaMilitar;
    }

    public String getNombreLibretaMilitar() {
        return nombreLibretaMilitar;
    }

    public void setNombreLibretaMilitar(String nombreLibretaMilitar) {
        this.nombreLibretaMilitar = nombreLibretaMilitar;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibretaMilitar != null ? idLibretaMilitar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibretaMilitar)) {
            return false;
        }
        LibretaMilitar other = (LibretaMilitar) object;
        if ((this.idLibretaMilitar == null && other.idLibretaMilitar != null) || (this.idLibretaMilitar != null && !this.idLibretaMilitar.equals(other.idLibretaMilitar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNombreLibretaMilitar().toUpperCase();
    }
    
}