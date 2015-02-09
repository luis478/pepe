package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-09T14:58:06")
@StaticMetamodel(Caracterizacion.class)
public class Caracterizacion_ { 

    public static volatile SingularAttribute<Caracterizacion, String> apoyoBienestar;
    public static volatile ListAttribute<Caracterizacion, Usuario> usuarioList;
    public static volatile SingularAttribute<Caracterizacion, String> acudiente;
    public static volatile SingularAttribute<Caracterizacion, String> direccion;
    public static volatile SingularAttribute<Caracterizacion, Integer> idCaracterizacion;
    public static volatile SingularAttribute<Caracterizacion, String> sistemaLidereazgo;
    public static volatile SingularAttribute<Caracterizacion, String> telefono;

}