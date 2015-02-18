package com.pepe.jpa.entities;

import com.pepe.jpa.entities.AspectosPK;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-17T17:50:58")
@StaticMetamodel(Aspectos.class)
public class Aspectos_ { 

    public static volatile SingularAttribute<Aspectos, Ficha> ficha;
    public static volatile ListAttribute<Aspectos, Usuario> usuarioList;
    public static volatile SingularAttribute<Aspectos, String> descripcion;
    public static volatile SingularAttribute<Aspectos, AspectosPK> aspectosPK;
    public static volatile SingularAttribute<Aspectos, String> observacionesAspectos;
    public static volatile SingularAttribute<Aspectos, Short> cumple;

}