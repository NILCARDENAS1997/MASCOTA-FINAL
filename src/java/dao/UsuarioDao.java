/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Usuario;
import utilitarios.HibernateUtil;
import entidades.Usuario;
import interfaces.IUsuario;
import interfaces.IUsuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UsuarioDao implements IUsuario {

    @Override
    public boolean guardarUsuario(Usuario usuario) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.save(usuario);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("ERROR USUARIO DAO.");
        }

        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        ArrayList<Usuario> milista = new ArrayList<>();
        Query query = sesion.createQuery("FROM Usuario");

        milista = (ArrayList<Usuario>) query.list();
        sesion.close();
        return milista;
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.update(usuario);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("ERROR");
        }

        sesion.close();
        return respuesta;
    }


    @Override
    public boolean eliminarUsuario(Usuario usuario) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.update(usuario);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
        }
        sesion.close();
        return respuesta;
    }

  

}
