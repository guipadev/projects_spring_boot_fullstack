package co.yom.configurationAnnotation;

import co.yom.configurationAnnotation.service.LowerCaseWordsService;
import co.yom.configurationAnnotation.service.UpperCaseWordsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	/**
	 * Mantenemos el contexto en una variable context.
	 * Luego recuperamos el bean minúscula y el bean UpperCase del contexto de la aplicación.
	 * Luego comprobamos si los 2 beans tienen la misma referencia.
	 * Si ejecuta la aplicación, verá que true se imprimirá, como lo hemos proxyBeanMethods configurado true.
	 */
	public static void main(String[] args) {

		var context = SpringApplication.run(App.class, args);
		var lowerCaseBean = (LowerCaseWordsService) context.getBean("lowerCase");
		var upperCaseBean = (UpperCaseWordsService) context.getBean("upperCase");

		System.out.printf("¿Ambos servicios de puntuación apuntan al mismo objeto? %b",
				lowerCaseBean.getPunctuationService() == upperCaseBean.getPunctuationService()
		);
	}

}
