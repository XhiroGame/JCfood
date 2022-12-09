package com.example.JCfood.Modelo;

import org.springframework.data.annotation.Id;

public class ComidaModelo {

    @Id
    private int id;
    private String nombre;
    private String precio;
    private String tamano;
    private String descripcion;
    private String imagen;
    
    public ComidaModelo(int id, String nombre, String precio, String tamano, String descripcion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tamano = tamano;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
    