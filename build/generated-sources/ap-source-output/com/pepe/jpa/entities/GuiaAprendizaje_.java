package com.pepe.jpa.entities;

import com.pepe.jpa.entities.ActividadAprendizajeHasGuiaAprendizaje;
import com.pepe.jpa.entities.Proyecto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-24T09:27:48")
@StaticMetamodel(GuiaAprendizaje.class)
public class GuiaAprendizaje_ { 

    public static volatile SingularAttribute<GuiaAprendizaje, String> controlDocumento;
    public static volatile SingularAttribute<GuiaAprendizaje, Integer> idGuiaAprendizaje;
    public static volatile ListAttribute<GuiaAprendizaje, ActividadAprendizajeHasGuiaAprendizaje> actividadAprendizajeHasGuiaAprendizajeList;
    public static volatile SingularAttribute<GuiaAprendizaje, String> introduccion;
    public static volatile SingularAttribute<GuiaAprendizaje, String> referentesBibliograficos;
    public static volatile SingularAttribute<GuiaAprendizaje, Proyecto> idProyecto;
    public static volatile SingularAttribute<GuiaAprendizaje, String> glosarioTerminos;

}