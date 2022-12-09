

<template>

    <head>
        <link rel="shortcut icon" href="#" />
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <!-- FontAwesom CSS -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
            integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <!--Sweet Alert 2 -->
        <link rel="stylesheet" href="plugins/sweetalert2/sweetalert2.min.css">

    </head>

    <header>
        <h2 class="text-center text-dark"><span class="badge badge-danger">BIENVENIDO A PANEL DEL ADMINISTRADOR</span>
        </h2>
    </header>

    <div id="appMoviles">
        <div class="container">
           <br>
            <input type="button" value="Ver Comidas" v-on:click="consultarComidas">
            <div class="row mt-5">
                <div class="col-lg-12">
                    <table  class="table table-striped" >
                        <thead>
                            <tr class="bg-primary text-light">
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Tamaño</th>
                                <th>Descripcion</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(comida) of comidas">
                                <td>{{ comida.id }}</td>
                                <td>{{ comida.nombre }}</td>
                                <td>{{ comida.precio }}</td>
                                <td>{{comida.tamano}}</td>
                                <td>{{ comida.descripcion }}</td>

                                <td>
                                    <div class="btn-group" role="group">
                                        <!-- <button class="btn btn-secondary" title="Editar"
                                            v-on:click="btnEditar(comida.id, comida.nombre, comida.precio, comida.tamano, comida.descripcion)"><i
                                                class="fas fa-pencil-alt"></i></button> -->
                                        <button class="btn btn-danger" title="Eliminar"  v-on:click="btnBorrar(comida.id)"><i
                                                class="fas fa-trash-alt"></i></button>
                                                
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>


</template>
<script>
export default {
    data() {
        return {
            busqueda: "",
            comidas: [],
            comida: [],
            id: "",
            nombre: "",
            precio: "",
            tamano: "",
            descripcion: "",
           


        }
    },
    methods: {
        btnBorrar:function(id){        
        Swal.fire({
          title: '¿Está seguro de borrar el registro: '+id+" ?",         
          type: 'warning',
          showCancelButton: true,
          confirmButtonColor:'#d33',
          cancelButtonColor:'#3085d6',
          confirmButtonText: 'Borrar'
        }).then((result) => {
          if (result.value) {            
            this.EliminarComida(id);             
            //y mostramos un msj sobre la eliminación  
            Swal.fire(
              '¡Eliminado!',
              'El registro ha sido borrado.',
              'success'
            )
          }
        })                
    },
    //     btnEditar:async function(id, nombre, precio, tamano, descripcion){                            
    //     await Swal.fire({
    //     title: 'ACTUALIZAR',
    //     html:

    //         '<div class="form-group"><div class="row"><label class="col-sm-3 col-form-label">id</label><div class="col-sm-7"><input id="id" value="' + id +'""textarea" class="form-control"></div></div>   <div class="form-group"><div class="row"><label class="col-sm-3 col-form-label">Nombre</label><div class="col-sm-7"><input id="nombre" value="'+nombre+'""textarea" class="form-control"></div></div>   <div class="row"><label class="col-sm-3 col-form-label">Precio</label><div class="col-sm-7"><input id="precio" value="'+precio+'" type="number" min="0" class="form-control"></div></div>   <div class="row"><label class="col-sm-3 col-form-label">tamano</label><div class="col-sm-7"><input id="tamano" value="'+tamano+'" type="textarea"  class="form-control"></div></div>       <div class="row"><label class="col-sm-3 col-form-label">Descripcion</label><div class="col-sm-7"><input id="descripcion" value="'+ descripcion+'" type="textarea"  class="form-control"></div></div>   ', 
    //     type: 'warning',
    //       showCancelButton: true,
    //       confirmButtonColor:'#d33',
    //       cancelButtonColor:'#3085d6',
    //       confirmButtonText: 'Actualizar'
                                 
    //     }).then((result) => {
    //       if (result.value) {   
    //         id = document.getElementById('id').value,                                          
    //         nombre = document.getElementById('nombre').value,    
    //         precio = document.getElementById('precio').value,
    //         tamano = document.getElementById('tamano').value,
    //         descripcion = document.getElementById('descripcion').value,              
            
    //         this.ActualizarComida(id,nombre,precio,tamano,descripcion);
    //         Swal.fire(
    //           '¡Actualizado!',
    //           'El registro ha sido actualizado.',
    //           'success'
    //         )                  
    //       }
          
    //     });
        
    // },
        
        consultarComidas() {
            var endpoint = "http://localhost:8080/comida/ver/";
            var opciones = { method: "GET" }
            fetch(endpoint, opciones).then(async response => {
                this.comidas = await response.json();

                if (!this.comidas.length) {
                    Swal.fire({
                        width: 300,
                        icon: 'question',
                        title: 'No hay Inmuebles disponibles por el momento',
                        text: "Inmueble no encontrado",
                        showConfirmButton: false,
                        timer: 1000
                    })
                }

            })

        },
        ConsultarComida() {
            var endpoint = "http://localhost:8080/comida/comida/" + this.busqueda;
            var opciones = { method: "GET" };
            fetch(endpoint, opciones)
                .then(response => response.json())
                .then(data => { this.comida = data; console.log(data) })
        },
        EliminarComida(id) {
            var endpoint = "http://localhost:8080/comida/eliminar/" + id;
            var opciones = { method: "DELETE" };
            fetch(endpoint, opciones,id).then(async Response => {
            
            })
        },
        // ActualizarComida() {
        //     var endpoint = "http://localhost:8080/comida/actualizar";
        //     var opciones = {
        //         method: "POST",
        //         headers: { "Content-type": "Application/json" },
        //         body: JSON.stringify({ id: this.id, nombre: this.nombre, precio: this.comi.precio, tamano: this.comi.tamano, descricion: this.comi.descripcion})
        //     }
        //     fetch(endpoint, opciones).then(async Response => {
        //         // alert('Guardado Correctamente');
        //         try {
        //             if (Response.status)
        //                 Swal.fire({
        //                     icon: 'question',
        //                     title: 'Desea Actualizar Usuario?',
        //                     showDenyButton: true,
        //                     showCancelButton: false,
        //                     confirmButtonText: 'Actualizar',
        //                     denyButtonText: `Cancelar`,
        //                 }).then((result) => {
        //                     if (result.isConfirmed) {
        //                         Swal.fire('Actualizado con exito', '', 'success')
        //                         this.$router.push('/');

        //                     } else if (result.isDenied) {
        //                         Swal.fire('Los cambios no se Actualizaron', '', 'warning')
        //                         return false
        //                     }
        //                 })
        //             else {
        //                 alert("error")
        //             }
        //         } catch (error) {
        //             return "{\"sucess\":false ,\"message\":\"Error al intentar actualizar.\"}";
        //         }
        //     })
        // }


    }

}
</script>
