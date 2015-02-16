package com.pepe.jpa.entities;

import com.pepe.jpa.entities.ActividadAprendizaje;
import com.pepe.jpa.entities.GuiaAprendizaje;
import com.pepe.jpa.entities.Recurso;
import com.pepe.jpa.entities.ResultadoAprendizaje;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-16T16:18:41")
@StaticMetamodel(Actividad.class)
public class Actividad_ { 

    public static volatile SingularAttribute<Actividad, Integer> idProyecto;
    public static volatile ListAttribute<Actividad, Recurso> recursoList;
    public static volatile SingularAttribute<Actividad, Integer> idActividad;
    public static volatile SingularAttribute<Actividad, String> nombreActividad;
    public static volatile SingularAttribute<Actividad, Integer> duracion;
    public static volatile ListAttribute<Actividad, ActividadAprendizaje> actividadAprendizajeList;
    public static volatile SingularAttribute<Actividad, GuiaAprendizaje> guiaAprendizaje;
    public static volatile ListAttribute<Actividad, ResultadoAprendizaje> resultadoAprendizajeList;

}