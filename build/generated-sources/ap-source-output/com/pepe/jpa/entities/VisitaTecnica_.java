package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Ciudad;
import com.pepe.jpa.entities.Proyecto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-13T18:03:49")
@StaticMetamodel(VisitaTecnica.class)
public class VisitaTecnica_ { 

    public static volatile SingularAttribute<VisitaTecnica, String> fecha;
    public static volatile SingularAttribute<VisitaTecnica, Proyecto> idProyecto;
    public static volatile SingularAttribute<VisitaTecnica, String> ciudad;
    public static volatile SingularAttribute<VisitaTecnica, Integer> idVisitaTecnica;
    public static volatile SingularAttribute<VisitaTecnica, Ciudad> ciudad1;
    public static volatile SingularAttribute<VisitaTecnica, String> nombre;

}