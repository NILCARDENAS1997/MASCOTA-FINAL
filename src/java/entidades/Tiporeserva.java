package entidades;
// Generated 19-jul-2019 9:58:34 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tiporeserva generated by hbm2java
 */
public class Tiporeserva  implements java.io.Serializable {


     private int idTipoReserva;
     private String descripcion;
     private Set reservacistas = new HashSet(0);

    public Tiporeserva() {
    }

	
    public Tiporeserva(int idTipoReserva, String descripcion) {
        this.idTipoReserva = idTipoReserva;
        this.descripcion = descripcion;
    }
    public Tiporeserva(int idTipoReserva, String descripcion, Set reservacistas) {
       this.idTipoReserva = idTipoReserva;
       this.descripcion = descripcion;
       this.reservacistas = reservacistas;
    }
   
    public int getIdTipoReserva() {
        return this.idTipoReserva;
    }
    
    public void setIdTipoReserva(int idTipoReserva) {
        this.idTipoReserva = idTipoReserva;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getReservacistas() {
        return this.reservacistas;
    }
    
    public void setReservacistas(Set reservacistas) {
        this.reservacistas = reservacistas;
    }




}


