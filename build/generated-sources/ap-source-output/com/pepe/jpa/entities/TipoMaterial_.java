package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Material;
import com.pepe.jpa.entities.TipoMaterialHasRubroPresupuestal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-17T17:50:58")
@StaticMetamodel(TipoMaterial.class)
public class TipoMaterial_ { 

    public static volatile SingularAttribute<TipoMaterial, String> nombreTipoMaterial;
    public static volatile SingularAttribute<TipoMaterial, Integer> idTipoMaterial;
    public static volatile ListAttribute<TipoMaterial, Material> materialList;
    public static volatile ListAttribute<TipoMaterial, TipoMaterialHasRubroPresupuestal> tipoMaterialHasRubroPresupuestalList;

}