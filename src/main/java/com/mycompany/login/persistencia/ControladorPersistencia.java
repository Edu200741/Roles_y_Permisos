
package com.mycompany.login.persistencia;

import com.mycompany.login.logica.Rol;
import com.mycompany.login.logica.Usuario;
import com.mycompany.login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladorPersistencia {
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();

    public List<Usuario> traerUsuario() {

        return usuJpa.findUsuarioEntities();
    
    }

    public List<Rol> traerRoles() {
 
    return rolJpa.findRolEntities();
    
    
    
    }

    public void crearUsuario(Usuario usu) {
        usuJpa.create(usu);
    
    }

    public void eliminarUsuario(int id_usuario) {

        try {
            usuJpa.destroy(id_usuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    public void editarUsuario(Usuario usuario1) {
 
    
        try {
            usuJpa.edit(usuario1);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
