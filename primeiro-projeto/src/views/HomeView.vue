<template>
  <HeaderComponent />

  <main>
    <h1>Bem vindo ao meu site em VueJS</h1>
  </main>

  <FooterComponent />
</template>

<script>
import FooterComponent from '@/components/FooterComponent.vue';
import HeaderComponent from '@/components/HeaderComponent.vue';

export default{
  name: "HomeView",
  components:{
    HeaderComponent,
    FooterComponent
  }


}

</script>

<style scoped>
  main{
    height: 90vh;
  }
</style>
