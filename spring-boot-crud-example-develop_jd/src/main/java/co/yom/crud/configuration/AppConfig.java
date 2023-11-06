package co.yom.crud.configuration;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

/**
 * @Configuration: Maarca la clase como una configuración de Spring.
 * Indica que esta clase contendrá definiciones de beans y configuraciones para la aplicación.
 *
 * @EnableWebMvc: Habilita la configuración de Spring MVC.
 * Indica que esta configuración se utilizará para configurar aspectos relacionados con el manejo de solicitudes HTTP.
 *
 * implements WebMvcConfigurer: La clase AppConfig implementa la interfaz WebMvcConfigurer.
 * Esto significa que esta clase proporciona configuración personalizada para Spring MVC.
 */
@Slf4j
@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer{

    /**
     * Campos Anotados con @Value:Se utilizan para inyectar valores desde propiedades definidas en archivos de propiedades
     * (por ejemplo, application.properties).
     * Estos valores se pueden personalizar en tiempo de ejecución.
     * Los valores predeterminados se utilizan en caso de que no se especifiquen en el archivo de propiedades.
     *
     * pathPattern: Define el patrón de URL para el cual se aplicarán las configuraciones CORS.
     */
    @Value("${app.cors.pathPattern:/**}")
    private String pathPattern;

    /**
     * allowedOrigins: Define los orígenes permitidos para las solicitudes CORS.
     */
    @Value("${app.cors.allowedOrigins:*}")
    private String[] allowedOrigins;

    /**
     * allowedHeaders: Define los encabezados permitidos en las solicitudes CORS.
     */
    @Value("${app.cors.allowedHeaders:*}")
    private String[] allowedHeaders;

    /**
     * allowedMethods: Define los métodos HTTP permitidos en las solicitudes CORS.
     */
    @Value("${app.cors.allowedMethods:*}")
    private String[] allowedMethods;

    /**
     * maxAge: Define la cantidad máxima de tiempo que se deben almacenar en caché las configuraciones CORS en el navegador del cliente.
     */
    @Value("${app.cors.maxAge:1800}")
    private long maxAge;

    /**
     * Este método anotado con @Override se utiliza para configurar las políticas de Cross-Origin Resource Sharing (CORS).
     * Define las reglas que permiten o restringen las solicitudes desde dominios o servidores diferentes.
     * Los valores se toman de los campos anotados con @Value.
     * @param corsRegistry
     */
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

        // Esta anotación se usa para habilitar el registro de eventos en la clase utilizando Simple Logging Facade for Java (SLF4J).
        log.info("pathPattern: {}",pathPattern);
        log.info("allowedOrigins: {}",Arrays.toString(allowedOrigins));
        log.info("allowedMethods: {}",Arrays.toString(allowedMethods));
        log.info("maxAge: {}",maxAge);
        
        corsRegistry.addMapping(pathPattern)
            .allowedHeaders(allowedHeaders)
            .allowedOrigins(allowedOrigins)
            .allowedMethods(allowedMethods)
            .maxAge(maxAge);
    }

    /**
     * @Bean Método getModelMapper:
     * Este método anotado con @Bean crea y devuelve una instancia de ModelMapper.
     * ModelMapper es una biblioteca utilizada para mapear objetos de un tipo a otro,
     * lo que puede ser útil en la conversión de datos en una aplicación
     * @return cada vez que se llama al ModelMapper, viene a este Bean y crea una nueva instancia
     */
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
