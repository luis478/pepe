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
public class UsuarioHasAspectosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id_usuario")
    private int usuarioIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aspectos_id_aspectos")
    private int aspectosIdAspectos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aspectos_ficha_id_ficha")
    private int aspectosFichaIdFicha;

    public UsuarioHasAspectosPK() {
    }

    public UsuarioHasAspectosPK(int usuarioIdUsuario, int aspectosIdAspectos, int aspectosFichaIdFicha) {
        this.usuarioIdUsuario = usuarioIdUsuario;
        this.aspectosIdAspectos = aspectosIdAspectos;
        this.aspectosFichaIdFicha = aspectosFichaIdFicha;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public int getAspectosIdAspectos() {
        return aspectosIdAspectos;
    }

    public void setAspectosIdAspectos(int aspectosIdAspectos) {
        this.aspectosIdAspectos = aspectosIdAspectos;
    }

    public int getAspectosFichaIdFicha() {
        return aspectosFichaIdFicha;
    }

    public void setAspectosFichaIdFicha(int aspectosFichaIdFicha) {
        this.aspectosFichaIdFicha = aspectosFichaIdFicha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioIdUsuario;
        hash += (int) aspectosIdAspectos;
        hash += (int) aspectosFichaIdFicha;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasAspectosPK)) {
            return false;
        }
        UsuarioHasAspectosPK other = (UsuarioHasAspectosPK) object;
        if (this.usuarioIdUsuario != other.usuarioIdUsuario) {
            return false;
        }
        if (this.aspectosIdAspectos != other.aspectosIdAspectos) {
            return false;
        }
        if (this.aspectosFichaIdFicha != other.aspectosFichaIdFicha) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.UsuarioHasAspectosPK[ usuarioIdUsuario=" + usuarioIdUsuario + ", aspectosIdAspectos=" + aspectosIdAspectos + ", aspectosFichaIdFicha=" + aspectosFichaIdFicha + " ]";
    }
    
}
