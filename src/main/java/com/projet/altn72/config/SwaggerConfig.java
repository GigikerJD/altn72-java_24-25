package com.projet.altn72.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    /* http://localhost:8080/swagger-ui.html */

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Projet - HOPE")
                        .version("1.0.0")
                        .description("Gestion d'accès des outils par utilisateurs selon leurs status"));
    }
}
