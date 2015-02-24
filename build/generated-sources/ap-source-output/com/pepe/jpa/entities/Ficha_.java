package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Acompanamiento;
import com.pepe.jpa.entities.Aspectos;
import com.pepe.jpa.entities.CentroFormacion;
import com.pepe.jpa.entities.Evento;
import com.pepe.jpa.entities.Jornada;
import com.pepe.jpa.entities.Programa;
import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.entities.TipoFormacion;
import com.pepe.jpa.entities.TipoOferta;
import com.pepe.jpa.entities.Trimestre;
import com.pepe.jpa.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-23T14:48:02")
@StaticMetamodel(Ficha.class)
public class Ficha_ { 

    public static volatile SingularAttribute<Ficha, TipoFormacion> idTipoFormacion;
    public static volatile SingularAttribute<Ficha, Jornada> idJornada;
    public static volatile SingularAttribute<Ficha, Proyecto> idProyecto;
    public static volatile SingularAttribute<Ficha, Short> trimestresLectiva;
    public static volatile ListAttribute<Ficha, Evento> eventoList;
    public static volatile ListAttribute<Ficha, Aspectos> aspectosList;
    public static volatile SingularAttribute<Ficha, CentroFormacion> idCentroFormacion;
    public static volatile SingularAttribute<Ficha, Programa> programa;
    public static volatile SingularAttribute<Ficha, Short> estado;
    public static volatile SingularAttribute<Ficha, TipoOferta> idTipoOferta;
    public static volatile SingularAttribute<Ficha, Integer> idFicha;
    public static volatile ListAttribute<Ficha, Usuario> usuarioList;
    public static volatile SingularAttribute<Ficha, String> codigoFicha;
    public static volatile ListAttribute<Ficha, Acompanamiento> acompanamientoList;
    public static volatile SingularAttribute<Ficha, Date> fechaInicio;
    public static volatile ListAttribute<Ficha, Trimestre> trimestreList;

}