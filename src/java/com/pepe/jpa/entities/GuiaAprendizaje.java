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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
    @NamedQuery(name = "GuiaAprendizaje.findByIdGuiaAprendizaje", query = "SELECT g FROM GuiaAprendizaje g WHERE g.idGuiaAprendizaje = :idGuiaAprendizaje")})
public class GuiaAprendizaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_guia_aprendizaje")
    private Integer idGuiaAprendizaje;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "introduccion")
    private String introduccion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "glosario_terminos")
    private String glosarioTerminos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "referentes_bibliograficos")
    private String referentesBibliograficos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "control_documento")
    private String controlDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "guiaAprendizaje")
    private List<ActividadAprendizajeHasGuiaAprendizaje> actividadAprendizajeHasGuiaAprendizajeList;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private Proyecto idProyecto;

    public GuiaAprendizaje() {
    }

    public GuiaAprendizaje(Integer idGuiaAprendizaje) {
        this.idGuiaAprendizaje = idGuiaAprendizaje;
    }

    public GuiaAprendizaje(Integer idGuiaAprendizaje, String introduccion, String glosarioTerminos, String referentesBibliograficos, String controlDocumento) {
        this.idGuiaAprendizaje = idGuiaAprendizaje;
        this.introduccion = introduccion;
        this.glosarioTerminos = glosarioTerminos;
        this.referentesBibliograficos = referentesBibliograficos;
        this.controlDocumento = controlDocumento;
    }

    public Integer getIdGuiaAprendizaje() {
        return idGuiaAprendizaje;
    }

    public void setIdGuiaAprendizaje(Integer idGuiaAprendizaje) {
        this.idGuiaAprendizaje = idGuiaAprendizaje;
    }

    public String getIntroduccion() {
        return introduccion;
    }

    public void setIntroduccion(String introduccion) {
        this.introduccion = introduccion;
    }

    public String getGlosarioTerminos() {
        return glosarioTerminos;
    }

    public void setGlosarioTerminos(String glosarioTerminos) {
        this.glosarioTerminos = glosarioTerminos;
    }

    public String getReferentesBibliograficos() {
        return referentesBibliograficos;
    }

    public void setReferentesBibliograficos(String referentesBibliograficos) {
        this.referentesBibliograficos = referentesBibliograficos;
    }

    public String getControlDocumento() {
        return controlDocumento;
    }

    public void setControlDocumento(String controlDocumento) {
        this.controlDocumento = controlDocumento;
    }

    @XmlTransient
    public List<ActividadAprendizajeHasGuiaAprendizaje> getActividadAprendizajeHasGuiaAprendizajeList() {
        return actividadAprendizajeHasGuiaAprendizajeList;
    }

    public void setActividadAprendizajeHasGuiaAprendizajeList(List<ActividadAprendizajeHasGuiaAprendizaje> actividadAprendizajeHasGuiaAprendizajeList) {
        this.actividadAprendizajeHasGuiaAprendizajeList = actividadAprendizajeHasGuiaAprendizajeList;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGuiaAprendizaje != null ? idGuiaAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuiaAprendizaje)) {
            return false;
        }
        GuiaAprendizaje other = (GuiaAprendizaje) object;
        if ((this.idGuiaAprendizaje == null && other.idGuiaAprendizaje != null) || (this.idGuiaAprendizaje != null && !this.idGuiaAprendizaje.equals(other.idGuiaAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.GuiaAprendizaje[ idGuiaAprendizaje=" + idGuiaAprendizaje + " ]";
    }
    
}
