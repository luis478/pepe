package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Actividad;
import com.pepe.jpa.entities.Evento;
import com.pepe.jpa.entities.Evidencia;
import com.pepe.jpa.entities.ResultadoAprendizaje;
import com.pepe.jpa.entities.TecnicaDidactica;
import com.pepe.jpa.entities.TipoActividadAprendizaje;
import com.pepe.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-10T11:26:52")
@StaticMetamodel(ActividadAprendizaje.class)
public class ActividadAprendizaje_ { 

    public static volatile SingularAttribute<ActividadAprendizaje, String> nombreActividadAprendizaje;
    public static volatile ListAttribute<ActividadAprendizaje, Usuario> usuarioList;
    public static volatile SingularAttribute<ActividadAprendizaje, Actividad> idActividad;
    public static volatile SingularAttribute<ActividadAprendizaje, Integer> duracionActividadAprendizaje;
    public static volatile ListAttribute<ActividadAprendizaje, Evidencia> evidenciaList;
    public static volatile SingularAttribute<ActividadAprendizaje, String> observaciones;
    public static volatile ListAttribute<ActividadAprendizaje, Evento> eventoList;
    public static volatile SingularAttribute<ActividadAprendizaje, Integer> idActividadAprendizaje;
    public static volatile SingularAttribute<ActividadAprendizaje, TipoActividadAprendizaje> idTipoActividadAprendizaje;
    public static volatile ListAttribute<ActividadAprendizaje, ResultadoAprendizaje> resultadoAprendizajeList;
    public static volatile SingularAttribute<ActividadAprendizaje, TecnicaDidactica> idTecnicaDidactica;

}