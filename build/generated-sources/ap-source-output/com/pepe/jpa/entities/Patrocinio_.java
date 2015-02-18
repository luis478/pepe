package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Empresa;
import com.pepe.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-18T11:25:43")
@StaticMetamodel(Patrocinio.class)
public class Patrocinio_ { 

    public static volatile SingularAttribute<Patrocinio, Empresa> idEmpresa;
    public static volatile ListAttribute<Patrocinio, Usuario> usuarioList;
    public static volatile SingularAttribute<Patrocinio, Integer> idPatrocinio;
    public static volatile SingularAttribute<Patrocinio, String> patrocinio;

}