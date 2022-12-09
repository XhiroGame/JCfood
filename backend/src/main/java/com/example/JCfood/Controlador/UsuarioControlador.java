package com.example.JCfood.Controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.example.JCfood.Modelo.UsuarioModelo;
import com.example.JCfood.Servicio.UsuarioServicio;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio servicios;

    @GetMapping("/")
    public String obtenerUsuarios() {

        try {
            ArrayList<UsuarioModelo> usuarios = servicios.consultarUsuarios();

            Gson json = new Gson();

            if (usuarios == null)
                return "consulta erronea";
            else if (usuarios.size() == 0)
                return "no se encuentran usuarios";
            else {

                return   json.toJson(usuarios) ;
                        
            }

        } catch (Exception e) {
            return "consulta erronea";
        }

    }

    @GetMapping("/usuario/{id}")
    public String consultarUsuario(@PathVariable("id") Long id) {
        try {
            Optional<UsuarioModelo> usuario = servicios.consultarUsuario(id);

            Gson json = new Gson();

            if (usuario == null)
                return "consulta erronea";
            else {

                return  json.toJson(usuario.get());
            }
        } catch (Exception e) {
            return "consulta erronea";
        }
    }

    @PostMapping(value = "/guardar")
    public String guardarUsuario(@RequestBody UsuarioModelo  nombre_usuario) {
        try {

            if ( nombre_usuario != null) {
                Boolean respuesta = servicios.guardarUsuario( nombre_usuario);

                if (respuesta)
                    return "Usuario Guardado";
                else
                    return "No se pudo guardar el usuario, algo anda mal";
            } else
                return "No se puede guardar si no llenas los campos";
        } catch (Exception e) {
            return "consulta erronea";
        }
    }

    @PostMapping(value = "/actualizar")
    public String actualizarUsuario(@RequestBody UsuarioModelo usuario) {
        try {
            boolean response = servicios.actualizarUsuario(usuario);

            if (response)
                return "Usuario actualizado";
            else
                return "No se pudo actualizar el usuario, revisa los datos suministrados";
        } catch (Exception e) {
            return "consulta erronea";
        }
    }


    @DeleteMapping(value = "/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        try {
            boolean response = servicios.eliminarUsuario(id);
            if (response)
                return "el usuario ah sido eliminado";
            else
                return "No se pudo eliminar el usuario";
        } catch (Exception e) {
            return "consulta erronea";
        }
    }

    @GetMapping(path = "/login/{usuario}/{contrasena}")
    public ArrayList<UsuarioModelo> Login(@PathVariable("usuario") String usuario , @PathVariable("contrasena") String contrasena) {
    return servicios.Login(usuario,contrasena);
   }
}
