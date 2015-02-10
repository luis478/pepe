package com.pepe.jpa.entities;

import com.pepe.jpa.entities.ActividadAprendizaje;
import com.pepe.jpa.entities.AmbienteFormacion;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.Trimestre;
import com.pepe.jpa.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T11:26:52")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile SingularAttribute<Evento, Ficha> idFicha;
    public static volatile ListAttribute<Evento, Usuario> usuarioList;
    public static volatile SingularAttribute<Evento, Date> fechaInicio;
    public static volatile SingularAttribute<Evento, Integer> idEvento;
    public static volatile ListAttribute<Evento, Trimestre> trimestreList;
    public static volatile SingularAttribute<Evento, ActividadAprendizaje> idActividadAprendizaje;
    public static volatile SingularAttribute<Evento, Date> fechaFin;
    public static volatile SingularAttribute<Evento, AmbienteFormacion> idAmbienteFormacion;

}