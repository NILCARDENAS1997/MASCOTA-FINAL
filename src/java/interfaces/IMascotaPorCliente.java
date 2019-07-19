/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Mascotaporcliente;
import entidades.Personal;
import java.util.ArrayList;

/**
 *
 * @author SAUL
 */
public interface IMascotaPorCliente {
    
    public abstract boolean guardarMascotaPorCliente(Mascotaporcliente Mascotaporcliente);
    public abstract ArrayList<Mascotaporcliente> listarMascotaPorCliente();
    public abstract boolean actualizarMascotaPorCliente(Mascotaporcliente Mascotaporcliente);
    public abstract boolean eliminarMascotaPorCliente(Mascotaporcliente Mascotaporcliente);
}
