<template>
    <head>
        
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="estilos.css">
    <link rel="stylesheet" href="plugins/sweetalert2/sweetalert2.min.css">        
    <link rel="stylesheet" type="text/css" href="fuentes/iconic/css/material-design-iconic-font.min.css">
    </head>
 <div class="container-login">
    <div class="wrap-login">
        <form class="login-form validate-form" id="formLogin" v-on:submit.prevent="GuardarUsuario">
            <span class="login-form-title">Registro Usuario</span>
            <br>
            <div class="wrap-input100" data-validate = "Cedula  incorrecta">
                <input class="input100" type="text" id="codigo" name="codigo" placeholder="codigo" v-model="codigo" required />
                <span class="focus-efecto"></span>
            </div>  
            <div class="wrap-input100" data-validate = "Nombre  incorrecto">
                <input class="input100" type="text" id="nombre" name="nombre" placeholder="nombre" v-model="nombre" required />
                <span class="focus-efecto"></span>
            </div>
            <div class="wrap-input100" data-validate = "Apellido incorrecto">
                <input class="input100" type="text" id="apellido" name="apellido" placeholder="apellido" v-model="apellido" required />
                <span class="focus-efecto"></span>
            </div>
            <div class="wrap-input100" data-validate = "Usuario incorrecto">
                <input class="input100" type="text" id="nombre_usuario" name="nombre_usuario" placeholder="nombre_usuario" v-model="usuario" required />
                <span class="focus-efecto"></span>
            </div>
            <div class="wrap-input100" data-validate = "Correo incorrecto">
                <input class="input100" type="text" id="correo" name="correo" placeholder="correo" v-model="correo" required />
                <span class="focus-efecto"></span>
            </div>
            <div class="wrap-input100" data-validate = "Telefono incorrecto">
                <input class="input100" type="text" id="telefono" name="telefono" placeholder="telefono" v-model="telefono" required />
                <span class="focus-efecto"></span>
            </div>          
            <div class="wrap-input100" data-validate="Password incorrecto">
                <input class="input100" type="password" id="contrasena" name="contrasena" placeholder="contrasena" v-model="contrasena" required />
                <span class="focus-efecto"></span>
            </div>
            
            <div class="container-login-form-btn">
                <div class="wrap-login-form-btn">
                    <div class="login-form-bgbtn"></div>
                    
                    <button type="button" name="" class="login- form-btn" v-on:click="GuardarUsuario">REGISTRAR</button>
                    <br>
                </div>
            </div>
        </form>
    </div>
</div>   

</template>

<script>
export default {
data() {
    return {
        codigo: "",
        nombre: "",
        apellido: "",
        usuario: "",
        correo: "",
        telefono: "",
        contrasena: "",


        //datos: [],
        // busqueda: "",
        // estudiante: "",
    }
},
methods: {
    GuardarUsuario() {
        var endpoint = "http://localhost:8080/usuarios/guardar";
        var opciones = {
            method: "POST",
            headers: { "Content-type": "Application/json" },
            body: JSON.stringify({ codigo: this.codigo, nombre: this.nombre, apellido: this.apellido, usuario: this.usuario, correo: this.correo,telefono: this.telefono, contrasena: this.contrasena })
        }
        fetch(endpoint, opciones).then(async Response => {
            // alert('Guardado Correctamente');
            try {
                if (Response.status)
                    Swal.fire({
                        icon: 'question',
                        title: 'Desea Registrar Usuario?',
                        showDenyButton: true,
                        showCancelButton: false,
                        confirmButtonText: 'Registrar',
                        denyButtonText: `Cancelar`,
                    }).then((result) => {
                        if (result.isConfirmed) {
                            Swal.fire('Guardado con exito', '', 'success')
                            this.$router.push('/');

                        } else if (result.isDenied) {
                            Swal.fire('Los cambios no se guardaron', '', 'warning')
                            return false
                        }
                    })
                else {
                    alert("error")
                }
            } catch (error) {
                return "{\"sucess\":false ,\"message\":\"Error al intentar registrar.\"}";
            }
        })
    }
    // ValidarUsuario() {
    //     var endpoint = "http://localhost:8080/usuario/login";
    //     var opciones = {
    //         method: "POST",
    //         headers: { "Content-type": "Application/json" },
    //         body: JSON.stringify({ email: this.email, pass: this.pass})
    //     }
}

}
</script>

   

