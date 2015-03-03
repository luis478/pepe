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
 * @author Junior Cabal
 */
@Embeddable
public class RecursoHasMaterialPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_recurso")
    private int idRecurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_material")
    private int idMaterial;

    public RecursoHasMaterialPK() {
    }

    public RecursoHasMaterialPK(int idRecurso, int idMaterial) {
        this.idRecurso = idRecurso;
        this.idMaterial = idMaterial;
    }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRecurso;
        hash += (int) idMaterial;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecursoHasMaterialPK)) {
            return false;
        }
        RecursoHasMaterialPK other = (RecursoHasMaterialPK) object;
        if (this.idRecurso != other.idRecurso) {
            return false;
        }
        if (this.idMaterial != other.idMaterial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pepe.jpa.entities.RecursoHasMaterialPK[ idRecurso=" + idRecurso + ", idMaterial=" + idMaterial + " ]";
    }
    
}
