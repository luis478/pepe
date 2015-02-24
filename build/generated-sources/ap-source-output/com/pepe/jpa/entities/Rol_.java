package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-24T09:27:48")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile CollectionAttribute<Rol, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Rol, String> nombreRol;
    public static volatile ListAttribute<Rol, Usuario> usuarioList;
    public static volatile SingularAttribute<Rol, String> codigoRol;
    public static volatile SingularAttribute<Rol, Integer> idRol;

}