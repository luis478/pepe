package com.pepe.jpa.entities;

import com.pepe.jpa.entities.UsuarioHasFicha;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-11T23:16:19")
@StaticMetamodel(TipoInstructor.class)
public class TipoInstructor_ { 

    public static volatile SingularAttribute<TipoInstructor, Integer> idTipoInstructor;
    public static volatile ListAttribute<TipoInstructor, UsuarioHasFicha> usuarioHasFichaList;
    public static volatile SingularAttribute<TipoInstructor, String> nombreTipoInstructor;

}