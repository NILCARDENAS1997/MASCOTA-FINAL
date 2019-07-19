package managedBean;

import utilitarios.HibernateUtil;
import dao.ClienteDao;
import dao.AtencionDao;
import dao.MascotaDao;
import dao.PersonalDao;
import dao.TipoAtencionDao;
import entidades.Cliente;
import entidades.Atencion;
import entidades.Mascota;
import entidades.Personal;
import entidades.Tipoatencion;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped

public class AtencionBean {

    private int idCliente;
    private ArrayList<Cliente> listaCliente;

    private int idMascota;
    private ArrayList<Mascota> listaMascota;

    private int idTipoAtencion;
    private ArrayList<Tipoatencion> listaTipoatencion;

    private int idPersonal;
    private ArrayList<Personal> listaPersonal;

    private AtencionDao atenciondao;
    private Atencion atencion;
    private boolean seleccionado = false;

    private boolean respuesta;
    private Tipoatencion tipoatencion;
    private Personal personal;
    private Mascota mascota;
    private Cliente cliente;

    //constructor
    public AtencionBean() {

        listaCliente = new ArrayList<>();
        listarCliente();

        listaMascota = new ArrayList<>();
        listarMascota();

        listaTipoatencion = new ArrayList<>();
        listarTipoatencion();

        listaPersonal = new ArrayList<>();
        listarPersonal();

        this.atencion = new Atencion();
        this.mascota = new Mascota();
        this.cliente = new Cliente();
        this.tipoatencion = new Tipoatencion();
        this.personal = new Personal();

    }

    //metodo
    public void listarCliente() {
        ClienteDao dao = new ClienteDao();
        listaCliente = dao.listarClientes();
    }

    public void listarMascota() {
        MascotaDao dao = new MascotaDao();
        listaMascota = dao.listarMascotas();
    }

    public void listarTipoatencion() {
        TipoatencionDao dao = new TipoatencionDao();
        listaTipoatencion = dao.listarTipoatencion();
    }

    public void listarPersonal() {
        PersonalDao dao = new PersonalDao();
        listaPersonal = dao.listarPersonal();
    }

    public String guardarAtencion() {
        atenciondao = new AtencionDao();

        personal.setIdPersonal(idPersonal);
        tipoatencion.setIdTipoAtencion(idTipoAtencion);
        mascota.setIdMascota(idMascota);
        cliente.setIdCliente(idCliente);

        atencion.setPersonal(personal);
        atencion.setTipoatencion(tipoatencion);
        atencion.setMascota(mascota);
        atencion.setCliente(cliente);

        respuesta = atenciondao.guardarAtencion(atencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("error", "REVICE"));
        }
        return "/RegistroAtencion";
    }

    public ArrayList<Atencion> listarAtencion() {
        ArrayList<Atencion> milista = new ArrayList<>();
        AtencionDao dao = new AtencionDao();
        milista = dao.listarAtencion();
        return milista;
    }

    public String actualizarAtencion() {
        atenciondao = new AtencionDao();
        personal.setIdPersonal(idPersonal);
        tipoatencion.setIdTipoAtencion(idTipoAtencion);
        mascota.setIdMascota(idMascota);
        cliente.setIdCliente(idCliente);

        atencion.setPersonal(personal);
        atencion.setTipoatencion(tipoatencion);
        atencion.setMascota(mascota);
        atencion.setCliente(cliente);

        respuesta = atenciondao.actualizarAtencion(atencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SE ACTUALIZÓ ", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(" error", "REVICE!!!!"));
        }
        limpiar();
        return "/RegistroAtencion";
    }

    public String eliminarAtencion(Atencion atencion) {
        atenciondao = new AtencionDao();
        personal.setIdPersonal(idPersonal);
        tipoatencion.setIdTipoAtencion(idTipoAtencion);
        mascota.setIdMascota(idMascota);
        cliente.setIdCliente(idCliente);

        atencion.setPersonal(personal);
        atencion.setTipoatencion(tipoatencion);
        atencion.setMascota(mascota);
        atencion.setCliente(cliente);

        respuesta = atenciondao.eliminarAtencion(atencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "eliminado UN DATO", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("error al eliminar", "exito"));
        }

        return "/RegistroAtencion";
    }

    public String limpiar() {

        atencion = new Atencion();
        return "/RegistroAtencion";
    }

    public void cambiarSeleccion() {
        seleccionado = true;
        idPersonal = atencion.getPersonal().getIdPersonal();
        idTipoAtencion = atencion.getTipoatencion().getIdTipoAtencion();
        idMascota = atencion.getMascota().getIdMascota();
        idCliente = atencion.getCliente().getIdCliente();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public ArrayList<Mascota> getListaMascota() {
        return listaMascota;
    }

    public void setListaMascota(ArrayList<Mascota> listaMascota) {
        this.listaMascota = listaMascota;
    }

    public int getIdTipoAtencion() {
        return idTipoAtencion;
    }

    public void setIdTipoAtencion(int idTipoAtencion) {
        this.idTipoAtencion = idTipoAtencion;
    }

    public ArrayList<Tipoatencion> getListaTipoatencion() {
        return listaTipoatencion;
    }

    public void setListaTipoatencion(ArrayList<Tipoatencion> listaTipoatencion) {
        this.listaTipoatencion = listaTipoatencion;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public ArrayList<Personal> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ArrayList<Personal> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public AtencionDao getAtenciondao() {
        return atenciondao;
    }

    public void setAtenciondao(AtencionDao atenciondao) {
        this.atenciondao = atenciondao;
    }

    public Atencion getAtencion() {
        return atencion;
    }

    public void setAtencion(Atencion atencion) {
        this.atencion = atencion;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public Tipoatencion getTipoatencion() {
        return tipoatencion;
    }

    public void setTipoatencion(Tipoatencion tipoatencion) {
        this.tipoatencion = tipoatencion;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
