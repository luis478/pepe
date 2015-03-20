/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.sesions;

import com.pepe.jpa.entities.TipoRevision;
import com.pepe.jpa.entities.Variable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ADSI-DESAROLLO
 */
@Stateless
public class VariableFacade extends AbstractFacade<Variable> {
    @PersistenceContext(unitName = "pepeAplicacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VariableFacade() {
        super(Variable.class);
    }
    
    public List<Variable> findByIdTipoRevision(TipoRevision tipo){
        Query q = getEntityManager().createNamedQuery("Variable.findByidTipoRevision");
        q.setParameter("idTipoRevision", tipo);
        return q.getResultList();
    }
}
