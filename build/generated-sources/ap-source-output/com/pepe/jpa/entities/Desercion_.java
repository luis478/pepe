package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Estado;
import com.pepe.jpa.entities.Motivo;
import com.pepe.jpa.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-17T17:50:58")
@StaticMetamodel(Desercion.class)
public class Desercion_ { 

    public static volatile SingularAttribute<Desercion, Date> fecha;
    public static volatile ListAttribute<Desercion, Usuario> usuarioList;
    public static volatile SingularAttribute<Desercion, Motivo> idMotivo;
    public static volatile SingularAttribute<Desercion, Estado> idEstado;
    public static volatile SingularAttribute<Desercion, Integer> idDesercion;
    public static volatile SingularAttribute<Desercion, String> desercion;

}