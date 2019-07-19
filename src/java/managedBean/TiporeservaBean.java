/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.TipoReservaDao;

import entidades.Tiporeserva;
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
public class TiporeservaBean implements Serializable {

    private Tiporeserva tiporeserva;
    private boolean banderaSelect = false;

    public TiporeservaBean() {
        this.tiporeserva = new Tiporeserva();
    }

    public Tiporeserva getTiporeserva() {
        return tiporeserva;
    }

    public void setTiporeserva(Tiporeserva tiporeserva) {
        this.tiporeserva = tiporeserva;
    }

    public String guardarTiporeserva() {
        try {

            TipoReservaDao tipoReservaDao = new TipoReservaDao();
            boolean respuesta = tipoReservaDao.guardarTiporeserva(tiporeserva);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RTipoReserva";
    }

    public String actualizarTiporeserva() {
        try {
            TipoReservaDao tipoReservaDao = new TipoReservaDao();
            boolean respuesta = tipoReservaDao.actualizarTiporeserva(tiporeserva);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RTipoReserva";

    }

    public ArrayList<Tiporeserva> listarTiporeserva() {
        ArrayList<Tiporeserva> lista = new ArrayList<>();
        TipoReservaDao tipoReservaDao = new TipoReservaDao();
        lista = tipoReservaDao.listarTiporeserva();
        return lista;
    }

    public String eliminarR() {
        TipoReservaDao tipoReservaDao = new TipoReservaDao();
        boolean respuesta = tipoReservaDao.eliminarTiporeserva(tiporeserva);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RTipoReserva";
    }

    public String limpiar() {
        return "/RTipoReserva";
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

}
