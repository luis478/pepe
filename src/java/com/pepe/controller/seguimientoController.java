/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pepe.controller;

import com.pepe.jpa.entities.Acompanamiento;
import com.pepe.jpa.entities.Criterio;
import com.pepe.jpa.entities.DescripcionCriterio1;
import com.pepe.jpa.entities.DescripcionCriterio2;
import com.pepe.jpa.entities.DescripcionCriterio3;
import com.pepe.jpa.entities.DescripcionCriterio4;
import com.pepe.jpa.entities.Fase;
import com.pepe.jpa.entities.Ficha;
import com.pepe.jpa.entities.ItemCriterio;
import com.pepe.jpa.entities.TipoCriterio;
import com.pepe.jpa.sesions.AcompanamientoFacade;
import com.pepe.jpa.sesions.CriterioFacade;
import com.pepe.jpa.sesions.DescripcionCriterio1Facade;
import com.pepe.jpa.sesions.DescripcionCriterio2Facade;
import com.pepe.jpa.sesions.DescripcionCriterio3Facade;
import com.pepe.jpa.sesions.DescripcionCriterio4Facade;
import com.pepe.jpa.sesions.FaseFacade;
import com.pepe.jpa.sesions.FichaFacade;
import com.pepe.jpa.sesions.ItemCriterioFacade;
import com.pepe.jpa.sesions.TipoCriterioFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Aprendiz
 */
@ManagedBean
@SessionScoped
public class seguimientoController implements Serializable {

    private Acompanamiento acompanamientoActual;
    private Ficha fichaActual;
    private TipoCriterio tipoCriterioActual;
    private ItemCriterio itemCriterioActual;
    private List<Acompanamiento> listaAcompanamiento = null;
    private int idTipoCriterio;
    private int idFase;
    private Criterio criterioActual;

    private List<ItemCriterio> listaItems = null;
    @EJB
    private AcompanamientoFacade acompanamientoFacade;
    @EJB
    private ItemCriterioFacade itemCriterioFacade;
    @EJB
    private FichaFacade fichaFacade;
    @EJB
    private FaseFacade faseFacade;
    @EJB
    private CriterioFacade criterioFacade;
    @EJB
    private ItemCriterioFacade itemFacade;
    @EJB
    private TipoCriterioFacade tipoCriterioFacade;
    @EJB
    private DescripcionCriterio1Facade descripcionCriterio1Facade;
    @EJB
    private DescripcionCriterio2Facade descripcionCriterio2Facade;
    @EJB
    private DescripcionCriterio3Facade descripcionCriterio3Facade;
    @EJB
    private DescripcionCriterio4Facade descripcionCriterio4Facade;
    @EJB
    private TipoCriterioFacade tipoCriteriosFacade;

    public seguimientoController() {
    }

    public FichaFacade getFichaFacade() {
        return fichaFacade;
    }

    public FaseFacade getFaseFacade() {
        return faseFacade;
    }

    public int getIdTipoCriterio() {
        return idTipoCriterio;
    }

    public void setIdTipoCriterio(int idTipoCriterio) {
        this.idTipoCriterio = idTipoCriterio;
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public Acompanamiento getAcompanamientoActual() {
        if (acompanamientoActual == null) {
            acompanamientoActual = new Acompanamiento();
        }
        return acompanamientoActual;
    }

    public void setAcompanamientoActual(Acompanamiento acompanamientoActual) {
        this.acompanamientoActual = acompanamientoActual;
    }

    public AcompanamientoFacade getAcompanamientoFacade() {
        return acompanamientoFacade;
    }

    public ItemCriterioFacade getItemCriterioFacade() {
        return itemCriterioFacade;
    }

    public void setItemCriterioFacade(ItemCriterioFacade itemCriterioFacade) {
        this.itemCriterioFacade = itemCriterioFacade;
    }

    public CriterioFacade getCriterioFacade() {
        return criterioFacade;
    }

    public void setCriterioFacade(CriterioFacade criterioFacade) {
        this.criterioFacade = criterioFacade;
    }

    public ItemCriterioFacade getItemFacade() {
        return itemFacade;
    }

    public void setItemFacade(ItemCriterioFacade itemFacade) {
        this.itemFacade = itemFacade;
    }

    public TipoCriterioFacade getTipoCriterioFacade() {
        return tipoCriterioFacade;
    }

    public void setTipoCriterioFacade(TipoCriterioFacade tipoCriterioFacade) {
        this.tipoCriterioFacade = tipoCriterioFacade;
    }

    public DescripcionCriterio1Facade getDescripcionCriterio1Facade() {
        return descripcionCriterio1Facade;
    }

    public void setDescripcionCriterio1Facade(DescripcionCriterio1Facade descripcionCriterio1Facade) {
        this.descripcionCriterio1Facade = descripcionCriterio1Facade;
    }

    public DescripcionCriterio2Facade getDescripcionCriterio2Facade() {
        return descripcionCriterio2Facade;
    }

    public void setDescripcionCriterio2Facade(DescripcionCriterio2Facade descripcionCriterio2Facade) {
        this.descripcionCriterio2Facade = descripcionCriterio2Facade;
    }

    public DescripcionCriterio3Facade getDescripcionCriterio3Facade() {
        return descripcionCriterio3Facade;
    }

    public void setDescripcionCriterio3Facade(DescripcionCriterio3Facade descripcionCriterio3Facade) {
        this.descripcionCriterio3Facade = descripcionCriterio3Facade;
    }

    public DescripcionCriterio4Facade getDescripcionCriterio4Facade() {
        return descripcionCriterio4Facade;
    }

    public void setDescripcionCriterio4Facade(DescripcionCriterio4Facade descripcionCriterio4Facade) {
        this.descripcionCriterio4Facade = descripcionCriterio4Facade;
    }

    public TipoCriterioFacade getTipoCriteriosFacade() {
        return tipoCriteriosFacade;
    }

    public void setTipoCriteriosFacade(TipoCriterioFacade tipoCriteriosFacade) {
        this.tipoCriteriosFacade = tipoCriteriosFacade;
    }

    public List<TipoCriterio> getListaCriterioSelectOne() {
        return getTipoCriterioFacade().findAll();
    }

    public List<ItemCriterio> getListaItems() {
        actualizarItems();
        return listaItems;
    }

    public void setListaItems(List<ItemCriterio> listaItems) {
        this.listaItems = listaItems;
    }

    public Ficha getFichaActual() {
        return fichaActual;
    }

    public void setFichaActual(Ficha fichaActual) {
        this.fichaActual = fichaActual;
    }

    public ItemCriterio getItemCriterioActual() {
        return itemCriterioActual;
    }

    public void setItemCriterioActual(ItemCriterio itemCriterioActual) {
        this.itemCriterioActual = itemCriterioActual;
    }

    public TipoCriterio getTipoCriterioActual() {
        return tipoCriterioActual;
    }

    public void setTipoCriterioActual(TipoCriterio tipoCriterioActual) {
        this.tipoCriterioActual = tipoCriterioActual;
    }

    public boolean renderTabla1() {
        if (idTipoCriterio == 1) {
            return true;

        } else {

            return false;
        }
    }
      public boolean renderTabla2() {
        if (idTipoCriterio == 2) {
            return true;

        } else {

            return false;
        }
    }
        public boolean renderTabla3() {
        if (idTipoCriterio == 3) {
            return true;

        } else {

            return false;
        }
    }
      public boolean renderTabla4() {
        if (idTipoCriterio == 4) {
            return true;

        } else {

            return false;
        }
    }
    public List<Ficha> getListFichaSelectOne() {
        return getFichaFacade().findAll();
    }

    public List<Fase> getListFaseSelectOne() {
        return getFaseFacade().findAll();
    }

    public List<Acompanamiento> getListaAcompanamiento() {
        if (listaAcompanamiento == null) {
            try {
                listaAcompanamiento = getAcompanamientoFacade().findAll();
            } catch (Exception e) {
                System.out.println("Error closing resource " + e.getClass().getName());
                System.out.println("Message: " + e.getMessage());
            }
        }
        return listaAcompanamiento;
    }

    private void recargarLista() {
        listaAcompanamiento = null;
    }

    public String prepareList() {
        recargarLista();
        return "/acompañamieno/List";
    }

    public String prepareEdit() {
        return "Edit";
    }

    public String prepareView() {
        return "View";
    }

    public String addAcompanamiento() {
        try {
            acompanamientoActual.setFachaFin(new Date());
            getAcompanamientoFacade().create(acompanamientoActual);
            getCriterioFacade().create(criterioActual);
            acompanamientoActual.getCriterioList().add(criterioActual);

            for (ItemCriterio ic : listaItems) {
                ic.setIdNombreCriterio(criterioActual);
                getItemCriterioFacade().create(ic);
            }

            addSuccessMessage("crear acompanamiento", "acompanamiento creado Exitosamente");
            recargarLista();
            return "lista_acompanamiento";

        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());

            return null;
        }
    }

    public String updateAcompanamieno() {
        try {
            getAcompanamientoFacade().edit(acompanamientoActual);

            addSuccessMessage("Actualizar acompanamiento", "acompanamiento actualizado Exitosamente");
            return "View";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());

            return null;
        }
    }

    public String deleteAcompanamiento() {
        try {

            getAcompanamientoFacade().remove(acompanamientoActual);
            addSuccessMessage("Eliminar acompanamiento", "acompanamiento eliminado Exitosamente");
            recargarLista();
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
        }
        return "List";
    }

    public void actualizarItems() {
        listaItems = new ArrayList<>();
        switch (idTipoCriterio) {
            case 1:
                for (DescripcionCriterio1 descripcion1 : getDescripcionCriterio1Facade().findAll()) {
                    itemCriterioActual = new ItemCriterio();
                    itemCriterioActual.setIdDescripcionCriterio1(descripcion1);
                    itemCriterioActual.setObservacion(null);
                    listaItems.add(itemCriterioActual);
                }
                break;
            case 2:
                for (DescripcionCriterio2 descripcion2 : getDescripcionCriterio2Facade().findAll()) {
                    itemCriterioActual = new ItemCriterio();
                    itemCriterioActual.setIdDescripcionCriterio2(descripcion2);
                    itemCriterioActual.setObservacion(null);
                    listaItems.add(itemCriterioActual);
                }
                break;
            case 3:
                for (DescripcionCriterio3 descripcion3 : getDescripcionCriterio3Facade().findAll()) {
                    itemCriterioActual = new ItemCriterio();
                    itemCriterioActual.setIdDescripcionCriterio3(descripcion3);
                    itemCriterioActual.setObservacion(null);
                    listaItems.add(itemCriterioActual);
                }
                break;
            case 4:
                for (DescripcionCriterio4 descripcion4 : getDescripcionCriterio4Facade().findAll()) {
                    itemCriterioActual = new ItemCriterio();
                    itemCriterioActual.setIdDescripcionCriterio4(descripcion4);
                    itemCriterioActual.setObservacion(null);
                    listaItems.add(itemCriterioActual);
                }
                break;
            default:
        }
    }

    public String prepareCreate(ActionEvent event) {
        fichaActual = ((Ficha) event.getComponent().getAttributes().get("ficha"));
        acompanamientoActual = new Acompanamiento();
        acompanamientoActual.setFechaInicio(new Date());
        acompanamientoActual.setIdFicha(fichaActual);
        criterioActual = new Criterio();
        criterioActual.setIdAcompanamiento(acompanamientoActual);
//        if (fichaActual.getAcompanamientoList().isEmpty()) {
//            acompanamientoActual.setFechaInicio(new Date());
//            acompanamientoActual.setIdFicha(fichaActual);
//        } else {
//            acompanamientoActual = fichaActual.getAcompanamientoList().get(0);
//        }
        actualizarItems();
        return "Create";
    }

    public void cargarLista() {

    }

    public String cargarCreate() {
        return "/acompanamiento/crear_acompanamiento";
    }

    private void addErrorMessage(String title, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    private void addSuccessMessage(String title, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

}