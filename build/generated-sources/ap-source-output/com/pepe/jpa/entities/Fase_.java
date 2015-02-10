package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Acompañamiento;
import com.pepe.jpa.entities.EvaluacionSeguimiento;
import com.pepe.jpa.entities.GuiaAprendizaje;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T11:26:52")
@StaticMetamodel(Fase.class)
public class Fase_ { 

    public static volatile ListAttribute<Fase, EvaluacionSeguimiento> evaluacionSeguimientoList;
    public static volatile SingularAttribute<Fase, String> fase;
    public static volatile ListAttribute<Fase, GuiaAprendizaje> guiaAprendizajeList;
    public static volatile SingularAttribute<Fase, Integer> idFase;
    public static volatile ListAttribute<Fase, Acompañamiento> acompañamientoList;

}