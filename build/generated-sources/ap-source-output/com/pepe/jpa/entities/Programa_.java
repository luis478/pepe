package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Competencia;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.LineaTecnologica;
import com.pepe.jpa.entities.ModalidadFormacion;
import com.pepe.jpa.entities.NivelFormacion;
import com.pepe.jpa.entities.PerfilEntrada;
import com.pepe.jpa.entities.ProgramaPK;
import com.pepe.jpa.entities.TipoFormacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-23T14:48:03")
@StaticMetamodel(Programa.class)
public class Programa_ { 

    public static volatile ListAttribute<Programa, Competencia> competenciaList;
    public static volatile SingularAttribute<Programa, String> justificacion;
    public static volatile SingularAttribute<Programa, TipoFormacion> idTipoFormacion;
    public static volatile SingularAttribute<Programa, Short> estado;
    public static volatile SingularAttribute<Programa, ProgramaPK> programaPK;
    public static volatile SingularAttribute<Programa, ModalidadFormacion> idModalidadFormacion;
    public static volatile SingularAttribute<Programa, LineaTecnologica> idLineaTecnologica;
    public static volatile SingularAttribute<Programa, Short> duracionTrimestres;
    public static volatile SingularAttribute<Programa, PerfilEntrada> idPerfilEntrada;
    public static volatile SingularAttribute<Programa, NivelFormacion> idNivelFormacion;
    public static volatile SingularAttribute<Programa, String> nombrePrograma;
    public static volatile ListAttribute<Programa, Ficha> fichaList;

}