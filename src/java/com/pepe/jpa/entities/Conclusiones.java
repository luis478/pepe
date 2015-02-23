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
 * @author Luis Carlos
 */
@Entity
@Table(name = "conclusiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conclusiones.findAll", query = "SELECT c FROM Conclusiones c"),
    @NamedQuery(name = "Conclusiones.findByIdConclusiones", query = "SELECT c FROM Conclusiones c WHERE c.idConclusiones = :idConclusiones")})
public class Conclusiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_conclusiones")
    private Integer idConclusiones;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConclusiones")
    private List<CriterioSeguimientoHasAcompanamiento> criterioSeguimientoHasAcompanamientoList;

    public Conclusiones() {
    }

    public Conclusiones(Integer idConclusiones) {
        this.idConclusiones = idConclusiones;
    }

    public Conclusiones(Integer idConclusiones, String descripcion) {
        this.idConclusiones = idConclusiones;
        this.descripcion = descripcion;
    }

    public Integer getIdConclusiones() {
        return idConclusiones;
    }

    public void setIdConclusiones(Integer idConclusiones) {
        this.idConclusiones = idConclusiones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<CriterioSeguimientoHasAcompanamiento> getCriterioSeguimientoHasAcompanamientoList() {
        return criterioSeguimientoHasAcompanamientoList;
    }

    public void setCriterioSeguimientoHasAcompanamientoList(List<CriterioSeguimientoHasAcompanamiento> criterioSeguimientoHasAcompanamientoList) {
        this.criterioSeguimientoHasAcompanamientoList = criterioSeguimientoHasAcompanamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConclusiones != null ? idConclusiones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conclusiones)) {
            return false;
        }
        Conclusiones other = (Conclusiones) object;
        if ((this.idConclusiones == null && other.idConclusiones != null) || (this.idConclusiones != null && !this.idConclusiones.equals(other.idConclusiones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Conclusiones[ idConclusiones=" + idConclusiones + " ]";
    }
    
}
