/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.PersonalDao;
import entidades.Personal;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author NIL CARDENAS
 */
@ManagedBean
@ViewScoped
public class PersonalBean {

    private Personal personal;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public PersonalBean() {
        this.personal = new Personal();
    }

    public String guardarPersonal() {

        PersonalDao dao = new PersonalDao();
        boolean respuesta = dao.guardarPersonal(personal);

        if (respuesta) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Se Registro Crrectamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo registrar"));
        }
        return "/index.xhtml";
    }

    public String actualizarPersonal() {
        PersonalDao dao = new PersonalDao();
        boolean respuesta = dao.actualizarPersonal(personal);
        if (respuesta) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Registro actualizo con exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo actualizar"));
        }
        return "/index.xhtml";
    }

    public ArrayList<Personal> listarPersonales() {
        ArrayList<Personal> milista = new ArrayList<>();
        PersonalDao dao = new PersonalDao();
        milista = dao.listarPersonales();

        return milista;
    }

    public String limpiar() {
        return "/index.xhtml";
    }

    public String eliminarPersonal() {
        PersonalDao dao = new PersonalDao();
        boolean respuesta = dao.eliminarPersonal(personal);
        if (respuesta) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto", "Registro Borrado con exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "No se pudo eliminar"));
        }
        return "/index.xhtml";
    }
}
