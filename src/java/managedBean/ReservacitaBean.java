package managedbean;

import utilitarios.HibernateUtil;
import dao.ClienteDao;


import dao.ReservacitaDao;
import dao.TipoReservaDao;
import dao.UsuarioDao;
import entidades.Cliente;


import entidades.Reservacista;
import entidades.Tiporeserva;
import entidades.Usuario;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@ViewScoped

public class ReservacitaBean {

    private int idCliente;
    private ArrayList<Cliente> listaCliente;

    private int idTipoReserva;
    private ArrayList<Tiporeserva> listaTiporeserva;
    
    private int idUsuario;
    private ArrayList<Usuario> listaUsuario;

    private ReservacitaDao reservacistadao;
    private Reservacista reservacista;
    private boolean seleccionado = false;
    
    private boolean respuesta;
    private Cliente cliente;
    private Usuario usuario;
    private Tiporeserva tiporeserva;

    //constructor
    public ReservacitaBean() {

        listaCliente = new ArrayList<>();
        listarCliente();

        listaUsuario = new ArrayList<>();
        listarUsuario();
        
        listaTiporeserva = new ArrayList<>();
        listarTiporeserva();

        this.reservacista = new Reservacista();
        this.cliente = new Cliente();
        this.usuario = new Usuario();
        this.tiporeserva = new Tiporeserva();

    }

    //metodo
    public void listarCliente() {
        ClienteDao dao = new ClienteDao();
        listaCliente = dao.listarCliente();
    }

    public void listarUsuario() {
        UsuarioDao dao = new UsuarioDao();
        listaUsuario = dao.listarUsuarios();
    }
    public void listarTiporeserva() {
        TipoReservaDao dao = new TipoReservaDao();
        listaTiporeserva = dao.listarTiporeserva();
    }

    public String guardarReservacista() {
        reservacistadao = new ReservacitaDao();
        cliente.setIdCliente(idCliente);
        usuario.setIdUsuario(idUsuario);
        tiporeserva.setIdTipoReserva(idTipoReserva);

        reservacista.setCliente(cliente);
        reservacista.setUsuario(usuario);
        reservacista.setTiporeserva(tiporeserva);
        respuesta = reservacistadao.guardarReservacista(reservacista);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("error", "REVICE"));
        }
        return "/RegistroTipoReservaCita";
    }

    public ArrayList<Reservacista> listarReservacistas() {
        ArrayList<Reservacista> milista = new ArrayList<>();
        ReservacitaDao dao = new ReservacitaDao();
        milista = dao.listarReservacista();
        return milista;
    }

    public String actualizarReservacista() {
        reservacistadao = new ReservacitaDao();
        cliente.setIdCliente(idCliente);
        usuario.setIdUsuario(idUsuario);
        tiporeserva.setIdTipoReserva(idTipoReserva);

        reservacista.setCliente(cliente);
        reservacista.setUsuario(usuario);
        reservacista.setTiporeserva(tiporeserva);
        respuesta = reservacistadao.actualizarReservacista(reservacista);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SE ACTUALIZÓ ", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(" error", "REVICE!!!!"));
        }
         limpiar();
        return "/RegistroTipoReservaCita";
    }

    public String eliminarReservacista(Usuario usuario) {
        reservacistadao = new ReservacitaDao();
        cliente.setIdCliente(idCliente);
        usuario.setIdUsuario(idUsuario);
        tiporeserva.setIdTipoReserva(idTipoReserva);

        reservacista.setCliente(cliente);
        reservacista.setUsuario(usuario);
        reservacista.setTiporeserva(tiporeserva);
        respuesta = reservacistadao.eliminarReservacista(reservacista);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "eliminado UN DATO", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("error al eliminar", "exito"));
        }
       
        return "/RegistroTipoReservaCita";
    }

    public String limpiar() {
         
        usuario = new Usuario();
        return "/RegistroTipoReservaCita";
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


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void cambiarSeleccion() {
        seleccionado = true;
        idCliente = reservacista.getCliente().getIdCliente();
        idUsuario = reservacista.getUsuario().getIdUsuario();
        idTipoReserva = reservacista.getTiporeserva().getIdTipoReserva();
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public int getIdTipoReserva() {
        return idTipoReserva;
    }

    public void setIdTipoReserva(int idTipoReserva) {
        this.idTipoReserva = idTipoReserva;
    }

    public ArrayList<Tiporeserva> getListaTiporeserva() {
        return listaTiporeserva;
    }

    public void setListaTiporeserva(ArrayList<Tiporeserva> listaTiporeserva) {
        this.listaTiporeserva = listaTiporeserva;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public ReservacitaDao getReservacistadao() {
        return reservacistadao;
    }

    public void setReservacistadao(ReservacitaDao reservacistadao) {
        this.reservacistadao = reservacistadao;
    }

    public Reservacista getReservacista() {
        return reservacista;
    }

    public void setReservacista(Reservacista reservacista) {
        this.reservacista = reservacista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tiporeserva getTiporeserva() {
        return tiporeserva;
    }

    public void setTiporeserva(Tiporeserva tiporeserva) {
        this.tiporeserva = tiporeserva;
    }

}
