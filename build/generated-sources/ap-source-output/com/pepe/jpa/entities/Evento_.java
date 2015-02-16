package com.pepe.jpa.entities;

import com.pepe.jpa.entities.ActividadAprendizajeHasResultadoAprendizaje;
import com.pepe.jpa.entities.AmbienteFormacion;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.ResultadoAprendizaje;
import com.pepe.jpa.entities.Trimestre;
import com.pepe.jpa.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-16T16:18:42")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile SingularAttribute<Evento, Ficha> idFicha;
    public static volatile ListAttribute<Evento, Usuario> usuarioList;
    public static volatile SingularAttribute<Evento, Date> fechaInicio;
    public static volatile SingularAttribute<Evento, Integer> idEvento;
    public static volatile ListAttribute<Evento, Trimestre> trimestreList;
    public static volatile ListAttribute<Evento, ResultadoAprendizaje> resultadoAprendizajeList;
    public static volatile SingularAttribute<Evento, Date> fechaFin;
    public static volatile SingularAttribute<Evento, AmbienteFormacion> idAmbienteFormacion;
    public static volatile SingularAttribute<Evento, ActividadAprendizajeHasResultadoAprendizaje> actividadAprendizajeHasResultadoAprendizaje;

}