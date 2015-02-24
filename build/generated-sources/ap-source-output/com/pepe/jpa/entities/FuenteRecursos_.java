package com.pepe.jpa.entities;

import com.pepe.jpa.entities.RecursoHasMaterial;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-24T09:27:48")
@StaticMetamodel(FuenteRecursos.class)
public class FuenteRecursos_ { 

    public static volatile SingularAttribute<FuenteRecursos, String> nombreRecursos;
    public static volatile SingularAttribute<FuenteRecursos, Integer> idFuenteRecursos;
    public static volatile ListAttribute<FuenteRecursos, RecursoHasMaterial> recursoHasMaterialList;

}