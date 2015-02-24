package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Evento;
import com.pepe.jpa.entities.Recurso;
import com.pepe.jpa.entities.Verificacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-24T09:27:48")
@StaticMetamodel(AmbienteFormacion.class)
public class AmbienteFormacion_ { 

    public static volatile ListAttribute<AmbienteFormacion, Verificacion> verificacionList;
    public static volatile SingularAttribute<AmbienteFormacion, String> nombreAmbienteFormacion;
    public static volatile ListAttribute<AmbienteFormacion, Recurso> recursoList;
    public static volatile SingularAttribute<AmbienteFormacion, Integer> idAmbienteFormacion;
    public static volatile ListAttribute<AmbienteFormacion, Evento> eventoList;

}