package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.entities.Usuario;
import com.pepe.jpa.entities.Variable;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-24T09:27:48")
@StaticMetamodel(Revision.class)
public class Revision_ { 

    public static volatile SingularAttribute<Revision, String> concepto;
    public static volatile ListAttribute<Revision, Usuario> usuarioList;
    public static volatile SingularAttribute<Revision, Proyecto> idProyecto;
    public static volatile SingularAttribute<Revision, Integer> idRevision;
    public static volatile ListAttribute<Revision, Variable> variableList;

}