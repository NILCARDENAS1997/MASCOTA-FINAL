/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Tipoatencion;
import interfaces.ITipoatencion;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author 
 */
public class TipoAtencionDao implements ITipoatencion{

    @Override
    public boolean guardarTipoatencion(Tipoatencion tipoatencion) {
        Session session = null;
        boolean respuesta = true;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaccion = session.beginTransaction(); //inicia
            session.save(tipoatencion);
            transaccion.commit();
        } catch (HibernateException e) {
            System.out.println("Error al guardar. " + e);
            respuesta = false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return respuesta;
    }
     @Override
    public ArrayList<Tipoatencion> listarTipoatencion() {
        Session session = null;
        ArrayList<Tipoatencion> lista = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //consulta hacia la base de datos
            String hql = "FROM Tipoatencion";
            Query query = session.createQuery(hql);
            //ejecuta la consulta y obtener la lista. array: castea
            lista = (ArrayList<Tipoatencion>) query.list();
            System.out.println(lista.size());
        } catch (Exception e) {
            System.out.println("ERROR EN LISTAR::" + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }
    
    @Override
    public boolean guardarTipoatencion(Tipoatencion tipoatencion) {
        boolean resp = true;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaccion = session.beginTransaction();
            session.update(tipoatencion);
            transaccion.commit();
        } catch (Exception e) {
            resp = false;
            System.out.println("ERROR EN ACTU::" + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return resp;
    
    }

        
    @Override
    public boolean eliminarTipoatencion(Tipoatencion tipoatencion) {
        
         Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(tipoatencion);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ERROR DAO::" + e);
            resp = false;
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }

        return resp;
    }

    @Override
    public boolean Tipoatencion(Tipoatencion tipoAtencion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
  
    

