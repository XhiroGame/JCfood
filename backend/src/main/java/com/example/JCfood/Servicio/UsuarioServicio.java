package com.example.JCfood.Servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JCfood.Modelo.UsuarioModelo;
import com.example.JCfood.Repositorio.UsuarioRepo;

@Service
public class UsuarioServicio {
    
    @Autowired
    UsuarioRepo repositorio;


    public boolean guardarUsuario(UsuarioModelo nombre_usuario){

        try {
            UsuarioModelo respuesta = repositorio.save( nombre_usuario);
            if(respuesta != null)
                return true;
            else return false;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean actualizarUsuario(UsuarioModelo user){

        try {
            if(repositorio.existsById((long) user.getCodigo())){
                repositorio.save(user);
                return true;
            }else return false;
            
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<UsuarioModelo> consultarUsuarios(){
        try {
            return (ArrayList<UsuarioModelo>)repositorio.findAll();
        } catch (Exception e) {
            return null;
        }
    }


    public Optional<UsuarioModelo> consultarUsuario(Long id){

        try {
            if(!repositorio.existsById(id))return null;
            else return repositorio.findById(id);
        } catch (Exception e) {
            return null;
        }
    }


    public boolean eliminarUsuario(Long id){
        try {
            if(repositorio.existsById(id)){
                repositorio.deleteById(id);
                return true;
            }else return false;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<UsuarioModelo> Login(String usuario, String contrasena) {
        ArrayList<UsuarioModelo> login = repositorio.findByUsuarioAndContrasena(usuario, contrasena);
        return login;
    }
}
