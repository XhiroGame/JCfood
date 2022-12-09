import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import VLogin from '../views/VLogin.vue'
import VcrearUsuario from '../views/VcrearUsuario.vue'
import viewBuscadorUsuario from '../views/viewBuscadorUsuario.vue'
import viewActualizarUsuario from '../views/viewActualizarUsuario.vue'
import viewEliminarUsuario from '../views/viewEliminarUsuario.vue'
import viewGuardarComida from '../views/viewGuardarComida.vue'
import viewActualizarComida from '../views/viewActualizarComida.vue'
import viewGestionComida from '../views/viewGestionComida.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component : VLogin

    },
    {
      path: '/crearUsuario',
      name: 'CrearUsuario',
      component: VcrearUsuario

    },
    {
      path: '/buscadorUsuario',
      name: 'Buscador Usuario',
      component: viewBuscadorUsuario
    },
    {
      path: '/actualizarUsuario',
      name: 'Actualizar Usuario',
      component:  viewActualizarUsuario
    },

    {
      path: '/EliminarUsuario',
      name: 'Eliminar Usuario',
      component: viewEliminarUsuario
    },

    {
      path: '/GuardarComida',
      name: 'Guardar Comida',
      component: viewGuardarComida
    },
    {
      path: '/ActualizarComida',
      name: 'Actualizar Comida',
      component: viewActualizarComida
    },

    {
      path: '/GestionComida',
      name: 'Gestion Comida',
      component: viewGestionComida
    },

    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    }
  ]
})

export default router
