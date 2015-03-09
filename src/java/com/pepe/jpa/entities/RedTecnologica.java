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
import javax.persistence.Lob;
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
@Table(name = "red_tecnologica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedTecnologica.findAll", query = "SELECT r FROM RedTecnologica r"),
    @NamedQuery(name = "RedTecnologica.findByIdRedTecnologica", query = "SELECT r FROM RedTecnologica r WHERE r.idRedTecnologica = :idRedTecnologica")})
public class RedTecnologica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_red_tecnologica")
    private Integer idRedTecnologica;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_red_tecnologica")
    private String nombreRedTecnologica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRedTecnologica")
    private List<LineaTecnologica> lineaTecnologicaList;

    public RedTecnologica() {
    }

    public RedTecnologica(Integer idRedTecnologica) {
        this.idRedTecnologica = idRedTecnologica;
    }

    public RedTecnologica(Integer idRedTecnologica, String nombreRedTecnologica) {
        this.idRedTecnologica = idRedTecnologica;
        this.nombreRedTecnologica = nombreRedTecnologica;
    }

    public Integer getIdRedTecnologica() {
        return idRedTecnologica;
    }

    public void setIdRedTecnologica(Integer idRedTecnologica) {
        this.idRedTecnologica = idRedTecnologica;
    }

    public String getNombreRedTecnologica() {
        return nombreRedTecnologica;
    }

    public void setNombreRedTecnologica(String nombreRedTecnologica) {
        this.nombreRedTecnologica = nombreRedTecnologica;
    }

    @XmlTransient
    public List<LineaTecnologica> getLineaTecnologicaList() {
        return lineaTecnologicaList;
    }

    public void setLineaTecnologicaList(List<LineaTecnologica> lineaTecnologicaList) {
        this.lineaTecnologicaList = lineaTecnologicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRedTecnologica != null ? idRedTecnologica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedTecnologica)) {
            return false;
        }
        RedTecnologica other = (RedTecnologica) object;
        if ((this.idRedTecnologica == null && other.idRedTecnologica != null) || (this.idRedTecnologica != null && !this.idRedTecnologica.equals(other.idRedTecnologica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.RedTecnologica[ idRedTecnologica=" + idRedTecnologica + " ]";
    }
    
}
