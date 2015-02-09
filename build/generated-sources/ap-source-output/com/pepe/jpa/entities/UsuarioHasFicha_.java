package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.TipoInstructor;
import com.pepe.jpa.entities.Usuario;
import com.pepe.jpa.entities.UsuarioHasFichaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-09T14:58:05")
@StaticMetamodel(UsuarioHasFicha.class)
public class UsuarioHasFicha_ { 

    public static volatile SingularAttribute<UsuarioHasFicha, UsuarioHasFichaPK> usuarioHasFichaPK;
    public static volatile SingularAttribute<UsuarioHasFicha, Ficha> ficha;
    public static volatile SingularAttribute<UsuarioHasFicha, TipoInstructor> tipoInstructor;
    public static volatile SingularAttribute<UsuarioHasFicha, Usuario> usuario;

}