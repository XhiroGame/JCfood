package com.example.JCfood.Modelo;

import org.springframework.data.annotation.Id;

public class UsuarioModelo {

    @Id
    private int codigo;
    private String nombre;
    private String apellido;
    private String usuario;
    private String correo;
    private long telefono;
    private String contrasena;
    
    
    public UsuarioModelo() {
    }


    public UsuarioModelo(int codigo, String nombre, String apellido, String usuario, String correo, long telefono,
            String contrasena) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getUsuario() {
        return usuario;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public long getTelefono() {
        return telefono;
    }


    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }


    public String getContrasena() {
        return contrasena;
    }


    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
   
   

    


    

    

    
    
}
