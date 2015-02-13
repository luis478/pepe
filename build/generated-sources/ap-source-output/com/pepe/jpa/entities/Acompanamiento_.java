package com.pepe.jpa.entities;

import com.pepe.jpa.entities.CriterioSeguimientoHasAcompanamiento;
import com.pepe.jpa.entities.Fase;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-13T18:03:49")
@StaticMetamodel(Acompanamiento.class)
public class Acompanamiento_ { 

    public static volatile SingularAttribute<Acompanamiento, Date> fachaFin;
    public static volatile SingularAttribute<Acompanamiento, Ficha> idFicha;
    public static volatile ListAttribute<Acompanamiento, Usuario> usuarioList;
    public static volatile ListAttribute<Acompanamiento, CriterioSeguimientoHasAcompanamiento> criterioSeguimientoHasAcompanamientoList;
    public static volatile SingularAttribute<Acompanamiento, Date> fechaInicio;
    public static volatile SingularAttribute<Acompanamiento, Fase> idFase;
    public static volatile SingularAttribute<Acompanamiento, Integer> idAcompanamiento;

}