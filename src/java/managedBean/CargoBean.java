/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.CargoDao;
import entidades.Cargo;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author 
 */

@ManagedBean
@ViewScoped
public class CargoBean implements Serializable {

    private Cargo cargo;
    private boolean banderaSelect = false;

    public CargoBean() {
        this.cargo = new Cargo();
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String guardarCargoPersonal() {
        try {

            CargoDao cargoDao = new CargoDao();
            boolean respuesta = cargoDao.guardarCargoPersonal(cargo);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RCargo";
    }

    public String actualizarCargoPersonal() {
        try {
            CargoDao cargoDao = new CargoDao();
            boolean respuesta = cargoDao.actualizarCargoPersonal(cargo);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RCargo";

    }

    public ArrayList<Cargo> listarCargos() {
        ArrayList<Cargo> lista = new ArrayList<>();
        CargoDao cargoDao = new CargoDao();
        lista = cargoDao.listarCargo();
        return lista;
    }

    public String eliminar() {
        CargoDao cargoDao = new CargoDao();
        boolean respuesta = cargoDao.eliminarCargoPersonal(cargo);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RCargo";
    }

    public String limpiar() {
        return "/RCargo";
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

}
