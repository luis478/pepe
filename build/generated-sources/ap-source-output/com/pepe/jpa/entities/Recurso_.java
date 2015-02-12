package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Actividad;
import com.pepe.jpa.entities.AmbienteFormacion;
import com.pepe.jpa.entities.RecursoHasMaterial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-11T23:16:19")
@StaticMetamodel(Recurso.class)
public class Recurso_ { 

    public static volatile SingularAttribute<Recurso, Actividad> idActividad;
    public static volatile SingularAttribute<Recurso, Integer> idRecurso;
    public static volatile ListAttribute<Recurso, AmbienteFormacion> ambienteFormacionList;
    public static volatile ListAttribute<Recurso, RecursoHasMaterial> recursoHasMaterialList;

}