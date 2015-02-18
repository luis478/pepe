package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Revision;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-17T17:50:58")
@StaticMetamodel(Variable.class)
public class Variable_ { 

    public static volatile SingularAttribute<Variable, String> observacion;
    public static volatile SingularAttribute<Variable, Integer> idVariable;
    public static volatile SingularAttribute<Variable, String> descripcion;
    public static volatile SingularAttribute<Variable, Revision> idRevision;
    public static volatile SingularAttribute<Variable, Short> cumple;

}