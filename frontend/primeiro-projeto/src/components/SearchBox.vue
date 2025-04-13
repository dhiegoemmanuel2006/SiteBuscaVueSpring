<template>
  <div class="search-container">
    <div class="search-box">
      <input
        type="text"
        v-model="searchTerm"
        @keyup.enter="handleSearch"
        placeholder="Digite razão social, nome fantasia ou CNPJ..."
        class="search-input"
        :disabled="loading"
      />
      <button
        @click="handleSearch"
        :disabled="loading"
        class="search-button"
      >
        <span v-if="loading" class="button-loading"></span>
        {{ loading ? 'Buscando...' : 'Buscar' }}
      </button>
    </div>

    <div v-if="erroAlert" class="error-message">
      <span class="error-icon">!</span>
      {{ erroAlert }}
    </div>
  </div>
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
        this.erroAlert = 'Por favor, digite um termo para buscar';
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
          this.erroAlert = 'Nenhuma operadora encontrada com os critérios informados';
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
.search-container {
  margin-bottom: 2rem;
}

.search-box {
  display: flex;
  gap: 1rem;
  max-width: 800px;
  margin: 0 auto;
}

.search-input {
  flex: 1;
  padding: 0.75rem 1rem;
  border: 2px solid #e0e0e0;
  border-radius: 6px;
  font-size: 1rem;
  transition: all 0.3s ease;
  background-color: white;
}

.search-input:focus {
  outline: none;
  border-color: #2E7D32;
  box-shadow: 0 0 0 3px rgba(46, 125, 50, 0.2);
}

.search-input:disabled {
  background-color: #f5f5f5;
}

.search-button {
  padding: 0.75rem 1.5rem;
  background-color: #2E7D32;
  color: white;
  border: none;
  border-radius: 6px;
  font-size: 1rem;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  min-width: 120px;
}

.search-button:hover:not(:disabled) {
  background-color: #1B5E20;
  transform: translateY(-1px);
}

.search-button:active:not(:disabled) {
  transform: translateY(0);
}

.search-button:disabled {
  background-color: #a5d6a7;
  cursor: not-allowed;
}

.button-loading {
  display: inline-block;
  width: 16px;
  height: 16px;
  border: 2px solid rgba(255, 255, 255, 0.3);
  border-radius: 50%;
  border-top-color: white;
  animation: spin 1s ease-in-out infinite;
  margin-right: 8px;
  vertical-align: middle;
}

@keyframes spin {
  to { transform: rotate(360deg); }
}

.error-message {
  margin-top: 1rem;
  padding: 0.75rem 1rem;
  background-color: #ffebee;
  border-left: 4px solid #d32f2f;
  border-radius: 4px;
  color: #d32f2f;
  display: flex;
  align-items: center;
  max-width: 800px;
  margin: 1rem auto 0;
}

.error-icon {
  display: inline-block;
  width: 20px;
  height: 20px;
  background-color: #d32f2f;
  color: white;
  border-radius: 50%;
  text-align: center;
  line-height: 20px;
  font-weight: bold;
  margin-right: 0.75rem;
  flex-shrink: 0;
}

@media (max-width: 768px) {
  .search-box {
    flex-direction: column;
    gap: 0.75rem;
  }

  .search-button {
    width: 100%;
    padding: 0.75rem;
  }
}
</style>
