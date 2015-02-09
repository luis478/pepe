/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Windows 8
 */
@Entity
@Table(name = "guia_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GuiaAprendizaje.findAll", query = "SELECT g FROM GuiaAprendizaje g"),
    @NamedQuery(name = "GuiaAprendizaje.findByIdGuiaAprendizaje", query = "SELECT g FROM GuiaAprendizaje g WHERE g.guiaAprendizajePK.idGuiaAprendizaje = :idGuiaAprendizaje"),
    @NamedQuery(name = "GuiaAprendizaje.findByIdFase", query = "SELECT g FROM GuiaAprendizaje g WHERE g.guiaAprendizajePK.idFase = :idFase"),
    @NamedQuery(name = "GuiaAprendizaje.findByGuiaAprendizaje", query = "SELECT g FROM GuiaAprendizaje g WHERE g.guiaAprendizaje = :guiaAprendizaje")})
public class GuiaAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GuiaAprendizajePK guiaAprendizajePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "guia_aprendizaje")
    private String guiaAprendizaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guiaAprendizaje")
    private List<Actividad> actividadList;
    @JoinColumn(name = "id_fase1", referencedColumnName = "id_fase")
    @ManyToOne(optional = false)
    private Fase idFase1;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;
    @JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha")
    @ManyToOne(optional = false)
    private Ficha idFicha;

    public GuiaAprendizaje() {
    }

    public GuiaAprendizaje(GuiaAprendizajePK guiaAprendizajePK) {
        this.guiaAprendizajePK = guiaAprendizajePK;
    }

    public GuiaAprendizaje(GuiaAprendizajePK guiaAprendizajePK, String guiaAprendizaje) {
        this.guiaAprendizajePK = guiaAprendizajePK;
        this.guiaAprendizaje = guiaAprendizaje;
    }

    public GuiaAprendizaje(int idGuiaAprendizaje, int idFase) {
        this.guiaAprendizajePK = new GuiaAprendizajePK(idGuiaAprendizaje, idFase);
    }

    public GuiaAprendizajePK getGuiaAprendizajePK() {
        return guiaAprendizajePK;
    }

    public void setGuiaAprendizajePK(GuiaAprendizajePK guiaAprendizajePK) {
        this.guiaAprendizajePK = guiaAprendizajePK;
    }

    public String getGuiaAprendizaje() {
        return guiaAprendizaje;
    }

    public void setGuiaAprendizaje(String guiaAprendizaje) {
        this.guiaAprendizaje = guiaAprendizaje;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    public Fase getIdFase1() {
        return idFase1;
    }

    public void setIdFase1(Fase idFase1) {
        this.idFase1 = idFase1;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Ficha getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Ficha idFicha) {
        this.idFicha = idFicha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guiaAprendizajePK != null ? guiaAprendizajePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaAprendizaje)) {
            return false;
        }
        GuiaAprendizaje other = (GuiaAprendizaje) object;
        if ((this.guiaAprendizajePK == null && other.guiaAprendizajePK != null) || (this.guiaAprendizajePK != null && !this.guiaAprendizajePK.equals(other.guiaAprendizajePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.GuiaAprendizaje[ guiaAprendizajePK=" + guiaAprendizajePK + " ]";
    }
    
}
