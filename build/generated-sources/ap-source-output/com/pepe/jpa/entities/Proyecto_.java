package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Empresa;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.GuiaAprendizaje;
import com.pepe.jpa.entities.Revision;
import com.pepe.jpa.entities.Verificacion;
import com.pepe.jpa.entities.VisitaTecnica;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-18T11:25:43")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, Short> innovacion262;
    public static volatile SingularAttribute<Proyecto, Short> innovacion263;
    public static volatile SingularAttribute<Proyecto, Short> innovacion264;
    public static volatile SingularAttribute<Proyecto, Short> innovacion265;
    public static volatile SingularAttribute<Proyecto, Integer> idProyecto;
    public static volatile SingularAttribute<Proyecto, String> productosResultados254;
    public static volatile SingularAttribute<Proyecto, String> innovacion261;
    public static volatile SingularAttribute<Proyecto, String> justificacion22;
    public static volatile ListAttribute<Proyecto, Ficha> fichaList;
    public static volatile SingularAttribute<Proyecto, String> restricciones253;
    public static volatile SingularAttribute<Proyecto, Short> valoracion271;
    public static volatile SingularAttribute<Proyecto, Short> valoracion272;
    public static volatile SingularAttribute<Proyecto, Integer> intructoresRequeridos;
    public static volatile ListAttribute<Proyecto, Revision> revisionList;
    public static volatile SingularAttribute<Proyecto, String> palabrasClave17;
    public static volatile SingularAttribute<Proyecto, String> objetivoGeneral23;
    public static volatile SingularAttribute<Proyecto, String> impacto252;
    public static volatile SingularAttribute<Proyecto, String> codigoProyecto;
    public static volatile SingularAttribute<Proyecto, String> descripcionAmbiente;
    public static volatile SingularAttribute<Proyecto, String> planteamiento21;
    public static volatile SingularAttribute<Proyecto, Integer> aprendicesSugeridos;
    public static volatile SingularAttribute<Proyecto, String> nombreProyecto;
    public static volatile ListAttribute<Proyecto, GuiaAprendizaje> guiaAprendizajeList;
    public static volatile ListAttribute<Proyecto, Verificacion> verificacionList;
    public static volatile ListAttribute<Proyecto, Empresa> empresaList;
    public static volatile ListAttribute<Proyecto, VisitaTecnica> visitaTecnicaList;
    public static volatile SingularAttribute<Proyecto, String> objetivoEspecifico24;

}