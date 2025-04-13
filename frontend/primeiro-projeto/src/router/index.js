import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import SearchView from "@/views/SearchView.vue";

const routes = [
  {
    path: '/inicio',
    name: 'Inicio',
    component: HomeView
  },
  {
    path: '/busca',
    name: 'Serch',
    component: SearchView
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
