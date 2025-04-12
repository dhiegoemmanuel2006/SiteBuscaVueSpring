<template>
  <HeaderComponent />

  <main class="search-container">
    <h1 class="page-title">Consulta de Operadoras de Saúde</h1>

    <div class="data-source-info">
      <p>Os dados utilizados nesta pesquisa são disponibilizados pela Agência Nacional de Saúde Suplementar (ANS) e estão abertos para consulta pública.</p>
    </div>

    <SearchBox
      @search-complete="operadoras = $event"
      @search-error="handleError"
    />

    <OperadoraList
      :operadoras="operadoras"
      :loading="loading"
    />
  </main>

  <FooterComponent />
</template>

<script>
import FooterComponent from '@/components/FooterComponent.vue';
import HeaderComponent from '@/components/HeaderComponent.vue';
import OperadoraList from '@/components/OperadoraList.vue';
import SearchBox from '@/components/SearchBox.vue';

export default {
  name: "SearchView",
  components: {
    HeaderComponent,
    FooterComponent,
    SearchBox,
    OperadoraList
  },
  data() {
    return {
      operadoras: [],
      loading: false
    }
  },
  methods: {
    handleError(error) {
      console.error("Erro na busca", error);
      this.operadoras = [];
    }
  }
}
</script>

<style scoped>
.search-container {
  max-width: 1200px;
  margin: 2rem auto;
  padding: 0 1rem;
  color: #333;
}

.page-title {
  font-size: 2rem;
  color: #1B5E20;
  margin-bottom: 1.5rem;
  text-align: center;
}

.data-source-info {
  background-color: #f8f9fa;
  border-left: 4px solid #2E7D32;
  padding: 1rem;
  margin-bottom: 2rem;
  border-radius: 0 4px 4px 0;
}

.data-source-info p {
  margin: 0;
  color: #555;
  line-height: 1.5;
}

@media (max-width: 768px) {
  .page-title {
    font-size: 1.5rem;
  }

  .data-source-info {
    padding: 0.75rem;
  }
}


</style>
