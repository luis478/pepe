package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Evento;
import com.pepe.jpa.entities.Ficha;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-11T23:16:19")
@StaticMetamodel(Trimestre.class)
public class Trimestre_ { 

    public static volatile SingularAttribute<Trimestre, Date> fechaInicio;
    public static volatile SingularAttribute<Trimestre, Integer> idTrimestre;
    public static volatile ListAttribute<Trimestre, Evento> eventoList;
    public static volatile ListAttribute<Trimestre, Ficha> fichaList;
    public static volatile SingularAttribute<Trimestre, Date> fechaFin;

}