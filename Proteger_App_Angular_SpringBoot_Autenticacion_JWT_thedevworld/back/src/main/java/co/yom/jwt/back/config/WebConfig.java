package co.yom.jwt.back.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

@Configuration
@EnableWebMvc
public class WebConfig {

    // Tiempo MAX. 30 min
    private static final Long MAX_AGE = 3600L;
    private static final int CORS_FILTER_ORDER = -102;

    // Configuración de Cors
    @Bean
    public FilterRegistrationBean corsFilter() {
        // Permitir que el servidor reciba los encabezados que contienen la información de autenticación
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // URL del frontend
        config.addAllowedOrigin("http://localhost:4200");
        // Algunos encabezados que la app debe aceptar
        config.setAllowedHeaders(Arrays.asList(
                HttpHeaders.AUTHORIZATION,
                HttpHeaders.CONTENT_TYPE,
                HttpHeaders.ACCEPT));
        // Métodos que el back debe aceptar
        config.setAllowedMethods(Arrays.asList(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.DELETE.name()));
        // El tiempo de aceptación de la configuración CORS, 30 min
        config.setMaxAge(MAX_AGE);
        // Se aplica la configuración a todas las rutas
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));

        // Se coloca este Bean en posición más baja, para ejecutarse antes que cualquier Spring Bean
        bean.setOrder(CORS_FILTER_ORDER);
        return bean;
    }
}