<template>
    <head>
        
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="estilos.css">
    <link rel="stylesheet" href="plugins/sweetalert2/sweetalert2.min.css">        
    <link rel="stylesheet" type="text/css" href="fuentes/iconic/css/material-design-iconic-font.min.css">
    </head>
 <div class="container-login">
    <div class="wrap-login">
        <form class="login-form validate-form" id="formLogin" v-on:submit.prevent="GuardarComida">
            <span class="login-form-title">Registro Comida</span>
            <br>
            <div class="wrap-input100" data-validate = "Id  incorrecto">
                <input class="input100" type="number" id="id" name="id" placeholder="id" v-model="id" required />
                <span class="focus-efecto"></span>
            </div>  
            <div class="wrap-input100" data-validate = "Nombre  incorrecto">
                <input class="input100" type="text" id="nombre" name="nombre" placeholder="Nombre" v-model="nombre" required />
                <span class="focus-efecto"></span>
            </div>
            <div class="wrap-input100" data-validate = "Precio incorrecto">
                <input class="input100" type="number" id="precio" name="precio" placeholder="Precio" v-model="precio" required />
                <span class="focus-efecto"></span>
            </div>
            <div class="wrap-input100">
              <div class="form-group">
                <label for="ciudades"><strong>Tamaño</strong></label>
                <select class="form-control" id="tamano" name="tamano"  v-model="tamano" required>
                  
                  <option value="pequeno" selected >Pequeño</option>
                  <option value="mediano">Mediano</option>
                  <option value="grande">Grande</option>
                </select>
              </div>
            </div>
            <div class="wrap-input100" data-validate = "">
                <input class="input100" type="text" id="descripcion" name="descripcion" placeholder="Descripcion" v-model="descripcion" required />
                <span class="focus-efecto"></span>
            </div>
           
            <div class="container-login-form-btn">
                <div class="wrap-login-form-btn">
                    <div class="login-form-bgbtn"></div>
                    
                    <button type="button" name="" class="login- form-btn" v-on:click="GuardarComida">GUARDAR</button>
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
        id: "",
        nombre: "",
        precio: "",
        tamano: "",
        descripcion: "",
     


        //datos: [],
        // busqueda: "",
        // estudiante: "",
    }
},
methods: {
    GuardarComida() {
        var endpoint = "http://localhost:8080/comida/guardar";
        var opciones = {
            method: "POST",
            headers: { "Content-type": "Application/json" },
            body: JSON.stringify({ id: this.id, nombre: this.nombre, precio: this.precio, tamano: this.tamano, descripcion: this.descripcion })
        }
        fetch(endpoint, opciones).then(async Response => {
            // alert('Guardado Correctamente');
            try {
                if (Response.status)
                    Swal.fire({
                        icon: 'question',
                        title: 'Desea Registrar la Comida?',
                        showDenyButton: true,
                        showCancelButton: false,
                        confirmButtonText: 'Registrar',
                        denyButtonText: `Cancelar`,
                    }).then((result) => {
                        if (result.isConfirmed) {
                            Swal.fire('Guardado con exito', '', 'success')
                            this.$router.push('/GestionComida');

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

   

