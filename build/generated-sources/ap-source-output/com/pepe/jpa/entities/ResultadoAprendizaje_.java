package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Actividad;
import com.pepe.jpa.entities.ActividadAprendizajeHasResultadoAprendizaje;
import com.pepe.jpa.entities.Competencia;
import com.pepe.jpa.entities.TipoResultadoAprendizaje;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-13T16:43:57")
@StaticMetamodel(ResultadoAprendizaje.class)
public class ResultadoAprendizaje_ { 

    public static volatile SingularAttribute<ResultadoAprendizaje, Integer> idResultadoAprendizaje;
    public static volatile SingularAttribute<ResultadoAprendizaje, Short> estado;
    public static volatile ListAttribute<ResultadoAprendizaje, Actividad> actividadList;
    public static volatile SingularAttribute<ResultadoAprendizaje, TipoResultadoAprendizaje> idTipoResultadoAprendizaje;
    public static volatile ListAttribute<ResultadoAprendizaje, ActividadAprendizajeHasResultadoAprendizaje> actividadAprendizajeHasResultadoAprendizajeList;
    public static volatile SingularAttribute<ResultadoAprendizaje, String> nombreResultadoAprendizaje;
    public static volatile SingularAttribute<ResultadoAprendizaje, Competencia> idCompetencia;

}