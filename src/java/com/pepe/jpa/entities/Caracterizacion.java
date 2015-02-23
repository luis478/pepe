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
@Table(name = "caracterizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracterizacion.findAll", query = "SELECT c FROM Caracterizacion c"),
    @NamedQuery(name = "Caracterizacion.findByIdCaracterizacion", query = "SELECT c FROM Caracterizacion c WHERE c.idCaracterizacion = :idCaracterizacion"),
    @NamedQuery(name = "Caracterizacion.findByAcudiente", query = "SELECT c FROM Caracterizacion c WHERE c.acudiente = :acudiente"),
    @NamedQuery(name = "Caracterizacion.findByTelefono", query = "SELECT c FROM Caracterizacion c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Caracterizacion.findByDireccion", query = "SELECT c FROM Caracterizacion c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Caracterizacion.findBySistemaLiderazgo", query = "SELECT c FROM Caracterizacion c WHERE c.sistemaLiderazgo = :sistemaLiderazgo")})
public class Caracterizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caracterizacion")
    private Integer idCaracterizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "acudiente")
    private String acudiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 80)
    @Column(name = "sistema_liderazgo")
    private String sistemaLiderazgo;
    @Lob
    @Size(max = 65535)
    @Column(name = "apoyo_bienestar")
    private String apoyoBienestar;
    @OneToMany(mappedBy = "idCaracterizacion")
    private List<Usuario> usuarioList;

    public Caracterizacion() {
    }

    public Caracterizacion(Integer idCaracterizacion) {
        this.idCaracterizacion = idCaracterizacion;
    }

    public Caracterizacion(Integer idCaracterizacion, String acudiente, String telefono, String direccion) {
        this.idCaracterizacion = idCaracterizacion;
        this.acudiente = acudiente;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Integer getIdCaracterizacion() {
        return idCaracterizacion;
    }

    public void setIdCaracterizacion(Integer idCaracterizacion) {
        this.idCaracterizacion = idCaracterizacion;
    }

    public String getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(String acudiente) {
        this.acudiente = acudiente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSistemaLiderazgo() {
        return sistemaLiderazgo;
    }

    public void setSistemaLiderazgo(String sistemaLiderazgo) {
        this.sistemaLiderazgo = sistemaLiderazgo;
    }

    public String getApoyoBienestar() {
        return apoyoBienestar;
    }

    public void setApoyoBienestar(String apoyoBienestar) {
        this.apoyoBienestar = apoyoBienestar;
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
        hash += (idCaracterizacion != null ? idCaracterizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracterizacion)) {
            return false;
        }
        Caracterizacion other = (Caracterizacion) object;
        if ((this.idCaracterizacion == null && other.idCaracterizacion != null) || (this.idCaracterizacion != null && !this.idCaracterizacion.equals(other.idCaracterizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Caracterizacion[ idCaracterizacion=" + idCaracterizacion + " ]";
    }
    
}
