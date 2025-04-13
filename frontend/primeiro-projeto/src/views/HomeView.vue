<template>
  <HeaderComponent />

  <main class="home-container">
    <section class="intro-section">
      <h1 class="title">Olá, eu sou Dhiego Andrade</h1>
      <p class="subtitle">Desenvolvedor Back-End em formação</p>

      <div class="about-me">
        <h2>Sobre Mim</h2>
        <p>
          Tenho 18 anos e sou apaixonado por desenvolvimento de software, com foco especial em back-end.
          Este projeto foi criado para consolidar e aprimorar minhas habilidades em Java e Spring Boot,
          enquanto demonstro minha capacidade de criar soluções completas integrando front-end e back-end.
        </p>
      </div>
    </section>

    <section class="technologies-section">
      <h2>Tecnologias Utilizadas</h2>
      <div class="tech-grid">
        <div class="tech-card" v-for="tech in technologies" :key="tech.name">
          <h3>{{ tech.name }}</h3>
          <p>{{ tech.description }}</p>
        </div>
      </div>
    </section>

    <section class="project-section">
      <h2>Sobre o Projeto</h2>
      <p>
        Este site é parte do meu portfólio de desenvolvimento, demonstrando habilidades full-stack
        com Vue.js no front-end e Spring Boot no back-end. O código completo está disponível no GitHub:
      </p>
      <a href="https://github.com/dhiegoemmanuel2006/SiteBuscaVueSpring" target="_blank" rel="noopener noreferrer" class="github-link">
        Acesse o repositório no GitHub
      </a>
    </section>
  </main>

  <FooterComponent />
</template>

<script>
import FooterComponent from '@/components/FooterComponent.vue';
import HeaderComponent from '@/components/HeaderComponent.vue';

export default {
  name: "HomeView",
  components: {
    HeaderComponent,
    FooterComponent
  },
  data() {
    return {
      technologies: [
        {
          name: "Java",
          description: "Linguagem principal para desenvolvimento back-end"
        },
        {
          name: "Spring Boot",
          description: "Framework para construção de aplicações Java"
        },
        {
          name: "Spring Docs",
          description: "Documentação automatizada da API (Swagger)"
        },
        {
          name: "Lombok",
          description: "Biblioteca para reduzir boilerplate code"
        },
        {
          name: "Postman",
          description: "Teste e documentação de endpoints da API"
        },
        {
          name: "MySQL",
          description: "Sistema de gerenciamento de banco de dados relacional"
        },
        {
          name: "Vue.js",
          description: "Framework JavaScript para a interface do usuário"
        }
      ]
    }
  }
}
</script>

<style scoped>
.home-container {
  max-width: 1200px;
  margin: 2rem auto;
  padding: 0 1rem;
  color: #333;
}

.title {
  font-size: 2.5rem;
  color: #1B5E20;
  margin-bottom: 0.5rem;
}

.subtitle {
  font-size: 1.2rem;
  color: #2E7D32;
  margin-bottom: 2rem;
}

section {
  margin-bottom: 3rem;
}

h2 {
  color: #1B5E20;
  font-size: 1.8rem;
  margin-bottom: 1rem;
  border-bottom: 2px solid #2E7D32;
  padding-bottom: 0.5rem;
}

.about-me p {
  line-height: 1.6;
  font-size: 1.1rem;
}

.tech-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 1.5rem;
}

.tech-card {
  background-color: #f5f5f5;
  border-radius: 8px;
  padding: 1.5rem;
  transition: transform 0.3s ease;
  border-left: 4px solid #2E7D32;
}

.tech-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 5px 15px rgba(0,0,0,0.1);
}

.tech-card h3 {
  color: #1B5E20;
  margin-bottom: 0.5rem;
}

.project-section p {
  margin-bottom: 1rem;
  line-height: 1.6;
}

.github-link {
  display: inline-block;
  background-color: #2E7D32;
  color: white;
  padding: 0.8rem 1.5rem;
  border-radius: 4px;
  text-decoration: none;
  font-weight: 600;
  transition: background-color 0.3s;
}

.github-link:hover {
  background-color: #1B5E20;
}

@media (max-width: 768px) {
  .title {
    font-size: 2rem;
  }

  .subtitle {
    font-size: 1rem;
  }

  .tech-grid {
    grid-template-columns: 1fr;
  }
}
</style>
