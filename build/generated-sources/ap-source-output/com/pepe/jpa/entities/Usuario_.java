package com.pepe.jpa.entities;

import com.pepe.jpa.entities.Acompanamiento;
import com.pepe.jpa.entities.ActividadAprendizaje;
import com.pepe.jpa.entities.Area;
import com.pepe.jpa.entities.Aspectos;
import com.pepe.jpa.entities.Caracterizacion;
import com.pepe.jpa.entities.CentroFormacion;
import com.pepe.jpa.entities.Ciudad;
import com.pepe.jpa.entities.Desercion;
import com.pepe.jpa.entities.Eps;
import com.pepe.jpa.entities.Especialidad;
import com.pepe.jpa.entities.EstiloAprendizaje;
import com.pepe.jpa.entities.Evento;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.Genero;
import com.pepe.jpa.entities.LibretaMilitar;
import com.pepe.jpa.entities.Patrocinio;
import com.pepe.jpa.entities.ResultadoAprendizaje;
import com.pepe.jpa.entities.Revision;
import com.pepe.jpa.entities.Rol;
import com.pepe.jpa.entities.TipoDocumento;
import com.pepe.jpa.entities.TipoInstructor;
import com.pepe.jpa.entities.TipoSangre;
import com.pepe.jpa.entities.TipoVocero;
import com.pepe.jpa.entities.Verificacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-02-13T18:03:49")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Short> estado;
    public static volatile SingularAttribute<Usuario, TipoInstructor> idTipoInstructor;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, Caracterizacion> idCaracterizacion;
    public static volatile ListAttribute<Usuario, ActividadAprendizaje> actividadAprendizajeList;
    public static volatile ListAttribute<Usuario, Rol> rolList;
    public static volatile SingularAttribute<Usuario, String> nombre2;
    public static volatile SingularAttribute<Usuario, String> nombre1;
    public static volatile ListAttribute<Usuario, Aspectos> aspectosList;
    public static volatile ListAttribute<Usuario, CentroFormacion> centroFormacionList;
    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, Desercion> idDesercion;
    public static volatile SingularAttribute<Usuario, TipoDocumento> idTipoDocumento;
    public static volatile SingularAttribute<Usuario, LibretaMilitar> idLibretaMilitar;
    public static volatile SingularAttribute<Usuario, String> telefono2;
    public static volatile SingularAttribute<Usuario, String> numeroDocumento;
    public static volatile SingularAttribute<Usuario, String> telefono3;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile ListAttribute<Usuario, Verificacion> verificacionList;
    public static volatile SingularAttribute<Usuario, String> apellido2;
    public static volatile SingularAttribute<Usuario, String> apellido1;
    public static volatile SingularAttribute<Usuario, EstiloAprendizaje> idEstiloAprendizaje;
    public static volatile ListAttribute<Usuario, Area> areaList;
    public static volatile SingularAttribute<Usuario, TipoVocero> idTipoVocero;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile ListAttribute<Usuario, Evento> eventoList;
    public static volatile SingularAttribute<Usuario, TipoSangre> idTipoSangre;
    public static volatile ListAttribute<Usuario, Revision> revisionList;
    public static volatile ListAttribute<Usuario, Ciudad> ciudadList;
    public static volatile ListAttribute<Usuario, Ficha> fichaList;
    public static volatile ListAttribute<Usuario, ResultadoAprendizaje> resultadoAprendizajeList;
    public static volatile SingularAttribute<Usuario, Date> fechaExpedicion;
    public static volatile SingularAttribute<Usuario, String> correo2;
    public static volatile SingularAttribute<Usuario, String> correo1;
    public static volatile ListAttribute<Usuario, Acompanamiento> acompanamientoList;
    public static volatile SingularAttribute<Usuario, Patrocinio> idPatrocinio;
    public static volatile SingularAttribute<Usuario, Genero> idGenero;
    public static volatile SingularAttribute<Usuario, Eps> idEps;
    public static volatile SingularAttribute<Usuario, Especialidad> idEspecialidad;

}