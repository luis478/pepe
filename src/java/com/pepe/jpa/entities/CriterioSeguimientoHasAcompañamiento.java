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
 * @author Windows 8
 */
@Entity
@Table(name = "criterio_seguimiento_has_acompa\u00f1amiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriterioSeguimientoHasAcompa\u00f1amiento.findAll", query = "SELECT c FROM CriterioSeguimientoHasAcompa\u00f1amiento c"),
    @NamedQuery(name = "CriterioSeguimientoHasAcompa\u00f1amiento.findByIdCriterioSeguimiento", query = "SELECT c FROM CriterioSeguimientoHasAcompa\u00f1amiento c WHERE c.criterioSeguimientoHasAcompa\u00f1amientoPK.idCriterioSeguimiento = :idCriterioSeguimiento"),
    @NamedQuery(name = "CriterioSeguimientoHasAcompa\u00f1amiento.findByIdAcompa\u00f1amiento", query = "SELECT c FROM CriterioSeguimientoHasAcompa\u00f1amiento c WHERE c.criterioSeguimientoHasAcompa\u00f1amientoPK.idAcompa\u00f1amiento = :idAcompa\u00f1amiento"),
    @NamedQuery(name = "CriterioSeguimientoHasAcompa\u00f1amiento.findByCumple", query = "SELECT c FROM CriterioSeguimientoHasAcompa\u00f1amiento c WHERE c.cumple = :cumple")})
public class CriterioSeguimientoHasAcompañamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriterioSeguimientoHasAcompañamientoPK criterioSeguimientoHasAcompañamientoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cumple")
    private short cumple;
    @JoinColumn(name = "id_criterio_seguimiento", referencedColumnName = "id_criterio_seguimiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CriterioSeguimiento criterioSeguimiento;
    @JoinColumn(name = "id_acompa\u00f1amiento", referencedColumnName = "id_acompa\u00f1amiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Acompañamiento acompañamiento;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_evidencia_encontrada", referencedColumnName = "id_evidencia_encontrada")
    @ManyToOne(optional = false)
    private EvidenciaEncontrada idEvidenciaEncontrada;
    @JoinColumn(name = "id_conclusiones", referencedColumnName = "id_conclusiones")
    @ManyToOne(optional = false)
    private Conclusiones idConclusiones;

    public CriterioSeguimientoHasAcompañamiento() {
    }

    public CriterioSeguimientoHasAcompañamiento(CriterioSeguimientoHasAcompañamientoPK criterioSeguimientoHasAcompañamientoPK) {
        this.criterioSeguimientoHasAcompañamientoPK = criterioSeguimientoHasAcompañamientoPK;
    }

    public CriterioSeguimientoHasAcompañamiento(CriterioSeguimientoHasAcompañamientoPK criterioSeguimientoHasAcompañamientoPK, short cumple) {
        this.criterioSeguimientoHasAcompañamientoPK = criterioSeguimientoHasAcompañamientoPK;
        this.cumple = cumple;
    }

    public CriterioSeguimientoHasAcompañamiento(int idCriterioSeguimiento, int idAcompañamiento) {
        this.criterioSeguimientoHasAcompañamientoPK = new CriterioSeguimientoHasAcompañamientoPK(idCriterioSeguimiento, idAcompañamiento);
    }

    public CriterioSeguimientoHasAcompañamientoPK getCriterioSeguimientoHasAcompañamientoPK() {
        return criterioSeguimientoHasAcompañamientoPK;
    }

    public void setCriterioSeguimientoHasAcompañamientoPK(CriterioSeguimientoHasAcompañamientoPK criterioSeguimientoHasAcompañamientoPK) {
        this.criterioSeguimientoHasAcompañamientoPK = criterioSeguimientoHasAcompañamientoPK;
    }

    public short getCumple() {
        return cumple;
    }

    public void setCumple(short cumple) {
        this.cumple = cumple;
    }

    public CriterioSeguimiento getCriterioSeguimiento() {
        return criterioSeguimiento;
    }

    public void setCriterioSeguimiento(CriterioSeguimiento criterioSeguimiento) {
        this.criterioSeguimiento = criterioSeguimiento;
    }

    public Acompañamiento getAcompañamiento() {
        return acompañamiento;
    }

    public void setAcompañamiento(Acompañamiento acompañamiento) {
        this.acompañamiento = acompañamiento;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public EvidenciaEncontrada getIdEvidenciaEncontrada() {
        return idEvidenciaEncontrada;
    }

    public void setIdEvidenciaEncontrada(EvidenciaEncontrada idEvidenciaEncontrada) {
        this.idEvidenciaEncontrada = idEvidenciaEncontrada;
    }

    public Conclusiones getIdConclusiones() {
        return idConclusiones;
    }

    public void setIdConclusiones(Conclusiones idConclusiones) {
        this.idConclusiones = idConclusiones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criterioSeguimientoHasAcompañamientoPK != null ? criterioSeguimientoHasAcompañamientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioSeguimientoHasAcompañamiento)) {
            return false;
        }
        CriterioSeguimientoHasAcompañamiento other = (CriterioSeguimientoHasAcompañamiento) object;
        if ((this.criterioSeguimientoHasAcompañamientoPK == null && other.criterioSeguimientoHasAcompañamientoPK != null) || (this.criterioSeguimientoHasAcompañamientoPK != null && !this.criterioSeguimientoHasAcompañamientoPK.equals(other.criterioSeguimientoHasAcompañamientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.CriterioSeguimientoHasAcompa\u00f1amiento[ criterioSeguimientoHasAcompa\u00f1amientoPK=" + criterioSeguimientoHasAcompañamientoPK + " ]";
    }
    
}
