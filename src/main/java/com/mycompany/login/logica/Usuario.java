
package com.mycompany.login.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Usuario implements Serializable {
    @Id
  //  @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String usuario;
    private String contrasenia;
    @ManyToOne
    @JoinColumn(name="ID_ROL")
    private Rol unRol;

    public Usuario() {
    }

    public Usuario(int id, String usuario, String contrasenia, Rol unRol) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.unRol = unRol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getUnRol() {
        return unRol;
    }

    public void setUnRol(Rol unRol) {
        this.unRol = unRol;
    }

    

    
    
    
    
}
