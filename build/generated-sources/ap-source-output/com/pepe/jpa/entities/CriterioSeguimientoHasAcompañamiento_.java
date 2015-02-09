package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Acompañamiento;
import com.pepe.jpa.entities.Conclusiones;
import com.pepe.jpa.entities.CriterioSeguimiento;
import com.pepe.jpa.entities.CriterioSeguimientoHasAcompañamientoPK;
import com.pepe.jpa.entities.EvidenciaEncontrada;
import com.pepe.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-09T14:58:05")
@StaticMetamodel(CriterioSeguimientoHasAcompañamiento.class)
public class CriterioSeguimientoHasAcompañamiento_ { 

    public static volatile SingularAttribute<CriterioSeguimientoHasAcompañamiento, CriterioSeguimiento> criterioSeguimiento;
    public static volatile SingularAttribute<CriterioSeguimientoHasAcompañamiento, CriterioSeguimientoHasAcompañamientoPK> criterioSeguimientoHasAcompañamientoPK;
    public static volatile SingularAttribute<CriterioSeguimientoHasAcompañamiento, Usuario> idUsuario;
    public static volatile SingularAttribute<CriterioSeguimientoHasAcompañamiento, EvidenciaEncontrada> idEvidenciaEncontrada;
    public static volatile SingularAttribute<CriterioSeguimientoHasAcompañamiento, Acompañamiento> acompañamiento;
    public static volatile SingularAttribute<CriterioSeguimientoHasAcompañamiento, Conclusiones> idConclusiones;
    public static volatile SingularAttribute<CriterioSeguimientoHasAcompañamiento, Short> cumple;

}