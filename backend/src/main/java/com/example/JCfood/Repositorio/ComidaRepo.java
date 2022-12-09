package com.example.JCfood.Repositorio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.JCfood.Modelo.ComidaModelo;

@Repository
public interface ComidaRepo extends MongoRepository<ComidaModelo, Long> {
    
}
