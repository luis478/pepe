package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Acompanamiento;
import com.pepe.jpa.entities.ActividadHasResultadoAprendizaje;
import com.pepe.jpa.entities.EvaluacionSeguimiento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-24T09:27:48")
@StaticMetamodel(Fase.class)
public class Fase_ { 

    public static volatile SingularAttribute<Fase, Integer> idFase;
    public static volatile ListAttribute<Fase, ActividadHasResultadoAprendizaje> actividadHasResultadoAprendizajeList;
    public static volatile ListAttribute<Fase, EvaluacionSeguimiento> evaluacionSeguimientoList;
    public static volatile SingularAttribute<Fase, String> fase;
    public static volatile ListAttribute<Fase, Acompanamiento> acompanamientoList;

}