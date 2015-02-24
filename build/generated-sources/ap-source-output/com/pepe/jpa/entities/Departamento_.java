package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Ciudad;
import com.pepe.jpa.entities.Paises;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-23T14:48:02")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, Integer> idDepartamento;
    public static volatile ListAttribute<Departamento, Ciudad> ciudadList;
    public static volatile SingularAttribute<Departamento, Paises> idPaises;
    public static volatile SingularAttribute<Departamento, String> nombreDepartamento;

}