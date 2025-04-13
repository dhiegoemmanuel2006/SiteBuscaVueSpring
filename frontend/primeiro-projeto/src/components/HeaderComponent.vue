<template>
  <header class="header">
    <div class="header-content">
      <button @click="$router.push('/inicio')" class="button-header">Home</button>
      <button @click="$router.push('/busca')" class="button-header">Busca</button>
    </div>
  </header>
</template>

<script>
export default {
  name: "HeaderComponent"
}
</script>

<style scoped>
.header {
  width: 100%;
  background-color: #1B5E20;
  padding: 1rem 0;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  position: sticky;
  top: 0;
  z-index: 100;
}

.header-content {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  justify-content: center;
  gap: 1.5rem;
  padding: 0 1rem;
}

.button-header {
  background-color: #2E7D32;
  color: white;
  padding: 0.75rem 1.5rem;
  border: none;
  border-radius: 4px;
  font-weight: 600;
  font-family: 'Helvetica', Arial, sans-serif;
  cursor: pointer;
  transition: all 0.3s ease;
  text-transform: uppercase;
  letter-spacing: 0.5px;
  font-size: 0.9rem;
}

.button-header:hover {
  background-color: #1B5E20;
  transform: translateY(-2px);
}

.button-header:active {
  transform: translateY(0);
}

@media (max-width: 600px) {
  .header-content {
    gap: 0.75rem;
  }

  .button-header {
    padding: 0.6rem 1rem;
    font-size: 0.8rem;
  }
}
</style>
