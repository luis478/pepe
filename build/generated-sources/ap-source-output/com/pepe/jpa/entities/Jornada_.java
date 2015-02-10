package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Ficha;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T11:26:52")
@StaticMetamodel(Jornada.class)
public class Jornada_ { 

    public static volatile SingularAttribute<Jornada, String> nombreJornada;
    public static volatile SingularAttribute<Jornada, Integer> idJornada;
    public static volatile ListAttribute<Jornada, Ficha> fichaList;

}