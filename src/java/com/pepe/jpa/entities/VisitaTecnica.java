/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis Carlos
 */
@Entity
@Table(name = "visita_tecnica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VisitaTecnica.findAll", query = "SELECT v FROM VisitaTecnica v"),
    @NamedQuery(name = "VisitaTecnica.findByIdVisitaTecnica", query = "SELECT v FROM VisitaTecnica v WHERE v.idVisitaTecnica = :idVisitaTecnica"),
    @NamedQuery(name = "VisitaTecnica.findByNombre", query = "SELECT v FROM VisitaTecnica v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "VisitaTecnica.findByFecha", query = "SELECT v FROM VisitaTecnica v WHERE v.fecha = :fecha")})
public class VisitaTecnica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_visita_tecnica")
    private Integer idVisitaTecnica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")})
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;

    public VisitaTecnica() {
    }

    public VisitaTecnica(Integer idVisitaTecnica) {
        this.idVisitaTecnica = idVisitaTecnica;
    }

    public VisitaTecnica(Integer idVisitaTecnica, String nombre, Date fecha) {
        this.idVisitaTecnica = idVisitaTecnica;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public Integer getIdVisitaTecnica() {
        return idVisitaTecnica;
    }

    public void setIdVisitaTecnica(Integer idVisitaTecnica) {
        this.idVisitaTecnica = idVisitaTecnica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisitaTecnica != null ? idVisitaTecnica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitaTecnica)) {
            return false;
        }
        VisitaTecnica other = (VisitaTecnica) object;
        if ((this.idVisitaTecnica == null && other.idVisitaTecnica != null) || (this.idVisitaTecnica != null && !this.idVisitaTecnica.equals(other.idVisitaTecnica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.VisitaTecnica[ idVisitaTecnica=" + idVisitaTecnica + " ]";
    }
    
}
