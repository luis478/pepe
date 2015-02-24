<<<<<<< HEAD
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
 * @author Luis Carlos
 */
@Entity
@Table(name = "usuario_has_ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioHasFicha.findAll", query = "SELECT u FROM UsuarioHasFicha u"),
    @NamedQuery(name = "UsuarioHasFicha.findByIdUsuario", query = "SELECT u FROM UsuarioHasFicha u WHERE u.usuarioHasFichaPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuarioHasFicha.findByIdFicha", query = "SELECT u FROM UsuarioHasFicha u WHERE u.usuarioHasFichaPK.idFicha = :idFicha")})
public class UsuarioHasFicha implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioHasFichaPK usuarioHasFichaPK;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ficha ficha;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "id_tipo_instructor", referencedColumnName = "id_tipo_instructor")
    @ManyToOne(optional = false)
    private TipoInstructor idTipoInstructor;

    public UsuarioHasFicha() {
    }

    public UsuarioHasFicha(UsuarioHasFichaPK usuarioHasFichaPK) {
        this.usuarioHasFichaPK = usuarioHasFichaPK;
    }

    public UsuarioHasFicha(int idUsuario, int idFicha) {
        this.usuarioHasFichaPK = new UsuarioHasFichaPK(idUsuario, idFicha);
    }

    public UsuarioHasFichaPK getUsuarioHasFichaPK() {
        return usuarioHasFichaPK;
    }

    public void setUsuarioHasFichaPK(UsuarioHasFichaPK usuarioHasFichaPK) {
        this.usuarioHasFichaPK = usuarioHasFichaPK;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoInstructor getIdTipoInstructor() {
        return idTipoInstructor;
    }

    public void setIdTipoInstructor(TipoInstructor idTipoInstructor) {
        this.idTipoInstructor = idTipoInstructor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioHasFichaPK != null ? usuarioHasFichaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasFicha)) {
            return false;
        }
        UsuarioHasFicha other = (UsuarioHasFicha) object;
        if ((this.usuarioHasFichaPK == null && other.usuarioHasFichaPK != null) || (this.usuarioHasFichaPK != null && !this.usuarioHasFichaPK.equals(other.usuarioHasFichaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.UsuarioHasFicha[ usuarioHasFichaPK=" + usuarioHasFichaPK + " ]";
    }
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADSI TARDE
 */
@Entity
@Table(name = "usuario_has_ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioHasFicha.findAll", query = "SELECT u FROM UsuarioHasFicha u"),
    @NamedQuery(name = "UsuarioHasFicha.findByTipoInstructor", query = "SELECT u FROM UsuarioHasFicha u WHERE u.idTipoInstructor.idTipoInstructor = 1 AND u.ficha.codigoFicha = :codigoFicha"), 
    @NamedQuery(name = "UsuarioHasFicha.findByIdUsuario", query = "SELECT u FROM UsuarioHasFicha u WHERE u.usuarioHasFichaPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuarioHasFicha.findByIdFicha", query = "SELECT u FROM UsuarioHasFicha u WHERE u.usuarioHasFichaPK.idFicha = :idFicha")})
public class UsuarioHasFicha implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioHasFichaPK usuarioHasFichaPK;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "id_tipo_instructor", referencedColumnName = "id_tipo_instructor")
    @ManyToOne(optional = false)
    private TipoInstructor idTipoInstructor;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ficha ficha;

    public UsuarioHasFicha() {
    }

    public UsuarioHasFicha(UsuarioHasFichaPK usuarioHasFichaPK) {
        this.usuarioHasFichaPK = usuarioHasFichaPK;
    }

    public UsuarioHasFicha(int idUsuario, int idFicha) {
        this.usuarioHasFichaPK = new UsuarioHasFichaPK(idUsuario, idFicha);
    }

    public UsuarioHasFichaPK getUsuarioHasFichaPK() {
        return usuarioHasFichaPK;
    }

    public void setUsuarioHasFichaPK(UsuarioHasFichaPK usuarioHasFichaPK) {
        this.usuarioHasFichaPK = usuarioHasFichaPK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoInstructor getIdTipoInstructor() {
        return idTipoInstructor;
    }

    public void setIdTipoInstructor(TipoInstructor idTipoInstructor) {
        this.idTipoInstructor = idTipoInstructor;
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
        hash += (usuarioHasFichaPK != null ? usuarioHasFichaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasFicha)) {
            return false;
        }
        UsuarioHasFicha other = (UsuarioHasFicha) object;
        if ((this.usuarioHasFichaPK == null && other.usuarioHasFichaPK != null) || (this.usuarioHasFichaPK != null && !this.usuarioHasFichaPK.equals(other.usuarioHasFichaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.UsuarioHasFicha[ usuarioHasFichaPK=" + usuarioHasFichaPK + " ]";
    }

}
>>>>>>> origin/master
