package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Actividad;
import com.pepe.jpa.entities.ActividadAprendizajeHasResultadoAprendizaje;
import com.pepe.jpa.entities.Competencia;
import com.pepe.jpa.entities.Evento;
import com.pepe.jpa.entities.TipoResultadoAprendizaje;
import com.pepe.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-16T13:59:22")
@StaticMetamodel(ResultadoAprendizaje.class)
public class ResultadoAprendizaje_ { 

    public static volatile SingularAttribute<ResultadoAprendizaje, Integer> idResultadoAprendizaje;
    public static volatile SingularAttribute<ResultadoAprendizaje, Short> estado;
    public static volatile ListAttribute<ResultadoAprendizaje, Actividad> actividadList;
    public static volatile SingularAttribute<ResultadoAprendizaje, TipoResultadoAprendizaje> idTipoResultadoAprendizaje;
    public static volatile SingularAttribute<ResultadoAprendizaje, Usuario> idUsuario;
    public static volatile ListAttribute<ResultadoAprendizaje, Evento> eventoList;
    public static volatile ListAttribute<ResultadoAprendizaje, ActividadAprendizajeHasResultadoAprendizaje> actividadAprendizajeHasResultadoAprendizajeList;
    public static volatile SingularAttribute<ResultadoAprendizaje, String> nombreResultadoAprendizaje;
    public static volatile SingularAttribute<ResultadoAprendizaje, Competencia> idCompetencia;

}