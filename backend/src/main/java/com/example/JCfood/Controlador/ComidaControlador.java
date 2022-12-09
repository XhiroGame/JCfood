package com.example.JCfood.Controlador;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.example.JCfood.Modelo.ComidaModelo;
import com.example.JCfood.Servicio.ComidaServicio;


@RestController
@RequestMapping("/comida")
@CrossOrigin("*")
public class ComidaControlador {

    @Autowired
    ComidaServicio servicios;

    @GetMapping("/ver")
    public String obtenerComidas() {

        try {
            ArrayList<ComidaModelo> comidas = servicios.consultarComidas();

            Gson json = new Gson();

            if (comidas == null)
                return " error al consultar";
            else if (comidas.size() == 0)
                return "No hay comidas que mostrar";
            else {

                return 
                         json.toJson(comidas);
                
            }

        } catch (Exception e) {
            return " error al hacer la consulta";
        }

        
    }

    @GetMapping("/comida/{id}")
    public String consultarComida(@PathVariable("id") Long id) {

       

        
        try {
            Optional<ComidaModelo> usuario = servicios.consultarComida(id);

            Gson json = new Gson();

            if (usuario == null)
                return " error al hacer la consulta";
            else {

                return json.toJson(usuario.get());
            }
        } catch (Exception e) {
            return " error al hacer la consulta";
        }

        
    }

    @PostMapping(value = "/guardar")
    public String guardarComida(@RequestBody ComidaModelo comida) {
        try {

            if (comida != null) {
                Boolean respuesta = servicios.guardarComida(comida);

                if (respuesta)
                    return "comida almacenado correctamente";
                else
                    return "No se pudo almacenar la comida, revisa los datos";
            } else
                return "No se puede almacenar una campo de comida vacio";
        } catch (Exception e) {
            return " error al hacer la consulta";
        }
    }

    


    @PostMapping(value = "/actualizar")
    public String actualizarComida(@RequestBody ComidaModelo user) {
        try {
            boolean response = servicios.actualizarComida(user);

            if (response)
                return "comida actualizado correctamente";
            else
                return "No se pudo actualizar el comida, revisa los parametros";
        } catch (Exception e) {
            return "Ocurrio un error al hacer la consulta";
        }
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public String eliminarComida(@PathVariable Long id){
        try {
            boolean response = servicios.eliminarcomida(id);
            if(response) return "comida eliminada correctamente";
            else return "No se pudo eliminar la comida, revisa los datos";
        } catch (Exception e) {
            return "Ocurrio un error al hacer la consulta";
        }
    }

    
    
}
