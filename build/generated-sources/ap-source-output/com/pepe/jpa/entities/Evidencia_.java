package com.pepe.jpa.entities;

import com.pepe.jpa.entities.ActividadAprendizaje;
import com.pepe.jpa.entities.TipoEvidencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-18T11:25:43")
@StaticMetamodel(Evidencia.class)
public class Evidencia_ { 

    public static volatile SingularAttribute<Evidencia, String> descripcionEvidencia;
    public static volatile SingularAttribute<Evidencia, TipoEvidencia> idTipoEvidencia;
    public static volatile SingularAttribute<Evidencia, Integer> idEvidencia;
    public static volatile SingularAttribute<Evidencia, String> observacionEvidencia;
    public static volatile SingularAttribute<Evidencia, String> nombreEvidencia;
    public static volatile SingularAttribute<Evidencia, ActividadAprendizaje> idActividadAprendizaje;

}