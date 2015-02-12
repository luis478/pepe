package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Competencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-11T23:16:19")
@StaticMetamodel(ConocimientoProceso.class)
public class ConocimientoProceso_ { 

    public static volatile SingularAttribute<ConocimientoProceso, Short> estado;
    public static volatile SingularAttribute<ConocimientoProceso, Integer> idConocimientoProceso;
    public static volatile SingularAttribute<ConocimientoProceso, String> nombreConocimientoProceso;
    public static volatile SingularAttribute<ConocimientoProceso, Competencia> idCompetencia;

}