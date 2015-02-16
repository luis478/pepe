package com.pepe.jpa.entities;

import com.pepe.jpa.entities.CentroFormacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-16T16:18:41")
@StaticMetamodel(Regional.class)
public class Regional_ { 

    public static volatile ListAttribute<Regional, CentroFormacion> centroFormacionList;
    public static volatile SingularAttribute<Regional, Integer> idRegional;
    public static volatile SingularAttribute<Regional, String> codigoRegional;
    public static volatile SingularAttribute<Regional, String> nombreRegional;

}