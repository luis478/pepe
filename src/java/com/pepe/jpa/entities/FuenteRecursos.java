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
 * @author ADSI TARDE
 */
@Entity
@Table(name = "fuente_recursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuenteRecursos.findAll", query = "SELECT f FROM FuenteRecursos f"),
    @NamedQuery(name = "FuenteRecursos.findByIdFuenteRecursos", query = "SELECT f FROM FuenteRecursos f WHERE f.idFuenteRecursos = :idFuenteRecursos"),
    @NamedQuery(name = "FuenteRecursos.findByNombreRecursos", query = "SELECT f FROM FuenteRecursos f WHERE f.nombreRecursos = :nombreRecursos")})
public class FuenteRecursos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fuente_recursos")
    private Integer idFuenteRecursos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_recursos")
    private String nombreRecursos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuenteRecursos")
    private List<RecursoHasMaterial> recursoHasMaterialList;

    public FuenteRecursos() {
    }

    public FuenteRecursos(Integer idFuenteRecursos) {
        this.idFuenteRecursos = idFuenteRecursos;
    }

    public FuenteRecursos(Integer idFuenteRecursos, String nombreRecursos) {
        this.idFuenteRecursos = idFuenteRecursos;
        this.nombreRecursos = nombreRecursos;
    }

    public Integer getIdFuenteRecursos() {
        return idFuenteRecursos;
    }

    public void setIdFuenteRecursos(Integer idFuenteRecursos) {
        this.idFuenteRecursos = idFuenteRecursos;
    }

    public String getNombreRecursos() {
        return nombreRecursos;
    }

    public void setNombreRecursos(String nombreRecursos) {
        this.nombreRecursos = nombreRecursos;
    }

    @XmlTransient
    public List<RecursoHasMaterial> getRecursoHasMaterialList() {
        return recursoHasMaterialList;
    }

    public void setRecursoHasMaterialList(List<RecursoHasMaterial> recursoHasMaterialList) {
        this.recursoHasMaterialList = recursoHasMaterialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuenteRecursos != null ? idFuenteRecursos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuenteRecursos)) {
            return false;
        }
        FuenteRecursos other = (FuenteRecursos) object;
        if ((this.idFuenteRecursos == null && other.idFuenteRecursos != null) || (this.idFuenteRecursos != null && !this.idFuenteRecursos.equals(other.idFuenteRecursos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.FuenteRecursos[ idFuenteRecursos=" + idFuenteRecursos + " ]";
    }
    
}