package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Departamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-24T09:27:48")
@StaticMetamodel(Paises.class)
public class Paises_ { 

    public static volatile SingularAttribute<Paises, String> nombrePais;
    public static volatile SingularAttribute<Paises, String> idPaises;
    public static volatile ListAttribute<Paises, Departamento> departamentoList;

}