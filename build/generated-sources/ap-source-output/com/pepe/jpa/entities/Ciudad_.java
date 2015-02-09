package com.pepe.jpa.entities;

import com.pepe.jpa.entities.CentroFormacion;
import com.pepe.jpa.entities.CiudadPK;
import com.pepe.jpa.entities.Departamento;
import com.pepe.jpa.entities.Usuario;
import com.pepe.jpa.entities.VisitaTecnica;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-09T14:58:05")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile ListAttribute<Ciudad, CentroFormacion> centroFormacionList;
    public static volatile ListAttribute<Ciudad, Usuario> usuarioList;
    public static volatile SingularAttribute<Ciudad, String> nombreCiudad;
    public static volatile SingularAttribute<Ciudad, Departamento> departamento;
    public static volatile SingularAttribute<Ciudad, CiudadPK> ciudadPK;
    public static volatile ListAttribute<Ciudad, VisitaTecnica> visitaTecnicaList;

}