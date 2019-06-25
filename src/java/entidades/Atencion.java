package entidades;
// Generated 24/06/2019 10:14:04 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Atencion NIL CARDENAS
 */
public class Atencion  implements java.io.Serializable {


     private int idAtencion;
     private Mascotaporcliente mascotaporcliente;
     private Personal personal;
     private String fechaAtencion;
     private String diagnostico;
     private Date horaAtencion;

    public Atencion() {
    }

    public Atencion(int idAtencion, Mascotaporcliente mascotaporcliente, Personal personal, String fechaAtencion, String diagnostico, Date horaAtencion) {
       this.idAtencion = idAtencion;
       this.mascotaporcliente = mascotaporcliente;
       this.personal = personal;
       this.fechaAtencion = fechaAtencion;
       this.diagnostico = diagnostico;
       this.horaAtencion = horaAtencion;
    }
   
    public int getIdAtencion() {
        return this.idAtencion;
    }
    
    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }
    public Mascotaporcliente getMascotaporcliente() {
        return this.mascotaporcliente;
    }
    
    public void setMascotaporcliente(Mascotaporcliente mascotaporcliente) {
        this.mascotaporcliente = mascotaporcliente;
    }
    public Personal getPersonal() {
        return this.personal;
    }
    
    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    public String getFechaAtencion() {
        return this.fechaAtencion;
    }
    
    public void setFechaAtencion(String fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }
    public String getDiagnostico() {
        return this.diagnostico;
    }
    
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public Date getHoraAtencion() {
        return this.horaAtencion;
    }
    
    public void setHoraAtencion(Date horaAtencion) {
        this.horaAtencion = horaAtencion;
    }




}


