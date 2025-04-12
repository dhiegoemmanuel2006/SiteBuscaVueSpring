<template>
  <div class="search-box">
    <input
      type="text"
      v-model="searchTerm"
      @keyup.enter="handleSearch"
      placeholder="Digite razão social ou CNPJ..."
    />
    <button @click="handleSearch" :disabled="loading">
      {{ loading ? 'Buscando...' : 'Buscar' }}
    </button>
  </div>
  <h3 v-if="erroAlert" class="erro">{{ erroAlert }}</h3>
</template>

<script>
import { OperadorasService } from '@/services/SerchService';

export default {
  data() {
    return {
      searchTerm: '',
      loading: false,
      erroAlert: ''
    };
  },
  methods: {
    async handleSearch() {
      this.erroAlert = '';
      if (!this.searchTerm.trim()) {
        this.erroAlert = 'Por favor digite algo na busca!';
        return;
      }

      this.loading = true;
      this.$emit('search-start');

      try {
        const response = await OperadorasService.buscarOperadoras(this.searchTerm);
        this.$emit('search-complete', response);
      } catch (error) {
        if (error.message === 'Nenhum resultado encontrado') {
          this.$emit('search-complete', []);
          this.erroAlert = 'Nenhuma operadora encontrada';
        } else {
          console.error('Erro detalhado:', error);
          this.erroAlert = `Erro na busca: ${error.response?.data?.message || error.message}`;
          this.$emit('search-error', error);
        }
      } finally {
        this.loading = false;
        this.$emit('search-finished');
      }
    }
  }
};
</script>

  <style scoped>
  .search-box {
    display: flex;
    gap: 10px;
    margin-bottom: 20px;
  }

  .search-box input {
    flex: 1;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
  }

  .search-box button {
    padding: 10px 15px;
    background: #42b983;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  .search-box button:disabled {
    background: #ccc;
    cursor: not-allowed;
  }
  .erro{
    color: red;
  }

  template{
    height: 80vh;
  }
  </style>
