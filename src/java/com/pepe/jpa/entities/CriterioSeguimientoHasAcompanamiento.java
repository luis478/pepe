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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADSI TARDE
 */
@Entity
@Table(name = "criterio_seguimiento_has_acompanamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriterioSeguimientoHasAcompanamiento.findAll", query = "SELECT c FROM CriterioSeguimientoHasAcompanamiento c"),
    @NamedQuery(name = "CriterioSeguimientoHasAcompanamiento.findByIdCriterioSeguimiento", query = "SELECT c FROM CriterioSeguimientoHasAcompanamiento c WHERE c.criterioSeguimientoHasAcompanamientoPK.idCriterioSeguimiento = :idCriterioSeguimiento"),
    @NamedQuery(name = "CriterioSeguimientoHasAcompanamiento.findByIdAcompanamiento", query = "SELECT c FROM CriterioSeguimientoHasAcompanamiento c WHERE c.criterioSeguimientoHasAcompanamientoPK.idAcompanamiento = :idAcompanamiento"),
    @NamedQuery(name = "CriterioSeguimientoHasAcompanamiento.findByValoracion", query = "SELECT c FROM CriterioSeguimientoHasAcompanamiento c WHERE c.valoracion = :valoracion")})
public class CriterioSeguimientoHasAcompanamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriterioSeguimientoHasAcompanamientoPK criterioSeguimientoHasAcompanamientoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "valoracion")
    private String valoracion;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_criterio_seguimiento", referencedColumnName = "id_criterio_seguimiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CriterioSeguimiento criterioSeguimiento;
    @JoinColumn(name = "id_conclusiones", referencedColumnName = "id_conclusiones")
    @ManyToOne(optional = false)
    private Conclusiones idConclusiones;
    @JoinColumn(name = "id_acompanamiento", referencedColumnName = "id_acompanamiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Acompanamiento acompanamiento;

    public CriterioSeguimientoHasAcompanamiento() {
    }

    public CriterioSeguimientoHasAcompanamiento(CriterioSeguimientoHasAcompanamientoPK criterioSeguimientoHasAcompanamientoPK) {
        this.criterioSeguimientoHasAcompanamientoPK = criterioSeguimientoHasAcompanamientoPK;
    }

    public CriterioSeguimientoHasAcompanamiento(CriterioSeguimientoHasAcompanamientoPK criterioSeguimientoHasAcompanamientoPK, String valoracion) {
        this.criterioSeguimientoHasAcompanamientoPK = criterioSeguimientoHasAcompanamientoPK;
        this.valoracion = valoracion;
    }

    public CriterioSeguimientoHasAcompanamiento(int idCriterioSeguimiento, int idAcompanamiento) {
        this.criterioSeguimientoHasAcompanamientoPK = new CriterioSeguimientoHasAcompanamientoPK(idCriterioSeguimiento, idAcompanamiento);
    }

    public CriterioSeguimientoHasAcompanamientoPK getCriterioSeguimientoHasAcompanamientoPK() {
        return criterioSeguimientoHasAcompanamientoPK;
    }

    public void setCriterioSeguimientoHasAcompanamientoPK(CriterioSeguimientoHasAcompanamientoPK criterioSeguimientoHasAcompanamientoPK) {
        this.criterioSeguimientoHasAcompanamientoPK = criterioSeguimientoHasAcompanamientoPK;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public CriterioSeguimiento getCriterioSeguimiento() {
        return criterioSeguimiento;
    }

    public void setCriterioSeguimiento(CriterioSeguimiento criterioSeguimiento) {
        this.criterioSeguimiento = criterioSeguimiento;
    }

    public Conclusiones getIdConclusiones() {
        return idConclusiones;
    }

    public void setIdConclusiones(Conclusiones idConclusiones) {
        this.idConclusiones = idConclusiones;
    }

    public Acompanamiento getAcompanamiento() {
        return acompanamiento;
    }

    public void setAcompanamiento(Acompanamiento acompanamiento) {
        this.acompanamiento = acompanamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criterioSeguimientoHasAcompanamientoPK != null ? criterioSeguimientoHasAcompanamientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioSeguimientoHasAcompanamiento)) {
            return false;
        }
        CriterioSeguimientoHasAcompanamiento other = (CriterioSeguimientoHasAcompanamiento) object;
        if ((this.criterioSeguimientoHasAcompanamientoPK == null && other.criterioSeguimientoHasAcompanamientoPK != null) || (this.criterioSeguimientoHasAcompanamientoPK != null && !this.criterioSeguimientoHasAcompanamientoPK.equals(other.criterioSeguimientoHasAcompanamientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.CriterioSeguimientoHasAcompanamiento[ criterioSeguimientoHasAcompanamientoPK=" + criterioSeguimientoHasAcompanamientoPK + " ]";
    }
    
}