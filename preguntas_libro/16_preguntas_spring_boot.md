# Preguntas Y Respuestas De La Entrevista Spring Boot

## Tabla de contenido
1. ¿Qué es Spring Boot?
2. ¿Por qué Spring Boot se hizo tan popular?
3. ¿Cómo se inicia una aplicación Spring Boot?
4. ¿Cuáles son las desventajas de Spring Boot?
5. ¿Cuáles son las formas de crear una aplicación Spring Boot?
6. ¿Cuáles son las dependencias iniciales de una aplicación Spring Boot?
7. ¿Qué servidor web proporciona Spring Boot de forma predeterminada?
8. ¿Cómo podemos cambiar a diferentes servidores web en Spring Boot?
9. ¿Cómo podemos deshabilitar la configuración automática para una clase específica en Spring Boot?
10. ¿Cuál es el concepto de Perfiles en Spring Boot?
11. ¿Cuál es la diferencia entre Spring y Spring Boot?
12. ¿Qué es el actuador Spring Boot? ¿Cual es su propósito?
13. ¿Cuál es el uso de DevTools en Spring Boot?
14. ¿Cuáles son las ventajas de usar un archivo yml en lugar de un archivo de propiedades?
15. ¿Qué es la compatibilidad con imágenes nativas de GraalVM en Spring Boot?
16. ¿Cuáles son las nuevas funciones de Spring Boot 3.0?

1. ¿Qué es Spring Boot?
Spring Boot es una combinación de dos palabras "Spring" y "Boot". Aquí, la palabra 'Spring' representa una aplicación Spring. La palabra 'Boot' representa bootstrap. Por lo tanto, Spring Boot es un marco basado en Java de código abierto que ayuda a iniciar la aplicación Spring.

Esta es la definición oficial del sitio web spring.io: " Spring Boot facilita la creación de aplicaciones basadas en Spring independientes y de grado de producción que puede ejecutar ".

En palabras simples, también podemos decir que Spring Boot es una extensión del marco Spring que simplifica el proceso de creación de una aplicación basada en Spring. Ahora, ¿cuáles son las características de la aplicación basada en Spring que Spring Boot simplifica? Estos son: la aplicación es independiente, está lista para la producción y solo se puede ejecutar.

Spring Boot puede crear una aplicación Spring independiente con una configuración mínima necesaria. Automatiza aproximadamente el 70-80% de las tareas repetidas que hacemos en la aplicación basada en Spring.

Spring Boot proporciona funciones listas para producción, como métricas, controles de estado y configuración externalizada.

Tiene servidores web incorporados en forma de archivos jar que manejan internamente el proceso de ejecución de la aplicación sin configurar manualmente un servidor web. Además, no tenemos que preocuparnos por hacer el archivo jar/war de la aplicación e implementarlo en cualquier servidor web. Estas tareas y configuraciones están automatizadas y realizadas internamente por Spring Boot, lo que hace que una aplicación sea simplemente ejecutable.

2. ¿Por qué Spring Boot se hizo tan popular?
Spring Boot se hizo muy popular en muy poco tiempo en comparación con otros marcos en el lenguaje de programación Java. Por ejemplo, a continuación se presentan algunos puntos que hacen de Spring Boot un marco popular para desarrollar una aplicación lista para producción.

1) Spring Boot proporciona funcionalidades listas para usar que son las más comunes y aplicables a cualquier tipo de proyecto. Por lo tanto, elimina el código de placa de caldera.
2) Proporciona una forma más fácil y rápida de configurar, instalar y ejecutar tanto aplicaciones simples como basadas en web.
3) Spring Boot reduce las configuraciones XML y promueve las anotaciones. Por lo tanto, reduce significativamente el esfuerzo de desarrollo.
4) Crea una aplicación independiente que puede ejecutarse con un archivo jar. No es obligatorio crear un archivo war, ni siquiera para ejecutar una aplicación web.
5) Ofrece funciones listas para producción como controles de estado, métricas y configuraciones externalizadas.
6) Spring Boot proporciona un proceso de integración fácil con muchas herramientas de terceros.
7) Spring Boot brinda un gran soporte para desarrollar Java Microservices .
8) Ofrece a los desarrolladores proyectos de inicio listos para usar para trabajar rápidamente en funcionalidades en lugar de perder tiempo configurando configuraciones iniciales.
9) Spring Boot es compatible con las herramientas de compilación más utilizadas, como Maven y Gradle.

3. ¿Cómo se inicia una aplicación Spring Boot?
La aplicación Spring Boot tiene un método principal como un programa Java simple. Este método sirve como punto de entrada, que invoca el método run() para iniciar la aplicación. El siguiente código muestra la clase principal con la anotación @SpringBootApplication que tiene el método main() que llama internamente al método run().

```
@SpringBootApplication 
clase pública MySpringBootApplication { 
    public static void main (String[] args) {      
      Aplicación Spring. ejecutar (MySpringBootApplication. class ,  args );
   }
}
```

4. ¿Cuáles son las desventajas de Spring Boot?
1) Una de las desventajas que muchos desarrolladores observaron en el momento del desarrollo es que incluye muchas dependencias adicionales que no son necesarias. Aumenta el tamaño del archivo de implementación. Sin embargo, si comparamos con la lista de ventajas, esta desventaja se vuelve insignificante. Si los criterios de tamaño son nuestra prioridad, esto se convierte realmente en una gran desventaja.

2) Otra desventaja es que existe un desafío cuando tenemos un requisito de migración de proyectos heredados basados ​​​​en Spring. Sin embargo, podemos corregir este problema usando Spring Boot CLI (Command Line Interface). Nos ayudará a convertir el código heredado.

5. ¿Cuáles son las formas de crear una aplicación Spring Boot?
En general, hay tres formas de crear una aplicación Spring Boot, como se muestra a continuación:

1) Uso de la interfaz de línea de comandos Spring Boot (herramienta CLI)
2) Uso de Spring Tool Suite (STS IDE)
3) Uso del sitio web Spring  Initializr

De ellos, la forma más utilizada de desarrollar un proyecto Spring Boot en la industria es usar STS (Spring Tool Suite) IDE. Es el más fácil de usar y tiene varias características. Se sabe que ahorra nuestro tiempo de desarrollo. Si es nuevo en STS, puede visitar el artículo separado sobre ' ¿Cómo crear un proyecto SpringBoot usando STS?'

6. ¿Cuáles son las dependencias iniciales de una aplicación Spring Boot?
En Spring Boot, trabajamos mucho con las dependencias iniciales. Los Starters son los pequeños proyectos listos para usar que podemos incluir en nuestra aplicación. Oficialmente se les llama descriptores de dependencia. Técnicamente, los starters contienen muchas de las dependencias que necesitamos para poner en marcha un proyecto rápidamente y con un conjunto consistente y compatible de dependencias transitivas administradas. No tenemos que buscar manualmente los archivos jar necesarios para ejecutar un proyecto.

Por ejemplo, si desea desarrollar una aplicación web Spring, incluya la dependencia spring-boot-starter-web en su proyecto. Sin embargo, si está utilizando STS (Spring Tool Suite) como IDE, solo necesita buscar 'Web' y seleccionar 'Spring Web'. El STS agregará automáticamente la dependencia 'spring-boot-starter-web' en su pom.xml.

Todos los titulares oficiales siguen una convención de nomenclatura similar; spring-boot-starter-*, donde * representa un tipo particular de aplicación. Esta estructura de nombres está destinada a ayudar cuando necesite encontrar un iniciador. Como se mencionó anteriormente, la integración de Maven con muchos IDE como STS le permite buscar dependencias por nombre. Puede encontrar la lista de algunos arrancadores de uso común en el enlace ' Arrancadores comunes en Spring Boot '.

7. ¿Qué servidor web proporciona Spring Boot de forma predeterminada?
Spring Boot proporciona Tomcat como servidor integrado predeterminado. Además, también proporciona dos servidores integrados más: Jetty y Undertow.

8. ¿Cómo podemos cambiar a diferentes servidores web en Spring Boot ?
Podemos cambiar a diferentes servidores agregando la dependencia Starter en el archivo pom.xml . Como podemos usar spring-boot-starter-jetty como una dependencia para usar un servidor jetty en nuestro proyecto.

9. ¿Cómo podemos deshabilitar la configuración automática para una clase específica en Spring Boot ?
Podemos deshabilitar la configuración automática para una clase específica usando el atributo de exclusión de la anotación @EnableAutoConfiguration como se muestra a continuación:

```@EnableAutoConfiguration(exclude={nombre de la clase})```

Por ejemplo, el siguiente fragmento de código deshabilita DataSourceAutoConfiguration:

```@EnableAutoConfiguration(excluir = DataSourceAutoConfiguration.class)```

Además, también podemos deshabilitar una configuración automática con la propiedad de entorno 'spring.autoconfigure.exclude'. La existencia de esta configuración en el archivo application.properties hace lo mismo que antes:

```spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration```

10. ¿Cuál es el concepto de Perfiles en Spring Boot?

Durante el desarrollo de cualquier proyecto, tenemos múltiples entornos como Dev, Test, QA, Prod. Cada entorno requiere una configuración diferente. Por ejemplo, podríamos estar usando una base de datos H2 integrada para desarrollo, pero podríamos tener SQL Server, Oracle o DB2 para Prod. Incluso si tenemos la misma base de datos en todos los entornos, la URL será diferente. Para que esto sea fácil y limpio, Spring tiene la provisión de perfiles para mantener la configuración separada de los entornos.

11. ¿Cuál es la diferencia entre Spring y Spring Boot?

1) Spring es un marco que requiere cierto esfuerzo para desarrollar aplicaciones de nivel empresarial, mientras que Spring Boot es una extensión de Spring Framework que proporciona desarrollo rápido de aplicaciones (RAD) para desarrollar una aplicación más rápido.

2) Spring es popular para la inyección de dependencia, mientras que Spring Boot es popular para la configuración automática.

3) Spring Framework requiere que los desarrolladores configuren el servidor web manualmente. Spring Boot tiene servidores integrados como Tomcat, Jetty y Undertow.

4) Spring Framework requiere un descriptor de implementación (web.xml) para ejecutar una aplicación. Spring Boot no requiere un descriptor de implementación para ejecutar una aplicación.

5) Spring requiere muchas configuraciones manuales, mientras que Spring Boot promueve la configuración automática.

6) Spring Framework requiere una serie de dependencias para crear una aplicación web. Spring Boot requiere solo una dependencia para funcionar en la aplicación web, que es 'spring-boot-starter-web'.

7) Spring Framework requiere configuraciones XML, mientras que Spring Boot no requiere configuración XML.

8) Spring Boot proporciona la herramienta CLI (Command Line Interface) para desarrollar y probar la aplicación, mientras que Spring Framework no proporciona ese tipo de herramienta.

9) Spring Framework requiere la definición manual de dependencias para el proyecto Spring en pom.xml. Spring Boot ofrece el concepto de iniciador en el archivo pom.xml que internamente se encarga de descargar los JAR dependientes automáticamente.

10) Spring Boot ofrece funciones listas para producción, como métricas, verificación de estado y otros informes. Spring no ofrece este tipo de características.

11) Spring Framework no admite bases de datos en memoria. Spring Boot incluye soporte para bases de datos en memoria como H2.

12. ¿Qué es el actuador Spring Boot? ¿Cual es su propósito?

Actuator habilita funciones listas para producción en una aplicación Spring Boot. Estas características nos permiten monitorear y administrar aplicaciones cuando se ejecutan en producción. Algunas de las características son salud, métricas, información, volcado, entorno, etc. Utiliza puntos finales HTTP o beans JMX para permitirnos interactuar con él. Para habilitar Spring Boot Actuator, solo necesitamos agregar la dependencia spring-boot-actuator a nuestro pom.xml como se muestra a continuación.

```
< dependencia > 
    < ID de grupo > org.springframework.boot </ ID de grupo >       
    < ID de artefacto > spring-boot-starter-actuator </ Id de artefacto > 
</ dependencia >  
```
 
A continuación se muestran algunos de los puntos finales integrados más utilizados que proporciona un actuador:

env: representa propiedades ambientales
salud: muestra el estado de salud de la aplicación
httptrace: muestra información de rastreo HTTP
info: muestra la información básica de la aplicación
métricas: muestra la información de métricas de la aplicación
asignaciones: muestra una lista de todas las rutas @RequestMapping en la aplicación
frijoles: muestra una lista completa de todos los frijoles Spring en la aplicación
shutdown: permite que la aplicación se apague correctamente

13. ¿Cuál es el uso de DevTools en Spring Boot?

Spring Boot DevTools es una característica proporcionada por Spring Boot, donde reinicia la aplicación cada vez que se realizan cambios en el código. Generalmente, necesitamos hacer clic derecho en el proyecto y ejecutar la aplicación una y otra vez. Spring Boot DevTools hace esto por nosotros si hay algún cambio en el código. El objetivo principal de este módulo es ahorrar tiempo en el desarrollo y las pruebas. 'spring-boot-devtools' es la dependencia que debemos agregar para aprovechar esta característica.

14. ¿Cuáles son las ventajas de usar un archivo yml en lugar de un archivo de propiedades?

YAML(.yml) es un formato conveniente para especificar datos de configuración jerárquicos. Se considera más legible que su alternativa de archivo de propiedades ya que no contiene prefijos repetidos. Además, también proporciona varias características únicas y útiles para nosotros.

1) Si usamos perfiles Spring, podemos tener múltiples perfiles en un solo archivo .yml. Por otro lado, cada perfil necesita un archivo .properties separado.

2) El archivo .yml tiene una estructura jerárquica, mientras que .properties no tiene una estructura jerárquica.

3) Al recuperar los valores del archivo .yml, obtenemos el valor del tipo respectivo (int, cadena, etc.) en la configuración. En el caso de los archivos .properties, obtenemos cadenas independientemente del tipo de valor real en la configuración.

15. ¿Qué es la compatibilidad con imágenes nativas de GraalVM en Spring Boot?

Esta es la nueva característica introducida en la versión Spring Boot 3.0. Las imágenes nativas de GraalVM proporcionan una nueva forma de implementar y ejecutar aplicaciones Java. En comparación con la máquina virtual de Java, las imágenes nativas pueden ejecutarse con una huella de memoria más pequeña y con tiempos de inicio mucho más rápidos.

GraalVM  es un JDK de alto rendimiento destinado a acelerar la ejecución de aplicaciones escritas en Java y otros lenguajes JVM, al mismo tiempo que ofrece tiempos de ejecución para JavaScript, Python y otros lenguajes populares. GraalVM ofrece dos formas de ejecutar aplicaciones Java: en HotSpot JVM con el compilador Graal justo a tiempo (JIT) o como un ejecutable nativo compilado antes de tiempo (AOT).

Las imágenes nativas de GraalVM  son ejecutables independientes que se pueden generar mediante el procesamiento de aplicaciones Java compiladas con anticipación. Las imágenes nativas generalmente tienen una huella de memoria más pequeña y se inician más rápido que sus contrapartes de JVM. Son muy adecuados para aplicaciones que se implementan utilizando imágenes de contenedor. Una imagen nativa de GraalVM es un ejecutable completo y específico de la plataforma. No necesitamos enviar una máquina virtual de Java para ejecutar una imagen nativa.

Si desea obtener más información al respecto y experimentar con GraalVM, puede continuar con la documentación oficial sobre " GraalVM Native Image Support ".

16. ¿Cuáles son las nuevas funciones de Spring Boot 3.0?
Spring Boot 3.0 se lanza oficialmente en noviembre de 2022. Las características principales de Spring Boot 3.0 son:

1) Una línea base de Java 17

2) Soporte para Jakarta EE en lugar de Java EE

3) Compatibilidad con imágenes nativas mediante GraalVM.

4) Observabilidad mejorada con Micrometer y Micrometer Tracing
