<template>
    <Header />

    <main>
        <h1>Página de busca</h1>
    </main>

    <Footer />
</template>

<script>
import Footer from '@/components/Footer.vue';
import Header from '@/components/Header.vue';

export default{
    name: "Search",
    components:{
        Header,
        Footer
    }
}

</script>