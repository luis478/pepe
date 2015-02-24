package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Patrocinio;
import com.pepe.jpa.entities.Proyecto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-24T09:27:48")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> nombreEmpresa;
    public static volatile SingularAttribute<Empresa, String> representante;
    public static volatile SingularAttribute<Empresa, Integer> idEmpresa;
    public static volatile SingularAttribute<Empresa, String> telefono;
    public static volatile ListAttribute<Empresa, Proyecto> proyectoList;
    public static volatile ListAttribute<Empresa, Patrocinio> patrocinioList;
    public static volatile SingularAttribute<Empresa, String> correo;

}