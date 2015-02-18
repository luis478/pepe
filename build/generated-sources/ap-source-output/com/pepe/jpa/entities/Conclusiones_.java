package com.pepe.jpa.entities;

import com.pepe.jpa.entities.CriterioSeguimientoHasAcompanamiento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-18T11:25:43")
@StaticMetamodel(Conclusiones.class)
public class Conclusiones_ { 

    public static volatile SingularAttribute<Conclusiones, Integer> idConclusiones;
    public static volatile SingularAttribute<Conclusiones, String> descripcion;
    public static volatile ListAttribute<Conclusiones, CriterioSeguimientoHasAcompanamiento> criterioSeguimientoHasAcompanamientoList;

}