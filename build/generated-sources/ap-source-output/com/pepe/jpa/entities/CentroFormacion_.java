package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Ciudad;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.Regional;
import com.pepe.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-17T17:50:58")
@StaticMetamodel(CentroFormacion.class)
public class CentroFormacion_ { 

    public static volatile SingularAttribute<CentroFormacion, Ciudad> ciudad;
    public static volatile SingularAttribute<CentroFormacion, String> codigoCentroFormacion;
    public static volatile ListAttribute<CentroFormacion, Usuario> usuarioList;
    public static volatile SingularAttribute<CentroFormacion, String> nombreCentroFormacion;
    public static volatile SingularAttribute<CentroFormacion, Integer> idCentroFormacion;
    public static volatile SingularAttribute<CentroFormacion, Regional> idRegional;
    public static volatile ListAttribute<CentroFormacion, Ficha> fichaList;

}