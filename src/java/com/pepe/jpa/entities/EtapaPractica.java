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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "etapa_practica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtapaPractica.findAll", query = "SELECT e FROM EtapaPractica e"),
    @NamedQuery(name = "EtapaPractica.findByIdEtapaPractica", query = "SELECT e FROM EtapaPractica e WHERE e.idEtapaPractica = :idEtapaPractica"),
    @NamedQuery(name = "EtapaPractica.findByNombreEmpresa", query = "SELECT e FROM EtapaPractica e WHERE e.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "EtapaPractica.findByRepresentante", query = "SELECT e FROM EtapaPractica e WHERE e.representante = :representante"),
    @NamedQuery(name = "EtapaPractica.findByTelefono", query = "SELECT e FROM EtapaPractica e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "EtapaPractica.findByCorreo", query = "SELECT e FROM EtapaPractica e WHERE e.correo = :correo"),
    @NamedQuery(name = "EtapaPractica.findByTipoPractica", query = "SELECT e FROM EtapaPractica e WHERE e.tipoPractica = :tipoPractica")})
public class EtapaPractica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_etapa_practica")
    private Integer idEtapaPractica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "representante")
    private String representante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_practica")
    private String tipoPractica;
    @JoinTable(name = "empresa_has_proyecto", joinColumns = {
        @JoinColumn(name = "id_empresa", referencedColumnName = "id_etapa_practica")}, inverseJoinColumns = {
        @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")})
    @ManyToMany
    private List<Proyecto> proyectoList;
    @OneToMany(mappedBy = "idEtapaPractica")
    private List<Usuario> usuarioList;

    public EtapaPractica() {
    }

    public EtapaPractica(Integer idEtapaPractica) {
        this.idEtapaPractica = idEtapaPractica;
    }

    public EtapaPractica(Integer idEtapaPractica, String nombreEmpresa, String representante, String telefono, String correo, String tipoPractica) {
        this.idEtapaPractica = idEtapaPractica;
        this.nombreEmpresa = nombreEmpresa;
        this.representante = representante;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoPractica = tipoPractica;
    }

    public Integer getIdEtapaPractica() {
        return idEtapaPractica;
    }

    public void setIdEtapaPractica(Integer idEtapaPractica) {
        this.idEtapaPractica = idEtapaPractica;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoPractica() {
        return tipoPractica;
    }

    public void setTipoPractica(String tipoPractica) {
        this.tipoPractica = tipoPractica;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtapaPractica != null ? idEtapaPractica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtapaPractica)) {
            return false;
        }
        EtapaPractica other = (EtapaPractica) object;
        if ((this.idEtapaPractica == null && other.idEtapaPractica != null) || (this.idEtapaPractica != null && !this.idEtapaPractica.equals(other.idEtapaPractica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.EtapaPractica[ idEtapaPractica=" + idEtapaPractica + " ]";
    }
    
}
