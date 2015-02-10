package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Categoria;
import com.pepe.jpa.entities.CriterioSeguimientoHasAcompañamiento;
import com.pepe.jpa.entities.Valoracion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T11:26:52")
@StaticMetamodel(CriterioSeguimiento.class)
public class CriterioSeguimiento_ { 

    public static volatile SingularAttribute<CriterioSeguimiento, Valoracion> idValoracion;
    public static volatile SingularAttribute<CriterioSeguimiento, String> descrpcion;
    public static volatile SingularAttribute<CriterioSeguimiento, Integer> idCriterioSeguimiento;
    public static volatile ListAttribute<CriterioSeguimiento, CriterioSeguimientoHasAcompañamiento> criterioSeguimientoHasAcompañamientoList;
    public static volatile SingularAttribute<CriterioSeguimiento, Categoria> idCategoria;

}