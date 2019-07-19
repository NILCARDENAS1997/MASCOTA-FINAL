/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import utilitarios.HibernateUtil;
import entidades.Reservacista;

import interfaces.IReservacita;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ReservacitaDao implements IReservacita {

    @Override
    public boolean guardarReservacista(Reservacista reservacista) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.save(reservacista);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("ERROR RESERVACITA DAO.");
        }

        sesion.close();
        return respuesta;
    }


    @Override
    public boolean actualizarReservacista(Reservacista reservacista) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.update(reservacista);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("ERROR");
        }

        sesion.close();
        return respuesta;
    }


    @Override
    public boolean eliminarReservacista(Reservacista reservacista) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.update(reservacista);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
        }
        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Reservacista> listarReservacista() {
            Session sesion = HibernateUtil.getSessionFactory().openSession();

        ArrayList<Reservacista> milista = new ArrayList<>();
        Query query = sesion.createQuery("FROM Reservacista");

        milista = (ArrayList<Reservacista>) query.list();
        sesion.close();
        return milista; //To change body of generated methods, choose Tools | Templates.
    }

  

}
