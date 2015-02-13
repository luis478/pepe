package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Programa;
import com.pepe.jpa.entities.RedTecnologica;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-13T16:43:57")
@StaticMetamodel(LineaTecnologica.class)
public class LineaTecnologica_ { 

    public static volatile SingularAttribute<LineaTecnologica, RedTecnologica> idRedTecnologica;
    public static volatile ListAttribute<LineaTecnologica, Programa> programaList;
    public static volatile SingularAttribute<LineaTecnologica, Integer> idLineaTecnologica;
    public static volatile SingularAttribute<LineaTecnologica, String> nombreLineaTecnologica;

}