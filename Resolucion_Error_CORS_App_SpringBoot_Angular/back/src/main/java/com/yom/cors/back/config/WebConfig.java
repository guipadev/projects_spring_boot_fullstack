package com.yom.cors.back.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    // Configuración global para manejor de Cors
    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Este método acepta una lista de cadenas, una lista de URL
                // Lo que significa que se puede ponder todos los frontend de todos los entornos de mi aplicación
                // Y también de la dirección localhost
                registry.addMapping("/**") // Agregar mapeo de todas las rutas
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods( // Algunos metodos aceptados
                                HttpMethod.GET.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.DELETE.name()
                        )
                        .allowedHeaders( // Algunos encabezados aceptados
                                HttpHeaders.CONTENT_TYPE,
                                HttpHeaders.AUTHORIZATION
                        );
            }
        };
    }
}
