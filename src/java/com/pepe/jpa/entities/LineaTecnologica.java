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
import javax.persistence.Lob;
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
@Table(name = "linea_tecnologica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineaTecnologica.findAll", query = "SELECT l FROM LineaTecnologica l"),
    @NamedQuery(name = "LineaTecnologica.findByIdLineaTecnologica", query = "SELECT l FROM LineaTecnologica l WHERE l.idLineaTecnologica = :idLineaTecnologica")})
public class LineaTecnologica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_linea_tecnologica")
    private Integer idLineaTecnologica;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_linea_tecnologica")
    private String nombreLineaTecnologica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLineaTecnologica")
    private List<Programa> programaList;
    @JoinColumn(name = "id_red_tecnologica", referencedColumnName = "id_red_tecnologica")
    @ManyToOne(optional = false)
    private RedTecnologica idRedTecnologica;

    public LineaTecnologica() {
    }

    public LineaTecnologica(Integer idLineaTecnologica) {
        this.idLineaTecnologica = idLineaTecnologica;
    }

    public LineaTecnologica(Integer idLineaTecnologica, String nombreLineaTecnologica) {
        this.idLineaTecnologica = idLineaTecnologica;
        this.nombreLineaTecnologica = nombreLineaTecnologica;
    }

    public Integer getIdLineaTecnologica() {
        return idLineaTecnologica;
    }

    public void setIdLineaTecnologica(Integer idLineaTecnologica) {
        this.idLineaTecnologica = idLineaTecnologica;
    }

    public String getNombreLineaTecnologica() {
        return nombreLineaTecnologica;
    }

    public void setNombreLineaTecnologica(String nombreLineaTecnologica) {
        this.nombreLineaTecnologica = nombreLineaTecnologica;
    }

    @XmlTransient
    public List<Programa> getProgramaList() {
        return programaList;
    }

    public void setProgramaList(List<Programa> programaList) {
        this.programaList = programaList;
    }

    public RedTecnologica getIdRedTecnologica() {
        return idRedTecnologica;
    }

    public void setIdRedTecnologica(RedTecnologica idRedTecnologica) {
        this.idRedTecnologica = idRedTecnologica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineaTecnologica != null ? idLineaTecnologica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaTecnologica)) {
            return false;
        }
        LineaTecnologica other = (LineaTecnologica) object;
        if ((this.idLineaTecnologica == null && other.idLineaTecnologica != null) || (this.idLineaTecnologica != null && !this.idLineaTecnologica.equals(other.idLineaTecnologica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.LineaTecnologica[ idLineaTecnologica=" + idLineaTecnologica + " ]";
    }
    
}
