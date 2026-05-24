package com.farmacia.usuario_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Usuário Service API")
                        .version("1.0")
                        .description("API responsável pelo gerenciamento de usuários da farmácia")
                        .contact(new Contact()
                                .name("Equipe Farmácia")
                                .email("suporte@farmacia.com")));
    }
}
