<script setup>
import { RouterLink, RouterView } from 'vue-router'
// import HelloWorld from './components/HelloWorld.vue'

</script>

<template>
  <header>
    <!-- <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" /> -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="estilos.css">
    <link rel="stylesheet" href="plugins/sweetalert2/sweetalert2.min.css">

    <link rel="stylesheet" type="text/css" href="fuentes/iconic/css/material-design-iconic-font.min.css">
    <div class="wrapper">
      <div class="wrapper">
      <!-- <HelloWorld msg="You did it!" /> -->

      <nav class="">
        <RouterLink to="/">login</RouterLink>
        <RouterLink to="/crearUsuario">Crear Usuario</RouterLink>
        <RouterLink to="/buscadorUsuario">Buscar Usuario</RouterLink>
        <RouterLink to="/actualizarUsuario">Actualizar Usuario</RouterLink>
        <RouterLink to="/EliminarUsuario">Eliminar Usuario</RouterLink>
        <RouterLink to="/GuardarComida">Guardar Comida</RouterLink>
        <RouterLink  to="/ActualizarComida">Actualizar Comida</RouterLink>
        <RouterLink to="/GestionComida">Gestion Comida</RouterLink>

      </nav>
    </div>

    </div>
    
  </header>

  <RouterView />
</template>

<style scoped >
header {
  text-align: center;
  background: #F9B5A8;
  line-height: 1.5;
  max-height: 100vh;
  margin: auto;
  padding: 10px 70px;
  
}



nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 0 auto 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
    text-align: center;
  }

  nav {
    
    text-align: center;
    margin-right: -3rem;
    font-size: 1rem;
    display: inline-flex;
    padding: 1rem 0;
    margin-top: 1rem;
    border-right: 4rem;
  }
}
</style>