import { createRouter, createWebHistory } from "vue-router";
import Home from "@/views/Home.vue";
import Search from "@/views/Search.vue";

const routes = [
  {
    path: '/inicio',
    name: 'Inicio',
    component: Home
  },
  {
    path: '/busca',
    name: 'Serch',
    component: Search
  },
  {
    path: '',
    name: 'App',
    redirect: '/inicio'
  }
]

const router = createRouter({
  history: createWebHistory('/'),
  routes
})

export default router;