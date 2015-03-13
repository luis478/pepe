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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Junior Cabal
 */
@Entity
@Table(name = "aspectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aspectos.findAll", query = "SELECT a FROM Aspectos a"),
    @NamedQuery(name = "Aspectos.findByIdAspectos", query = "SELECT a FROM Aspectos a WHERE a.idAspectos = :idAspectos"),
    @NamedQuery(name = "Aspectos.findByValoracion", query = "SELECT a FROM Aspectos a WHERE a.valoracion = :valoracion")})
public class Aspectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aspectos")
    private Integer idAspectos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valoracion")
    private boolean valoracion;
    @JoinColumn(name = "id_descripcion_aspectos", referencedColumnName = "id_descripcion_aspectos")
    @ManyToOne(optional = false)
    private DescripcionAspectos idDescripcionAspectos;
    @JoinColumn(name = "id_seguimiento", referencedColumnName = "id_seguimiento")
    @ManyToOne(optional = false)
    private Seguimiento idSeguimiento;

    public Aspectos() {
    }

    public Aspectos(Integer idAspectos) {
        this.idAspectos = idAspectos;
    }

    public Aspectos(Integer idAspectos, boolean valoracion) {
        this.idAspectos = idAspectos;
        this.valoracion = valoracion;
    }

    public Integer getIdAspectos() {
        return idAspectos;
    }

    public void setIdAspectos(Integer idAspectos) {
        this.idAspectos = idAspectos;
    }

    public boolean getValoracion() {
        return valoracion;
    }

    public void setValoracion(boolean valoracion) {
        this.valoracion = valoracion;
    }

    public DescripcionAspectos getIdDescripcionAspectos() {
        return idDescripcionAspectos;
    }

    public void setIdDescripcionAspectos(DescripcionAspectos idDescripcionAspectos) {
        this.idDescripcionAspectos = idDescripcionAspectos;
    }

    public Seguimiento getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Seguimiento idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAspectos != null ? idAspectos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aspectos)) {
            return false;
        }
        Aspectos other = (Aspectos) object;
        if ((this.idAspectos == null && other.idAspectos != null) || (this.idAspectos != null && !this.idAspectos.equals(other.idAspectos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Aspectos[ idAspectos=" + idAspectos + " ]";
    }
    
}
