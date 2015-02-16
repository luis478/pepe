package com.pepe.jpa.entities;

import com.pepe.jpa.entities.RecursoHasMaterial;
import com.pepe.jpa.entities.TipoMaterial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-16T16:18:41")
@StaticMetamodel(Material.class)
public class Material_ { 

    public static volatile SingularAttribute<Material, String> codigoOrions;
    public static volatile SingularAttribute<Material, Integer> idMaterial;
    public static volatile SingularAttribute<Material, Integer> cantidad;
    public static volatile SingularAttribute<Material, String> nombre;
    public static volatile ListAttribute<Material, RecursoHasMaterial> recursoHasMaterialList;
    public static volatile SingularAttribute<Material, Double> valorUnitario;
    public static volatile SingularAttribute<Material, TipoMaterial> idTipoMaterial;

}