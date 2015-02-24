package com.pepe.controller;

import com.pepe.jpa.entities.Competencia;
import com.pepe.jpa.entities.ConocimientoConceptoPrincipios;
import com.pepe.jpa.entities.ConocimientoProceso;
import com.pepe.jpa.entities.CriteriosEvaluacion;
import com.pepe.jpa.entities.LineaTecnologica;
import com.pepe.jpa.entities.ModalidadFormacion;
import com.pepe.jpa.entities.NivelFormacion;
import com.pepe.jpa.entities.PerfilEntrada;
import com.pepe.jpa.entities.ProgramaPK;
import com.pepe.jpa.entities.ResultadoAprendizaje;
import com.pepe.jpa.entities.TipoFormacion;
import com.pepe.jpa.sesions.CompetenciaFacade;
import com.pepe.jpa.sesions.ConocimientoConceptoPrincipiosFacade;
import com.pepe.jpa.sesions.ConocimientoProcesoFacade;
import com.pepe.jpa.sesions.CriteriosEvaluacionFacade;
import com.pepe.jpa.sesions.LineaTecnologicaFacade;
import com.pepe.jpa.sesions.ModalidadFormacionFacade;
import com.pepe.jpa.sesions.NivelFormacionFacade;
import com.pepe.jpa.sesions.PerfilEntradaFacade;
import com.pepe.jpa.sesions.ResultadoAprendizajeFacade;
import com.pepe.jpa.sesions.TipoFormacionFacade;
import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import com.pepe.jpa.entities.Programa;
import com.pepe.jpa.sesions.ProgramaFacade;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 *
 * @author EQUIPO 3
 */
@Named(value = "programaController")
@SessionScoped
public class ProgramaController implements Serializable {

    @EJB
    private ProgramaFacade programaFacade;
    private Programa programaActual = null;
    private Programa programaVersion = null;
    private List<Programa> programas;
    @EJB
    private CompetenciaFacade competenciaFacade;
    private Competencia competenciaActual = null;
    @EJB
    private LineaTecnologicaFacade lineaTecnologicaFacade;
    @EJB
    private ModalidadFormacionFacade modalidadFormacionFacade;
    @EJB
    private PerfilEntradaFacade perfilEntradaFacade;
    @EJB
    private NivelFormacionFacade nivelFormacionFacade;
    @EJB
    private TipoFormacionFacade tipoFormacionFacade;
    @EJB
    private ConocimientoConceptoPrincipiosFacade conocimientoConceptoPrincipiosFacade;
    private ConocimientoConceptoPrincipios conocimientoConceptoPrincipiosActual = null;
    @EJB
    private ConocimientoProcesoFacade conocimientoProcesoFacade;
    @EJB
    private CriteriosEvaluacionFacade criteriosEvaluacionFacade;
    private CriteriosEvaluacion criteriosEvaluacionActual = null;
    @EJB
    private ResultadoAprendizajeFacade resultadoAprendizajeFacade;

    private String codigo = "";
    private String version = "";
    private int idLinea;
    private int idPerfil;
    private int idModalidad;
    private int idNivel;
    private int idTipo;
    private String duracion;
    private boolean cod = true;

    public ProgramaController() {
    }

    public Programa getProgramaActual() {
        return programaActual;
    }

    public Programa getProgramaVersion() {
        return programaVersion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setProgramaVersion(Programa programaVersion) {
        this.programaVersion = programaVersion;
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }

    public boolean isCod() {
        return cod;
    }

    public void setCod(boolean cod) {
        this.cod = cod;
    }

    public ConocimientoConceptoPrincipiosFacade getConocimientoConceptoPrincipiosFacade() {
        return conocimientoConceptoPrincipiosFacade;
    }

    public void setConocimientoConceptoPrincipiosFacade(ConocimientoConceptoPrincipiosFacade conocimientoConceptoPrincipiosFacade) {
        this.conocimientoConceptoPrincipiosFacade = conocimientoConceptoPrincipiosFacade;
    }

    public CriteriosEvaluacion getCriteriosEvaluacionActual() {
        if (criteriosEvaluacionActual == null) {
            criteriosEvaluacionActual = new CriteriosEvaluacion();
        }
        return criteriosEvaluacionActual;
    }

    public void setCriteriosEvaluacionActual(CriteriosEvaluacion criteriosEvaluacionActual) {
        this.criteriosEvaluacionActual = criteriosEvaluacionActual;
    }

    public ConocimientoProcesoFacade getConocimientoProcesoFacade() {
        return conocimientoProcesoFacade;
    }

    public void setConocimientoProcesoFacade(ConocimientoProcesoFacade conocimientoProcesoFacade) {
        this.conocimientoProcesoFacade = conocimientoProcesoFacade;
    }

    public CriteriosEvaluacionFacade getCriteriosEvaluacionFacade() {
        return criteriosEvaluacionFacade;
    }

    public void setCriteriosEvaluacionFacade(CriteriosEvaluacionFacade criteriosEvaluacionFacade) {
        this.criteriosEvaluacionFacade = criteriosEvaluacionFacade;
    }

    public ResultadoAprendizajeFacade getResultadoAprendizajeFacade() {
        return resultadoAprendizajeFacade;
    }

    public void setResultadoAprendizajeFacade(ResultadoAprendizajeFacade resultadoAprendizajeFacade) {
        this.resultadoAprendizajeFacade = resultadoAprendizajeFacade;
    }

    public Competencia getCompetenciaActual() {
        if (competenciaActual == null) {
            competenciaActual = new Competencia();
        }
        return competenciaActual;
    }

    public ConocimientoConceptoPrincipios getConocimientoConceptoPrincipiosActual() {
        if (conocimientoConceptoPrincipiosActual == null) {
            conocimientoConceptoPrincipiosActual = new ConocimientoConceptoPrincipios();
        }
        return conocimientoConceptoPrincipiosActual;
    }

    public void setConocimientoConceptoPrincipiosActual(ConocimientoConceptoPrincipios conocimientoConceptoPrincipiosActual) {
        this.conocimientoConceptoPrincipiosActual = conocimientoConceptoPrincipiosActual;
    }

    public void setCompetenciaActual(Competencia competenciaActual) {
        this.competenciaActual = competenciaActual;
    }

    public CompetenciaFacade getCompetenciaFacade() {
        return competenciaFacade;
    }

    public void setCompetenciaFacade(CompetenciaFacade competenciaFacade) {
        this.competenciaFacade = competenciaFacade;
    }

    public String getCodigo() {
        if (programaActual != null && programaActual.getProgramaPK() != null && programaActual.getProgramaPK().getCodigo() != null && programaActual.getProgramaPK().getVersion() != null) {
            codigo = programaActual.getProgramaPK().getCodigo();
        }
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getVersion() {
        if (programaActual != null && programaActual.getProgramaPK() != null && programaActual.getProgramaPK().getCodigo() != null && programaActual.getProgramaPK().getVersion() != null) {
            version = programaActual.getProgramaPK().getVersion();
        }
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setProgramaActual(Programa programaActual) {
        this.programaActual = programaActual;
    }

    public ProgramaFacade getProgramaFacade() {
        return programaFacade;
    }

    public void setProgramaFacade(ProgramaFacade programaFacade) {
        this.programaFacade = programaFacade;
    }

    public String programaConsulta() {
        return "programaTabla.xhtml";
    }

    public LineaTecnologicaFacade getLineaTecnologicaFacade() {
        return lineaTecnologicaFacade;
    }

    public void setLineaTecnologicaFacade(LineaTecnologicaFacade lineaTecnologicaFacade) {
        this.lineaTecnologicaFacade = lineaTecnologicaFacade;
    }

    public ModalidadFormacionFacade getModalidadFormacionFacade() {
        return modalidadFormacionFacade;
    }

    public void setModalidadFormacionFacade(ModalidadFormacionFacade modalidadFormacionFacade) {
        this.modalidadFormacionFacade = modalidadFormacionFacade;
    }

    public PerfilEntradaFacade getPerfilEntradaFacade() {
        return perfilEntradaFacade;
    }

    public void setPerfilEntradaFacade(PerfilEntradaFacade perfilEntradaFacade) {
        this.perfilEntradaFacade = perfilEntradaFacade;
    }

    public NivelFormacionFacade getNivelFormacionFacade() {
        return nivelFormacionFacade;
    }

    public void setNivelFormacionFacade(NivelFormacionFacade nivelFormacionFacade) {
        this.nivelFormacionFacade = nivelFormacionFacade;
    }

    public TipoFormacionFacade getTipoFormacionFacade() {
        return tipoFormacionFacade;
    }

    public void setTipoFormacionFacade(TipoFormacionFacade tipoFormacionFacade) {
        this.tipoFormacionFacade = tipoFormacionFacade;
    }

    public int getIdLinea() {
        if (getProgramaActual() != null && getProgramaActual().getIdLineaTecnologica() != null) {
            idLinea = getProgramaActual().getIdLineaTecnologica().getIdLineaTecnologica();
        }
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public int getIdPerfil() {
        if (getProgramaActual() != null && getProgramaActual().getIdLineaTecnologica() != null) {
            idPerfil = getProgramaActual().getIdPerfilEntrada().getIdPerfilEntrada();
        }
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdModalidad() {

        if (getProgramaActual() != null && getProgramaActual().getIdModalidadFormacion() != null) {
            idModalidad = getProgramaActual().getIdModalidadFormacion().getIdModalidadFormacion();
        }
        return idModalidad;
    }

    public void setIdModalidad(int idModalidad) {
        this.idModalidad = idModalidad;
    }

    public int getIdNivel() {
        if (getProgramaActual() != null && getProgramaActual().getIdNivelFormacion() != null) {
            idNivel = getProgramaActual().getIdNivelFormacion().getIdNivelFormacion();
        }
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public int getIdTipo() {

        if (getProgramaActual() != null && getProgramaActual().getIdTipoFormacion() != null) {
            idTipo = getProgramaActual().getIdTipoFormacion().getIdTipoFormacion();
        }
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public List<Programa> getListaPrograma() {
        return getProgramaFacade().findAll();
    }

    public List<LineaTecnologica> getListaLineaTecnologica() {
        return getLineaTecnologicaFacade().findAll();
    }

    public List<ModalidadFormacion> getListaModalidadFormacion() {
        return getModalidadFormacionFacade().findAll();
    }

    public List<TipoFormacion> getListaTipoFormacion() {
        return getTipoFormacionFacade().findAll();
    }

    public List<NivelFormacion> getListaNivelFormacion() {
        return getNivelFormacionFacade().findAll();
    }

    public List<PerfilEntrada> getListaPerfilEntrada() {
        return getPerfilEntradaFacade().findAll();
    }

    public List<Programa> autoCompletarNombre(String query) {
        try {
            return getProgramaFacade().autoCompletarNombre(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<ConocimientoConceptoPrincipios> getListaCCP() {
        return getConocimientoConceptoPrincipiosFacade().consulta(competenciaActual);
    }

    public List<ConocimientoProceso> getListaCP() {
        return getConocimientoProcesoFacade().consulta(competenciaActual);
    }

    public List<CriteriosEvaluacion> getListaCE() {
        return getCriteriosEvaluacionFacade().consulta(competenciaActual);
    }

    public List<ResultadoAprendizaje> getListaRA() {
        return getResultadoAprendizajeFacade().consulta(competenciaActual);
    }

    public boolean competenciaNull() {
        if (getCompetenciaActual().getCodigo() == null) {
            return true;
        } else {
            return false;
        }
    }

    public void prepareCreate() {
        programaVersion = getProgramaFacade().consultaCodigoVersion(programaActual.getProgramaPK().getCodigo(), programaActual.getProgramaPK().getVersion());
        programaVersion.getProgramaPK().setVersion("");
        programaVersion.getCompetenciaList().clear();
    }

    public void anular() {
        programaActual = null;
        codigo = "";
        version = "";
        cod = false;
        programas = null;
        idLinea = idModalidad = idNivel = idPerfil = idTipo = 0;
        competenciaActual = null;
    }

    public void anularComp() {
        competenciaActual = null;
    }

    public void anularItem() {
        conocimientoConceptoPrincipiosActual = null;
    }

    public boolean codigoBoolean() {
        return cod;
    }

    public List<Competencia> getListaCompetencia() {
        return getProgramaActual().getCompetenciaList();
    }

    public boolean programaBoolean() {
        return programaActual != null;
    }

    public boolean ccpBoolean() {
        if (conocimientoConceptoPrincipiosActual.getIdConocimientoConceptoPrincipios() == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ceBoolean() {
        if (criteriosEvaluacionActual.getIdCriteriosEvaluacion() == null) {
            return true;
        } else {
            return false;
        }
    }

    public void validarCodigoPrograma(FacesContext context, UIComponent component, Object o) throws ValidatorException {
        List<Programa> pro = getProgramaFacade().consultaCodigo((String) o);
        Pattern pat = Pattern.compile("[0-9]{6}");
        Matcher mat = pat.matcher((String) o);
        if (mat.matches()) {
            if (pro.isEmpty()) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El codigo del programa no existe en el sistema"));
            } else {
                programas = pro;
                cod = false;
            }
        } else {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El codigo del programa se compone de 6 digitos numericos"));
        }
    }

    public void validarVersionPrograma(FacesContext context, UIComponent component, Object v) throws ValidatorException {
        List<Programa> pro = getProgramaFacade().consultaCodigo(programaActual.getProgramaPK().getCodigo());
        Pattern pat = Pattern.compile("[0-9]{1,3}");
        Matcher mat = pat.matcher((String) v);
        if (mat.matches()) {
            boolean b = false;
            for (Programa programa : pro) {
                if (((String) v).equals(programa.getProgramaPK().getVersion())) {
                    b = true;
                }
            }
            if (b) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El numero de version ya fue ingresado"));
            } else {
                programaVersion.getProgramaPK().setVersion((String) v);
            }
        } else {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "la version del programa se compone de 1-3 digitos numericos"));
        }
    }

    public List<Programa> getListaProgramas() {
        return getProgramaFacade().consultaCodigo(codigo);
    }

    public void crearPrograma() {
        try {
            programaActual.setIdLineaTecnologica(getLineaTecnologicaFacade().find(idLinea));
            programaActual.setIdModalidadFormacion(getModalidadFormacionFacade().find(idModalidad));
            programaActual.setIdNivelFormacion(getNivelFormacionFacade().find(idNivel));
            programaActual.setIdPerfilEntrada(getPerfilEntradaFacade().find(idPerfil));
            programaActual.setIdTipoFormacion(getTipoFormacionFacade().find(idTipo));
            programaActual.setEstado((short) 1);
            getProgramaFacade().create(programaActual);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void crearVersion() {
        try {
            programaVersion.setIdLineaTecnologica(getLineaTecnologicaFacade().find(idLinea));
            programaVersion.setIdModalidadFormacion(getModalidadFormacionFacade().find(idModalidad));
            programaVersion.setIdNivelFormacion(getNivelFormacionFacade().find(idNivel));
            programaVersion.setIdPerfilEntrada(getPerfilEntradaFacade().find(idPerfil));
            programaVersion.setIdTipoFormacion(getTipoFormacionFacade().find(idTipo));
            getProgramaFacade().create(programaVersion);
            for (Competencia c : programaActual.getCompetenciaList()) {
                programaVersion.getCompetenciaList().add(c);
            }
            getProgramaFacade().edit(programaVersion);
            anular();
            programaActual = getProgramaFacade().consultaCodigoVersion(programaVersion.getProgramaPK().getCodigo(), programaVersion.getProgramaPK().getVersion());
            programaVersion = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void crearCompetencia() {
        try {
            competenciaActual.setEstado((short) 1);
            competenciaActual.setDuracionEstimadaHoras(Integer.parseInt(duracion));
            getCompetenciaFacade().create(competenciaActual);
            programaActual.getCompetenciaList().add(competenciaActual);
            getProgramaFacade().edit(programaActual);
            duracion = "";
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void editarCompetencia() {
        try {
            competenciaActual.setDuracionEstimadaHoras(Integer.parseInt(duracion));
            getCompetenciaFacade().edit(competenciaActual);
            duracion = "";
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void crearCCP() {
        try {
            conocimientoConceptoPrincipiosActual.setEstado((short) 1);
            conocimientoConceptoPrincipiosActual.setIdCompetencia(competenciaActual);
            getConocimientoConceptoPrincipiosFacade().create(conocimientoConceptoPrincipiosActual);
            conocimientoConceptoPrincipiosActual = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarCCP() {
        try {
            getConocimientoConceptoPrincipiosFacade().edit(conocimientoConceptoPrincipiosActual);
            conocimientoConceptoPrincipiosActual = null;
            getConocimientoConceptoPrincipiosActual();
            ccpBoolean();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deshabilitarCCP() {
        try {
            conocimientoConceptoPrincipiosActual.setEstado((short) 0);
            getConocimientoConceptoPrincipiosFacade().edit(conocimientoConceptoPrincipiosActual);
            conocimientoConceptoPrincipiosActual = null;
            getConocimientoConceptoPrincipiosActual();
            ccpBoolean();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void crearCE() {
        try {
            criteriosEvaluacionActual.setEstado((short) 1);
            criteriosEvaluacionActual.setIdCompetencia(competenciaActual);
            getCriteriosEvaluacionFacade().create(criteriosEvaluacionActual);
            criteriosEvaluacionActual = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarCE() {
        try {
            getCriteriosEvaluacionFacade().edit(criteriosEvaluacionActual);
            criteriosEvaluacionActual = null;
            getCriteriosEvaluacionActual();
            ceBoolean();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deshabilitarCE() {
        try {
            criteriosEvaluacionActual.setEstado((short) 0);
            getCriteriosEvaluacionFacade().edit(criteriosEvaluacionActual);
            criteriosEvaluacionActual = null;
            getCriteriosEvaluacionActual();
            ceBoolean();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /*   CONVERTER   */
    public Programa getPrograma(ProgramaPK id) {
        return getProgramaFacade().find(id);

    }

    @FacesConverter(forClass = Programa.class, value = "ProgramaConverter")
    public static class ProgramaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProgramaController controller = (ProgramaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "programaController");
            return controller.getPrograma(getKey(value));
        }

        ProgramaPK getKey(String value) {
            ProgramaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new ProgramaPK();
            key.setCodigo(values[0]);
            key.setVersion(values[1]);
            return key;
        }

        String getStringKey(ProgramaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getVersion());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Programa) {
                Programa o = (Programa) object;
                return getStringKey(o.getProgramaPK());
            } else {

                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Programa.class.getName());
            }
        }

    }
}
