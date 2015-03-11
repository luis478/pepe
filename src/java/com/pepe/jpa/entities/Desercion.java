/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Junior Cabal
 */
@Entity
@Table(name = "desercion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desercion.findAll", query = "SELECT d FROM Desercion d"),
    @NamedQuery(name = "Desercion.findByIdDesercion", query = "SELECT d FROM Desercion d WHERE d.idDesercion = :idDesercion"),
    @NamedQuery(name = "Desercion.findByFecha", query = "SELECT d FROM Desercion d WHERE d.fecha = :fecha")})
public class Desercion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_desercion")
    private Integer idDesercion;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Lob
    @Size(max = 65535)
    @Column(name = "motivo")
    private String motivo;
    @OneToMany(mappedBy = "idDesercion")
    private List<Usuario> usuarioList;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado idEstado;

    public Desercion() {
    }

    public Desercion(Integer idDesercion) {
        this.idDesercion = idDesercion;
    }

    public Integer getIdDesercion() {
        return idDesercion;
    }

    public void setIdDesercion(Integer idDesercion) {
        this.idDesercion = idDesercion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesercion != null ? idDesercion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desercion)) {
            return false;
        }
        Desercion other = (Desercion) object;
        if ((this.idDesercion == null && other.idDesercion != null) || (this.idDesercion != null && !this.idDesercion.equals(other.idDesercion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Desercion[ idDesercion=" + idDesercion + " ]";
    }
    
}
