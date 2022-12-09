<template>
    <head>
        <head>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="estilos.css">
        <link rel="stylesheet" href="plugins/sweetalert2/sweetalert2.min.css">        
        
        <link rel="stylesheet" type="text/css" href="fuentes/iconic/css/material-design-iconic-font.min.css">
  </head>
    </head>
    <div class="container-login">
        <div class="wrap-login">
            <form class="login-form validate-form" id="formLogin" v-on:submit.prevent="ActualizarUsuario">
                <span class="login-form-title">Actualizar Usuario</span>
                <br>
                <div class="wrap-input100" data-validate = "Cedula  incorrecta">
                    <input class="input100" type="text" id="busqueda" name="busqueda" placeholder="busqueda" v-model="busqueda" required />
                    <span class="focus-efecto"></span>  
                </div> 
           
                <div class="wrap-input100" >
                    <input class="input100  " type="text" id="nombre" name="nombre" placeholder="nombre" v-model="usuario.nombre" required />
                    <span class="focus-efecto"></span>
                </div>
                <div class="wrap-input100" >
                    <input class="input100" type="text" id="apellido" name="apellido" placeholder="apellido" v-model="usuario.apellido" required />
                    <span class="focus-efecto"></span>
                </div>
                <div class="wrap-input100" >
                    <input class="input100" type="text" id="nombre_usuario" name="nombre_usuario" placeholder="nombre_usuario" v-model="usuario.nombre_usuario" required />
                    <span class="focus-efecto"></span>
                </div>
                <div class="wrap-input100" >
                    <input class="input100" type="text" id="correo" name="correo" placeholder="correo" v-model="usuario.correo" required />
                    <span class="focus-efecto"></span>
                </div>
                <div class="wrap-input100" >
                    <input class="input100" type="text" id="telefono" name="telefono" placeholder="telefono" v-model="usuario.telefono" required />
                    <span class="focus-efecto"></span>
                </div>          
                <div class="wrap-input100" data-validate="Password incorrecto" >
                    <input class="input100" type="text" id="contrasena" name="contrasena" placeholder="contrasena" v-model="usuario.contrasena" required />
                    <span class="focus-efecto"></span>
                </div>
                
                <div class="container-login-form-btn">
                    
                    <div class="wrap-login-form-btn">
                        <div class="login-form-bgbtn"></div>
                        
                        <button type="button" name="" class="login- form-btn" v-on:click="BuscarUsuario">BUSCAR</button>
                        <br>
                    </div>
                    
                </div>
                <div class="container-login-form-btn">
                    
                    <div class="wrap-login-form-btn">
                        <div class="login-form-bgbtn"></div>
                        
                        <button type="button" name="" class="login- form-btn" v-on:click="ActualizarUsuario">ACTUALIZAR</button>
                        <br>
                    </div>
                    
                </div>
            </form>
        </div>
    </div>  
</template>
<style>

</style>

<script>
 
export default {
   
    data() {
        return{
            busqueda: "",
            usuario: {},
            codigo: "",
            nombre: "",
            apellido:"",
            nombre_usuario:"",
            correo: "",
            telefono: "",
            contrasena:"",
            
            // pass: "",

            // datos: [],

        }
    },

    methods: {
      
        BuscarUsuario() {
            var endpoint = "http://localhost:8080/usuarios/usuario/" + this.busqueda;
            var opciones = { method: "GET" };
            fetch(endpoint, opciones)
            .then( response => response.json())
            .then( data => {this.usuario = data; console.log(data)})
            
            
        },
        ActualizarUsuario() {
            var endpoint = "http://localhost:8080/usuarios/actualizar";
            var opciones = {
                method: "POST",
                headers: { "Content-type": "Application/json" },
                body: JSON.stringify({ codigo: this.usuario.codigo, nombre: this.usuario.nombre, apellido: this.usuario.apellido, nombre_usuario: this.usuario.nombre_usuario, correo: this.usuario.correo, telefono: this.usuario.telefono, contrasena: this.usuario.contrasena })
            }
            fetch(endpoint, opciones).then(async Response => {
                // alert('Guardado Correctamente');
                try {
                    if (Response.status)
                        Swal.fire({
                            icon: 'question',
                            title: 'Desea Actualizar Usuario?',
                            showDenyButton: true,
                            showCancelButton: false,
                            confirmButtonText: 'Actualizar',
                            denyButtonText: `Cancelar`,
                        }).then((result) => {
                            if (result.isConfirmed) {
                                Swal.fire('Actualizado con exito', '', 'success')
                                this.$router.push('/actualizarUsuario');

                            } else if (result.isDenied) {
                                Swal.fire('Los cambios no se Actualizaron', '', 'warning')
                                return false
                            }
                        })
                    else {
                        alert("error")
                    }
                } catch (error) {
                    return "{\"sucess\":false ,\"message\":\"Error al intentar actualizar.\"}";
                }
            })
        }
    }
    
}
</script>