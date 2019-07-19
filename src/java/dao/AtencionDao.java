/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import utilitarios.HibernateUtil;
import entidades.Atencion;

import interfaces.IAtencion;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AtencionDao implements IAtencion {

    @Override
    public boolean guardarAtencion(Atencion atencion) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.save(atencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("ERROR atencion DAO.");
        }

        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Atencion> listarAtencion() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        ArrayList<Atencion> milista = new ArrayList<>();
        Query query = sesion.createQuery("FROM Atencion");

        milista = (ArrayList<Atencion>) query.list();
        sesion.close();
        return milista;
    }

    @Override
    public boolean actualizarAtencion(Atencion atencion) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.update(atencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("ERROR");
        }

        sesion.close();
        return respuesta;
    }


    @Override
    public boolean eliminarAtencion(Atencion atencion) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.update(atencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
        }
        sesion.close();
        return respuesta;
    }

    @Override
    public int ContarAtencion() {
          Session sesion = HibernateUtil.getSessionFactory().openSession();
        Query query = sesion.createQuery( "select count(*) from Atencion");
        
        Long num = (Long) query.uniqueResult();
        Integer cont = num.intValue();
        sesion.close();
        return cont;
    }

  

}
