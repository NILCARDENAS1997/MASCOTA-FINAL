package interfaces;

import entidades.Reservacista;
import java.util.ArrayList;

public interface IReservacita {

    public abstract boolean guardarReservacista(Reservacista reservacista);

    public abstract ArrayList<Reservacista> listarReservacista();

    public abstract boolean actualizarReservacista(Reservacista reservacista);

    public abstract boolean eliminarReservacista(Reservacista reservacista);
}
