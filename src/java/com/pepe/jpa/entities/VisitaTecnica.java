/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows 8
 */
@Entity
@Table(name = "visita_tecnica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VisitaTecnica.findAll", query = "SELECT v FROM VisitaTecnica v"),
    @NamedQuery(name = "VisitaTecnica.findByIdVisitaTecnica", query = "SELECT v FROM VisitaTecnica v WHERE v.idVisitaTecnica = :idVisitaTecnica"),
    @NamedQuery(name = "VisitaTecnica.findByNombre", query = "SELECT v FROM VisitaTecnica v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "VisitaTecnica.findByFecha", query = "SELECT v FROM VisitaTecnica v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "VisitaTecnica.findByCiudad", query = "SELECT v FROM VisitaTecnica v WHERE v.ciudad = :ciudad")})
public class VisitaTecnica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_visita_tecnica")
    private Integer idVisitaTecnica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;
    @JoinColumns({
        @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad"),
        @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")})
    @ManyToOne(optional = false)
    private Ciudad ciudad1;

    public VisitaTecnica() {
    }

    public VisitaTecnica(Integer idVisitaTecnica) {
        this.idVisitaTecnica = idVisitaTecnica;
    }

    public VisitaTecnica(Integer idVisitaTecnica, String nombre, String fecha, String ciudad) {
        this.idVisitaTecnica = idVisitaTecnica;
        this.nombre = nombre;
        this.fecha = fecha;
        this.ciudad = ciudad;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Ciudad getCiudad1() {
        return ciudad1;
    }

    public void setCiudad1(Ciudad ciudad1) {
        this.ciudad1 = ciudad1;
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
