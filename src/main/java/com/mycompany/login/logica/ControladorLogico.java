package com.mycompany.login.logica;

import com.mycompany.login.persistencia.ControladorPersistencia;

//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
import java.util.List;

public class ControladorLogico {

    ControladorPersistencia conPersi;

    public ControladorLogico() {
        conPersi = new ControladorPersistencia();
    }

    public Usuario validarUsuario(String usuario, String contrasenia) {
        Usuario usr = null;
        List<Usuario> listaUsuarios = conPersi.traerUsuario();

        for (Usuario usu : listaUsuarios) {
            if (usu.getUsuario().equals(usuario)) {
                if (usu.getContrasenia().equals(contrasenia)) {
                    usr = usu;
                    return usr;
                    //return mensaje="el usuario y contrasenia son Correctos, Bien Venidos!";
                } else {
                    usr = null;
                    return usr;
                }

                //mensaje="la contrasenia es incorrecta";
            } else {
                usr = null;
                // return usr;
            }

            // //mensaje="el usuario es incorrecto";
        }
        return usr;
    }

    public List<Usuario> traerUsuarios() {
        return conPersi.traerUsuario();

    }

    public List<Rol> traerRoles() {

        return conPersi.traerRoles();

    }

    public void crearUsuario(String usuario, String contrasenia, String rolRecibido) {

        Usuario usu = new Usuario();
        usu.setUsuario(usuario);
        usu.setContrasenia(contrasenia);

        Rol rolEncontrado = new Rol();

        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }

        int id = this.buscarUltimaIdUsuarios();

        usu.setId(id + 1);

        conPersi.crearUsuario(usu);
    }

    private Rol traerRol(String rolRecibido) {

        List<Rol> listaRoles = conPersi.traerRoles();
        for (Rol rol : listaRoles) {
            if (rol.getNombreRol().equals(rolRecibido)) {
                return rol;
            }
        }
        return null;
    }

    private int buscarUltimaIdUsuarios() {
        List<Usuario> listaUsuarios = this.traerUsuarios();
        int max = 0;
        for (Usuario usu : listaUsuarios) {
            if (usu.getId() > max) {
                max = usu.getId();

            }
        }
        return max;
        // Usuario usu = listaUsuarios.get(listaUsuarios.size()-1);
        // return usu.getId();
    }

    public void eliminarUsuario(int id_usuario) {

        conPersi.eliminarUsuario(id_usuario);

    }

    public void editarUsuario(Usuario usuario1, String usuario, String contrasenia, String rolRecibido) {
        usuario1.setUsuario(usuario);
        usuario1.setContrasenia(contrasenia);

        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null) {
            usuario1.setUnRol(rolEncontrado);
        }
        conPersi.editarUsuario(usuario1);
    }

}
