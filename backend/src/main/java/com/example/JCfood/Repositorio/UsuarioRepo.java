package com.example.JCfood.Repositorio;
import java.util.ArrayList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.JCfood.Modelo.UsuarioModelo;


@Repository
public interface UsuarioRepo extends MongoRepository<UsuarioModelo,Long>{

public ArrayList<UsuarioModelo> findByUsuarioAndContrasena(String usuario, String contrasena);
    
}
