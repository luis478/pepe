package com.pepe.jpa.entities;

import com.pepe.jpa.entities.CriterioSeguimientoHasAcompanamiento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-17T17:50:58")
@StaticMetamodel(CriterioSeguimiento.class)
public class CriterioSeguimiento_ { 

    public static volatile SingularAttribute<CriterioSeguimiento, Integer> idCategoria;
    public static volatile SingularAttribute<CriterioSeguimiento, Integer> idCriterioSeguimiento;
    public static volatile SingularAttribute<CriterioSeguimiento, String> descrpcion;
    public static volatile ListAttribute<CriterioSeguimiento, CriterioSeguimientoHasAcompanamiento> criterioSeguimientoHasAcompanamientoList;

}