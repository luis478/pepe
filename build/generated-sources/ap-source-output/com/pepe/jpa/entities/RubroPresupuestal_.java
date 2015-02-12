package com.pepe.jpa.entities;

import com.pepe.jpa.entities.TipoMaterialHasRubroPresupuestal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-11T23:16:19")
@StaticMetamodel(RubroPresupuestal.class)
public class RubroPresupuestal_ { 

    public static volatile SingularAttribute<RubroPresupuestal, Integer> idrubroPresupuestal;
    public static volatile SingularAttribute<RubroPresupuestal, String> nombreRubroPresupuestal;
    public static volatile ListAttribute<RubroPresupuestal, TipoMaterialHasRubroPresupuestal> tipoMaterialHasRubroPresupuestalList;

}