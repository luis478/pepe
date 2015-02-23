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
 * @author ADSI TARDE
 */
@Entity
@Table(name = "modalidad_formacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModalidadFormacion.findAll", query = "SELECT m FROM ModalidadFormacion m"),
    @NamedQuery(name = "ModalidadFormacion.findByIdModalidadFormacion", query = "SELECT m FROM ModalidadFormacion m WHERE m.idModalidadFormacion = :idModalidadFormacion"),
    @NamedQuery(name = "ModalidadFormacion.findByModalidadFormacion", query = "SELECT m FROM ModalidadFormacion m WHERE m.modalidadFormacion = :modalidadFormacion")})
public class ModalidadFormacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_modalidad_formacion")
    private Integer idModalidadFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "modalidad_formacion")
    private String modalidadFormacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModalidadFormacion")
    private List<Programa> programaList;

    public ModalidadFormacion() {
    }

    public ModalidadFormacion(Integer idModalidadFormacion) {
        this.idModalidadFormacion = idModalidadFormacion;
    }

    public ModalidadFormacion(Integer idModalidadFormacion, String modalidadFormacion) {
        this.idModalidadFormacion = idModalidadFormacion;
        this.modalidadFormacion = modalidadFormacion;
    }

    public Integer getIdModalidadFormacion() {
        return idModalidadFormacion;
    }

    public void setIdModalidadFormacion(Integer idModalidadFormacion) {
        this.idModalidadFormacion = idModalidadFormacion;
    }

    public String getModalidadFormacion() {
        return modalidadFormacion;
    }

    public void setModalidadFormacion(String modalidadFormacion) {
        this.modalidadFormacion = modalidadFormacion;
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
        hash += (idModalidadFormacion != null ? idModalidadFormacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModalidadFormacion)) {
            return false;
        }
        ModalidadFormacion other = (ModalidadFormacion) object;
        if ((this.idModalidadFormacion == null && other.idModalidadFormacion != null) || (this.idModalidadFormacion != null && !this.idModalidadFormacion.equals(other.idModalidadFormacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.ModalidadFormacion[ idModalidadFormacion=" + idModalidadFormacion + " ]";
    }
    
}
