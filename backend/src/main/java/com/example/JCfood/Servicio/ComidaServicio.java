package com.example.JCfood.Servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JCfood.Modelo.ComidaModelo;
import com.example.JCfood.Repositorio.ComidaRepo;

@Service
public class ComidaServicio {

    @Autowired
    ComidaRepo repositorio;

    public boolean guardarComida(ComidaModelo comida) {

        try {
            ComidaModelo respuesta = repositorio.save(comida);
            if (respuesta != null)
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean actualizarComida(ComidaModelo comida) {

        try {
            if (repositorio.existsById((long) comida.getId())) {
                repositorio.save(comida);
                return true;
            } else
                return false;

        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<ComidaModelo> consultarComidas() {
        try {
            return (ArrayList<ComidaModelo>)repositorio.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public Optional<ComidaModelo> consultarComida(Long id) {

        try {
            if(!repositorio.existsById(id))return null;
            else return repositorio.findById(id);
        } catch (Exception e) {
            return null;
        }
    }


    public boolean eliminarcomida(Long id) {
        try {
            if (repositorio.existsById(id)) {
                repositorio.deleteById(id);
                return true;
            } else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

}
