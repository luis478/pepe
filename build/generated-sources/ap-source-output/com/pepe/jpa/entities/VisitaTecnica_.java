package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Ciudad;
import com.pepe.jpa.entities.Proyecto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-24T09:27:48")
@StaticMetamodel(VisitaTecnica.class)
public class VisitaTecnica_ { 

    public static volatile SingularAttribute<VisitaTecnica, String> nombre;
    public static volatile SingularAttribute<VisitaTecnica, Ciudad> ciudad;
    public static volatile SingularAttribute<VisitaTecnica, Integer> idVisitaTecnica;
    public static volatile SingularAttribute<VisitaTecnica, Date> fecha;
    public static volatile SingularAttribute<VisitaTecnica, Proyecto> idProyecto;

}