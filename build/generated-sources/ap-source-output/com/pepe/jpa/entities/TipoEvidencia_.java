package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Evidencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-17T17:50:58")
@StaticMetamodel(TipoEvidencia.class)
public class TipoEvidencia_ { 

    public static volatile SingularAttribute<TipoEvidencia, Integer> idTipoEvidencia;
    public static volatile SingularAttribute<TipoEvidencia, String> tipoEvidencia;
    public static volatile ListAttribute<TipoEvidencia, Evidencia> evidenciaList;

}