package com.pepe.jpa.entities;

import com.pepe.jpa.entities.AmbienteFormacion;
import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-16T13:59:22")
@StaticMetamodel(Verificacion.class)
public class Verificacion_ { 

    public static volatile SingularAttribute<Verificacion, String> descripcion;
    public static volatile SingularAttribute<Verificacion, Proyecto> idProyecto;
    public static volatile SingularAttribute<Verificacion, String> obervaciones;
    public static volatile SingularAttribute<Verificacion, Usuario> idUsuario;
    public static volatile SingularAttribute<Verificacion, Integer> idVerificacion;
    public static volatile SingularAttribute<Verificacion, Short> cumple;
    public static volatile SingularAttribute<Verificacion, AmbienteFormacion> idAmbienteFormacion;

}