
package interfaces;

import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;


public interface IUsuario{
   public abstract boolean guardarUsuario (Usuario usuario);
    public abstract ArrayList<Usuario> listarUsuarios();
     public abstract boolean actualizarUsuario(Usuario usuario);
  public abstract boolean eliminarUsuario(Usuario usuario);
}
