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
 * @author Windows 8
 */
@Entity
@Table(name = "recurso_has_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecursoHasMaterial.findAll", query = "SELECT r FROM RecursoHasMaterial r"),
    @NamedQuery(name = "RecursoHasMaterial.findByIdRecurso", query = "SELECT r FROM RecursoHasMaterial r WHERE r.recursoHasMaterialPK.idRecurso = :idRecurso"),
    @NamedQuery(name = "RecursoHasMaterial.findByIdMaterial", query = "SELECT r FROM RecursoHasMaterial r WHERE r.recursoHasMaterialPK.idMaterial = :idMaterial")})
public class RecursoHasMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecursoHasMaterialPK recursoHasMaterialPK;
    @JoinColumn(name = "id_recurso", referencedColumnName = "id_recurso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recurso recurso;
    @JoinColumn(name = "id_material", referencedColumnName = "id_material", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Material material;
    @JoinColumn(name = "id_fuente_recursos", referencedColumnName = "id_fuente_recursos")
    @ManyToOne(optional = false)
    private FuenteRecursos idFuenteRecursos;

    public RecursoHasMaterial() {
    }

    public RecursoHasMaterial(RecursoHasMaterialPK recursoHasMaterialPK) {
        this.recursoHasMaterialPK = recursoHasMaterialPK;
    }

    public RecursoHasMaterial(int idRecurso, int idMaterial) {
        this.recursoHasMaterialPK = new RecursoHasMaterialPK(idRecurso, idMaterial);
    }

    public RecursoHasMaterialPK getRecursoHasMaterialPK() {
        return recursoHasMaterialPK;
    }

    public void setRecursoHasMaterialPK(RecursoHasMaterialPK recursoHasMaterialPK) {
        this.recursoHasMaterialPK = recursoHasMaterialPK;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public FuenteRecursos getIdFuenteRecursos() {
        return idFuenteRecursos;
    }

    public void setIdFuenteRecursos(FuenteRecursos idFuenteRecursos) {
        this.idFuenteRecursos = idFuenteRecursos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recursoHasMaterialPK != null ? recursoHasMaterialPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecursoHasMaterial)) {
            return false;
        }
        RecursoHasMaterial other = (RecursoHasMaterial) object;
        if ((this.recursoHasMaterialPK == null && other.recursoHasMaterialPK != null) || (this.recursoHasMaterialPK != null && !this.recursoHasMaterialPK.equals(other.recursoHasMaterialPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.RecursoHasMaterial[ recursoHasMaterialPK=" + recursoHasMaterialPK + " ]";
    }
    
}
