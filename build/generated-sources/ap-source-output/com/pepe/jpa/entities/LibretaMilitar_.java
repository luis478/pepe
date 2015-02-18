package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-18T11:25:43")
@StaticMetamodel(LibretaMilitar.class)
public class LibretaMilitar_ { 

    public static volatile SingularAttribute<LibretaMilitar, Integer> idLibretaMilitar;
    public static volatile SingularAttribute<LibretaMilitar, String> nombreLibretaMilitar;
    public static volatile ListAttribute<LibretaMilitar, Usuario> usuarioList;

}