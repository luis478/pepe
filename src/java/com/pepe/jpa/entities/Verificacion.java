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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADSI TARDE
 */
@Entity
@Table(name = "verificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Verificacion.findAll", query = "SELECT v FROM Verificacion v"),
    @NamedQuery(name = "Verificacion.findByIdVerificacion", query = "SELECT v FROM Verificacion v WHERE v.idVerificacion = :idVerificacion"),
    @NamedQuery(name = "Verificacion.findByCumple", query = "SELECT v FROM Verificacion v WHERE v.cumple = :cumple")})
public class Verificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_verificacion")
    private Integer idVerificacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cumple")
    private short cumple;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "obervaciones")
    private String obervaciones;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;
    @JoinColumn(name = "id_ambiente_formacion", referencedColumnName = "id_ambiente_formacion")
    @ManyToOne(optional = false)
    private AmbienteFormacion idAmbienteFormacion;

    public Verificacion() {
    }

    public Verificacion(Integer idVerificacion) {
        this.idVerificacion = idVerificacion;
    }

    public Verificacion(Integer idVerificacion, String descripcion, short cumple, String obervaciones) {
        this.idVerificacion = idVerificacion;
        this.descripcion = descripcion;
        this.cumple = cumple;
        this.obervaciones = obervaciones;
    }

    public Integer getIdVerificacion() {
        return idVerificacion;
    }

    public void setIdVerificacion(Integer idVerificacion) {
        this.idVerificacion = idVerificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getCumple() {
        return cumple;
    }

    public void setCumple(short cumple) {
        this.cumple = cumple;
    }

    public String getObervaciones() {
        return obervaciones;
    }

    public void setObervaciones(String obervaciones) {
        this.obervaciones = obervaciones;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public AmbienteFormacion getIdAmbienteFormacion() {
        return idAmbienteFormacion;
    }

    public void setIdAmbienteFormacion(AmbienteFormacion idAmbienteFormacion) {
        this.idAmbienteFormacion = idAmbienteFormacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVerificacion != null ? idVerificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Verificacion)) {
            return false;
        }
        Verificacion other = (Verificacion) object;
        if ((this.idVerificacion == null && other.idVerificacion != null) || (this.idVerificacion != null && !this.idVerificacion.equals(other.idVerificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Verificacion[ idVerificacion=" + idVerificacion + " ]";
    }
    
}
