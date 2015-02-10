package com.pepe.jpa.entities;

import com.pepe.jpa.entities.CriterioSeguimiento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T11:26:52")
@StaticMetamodel(Valoracion.class)
public class Valoracion_ { 

    public static volatile SingularAttribute<Valoracion, Integer> idValoracion;
    public static volatile ListAttribute<Valoracion, CriterioSeguimiento> criterioSeguimientoList;
    public static volatile SingularAttribute<Valoracion, String> nombre;

}