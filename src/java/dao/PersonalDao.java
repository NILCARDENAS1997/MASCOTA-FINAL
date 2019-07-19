/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import utilitarios.HibernateUtil;
import entidades.Personal;
import interfaces.IPersonal;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Juan Carlos
 */
public class PersonalDao implements IPersonal{

    @Override
    public boolean guardarPersonal(Personal personal) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        
        try {
            sesion.save(personal);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
        }
        
        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Personal> listarPersonal() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Personal> milista = new ArrayList<>();
        Query query = sesion.createQuery("from Personal");
        milista = (ArrayList<Personal>)query.list();
        sesion.close();
        return milista;
        
    }

    @Override
    public boolean eliminarPersonal(Personal personal) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        
        try {
            sesion.delete(personal);
            transaccion.commit();
            respuesta=true;
        } catch (Exception e) {
            respuesta=false;
        }
        sesion.close();
        return respuesta;
    }

    @Override
    public boolean actualizarPersonal(Personal personal) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        
        try {
            sesion.update(personal);
            transaccion.commit();
            respuesta=true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            respuesta=false;
        }
        sesion.close();
        return respuesta;
    }
    
    
    
    
}
