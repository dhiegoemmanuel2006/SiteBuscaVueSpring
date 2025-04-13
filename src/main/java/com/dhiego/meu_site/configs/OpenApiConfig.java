package com.dhiego.meu_site.configs;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API do meu site de busca")
                        .version("1.0")
                        .description("Documentação da API Java Spring Boot")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Suporte")
                                .email("suporte@exemplo.com"))
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}