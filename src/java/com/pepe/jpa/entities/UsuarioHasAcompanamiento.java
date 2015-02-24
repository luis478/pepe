/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adsit
 */
@Entity
@Table(name = "usuario_has_acompanamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioHasAcompanamiento.findAll", query = "SELECT u FROM UsuarioHasAcompanamiento u"),
    @NamedQuery(name = "UsuarioHasAcompanamiento.findByUsuarioIdUsuario", query = "SELECT u FROM UsuarioHasAcompanamiento u WHERE u.usuarioHasAcompanamientoPK.usuarioIdUsuario = :usuarioIdUsuario"),
    @NamedQuery(name = "UsuarioHasAcompanamiento.findByAcompanamientoIdAcompanamiento", query = "SELECT u FROM UsuarioHasAcompanamiento u WHERE u.usuarioHasAcompanamientoPK.acompanamientoIdAcompanamiento = :acompanamientoIdAcompanamiento")})
public class UsuarioHasAcompanamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioHasAcompanamientoPK usuarioHasAcompanamientoPK;
    @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioHasAcompanamiento() {
    }

    public UsuarioHasAcompanamiento(UsuarioHasAcompanamientoPK usuarioHasAcompanamientoPK) {
        this.usuarioHasAcompanamientoPK = usuarioHasAcompanamientoPK;
    }

    public UsuarioHasAcompanamiento(int usuarioIdUsuario, int acompanamientoIdAcompanamiento) {
        this.usuarioHasAcompanamientoPK = new UsuarioHasAcompanamientoPK(usuarioIdUsuario, acompanamientoIdAcompanamiento);
    }

    public UsuarioHasAcompanamientoPK getUsuarioHasAcompanamientoPK() {
        return usuarioHasAcompanamientoPK;
    }

    public void setUsuarioHasAcompanamientoPK(UsuarioHasAcompanamientoPK usuarioHasAcompanamientoPK) {
        this.usuarioHasAcompanamientoPK = usuarioHasAcompanamientoPK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioHasAcompanamientoPK != null ? usuarioHasAcompanamientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasAcompanamiento)) {
            return false;
        }
        UsuarioHasAcompanamiento other = (UsuarioHasAcompanamiento) object;
        if ((this.usuarioHasAcompanamientoPK == null && other.usuarioHasAcompanamientoPK != null) || (this.usuarioHasAcompanamientoPK != null && !this.usuarioHasAcompanamientoPK.equals(other.usuarioHasAcompanamientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.UsuarioHasAcompanamiento[ usuarioHasAcompanamientoPK=" + usuarioHasAcompanamientoPK + " ]";
    }
    
}
