package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Acompañamiento;
import com.pepe.jpa.entities.CentroFormacion;
import com.pepe.jpa.entities.Evento;
import com.pepe.jpa.entities.GuiaAprendizaje;
import com.pepe.jpa.entities.Jornada;
import com.pepe.jpa.entities.Programa;
import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.entities.TipoFormacion;
import com.pepe.jpa.entities.TipoOferta;
import com.pepe.jpa.entities.Trimestre;
import com.pepe.jpa.entities.UsuarioHasFicha;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-11T23:16:19")
@StaticMetamodel(Ficha.class)
public class Ficha_ { 

    public static volatile SingularAttribute<Ficha, Integer> idFicha;
    public static volatile SingularAttribute<Ficha, String> estado;
    public static volatile ListAttribute<Ficha, Evento> eventoList;
    public static volatile SingularAttribute<Ficha, Programa> programa;
    public static volatile SingularAttribute<Ficha, TipoOferta> idTipoOferta;
    public static volatile SingularAttribute<Ficha, Integer> idPrograma;
    public static volatile ListAttribute<Ficha, Proyecto> proyectoList;
    public static volatile SingularAttribute<Ficha, TipoFormacion> idTipoFormacion;
    public static volatile ListAttribute<Ficha, GuiaAprendizaje> guiaAprendizajeList;
    public static volatile SingularAttribute<Ficha, Date> fechaInicio;
    public static volatile SingularAttribute<Ficha, CentroFormacion> idCentroFormacion;
    public static volatile SingularAttribute<Ficha, String> codigoFicha;
    public static volatile ListAttribute<Ficha, Trimestre> trimestreList;
    public static volatile SingularAttribute<Ficha, Jornada> idJornada;
    public static volatile SingularAttribute<Ficha, Short> trimestresLectiva;
    public static volatile ListAttribute<Ficha, Acompañamiento> acompañamientoList;
    public static volatile ListAttribute<Ficha, UsuarioHasFicha> usuarioHasFichaList;

}