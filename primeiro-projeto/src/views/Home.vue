<template>
  <Header />

  <main>
    <h1>Bem vindo ao meu site em VueJS</h1>
  </main>

  <Footer />
</template>

<script>
import Footer from '@/components/Footer.vue';
import Header from '@/components/Header.vue';

export default{
  name: "Home",
  components:{
    Header,
    Footer
  }


}

</script>