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
import javax.persistence.JoinColumn;
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
 * @author Windows 8
 */
@Entity
@Table(name = "patrocinio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patrocinio.findAll", query = "SELECT p FROM Patrocinio p"),
    @NamedQuery(name = "Patrocinio.findByIdPatrocinio", query = "SELECT p FROM Patrocinio p WHERE p.idPatrocinio = :idPatrocinio"),
    @NamedQuery(name = "Patrocinio.findByPatrocinio", query = "SELECT p FROM Patrocinio p WHERE p.patrocinio = :patrocinio")})
public class Patrocinio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_patrocinio")
    private Integer idPatrocinio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "patrocinio")
    private String patrocinio;
    @OneToMany(mappedBy = "idPatrocinio")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    public Patrocinio() {
    }

    public Patrocinio(Integer idPatrocinio) {
        this.idPatrocinio = idPatrocinio;
    }

    public Patrocinio(Integer idPatrocinio, String patrocinio) {
        this.idPatrocinio = idPatrocinio;
        this.patrocinio = patrocinio;
    }

    public Integer getIdPatrocinio() {
        return idPatrocinio;
    }

    public void setIdPatrocinio(Integer idPatrocinio) {
        this.idPatrocinio = idPatrocinio;
    }

    public String getPatrocinio() {
        return patrocinio;
    }

    public void setPatrocinio(String patrocinio) {
        this.patrocinio = patrocinio;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPatrocinio != null ? idPatrocinio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patrocinio)) {
            return false;
        }
        Patrocinio other = (Patrocinio) object;
        if ((this.idPatrocinio == null && other.idPatrocinio != null) || (this.idPatrocinio != null && !this.idPatrocinio.equals(other.idPatrocinio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Patrocinio[ idPatrocinio=" + idPatrocinio + " ]";
    }
    
}
