/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Adsit
 */
@Embeddable
public class UsuarioHasAcompanamientoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id_usuario")
    private int usuarioIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acompanamiento_id_acompanamiento")
    private int acompanamientoIdAcompanamiento;

    public UsuarioHasAcompanamientoPK() {
    }

    public UsuarioHasAcompanamientoPK(int usuarioIdUsuario, int acompanamientoIdAcompanamiento) {
        this.usuarioIdUsuario = usuarioIdUsuario;
        this.acompanamientoIdAcompanamiento = acompanamientoIdAcompanamiento;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public int getAcompanamientoIdAcompanamiento() {
        return acompanamientoIdAcompanamiento;
    }

    public void setAcompanamientoIdAcompanamiento(int acompanamientoIdAcompanamiento) {
        this.acompanamientoIdAcompanamiento = acompanamientoIdAcompanamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioIdUsuario;
        hash += (int) acompanamientoIdAcompanamiento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasAcompanamientoPK)) {
            return false;
        }
        UsuarioHasAcompanamientoPK other = (UsuarioHasAcompanamientoPK) object;
        if (this.usuarioIdUsuario != other.usuarioIdUsuario) {
            return false;
        }
        if (this.acompanamientoIdAcompanamiento != other.acompanamientoIdAcompanamiento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.UsuarioHasAcompanamientoPK[ usuarioIdUsuario=" + usuarioIdUsuario + ", acompanamientoIdAcompanamiento=" + acompanamientoIdAcompanamiento + " ]";
    }
    
}
