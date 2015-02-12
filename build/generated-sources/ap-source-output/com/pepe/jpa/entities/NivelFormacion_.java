package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Programa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-11T23:16:19")
@StaticMetamodel(NivelFormacion.class)
public class NivelFormacion_ { 

    public static volatile SingularAttribute<NivelFormacion, Integer> idNivelFormacion;
    public static volatile ListAttribute<NivelFormacion, Programa> programaList;
    public static volatile SingularAttribute<NivelFormacion, String> nivelFormacion;

}