/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Cargo;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public interface ICargoPersonal {
    
    public abstract boolean guardarCargoPersonal(Cargo cargo);

    public abstract ArrayList<Cargo> listarCargo();

    public abstract boolean actualizarCargoPersonal(Cargo cargo);

    public abstract boolean eliminarCargoPersonal(Cargo cargo);
}
