<template>

    <head>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="estilos.css">
        <link rel="stylesheet" href="plugins/sweetalert2/sweetalert2.min.css">

        <link rel="stylesheet" type="text/css" href="fuentes/iconic/css/material-design-iconic-font.min.css">
    </head>
    <div class="container-login">
        <div class="wrap-login">
            <form class="login-form validate-form" id="formLogin" action="GET" @submit.prevent ="ValidarUsuario">
                <span class="login-form-title">Inicio de Sesión</span>
                <br><br><br>


                <div class="wrap-input100">
                    <input class="input100" type="text" id="usuario" name="usuario" placeholder="Usuario"
                        v-model="usuario" required>
                    <span class="focus-efecto"></span>
                </div>

                <div class="wrap-input100">
                    <input class="input100" type="password" id="contrasena" name="contrasena" placeholder="Contraseña"
                        v-model="contrasena" required>
                    <span class="focus-efecto"></span>
                </div>

                <div class="container-login-form-btn">
                    <div class="wrap-login-form-btn">
                        <div class="login-form-bgbtn"></div>
                        <button type="submit" name="" class="login- form-btn">Iniciar
                            Sesión</button>

                    </div>
                </div>
                <div class="container-login-form-btn">
                    <div class="wrap-login-form-btn">
                        <div class="login-form-bgbtn"></div>
                        <!-- <a href="registro.html" class="login-form-btn">REGISTRO</a> -->
                    </div>
                </div>
                <br>
                <div>
                    <!-- <a href="index.html">Entrar al sistema de administrador</a> -->

                </div>
            </form>
        </div>
    </div>
</template>

<script scoped>
export default {
    data() {
        return {
            usuario: "",
            contrasena: "",
        }
    },
    methods: {
        ValidarUsuario() {
            var endpoint = "http://localhost:8080/usuarios/login/" + this.usuario + '/' + this.contrasena;
            var opciones = { method: "GET" }
            fetch(endpoint, opciones).then(async response => {
                const resultado = await response.json();
                if (resultado.length >= 1) {
                    Swal.fire({
                        width: 300,
                        icon: 'success',
                        title: 'Correcto',
                        text: "Usuario Registrado",
                        showConfirmButton: false,
                        timer: 500
                    })
                    this.$router.push('/GestionComida')
                }
                else if (resultado.length != null) {
                    Swal.fire({
                        width: 300,
                        icon: 'error',
                        title: 'Usuario o Clave Incorrectos',
                        text: "Usuario no encontrado",
                        showConfirmButton: false,
                        timer: 1000
                    })
                }
            })
        }
    }
}

</script>