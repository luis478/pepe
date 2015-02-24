/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADSI TARDE
 */
@Entity
@Table(name = "ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f"),
    @NamedQuery(name = "Ficha.findByIdFicha", query = "SELECT f FROM Ficha f WHERE f.idFicha = :idFicha"),
    @NamedQuery(name = "Ficha.findByCodigoFicha", query = "SELECT f FROM Ficha f WHERE f.codigoFicha = :codigoFicha"),
    @NamedQuery(name = "Ficha.findByFechaInicio", query = "SELECT f FROM Ficha f WHERE f.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Ficha.findByTrimestresLectiva", query = "SELECT f FROM Ficha f WHERE f.trimestresLectiva = :trimestresLectiva"),
    @NamedQuery(name = "Ficha.findByEstado", query = "SELECT f FROM Ficha f WHERE f.estado = :estado")})
public class Ficha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ficha")
    private Integer idFicha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "codigo_ficha")
    private String codigoFicha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trimestres_lectiva")
    private short trimestresLectiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private short estado;
    @JoinTable(name = "trimestre_has_ficha", joinColumns = {
        @JoinColumn(name = "id_ficha", referencedColumnName = "id_ficha")}, inverseJoinColumns = {
        @JoinColumn(name = "id_trimestre", referencedColumnName = "id_trimestre")})
    @ManyToMany
    private List<Trimestre> trimestreList;
    @JoinColumn(name = "id_tipo_oferta", referencedColumnName = "id_tipo_oferta")
    @ManyToOne(optional = false)
    private TipoOferta idTipoOferta;
    @JoinColumn(name = "id_tipo_formacion", referencedColumnName = "id_tipo_formacion")
    @ManyToOne(optional = false)
    private TipoFormacion idTipoFormacion;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto")
    @ManyToOne
    private Proyecto idProyecto;
    @JoinColumns({
        @JoinColumn(name = "programa_codigo", referencedColumnName = "codigo"),
        @JoinColumn(name = "programa_version", referencedColumnName = "version")})
    @ManyToOne(optional = false)
    private Programa programa;
    @JoinColumn(name = "id_jornada", referencedColumnName = "id_jornada")
    @ManyToOne(optional = false)
    private Jornada idJornada;
    @JoinColumn(name = "id_centro_formacion", referencedColumnName = "id_centro_formacion")
    @ManyToOne(optional = false)
    private CentroFormacion idCentroFormacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ficha")
    private List<Aspectos> aspectosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ficha")
    private List<UsuarioHasFicha> usuarioHasFichaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFicha")
    private List<Evento> eventoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFicha")
    private List<Acompanamiento> acompanamientoList;

    public Ficha() {
    }

    public Ficha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public Ficha(Integer idFicha, String codigoFicha, Date fechaInicio, short trimestresLectiva, short estado) {
        this.idFicha = idFicha;
        this.codigoFicha = codigoFicha;
        this.fechaInicio = fechaInicio;
        this.trimestresLectiva = trimestresLectiva;
        this.estado = estado;
    }

    public Integer getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public String getCodigoFicha() {
        return codigoFicha;
    }

    public void setCodigoFicha(String codigoFicha) {
        this.codigoFicha = codigoFicha;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public short getTrimestresLectiva() {
        return trimestresLectiva;
    }

    public void setTrimestresLectiva(short trimestresLectiva) {
        this.trimestresLectiva = trimestresLectiva;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Trimestre> getTrimestreList() {
        return trimestreList;
    }

    public void setTrimestreList(List<Trimestre> trimestreList) {
        this.trimestreList = trimestreList;
    }

    public TipoOferta getIdTipoOferta() {
        return idTipoOferta;
    }

    public void setIdTipoOferta(TipoOferta idTipoOferta) {
        this.idTipoOferta = idTipoOferta;
    }

    public TipoFormacion getIdTipoFormacion() {
        return idTipoFormacion;
    }

    public void setIdTipoFormacion(TipoFormacion idTipoFormacion) {
        this.idTipoFormacion = idTipoFormacion;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Jornada getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Jornada idJornada) {
        this.idJornada = idJornada;
    }

    public CentroFormacion getIdCentroFormacion() {
        return idCentroFormacion;
    }

    public void setIdCentroFormacion(CentroFormacion idCentroFormacion) {
        this.idCentroFormacion = idCentroFormacion;
    }

    @XmlTransient
    public List<Aspectos> getAspectosList() {
        return aspectosList;
    }

    public void setAspectosList(List<Aspectos> aspectosList) {
        this.aspectosList = aspectosList;
    }

    @XmlTransient
    public List<UsuarioHasFicha> getUsuarioHasFichaList() {
        return usuarioHasFichaList;
    }

    public void setUsuarioHasFichaList(List<UsuarioHasFicha> usuarioHasFichaList) {
        this.usuarioHasFichaList = usuarioHasFichaList;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @XmlTransient
    public List<Acompanamiento> getAcompanamientoList() {
        return acompanamientoList;
    }

    public void setAcompanamientoList(List<Acompanamiento> acompanamientoList) {
        this.acompanamientoList = acompanamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFicha != null ? idFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.idFicha == null && other.idFicha != null) || (this.idFicha != null && !this.idFicha.equals(other.idFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigoFicha;
    }

    
}
