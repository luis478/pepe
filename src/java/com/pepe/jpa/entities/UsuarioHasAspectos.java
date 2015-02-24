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
@Table(name = "usuario_has_aspectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioHasAspectos.findAll", query = "SELECT u FROM UsuarioHasAspectos u"),
    @NamedQuery(name = "UsuarioHasAspectos.findByUsuarioIdUsuario", query = "SELECT u FROM UsuarioHasAspectos u WHERE u.usuarioHasAspectosPK.usuarioIdUsuario = :usuarioIdUsuario"),
    @NamedQuery(name = "UsuarioHasAspectos.findByAspectosIdAspectos", query = "SELECT u FROM UsuarioHasAspectos u WHERE u.usuarioHasAspectosPK.aspectosIdAspectos = :aspectosIdAspectos"),
    @NamedQuery(name = "UsuarioHasAspectos.findByAspectosFichaIdFicha", query = "SELECT u FROM UsuarioHasAspectos u WHERE u.usuarioHasAspectosPK.aspectosFichaIdFicha = :aspectosFichaIdFicha")})
public class UsuarioHasAspectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioHasAspectosPK usuarioHasAspectosPK;
    @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioHasAspectos() {
    }

    public UsuarioHasAspectos(UsuarioHasAspectosPK usuarioHasAspectosPK) {
        this.usuarioHasAspectosPK = usuarioHasAspectosPK;
    }

    public UsuarioHasAspectos(int usuarioIdUsuario, int aspectosIdAspectos, int aspectosFichaIdFicha) {
        this.usuarioHasAspectosPK = new UsuarioHasAspectosPK(usuarioIdUsuario, aspectosIdAspectos, aspectosFichaIdFicha);
    }

    public UsuarioHasAspectosPK getUsuarioHasAspectosPK() {
        return usuarioHasAspectosPK;
    }

    public void setUsuarioHasAspectosPK(UsuarioHasAspectosPK usuarioHasAspectosPK) {
        this.usuarioHasAspectosPK = usuarioHasAspectosPK;
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
        hash += (usuarioHasAspectosPK != null ? usuarioHasAspectosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasAspectos)) {
            return false;
        }
        UsuarioHasAspectos other = (UsuarioHasAspectos) object;
        if ((this.usuarioHasAspectosPK == null && other.usuarioHasAspectosPK != null) || (this.usuarioHasAspectosPK != null && !this.usuarioHasAspectosPK.equals(other.usuarioHasAspectosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.UsuarioHasAspectos[ usuarioHasAspectosPK=" + usuarioHasAspectosPK + " ]";
    }
    
}
