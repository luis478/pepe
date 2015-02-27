/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pepe.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADSI TARDE
 */
@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByIdProyecto", query = "SELECT p FROM Proyecto p WHERE p.idProyecto = :idProyecto"),
    @NamedQuery(name = "Proyecto.findByCodigoProyecto", query = "SELECT p FROM Proyecto p WHERE p.codigoProyecto = :codigoProyecto"),
    @NamedQuery(name = "Proyecto.findByInnovacion261", query = "SELECT p FROM Proyecto p WHERE p.innovacion261 = :innovacion261"),
    @NamedQuery(name = "Proyecto.findByInnovacion262", query = "SELECT p FROM Proyecto p WHERE p.innovacion262 = :innovacion262"),
    @NamedQuery(name = "Proyecto.findByInnovacion263", query = "SELECT p FROM Proyecto p WHERE p.innovacion263 = :innovacion263"),
    @NamedQuery(name = "Proyecto.findByInnovacion264", query = "SELECT p FROM Proyecto p WHERE p.innovacion264 = :innovacion264"),
    @NamedQuery(name = "Proyecto.findByInnovacion265", query = "SELECT p FROM Proyecto p WHERE p.innovacion265 = :innovacion265"),
    @NamedQuery(name = "Proyecto.findByValoracion271", query = "SELECT p FROM Proyecto p WHERE p.valoracion271 = :valoracion271"),
    @NamedQuery(name = "Proyecto.findByValoracion272", query = "SELECT p FROM Proyecto p WHERE p.valoracion272 = :valoracion272"),
    @NamedQuery(name = "Proyecto.findByIntructoresRequeridos", query = "SELECT p FROM Proyecto p WHERE p.intructoresRequeridos = :intructoresRequeridos"),
    @NamedQuery(name = "Proyecto.findByAprendicesSugeridos", query = "SELECT p FROM Proyecto p WHERE p.aprendicesSugeridos = :aprendicesSugeridos")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proyecto")
    private Integer idProyecto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nombre_proyecto")
    private String nombreProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo_proyecto")
    private String codigoProyecto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "justificacion_2_2")
    private String justificacion22;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "objetivo_general_2_3")
    private String objetivoGeneral23;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "objetivo_especifico_2_4")
    private String objetivoEspecifico24;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "palabras_clave_1_7")
    private String palabrasClave17;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "planteamiento_2_1")
    private String planteamiento21;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "impacto_2_5_2")
    private String impacto252;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "restricciones_2_5_3")
    private String restricciones253;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "productos_resultados_2_5_4")
    private String productosResultados254;
    @Basic(optional = false)
    @NotNull
    @Column(name = "innovacion_2_6_1")
    private short innovacion261;
    @Basic(optional = false)
    @NotNull
    @Column(name = "innovacion_2_6_2")
    private short innovacion262;
    @Basic(optional = false)
    @NotNull
    @Column(name = "innovacion_2_6_3")
    private short innovacion263;
    @Basic(optional = false)
    @NotNull
    @Column(name = "innovacion_2_6_4")
    private short innovacion264;
    @Basic(optional = false)
    @NotNull
    @Column(name = "innovacion_2_6_5")
    private short innovacion265;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valoracion_2_7_1")
    private short valoracion271;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valoracion_2_7_2")
    private short valoracion272;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intructores_requeridos")
    private int intructoresRequeridos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aprendices_sugeridos")
    private int aprendicesSugeridos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion_ambiente")
    private String descripcionAmbiente;
    @ManyToMany(mappedBy = "proyectoList")
    private List<Empresa> empresaList;
    @OneToMany(mappedBy = "idProyecto")
    private List<Ficha> fichaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private List<Actividad> actividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private List<Revision> revisionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private List<VisitaTecnica> visitaTecnicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private List<GuiaAprendizaje> guiaAprendizajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private List<Verificacion> verificacionList;

    public Proyecto() {
    }

    public Proyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyecto(Integer idProyecto, String nombreProyecto, String codigoProyecto, String justificacion22, String objetivoGeneral23, String objetivoEspecifico24, String palabrasClave17, String planteamiento21, String impacto252, String restricciones253, String productosResultados254, short innovacion261, short innovacion262, short innovacion263, short innovacion264, short innovacion265, short valoracion271, short valoracion272, int intructoresRequeridos, int aprendicesSugeridos, String descripcionAmbiente) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.codigoProyecto = codigoProyecto;
        this.justificacion22 = justificacion22;
        this.objetivoGeneral23 = objetivoGeneral23;
        this.objetivoEspecifico24 = objetivoEspecifico24;
        this.palabrasClave17 = palabrasClave17;
        this.planteamiento21 = planteamiento21;
        this.impacto252 = impacto252;
        this.restricciones253 = restricciones253;
        this.productosResultados254 = productosResultados254;
        this.innovacion261 = innovacion261;
        this.innovacion262 = innovacion262;
        this.innovacion263 = innovacion263;
        this.innovacion264 = innovacion264;
        this.innovacion265 = innovacion265;
        this.valoracion271 = valoracion271;
        this.valoracion272 = valoracion272;
        this.intructoresRequeridos = intructoresRequeridos;
        this.aprendicesSugeridos = aprendicesSugeridos;
        this.descripcionAmbiente = descripcionAmbiente;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getJustificacion22() {
        return justificacion22;
    }

    public void setJustificacion22(String justificacion22) {
        this.justificacion22 = justificacion22;
    }

    public String getObjetivoGeneral23() {
        return objetivoGeneral23;
    }

    public void setObjetivoGeneral23(String objetivoGeneral23) {
        this.objetivoGeneral23 = objetivoGeneral23;
    }

    public String getObjetivoEspecifico24() {
        return objetivoEspecifico24;
    }

    public void setObjetivoEspecifico24(String objetivoEspecifico24) {
        this.objetivoEspecifico24 = objetivoEspecifico24;
    }

    public String getPalabrasClave17() {
        return palabrasClave17;
    }

    public void setPalabrasClave17(String palabrasClave17) {
        this.palabrasClave17 = palabrasClave17;
    }

    public String getPlanteamiento21() {
        return planteamiento21;
    }

    public void setPlanteamiento21(String planteamiento21) {
        this.planteamiento21 = planteamiento21;
    }

    public String getImpacto252() {
        return impacto252;
    }

    public void setImpacto252(String impacto252) {
        this.impacto252 = impacto252;
    }

    public String getRestricciones253() {
        return restricciones253;
    }

    public void setRestricciones253(String restricciones253) {
        this.restricciones253 = restricciones253;
    }

    public String getProductosResultados254() {
        return productosResultados254;
    }

    public void setProductosResultados254(String productosResultados254) {
        this.productosResultados254 = productosResultados254;
    }

    public short getInnovacion261() {
        return innovacion261;
    }

    public void setInnovacion261(short innovacion261) {
        this.innovacion261 = innovacion261;
    }

    public short getInnovacion262() {
        return innovacion262;
    }

    public void setInnovacion262(short innovacion262) {
        this.innovacion262 = innovacion262;
    }

    public short getInnovacion263() {
        return innovacion263;
    }

    public void setInnovacion263(short innovacion263) {
        this.innovacion263 = innovacion263;
    }

    public short getInnovacion264() {
        return innovacion264;
    }

    public void setInnovacion264(short innovacion264) {
        this.innovacion264 = innovacion264;
    }

    public short getInnovacion265() {
        return innovacion265;
    }

    public void setInnovacion265(short innovacion265) {
        this.innovacion265 = innovacion265;
    }

    public short getValoracion271() {
        return valoracion271;
    }

    public void setValoracion271(short valoracion271) {
        this.valoracion271 = valoracion271;
    }

    public short getValoracion272() {
        return valoracion272;
    }

    public void setValoracion272(short valoracion272) {
        this.valoracion272 = valoracion272;
    }

    public int getIntructoresRequeridos() {
        return intructoresRequeridos;
    }

    public void setIntructoresRequeridos(int intructoresRequeridos) {
        this.intructoresRequeridos = intructoresRequeridos;
    }

    public int getAprendicesSugeridos() {
        return aprendicesSugeridos;
    }

    public void setAprendicesSugeridos(int aprendicesSugeridos) {
        this.aprendicesSugeridos = aprendicesSugeridos;
    }

    public String getDescripcionAmbiente() {
        return descripcionAmbiente;
    }

    public void setDescripcionAmbiente(String descripcionAmbiente) {
        this.descripcionAmbiente = descripcionAmbiente;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @XmlTransient
    public List<Ficha> getFichaList() {
        return fichaList;
    }

    public void setFichaList(List<Ficha> fichaList) {
        this.fichaList = fichaList;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @XmlTransient
    public List<Revision> getRevisionList() {
        return revisionList;
    }

    public void setRevisionList(List<Revision> revisionList) {
        this.revisionList = revisionList;
    }

    @XmlTransient
    public List<VisitaTecnica> getVisitaTecnicaList() {
        return visitaTecnicaList;
    }

    public void setVisitaTecnicaList(List<VisitaTecnica> visitaTecnicaList) {
        this.visitaTecnicaList = visitaTecnicaList;
    }

    @XmlTransient
    public List<GuiaAprendizaje> getGuiaAprendizajeList() {
        return guiaAprendizajeList;
    }

    public void setGuiaAprendizajeList(List<GuiaAprendizaje> guiaAprendizajeList) {
        this.guiaAprendizajeList = guiaAprendizajeList;
    }

    @XmlTransient
    public List<Verificacion> getVerificacionList() {
        return verificacionList;
    }

    public void setVerificacionList(List<Verificacion> verificacionList) {
        this.verificacionList = verificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreProyecto;
    }
    
}
