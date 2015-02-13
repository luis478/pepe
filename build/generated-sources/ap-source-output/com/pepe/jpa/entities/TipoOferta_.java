package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Ficha;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-13T18:03:49")
@StaticMetamodel(TipoOferta.class)
public class TipoOferta_ { 

    public static volatile SingularAttribute<TipoOferta, Integer> idTipoOferta;
    public static volatile ListAttribute<TipoOferta, Ficha> fichaList;
    public static volatile SingularAttribute<TipoOferta, String> tipoOferta;

}