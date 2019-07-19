package interfaces;

import entidades.Tipoatencion;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public interface ITipoatencion {

    //gurdar
   public abstract boolean guardarTipoatencion(Tipoatencion tipoatencion);

    public abstract ArrayList<Tipoatencion> listarTipoatencion();

    public abstract boolean actualizarTipoatencion(Tipoatencion tipoatencion);

    public abstract boolean eliminarTipoatencion(Tipoatencion tipoatencion);
}
