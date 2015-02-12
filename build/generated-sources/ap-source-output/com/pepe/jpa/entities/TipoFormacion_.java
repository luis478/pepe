package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.Programa;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-11T23:16:19")
@StaticMetamodel(TipoFormacion.class)
public class TipoFormacion_ { 

    public static volatile SingularAttribute<TipoFormacion, Integer> idTipoFormacion;
    public static volatile ListAttribute<TipoFormacion, Programa> programaList;
    public static volatile SingularAttribute<TipoFormacion, String> tipoFormacion;
    public static volatile ListAttribute<TipoFormacion, Ficha> fichaList;

}