/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.TipoAtencionDao;
import entidades.Tipoatencion;
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
public class TipoAtencionBean implements Serializable {

    private Tipoatencion tipoatencion;
    private boolean banderaSelect = false;

    public TipoAtencionBean() {
        this.tipoatencion = new Tipoatencion();
    }

    public Tipoatencion getTipoatencion() {
        return tipoatencion;
    }

    public void setTipoatencion(Tipoatencion tipoatencion) {
        this.tipoatencion = tipoatencion;
    }

    public String guardarTipoatencion() {
        try {

            TipoAtencionDao tipoAtencionDao = new TipoAtencionDao();
            boolean respuesta = tipoAtencionDao.guardarTipoatencion(tipoatencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RTipoatencion";
    }

    public String actualizarTipoatencion() {
        try {
            TipoAtencionDao tipoAtencionDao = new TipoAtencionDao();
            boolean respuesta = tipoAtencionDao.actualizarTipoatencion(tipoatencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RTipoatencion";

    }

    public ArrayList<Tipoatencion> listarTipoatencions() {
        ArrayList<Tipoatencion> lista = new ArrayList<>();
        TipoAtencionDao tipoAtencionDao = new TipoAtencionDao();
        lista = tipoAtencionDao.listarTipoatencion();
        return lista;
    }

    public String eliminar() {
        TipoAtencionDao tipoAtencionDao = new TipoAtencionDao();
        boolean respuesta = tipoAtencionDao.eliminarTipoatencion(tipoatencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RTipoatencion";
    }

    public String limpiar() {
        return "/RTipoatencion";
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

}
