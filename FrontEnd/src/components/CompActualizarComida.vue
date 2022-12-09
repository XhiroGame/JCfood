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
            <form class="login-form validate-form" id="formLogin" v-on:submit.prevent="ActualizarComida">
                <span class="login-form-title">Actualizar Comida</span>
                <br>
                <div class="wrap-input100" data-validate="Cedula  incorrecta">
                    <input class="input100" type="text" id="busqueda" name="busqueda" placeholder="busqueda"
                        v-model="busqueda" required />
                    <span class="focus-efecto"></span>
                </div>

                <div class="wrap-input100">
                    <input class="input100  " type="text" id="nombre" name="nombre" placeholder="nombre"
                        v-model="comida.nombre" required />
                    <span class="focus-efecto"></span>
                </div>
                <div class="wrap-input100">
                    <input class="input100" type="number" id="precio" name="precio" placeholder="precio"
                        v-model="comida.precio" required />
                    <span class="focus-efecto"></span>
                </div>

                <div class="wrap-input100">
                    <div class="form-group">
                        <label for="ciudades"><strong>Tamaño</strong></label>
                        <select class="form-control" id="tamano" name="tamano" v-model="comida.tamano" required>

                            <option value="pequeno" selected>Pequeño</option>
                            <option value="mediano">Mediano</option>
                            <option value="grande">Grande</option>
                        </select>
                    </div>
                </div>

                <div class="wrap-input100">
                    <input class="input100" type="text" id="descripcion" name="descripcion" placeholder="descripcion"
                        v-model="comida.descripcion" required />
                    <span class="focus-efecto"></span>
                </div>
                

                <div class="container-login-form-btn">

                    <div class="wrap-login-form-btn">
                        <div class="login-form-bgbtn"></div>

                        <button type="button" name="" class="login- form-btn" v-on:click="BuscarComida">BUSCAR</button>
                        <br>
                    </div>

                </div>
                <div class="container-login-form-btn">

                    <div class="wrap-login-form-btn">
                        <div class="login-form-bgbtn"></div>

                        <button type="button" name="" class="login- form-btn"
                            v-on:click="ActualizarComida">ACTUALIZAR</button>
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
        return {
            busqueda: "",
            comida: {},
            id: "",
            nombre: "",
            precio: "",
            tamano: "",
            descripcion: "",

        }
    },

    methods: {

        BuscarComida() {
            var endpoint = "http://localhost:8080/comida/comida/" + this.busqueda;
            var opciones = { method: "GET" };
            fetch(endpoint, opciones)
                .then(response => response.json())
                .then(data => { this.comida = data; console.log(data) })


        },
        ActualizarComida() {
            var endpoint = "http://localhost:8080/comida/actualizar";
            var opciones = {
                method: "POST",
                headers: { "Content-type": "Application/json" },
                body: JSON.stringify({ id: this.comida.id, nombre: this.comida.nombre, precio: this.comida.precio, tamano: this.comida.tamano, descripcion: this.comida.descripcion })
            }
            fetch(endpoint, opciones).then(async Response => {
                // alert('Guardado Correctamente');
                try {
                    if (Response.status)
                        Swal.fire({
                            icon: 'question',
                            title: 'Desea Actualizar Comida?',
                            showDenyButton: true,
                            showCancelButton: false,
                            confirmButtonText: 'Actualizar',
                            denyButtonText: `Cancelar`,
                        }).then((result) => {
                            if (result.isConfirmed) {
                                Swal.fire('Actualizado con exito', '', 'success')
                                this.$router.push('/GestionComida');

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