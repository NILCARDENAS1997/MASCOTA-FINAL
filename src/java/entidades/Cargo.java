package entidades;
// Generated 19-jul-2019 9:58:34 by Hibernate Tools 4.3.1



/**
 * Cargo generated by hbm2java
 */
public class Cargo  implements java.io.Serializable {


     private String idCargo;
     private String descripcion;
     private String estado;

    public Cargo() {
    }

    public Cargo(String idCargo, String descripcion, String estado) {
       this.idCargo = idCargo;
       this.descripcion = descripcion;
       this.estado = estado;
    }
   
    public String getIdCargo() {
        return this.idCargo;
    }
    
    public void setIdCargo(String idCargo) {
        this.idCargo = idCargo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


