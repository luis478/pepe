

package com.pepe.controller;

import com.pepe.jpa.entities.Actividad;
import com.pepe.jpa.entities.Proyecto;
import com.pepe.jpa.entities.TecnicaDidactica;
import com.pepe.jpa.sesions.ActividadFacade;
import com.pepe.jpa.sesions.ProyectoFacade;
import com.pepe.jpa.sesions.TecnicaDidacticaFacade;
import controller.util.JsfUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@ManagedBean
@SessionScoped
public class TecnicadidacticaController implements Serializable {

    private TecnicaDidactica tecnicaActual;
    private List<TecnicaDidactica> listaTecnica = null;
    @EJB
    private TecnicaDidacticaFacade tecnicaFacade;
    
    public TecnicadidacticaController() {
        
    }

    public TecnicaDidactica getTecnicaActual() {
        if (tecnicaActual == null ){
            tecnicaActual = new TecnicaDidactica();
                    }         
        return tecnicaActual;
    }

    public void setTecnicaActual(TecnicaDidactica tecnicaActual) {
        this.tecnicaActual = tecnicaActual;
    }

    public List<TecnicaDidactica> getListaTecnica() {
        return listaTecnica;
    }

    public void setListaTecnica(List<TecnicaDidactica> listaTecnica) {
        this.listaTecnica = listaTecnica;
    }

    public TecnicaDidacticaFacade getTecnicaFacade() {
        return tecnicaFacade;
    }

    public void setTecnicaFacade(TecnicaDidacticaFacade tecnicaFacade) {
        this.tecnicaFacade = tecnicaFacade;
    }
    
    public List<TecnicaDidactica> getListaTecnicaDidacticas(){
        if (listaTecnica == null){
            try{
                listaTecnica = getTecnicaFacade().findAll();
            }catch (Exception e){
               addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            }
        }
        return listaTecnica;
    }
    
    private void recargarlista(){
        listaTecnica = null;
    }
    
     public String prepareCreate(){
      tecnicaActual = new TecnicaDidactica();
        return "TecnicaDidactica/crear_Tecnica";
}
    public String prepareEdit (){
    return "TecnicaDidactica/editar_TecnicaDidactica";
}
    public String prepareView (){
    return "TecnicaDidactica/view_TecnicaDidactica";
}
    public String prepareList (){
    recargarlista();
        return "TecnicaDidactica/lista_Tecnica_Didactica";
}
    
     public String addTecnica(){
        try{
        getTecnicaFacade().create(tecnicaActual);
        recargarlista();
        return "TecnicaDidactica/lista_Tecnica_Didactica";
        }catch (Exception e){
        addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }
     
     public String updateTecnica(){
        try{
        getTecnicaFacade().edit(tecnicaActual);
        recargarlista();
        return "view_TecnicaDidactica";
        }catch (Exception e){
        addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }
     
       public String deleteTecnica(){
        try{
        getTecnicaFacade().remove(tecnicaActual);
        recargarlista();
        return "TecnicaDidactica/lista_Tecnica_Didactica";
        }catch (Exception e){
        addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return "";
        }
    }
        private void addErrorMessage(String title, String msg) {
        FacesMessage facesMsg
                = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
         private void addSuccessMessage(String title, String msg) {
        FacesMessage facesMsg
                = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
}
