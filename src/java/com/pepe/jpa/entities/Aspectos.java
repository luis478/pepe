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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "aspectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aspectos.findAll", query = "SELECT a FROM Aspectos a"),
    @NamedQuery(name = "Aspectos.findByIdAspectos", query = "SELECT a FROM Aspectos a WHERE a.aspectosPK.idAspectos = :idAspectos"),
    @NamedQuery(name = "Aspectos.findByCumple", query = "SELECT a FROM Aspectos a WHERE a.cumple = :cumple"),
    @NamedQuery(name = "Aspectos.findByIdFicha", query = "SELECT a FROM Aspectos a WHERE a.aspectosPK.idFicha = :idFicha")})
public class Aspectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AspectosPK aspectosPK;
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
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones_aspectos")
    private String observacionesAspectos;
    @JoinTable(name = "usuario_has_aspectos", joinColumns = {
        @JoinColumn(name = "id_aspectos", referencedColumnName = "id_aspectos"),
        @JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ficha ficha;

    public Aspectos() {
    }

    public Aspectos(AspectosPK aspectosPK) {
        this.aspectosPK = aspectosPK;
    }

    public Aspectos(AspectosPK aspectosPK, String descripcion, short cumple) {
        this.aspectosPK = aspectosPK;
        this.descripcion = descripcion;
        this.cumple = cumple;
    }

    public Aspectos(int idAspectos, int idFicha) {
        this.aspectosPK = new AspectosPK(idAspectos, idFicha);
    }

    public AspectosPK getAspectosPK() {
        return aspectosPK;
    }

    public void setAspectosPK(AspectosPK aspectosPK) {
        this.aspectosPK = aspectosPK;
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

    public String getObservacionesAspectos() {
        return observacionesAspectos;
    }

    public void setObservacionesAspectos(String observacionesAspectos) {
        this.observacionesAspectos = observacionesAspectos;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aspectosPK != null ? aspectosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aspectos)) {
            return false;
        }
        Aspectos other = (Aspectos) object;
        if ((this.aspectosPK == null && other.aspectosPK != null) || (this.aspectosPK != null && !this.aspectosPK.equals(other.aspectosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Aspectos[ aspectosPK=" + aspectosPK + " ]";
    }
    
}