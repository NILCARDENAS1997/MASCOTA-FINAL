/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import dao.MascotaDao;
import entidades.Mascota;
import org.hibernate.Session;
import utilitarios.HibernateUtil;



/**
 *
 * @author NIL CARDENAS
 */
public class Ejercicio3 {
    
    public static void main(String[] args ){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        MascotaDao mascotadao = new MascotaDao();
        Mascota actualizardatos = new Mascota(7, "Brunooo", "Jesus", "Chihuahua");
        mascotadao.actualizarMascota( actualizardatos);
        
        session.beginTransaction();
        session.saveOrUpdate(actualizardatos);
        session.getTransaction().commit();
        session.close();  
    }
}
