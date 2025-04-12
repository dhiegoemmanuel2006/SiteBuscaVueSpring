<template>
    <HeaderComponent />

    <main>
        <h1>Página de busca</h1>
    </main>

    <SearchBox
    @search-complete="operadoras = $event"
    @search-error="handleError"

    />

    <OperadoraList
        :operadoras="operadoras"
        :loading="loading"
    />

    <FooterComponent />
</template>

<script>
import FooterComponent from '@/components/FooterComponent.vue';
import HeaderComponent from '@/components/HeaderComponent.vue';
import OperadoraList from '@/components/OperadoraList.vue';
import SearchBox from '@/components/SearchBox.vue';

export default{
    name: "SearchView",
    components:{
        HeaderComponent,
        FooterComponent,
        SearchBox,
        OperadoraList
    },

    data(){
        return{
            operadoras:[],
            loading: false
        }
    },
    methods:{
        handleError(error){
            console.error("Erro na busca", error);
            this.operadoras = [];
        }
    }


}

</script>
