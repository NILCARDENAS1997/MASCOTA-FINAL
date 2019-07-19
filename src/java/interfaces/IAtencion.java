package interfaces;

import entidades.Atencion;

import java.util.ArrayList;


public interface IAtencion {

    //gurdar
    public abstract boolean guardarAtencion(Atencion atencion);

    //listar todas
   // public abstract ArrayList<Atencion> listarAtencions(Session sesion);
    public abstract ArrayList<Atencion> listarAtencion();

    //actualizar
    public abstract boolean actualizarAtencion(Atencion atencion);

    // listar por datos
    //public abstract List<Atencion> listarMascotaDatosRaza(Session session);

    //listar por nombre
    //public abstract List<Atencion> listarAtencionNombre(Session session);
    
    //elimnar
    public  abstract boolean eliminarAtencion(Atencion atencion);

    //contar registro
   public abstract int ContarAtencion();
}
