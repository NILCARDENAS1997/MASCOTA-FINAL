/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import dao.PersonalDao;
import entidades.Personal;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Juan Carlos
 */
@ManagedBean
@ViewScoped
public class PersonalBean {
    private Personal personal ;

    public PersonalBean() {
        this.personal = new Personal();
    }
    
    public   Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    
    public String guardar(){
        PersonalDao dao = new PersonalDao();
        boolean respuesta = dao.guardarPersonal(personal);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "asdsd", "qweqwe"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/RegistroPersonal";
    }
    
    public ArrayList<Personal> listar(){
        ArrayList<Personal> milista = new ArrayList<>();
        PersonalDao dao = new PersonalDao();
        milista = dao.listarPersonal();
        return milista;
    }
    
    public String eliminar(){
        PersonalDao dao = new PersonalDao();
        boolean respuesta = dao.eliminarPersonal(personal);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "asdsd", "Error"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo eliminar"));
        }
        return "/RegistroPersonal";
    }
    
    public String actualizar(){
        PersonalDao dao = new PersonalDao();
        boolean respuesta = dao.actualizarPersonal(personal);
        System.out.println(respuesta);
        if(respuesta){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Se registro correctamente"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo actualizar"));
        }
        
        return "/RegistroPersonal";
    }
    
    public String limpiar(){
        return "/RegistroPersonal";
    }
    
    
    
    public void refrescar(){
        
    }
}
