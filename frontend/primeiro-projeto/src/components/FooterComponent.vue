<template>
  <footer class="footer">
    <div class="container-contacts">
      <ul class="contacts-list">
        <li class="contact-title"><strong>Contact:</strong></li>
        <li class="contact-item">
          <a href="https://github.com/dhiegoemmanuel2006" target="_blank" rel="noopener noreferrer">
            <IconGitHub class="icon"/> /dhiegoemmanuel2006
          </a>
        </li>
        <li class="contact-item">
          <a href="https://www.linkedin.com/in/dhiegoandrade/" target="_blank" rel="noopener noreferrer">
            <IconLinkedin class="icon"/> /dhiegoandrade
          </a>
        </li>
        <li class="contact-item">
          <IconWhatsApp class="icon"/> (61) 99660-0236
        </li>
      </ul>
    </div>
  </footer>
</template>

<script>
import IconLinkedin from "@/components/icons/IconLinkedin.vue";
import IconGitHub from "@/components/icons/IconGitHub.vue";
import IconWhatsApp from "@/components/icons/IconWhatsApp.vue";

export default {
  name: "FooterComponent",
  components: {
    IconWhatsApp,
    IconGitHub,
    IconLinkedin
  }
}
</script>

<style scoped>
.footer {
  background-color: #2E7D32; /* A nicer green shade */
  color: white;
  padding: 1.5rem 0;
  width: 100%;
}

.container-contacts {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 1rem;
}

.contacts-list {
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;
  flex-wrap: wrap;
  gap: 1.5rem;
}

.contact-title {
  width: 100%;
  margin-bottom: 0.5rem;
  font-size: 1.1rem;
}

.contact-item {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.contact-item a {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.icon {
  width: 20px;
  height: 20px;
}

a {
  text-decoration: none;
  color: white;
  transition: opacity 0.2s;
}

a:hover {
  opacity: 0.8;
}

@media (max-width: 600px) {
  .contacts-list {
    flex-direction: column;
    gap: 0.75rem;
  }

  .contact-title {
    margin-bottom: 0.25rem;
  }
}
</style>
