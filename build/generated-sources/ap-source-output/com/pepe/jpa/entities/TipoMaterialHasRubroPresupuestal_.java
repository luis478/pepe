package com.pepe.jpa.entities;

import com.pepe.jpa.entities.RubroPresupuestal;
import com.pepe.jpa.entities.TipoMaterial;
import com.pepe.jpa.entities.TipoMaterialHasRubroPresupuestalPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-24T09:01:04")
@StaticMetamodel(TipoMaterialHasRubroPresupuestal.class)
public class TipoMaterialHasRubroPresupuestal_ { 

    public static volatile SingularAttribute<TipoMaterialHasRubroPresupuestal, RubroPresupuestal> rubroPresupuestal;
    public static volatile SingularAttribute<TipoMaterialHasRubroPresupuestal, TipoMaterial> tipoMaterial;
    public static volatile SingularAttribute<TipoMaterialHasRubroPresupuestal, String> valorTotal;
    public static volatile SingularAttribute<TipoMaterialHasRubroPresupuestal, TipoMaterialHasRubroPresupuestalPK> tipoMaterialHasRubroPresupuestalPK;

}