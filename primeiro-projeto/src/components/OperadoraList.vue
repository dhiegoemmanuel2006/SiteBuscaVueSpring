<template>
  <div class="operadora-list">
    <div v-if="loading" class="loading-message">
      <div class="spinner"></div>
      <p>Carregando operadoras...</p>
    </div>

    <div v-else-if="operadoras.length === 0" class="empty-message">
      <p>Nenhuma operadora encontrada com os critérios informados</p>
    </div>

    <div v-else class="operadora-items">
      <div v-for="operadora in operadoras" :key="operadora.id" class="operadora-card">
        <h3>{{ operadora.nome || operadora.razaoSocial }}</h3>
        <div class="operadora-details">
          <p><strong>CNPJ:</strong> {{ formatCnpj(operadora.cnpj) }}</p>
          <p><strong>Registro ANS:</strong> {{ operadora.registroANS }}</p>
          <p><strong>Localização:</strong> {{ operadora.cidade }}/{{ operadora.uf }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { formatCNPJ } from '@/utils/formatters';

export default {
  props: {
    operadoras: {
      type: Array,
      default: () => []
    },
    loading: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    formatCnpj(cnpj) {
      return formatCNPJ(cnpj);
    }
  }
};
</script>

<style scoped>
.operadora-list {
  margin-top: 2rem;
}

.loading-message {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 2rem;
  color: #2E7D32;
}

.spinner {
  width: 40px;
  height: 40px;
  border: 4px solid rgba(46, 125, 50, 0.2);
  border-radius: 50%;
  border-top-color: #2E7D32;
  animation: spin 1s ease-in-out infinite;
  margin-bottom: 1rem;
}

@keyframes spin {
  to { transform: rotate(360deg); }
}

.empty-message {
  text-align: center;
  padding: 2rem;
  background-color: #f5f5f5;
  border-radius: 8px;
  color: #666;
  border-left: 4px solid #2E7D32;
}

.empty-message p {
  margin: 0;
  font-size: 1.1rem;
}

.operadora-items {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 1.5rem;
}

.operadora-card {
  background: white;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  padding: 1.5rem;
  transition: all 0.3s ease;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
  border-left: 4px solid #2E7D32;
}

.operadora-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
}

.operadora-card h3 {
  margin: 0 0 1rem 0;
  color: #1B5E20;
  font-size: 1.2rem;
  padding-bottom: 0.75rem;
  border-bottom: 1px solid #eee;
}

.operadora-details p {
  margin: 0.75rem 0;
  color: #555;
  line-height: 1.5;
}

.operadora-details strong {
  color: #333;
  display: inline-block;
  min-width: 120px;
  font-weight: 600;
}

@media (max-width: 768px) {
  .operadora-items {
    grid-template-columns: 1fr;
  }

  .operadora-card {
    padding: 1.25rem;
  }

  .operadora-details strong {
    min-width: 100px;
  }
}
</style>
