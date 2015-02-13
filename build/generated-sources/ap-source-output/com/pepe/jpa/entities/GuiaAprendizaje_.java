package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Actividad;
import com.pepe.jpa.entities.Fase;
import com.pepe.jpa.entities.GuiaAprendizajePK;
import com.pepe.jpa.entities.Proyecto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-13T18:03:49")
@StaticMetamodel(GuiaAprendizaje.class)
public class GuiaAprendizaje_ { 

    public static volatile SingularAttribute<GuiaAprendizaje, Proyecto> idProyecto;
    public static volatile ListAttribute<GuiaAprendizaje, Actividad> actividadList;
    public static volatile SingularAttribute<GuiaAprendizaje, Fase> idFase1;
    public static volatile SingularAttribute<GuiaAprendizaje, GuiaAprendizajePK> guiaAprendizajePK;
    public static volatile SingularAttribute<GuiaAprendizaje, String> guiaAprendizaje;

}