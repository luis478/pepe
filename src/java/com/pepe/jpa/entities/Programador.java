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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Junior Cabal
 */
@Entity
@Table(name = "programador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programador.findAll", query = "SELECT p FROM Programador p"),
    @NamedQuery(name = "Programador.findByIdProgramador", query = "SELECT p FROM Programador p WHERE p.idProgramador = :idProgramador"),
    @NamedQuery(name = "Programador.findByCantidadHora", query = "SELECT p FROM Programador p WHERE p.cantidadHora = :cantidadHora"),
    @NamedQuery(name = "Programador.findByUsuarioP", query = "SELECT p FROM Programador p WHERE p.idUsuario = :idUsuario"),
    @NamedQuery(name = "Programador.findByTrimestre", query = "SELECT p FROM Programador p WHERE p.trimestre = :trimestre")})
public class Programador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_programador")
    private Integer idProgramador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_hora")
    private int cantidadHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trimestre")
    private int trimestre;
    @JoinColumns({
        @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad"),
        @JoinColumn(name = "id_resultado_aprendizaje", referencedColumnName = "id_resultado_aprendizaje")})
    @ManyToOne(optional = false)
    private ActividadHasResultadoAprendizaje actividadHasResultadoAprendizaje;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProgramador")
    private List<Evento> eventoList;

    public Programador() {
    }

    public Programador(Integer idProgramador) {
        this.idProgramador = idProgramador;
    }

    public Programador(Integer idProgramador, int cantidadHora, int trimestre) {
        this.idProgramador = idProgramador;
        this.cantidadHora = cantidadHora;
        this.trimestre = trimestre;
    }

    public Integer getIdProgramador() {
        return idProgramador;
    }

    public void setIdProgramador(Integer idProgramador) {
        this.idProgramador = idProgramador;
    }

    public int getCantidadHora() {
        return cantidadHora;
    }

    public void setCantidadHora(int cantidadHora) {
        this.cantidadHora = cantidadHora;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public ActividadHasResultadoAprendizaje getActividadHasResultadoAprendizaje() {
        return actividadHasResultadoAprendizaje;
    }

    public void setActividadHasResultadoAprendizaje(ActividadHasResultadoAprendizaje actividadHasResultadoAprendizaje) {
        this.actividadHasResultadoAprendizaje = actividadHasResultadoAprendizaje;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProgramador != null ? idProgramador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programador)) {
            return false;
        }
        Programador other = (Programador) object;
        if ((this.idProgramador == null && other.idProgramador != null) || (this.idProgramador != null && !this.idProgramador.equals(other.idProgramador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.Programador[ idProgramador=" + idProgramador + " ]";
    }
    
}
