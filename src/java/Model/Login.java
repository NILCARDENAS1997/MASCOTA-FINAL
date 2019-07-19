package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@NamedQueries({@NamedQuery(name="inicioSesion", query="from Login as l where l.usuario = :user and l.pass = :pass")})
@Entity
@Table(name="Login")
public class Login implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idLogin")
    private Integer idLogin;
    
    @Size(min = 1, max = 25)
    @Column(name="usuario", nullable = false, length = 25)
    private String usuario;
    
    @Size(min = 1, max = 32)
    @Column(name="pass", nullable = false, length = 32)
    private String pass;
    
    @Column(name="imagen")
    private String imagen;
    
    //-----Many To One-----//


    public Login() {
    }

    public Login(Integer idLogin, String usuario, String pass, String imagen) {
        this.idLogin = idLogin;
        this.usuario = usuario;
        this.pass = pass;
        this.imagen = imagen;
 
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    
}