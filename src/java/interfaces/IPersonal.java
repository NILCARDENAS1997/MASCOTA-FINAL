/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Personal;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author Juan Carlos
 */
public interface IPersonal {

    public abstract boolean guardarPersonal(Personal personal);

    public abstract ArrayList<Personal> listarPersonales();

    public abstract boolean actualizarPersonal(Personal personal);

    public abstract boolean eliminarPersonal(Personal personal);

    public abstract ArrayList<Personal> listPastor(Session session);

    public abstract ArrayList<Personal> listSANDOR(Session session);

    public abstract Integer listCount(Session sesion);
}
