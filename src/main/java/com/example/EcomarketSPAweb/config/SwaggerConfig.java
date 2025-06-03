package com.example.EcomarketSPAweb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ecomarket API")
                        .version("1.0")
                        .description("prueba para Ecomarket SPAweb para la gestion de usuario, productos y envios"));

    }
}
