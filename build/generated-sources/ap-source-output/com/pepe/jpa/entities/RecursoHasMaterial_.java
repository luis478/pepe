package com.pepe.jpa.entities;

import com.pepe.jpa.entities.FuenteRecursos;
import com.pepe.jpa.entities.Material;
import com.pepe.jpa.entities.Recurso;
import com.pepe.jpa.entities.RecursoHasMaterialPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-09T14:58:06")
@StaticMetamodel(RecursoHasMaterial.class)
public class RecursoHasMaterial_ { 

    public static volatile SingularAttribute<RecursoHasMaterial, Recurso> recurso;
    public static volatile SingularAttribute<RecursoHasMaterial, FuenteRecursos> idFuenteRecursos;
    public static volatile SingularAttribute<RecursoHasMaterial, Material> material;
    public static volatile SingularAttribute<RecursoHasMaterial, RecursoHasMaterialPK> recursoHasMaterialPK;

}