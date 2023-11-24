package co.yom.configurationAnnotation.configuration;

import co.yom.configurationAnnotation.service.LowerCaseWordsService;
import co.yom.configurationAnnotation.service.PunctuationService;
import co.yom.configurationAnnotation.service.UpperCaseWordsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// El nombre del bean por defecto coincide con el nombre del método anotado @Bean.

/**
 * @Configuration(proxyBeanMethods = false)
 * Ahora vuelva a ejecutar la aplicación y verá que false está impreso.
 * Esto significa que la segunda vez punctuationService()que se llamó al método, se creó un nuevo bean.
 *
 * @Configuration(enforceUniqueMethods = false)
 */
@Configuration(enforceUniqueMethods = false)
public class Config {

    /**
     * Se crearán tres beans (y los dos primeros usarán el tercero) al inicio, ya que usamos la @Bean anotación,
     * aunque no etiquetamos las clases respectivas con una anotación como @Componento @Service.
     *
     * El siguiente paso es probar si sólo PunctuationServicese creó un bean; dirigirse a App.java
     *
     */

    @Bean
    public LowerCaseWordsService lowerCase(){
        return new LowerCaseWordsService(punctuationService());
    }

    @Bean
    public UpperCaseWordsService upperCase(){
        return new UpperCaseWordsService(punctuationService());
    }

    @Bean
    public UpperCaseWordsService upperCase(String dummy){
        return new UpperCaseWordsService(punctuationService());
    }

    @Bean
    public PunctuationService punctuationService(){
        return new PunctuationService();
    }
}
