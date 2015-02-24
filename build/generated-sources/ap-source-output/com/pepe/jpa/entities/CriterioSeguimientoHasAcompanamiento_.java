package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Acompanamiento;
import com.pepe.jpa.entities.Conclusiones;
import com.pepe.jpa.entities.CriterioSeguimiento;
import com.pepe.jpa.entities.CriterioSeguimientoHasAcompanamientoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-23T14:48:03")
@StaticMetamodel(CriterioSeguimientoHasAcompanamiento.class)
public class CriterioSeguimientoHasAcompanamiento_ { 

    public static volatile SingularAttribute<CriterioSeguimientoHasAcompanamiento, CriterioSeguimientoHasAcompanamientoPK> criterioSeguimientoHasAcompanamientoPK;
    public static volatile SingularAttribute<CriterioSeguimientoHasAcompanamiento, String> observacion;
    public static volatile SingularAttribute<CriterioSeguimientoHasAcompanamiento, String> valoracion;
    public static volatile SingularAttribute<CriterioSeguimientoHasAcompanamiento, Conclusiones> idConclusiones;
    public static volatile SingularAttribute<CriterioSeguimientoHasAcompanamiento, CriterioSeguimiento> criterioSeguimiento;
    public static volatile SingularAttribute<CriterioSeguimientoHasAcompanamiento, Acompanamiento> acompanamiento;

}