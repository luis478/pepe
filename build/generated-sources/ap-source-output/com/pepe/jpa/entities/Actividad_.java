package com.pepe.jpa.entities;

import com.pepe.jpa.entities.ActividadAprendizaje;
import com.pepe.jpa.entities.ActividadHasResultadoAprendizaje;
import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.entities.Recurso;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-24T09:27:48")
@StaticMetamodel(Actividad.class)
public class Actividad_ { 

    public static volatile SingularAttribute<Actividad, Integer> idFase;
    public static volatile ListAttribute<Actividad, ActividadHasResultadoAprendizaje> actividadHasResultadoAprendizajeList;
    public static volatile ListAttribute<Actividad, Recurso> recursoList;
    public static volatile SingularAttribute<Actividad, Proyecto> idProyecto;
    public static volatile SingularAttribute<Actividad, String> nombreActividad;
    public static volatile ListAttribute<Actividad, ActividadAprendizaje> actividadAprendizajeList;
    public static volatile SingularAttribute<Actividad, Integer> idActividad;
    public static volatile SingularAttribute<Actividad, Integer> duracion;

}