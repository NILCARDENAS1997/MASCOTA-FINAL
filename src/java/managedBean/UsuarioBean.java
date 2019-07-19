package managedbean;

import utilitarios.HibernateUtil;
import dao.ClienteDao;

import dao.PersonalDao;
import dao.UsuarioDao;
import entidades.Cliente;

import entidades.Personal;
import entidades.Usuario;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;


@ManagedBean
@ViewScoped

public class UsuarioBean {

    private int idCliente;
    private ArrayList<Cliente> listarClientes;

    private int idPersonal;
    private ArrayList<Personal> listaPersonal;

    private UsuarioDao usuariodao;
    private Usuario usuario;
    private boolean seleccionado = false;
    
    private boolean respuesta;
    private Cliente cliente;
    private Personal personal;

    //constructor
    public UsuarioBean() {

        listarClientes = new ArrayList<>();
        listarClientes();

        listaPersonal = new ArrayList<>();
        listarPersonal();

        this.usuario = new Usuario();
        this.cliente = new Cliente();
        this.personal = new Personal();

    }

    //metodo
    public void listarClientes() {
        ClienteDao dao = new ClienteDao();
        listarClientes = dao.listarCliente();
    }

    public void listarPersonal() {
        PersonalDao dao = new PersonalDao();
        listaPersonal = dao.listarPersonal();
    }

    public String guardar() {
        usuariodao = new UsuarioDao();
        cliente.setIdCliente(idCliente);
        personal.setIdPersonal(idPersonal);

        usuario.setCliente(cliente);
        usuario.setPersonal(personal);
        respuesta = usuariodao.guardarUsuario(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro insertado", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("error", "REVICE"));
        }
        return "/RegistroUsuario";
    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> milista = new ArrayList<>();
        UsuarioDao dao = new UsuarioDao();
        milista = dao.listarUsuarios();
        return milista;
    }

    public String actualizarUsuario() {
        usuariodao = new UsuarioDao();
        cliente.setIdCliente(idCliente);
        personal.setIdPersonal(idPersonal);

        usuario.setCliente(cliente);
        usuario.setPersonal(personal);
        respuesta = usuariodao.actualizarUsuario(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SE ACTUALIZÓ ", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(" error", "REVICE!!!!"));
        }
         limpiar();
        return "/RegistroUsuario";
    }

    public String eliminarUsuario(Usuario usuario) {
        usuariodao = new UsuarioDao();
        cliente.setIdCliente(idCliente);
        personal.setIdPersonal(idPersonal);

        usuario.setCliente(cliente);
        usuario.setPersonal(personal);
        respuesta = usuariodao.eliminarUsuario(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "eliminado UN DATO", "exito"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("error al eliminar", "exito"));
        }
       
        return "/RegistroUsuario";
    }

    public String limpiar() {
         
        usuario = new Usuario();
        return "/RegistroUsuario";
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<Cliente> getListaCliente() {
        return listarClientes;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listarClientes = listaCliente;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void cambiarSeleccion() {
        seleccionado = true;
        idCliente = usuario.getCliente().getIdCliente();
        idPersonal = usuario.getPersonal().getIdPersonal();
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

}
