package com.pepe.jpa.entities;

import com.pepe.jpa.entities.AmbienteFormacion;
import com.pepe.jpa.entities.CriterioSeguimientoHasAcompañamiento;
import com.pepe.jpa.entities.Fase;
import com.pepe.jpa.entities.Ficha;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-09T14:58:05")
@StaticMetamodel(Acompañamiento.class)
public class Acompañamiento_ { 

    public static volatile SingularAttribute<Acompañamiento, Date> fachaFin;
    public static volatile SingularAttribute<Acompañamiento, Ficha> idFicha;
    public static volatile SingularAttribute<Acompañamiento, Date> fechaInicio;
    public static volatile SingularAttribute<Acompañamiento, Integer> idAcompañamiento;
    public static volatile ListAttribute<Acompañamiento, CriterioSeguimientoHasAcompañamiento> criterioSeguimientoHasAcompañamientoList;
    public static volatile SingularAttribute<Acompañamiento, Fase> idFase;
    public static volatile SingularAttribute<Acompañamiento, AmbienteFormacion> idAmbienteFormacion;

}