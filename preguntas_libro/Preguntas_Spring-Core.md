# Preguntas De La Entrevista De Spring Core

1. ¿Qué es Spring Core?

Spring Core es un submódulo de Spring Framework que proporciona un conjunto de características y funcionalidades que ayudan a crear aplicaciones empresariales utilizando el lenguaje de programación Java. Es el módulo clave de Spring Framework. No podemos esperar desarrollar una aplicación basada en Spring sin aplicar los conceptos de Spring Core Module.

2. ¿Cuáles son las características clave de Spring Core Container?

Spring Core Container es el corazón de todo el ecosistema de Spring que cubre principalmente cuatro componentes: núcleo, beans, contexto y lenguaje de expresión. El núcleo y los beans son responsables de proporcionar las características más fundamentales del marco Spring, incluida la inyección de dependencia (DI) y la inversión de control (IoC). Estos módulos son responsables de administrar el contenedor IoC, y las responsabilidades principales son: creación de instancias de bean, configuración de bean y destrucción del bean que reside en el contenedor Spring.

3. ¿Qué es la inyección de dependencia de primavera?

Spring Dependency Injection (DI) es la característica del módulo central de Spring Framework, donde Spring Container inyecta otros objetos en un objeto. Aquí, otros objetos no son más que dependencias (variables de instancia) que se declaran en la clase (Spring Bean). En Spring Core, la inyección de dependencia se logra mediante el uso de anotaciones y configuraciones XML.

4. ¿Qué es la inversión de control (IoC)?

Inversion Of Control (IoC) es un concepto de ingeniería de software, donde el control de objetos o un bloque de un programa se transfiere a un contenedor o marco. IoC permite que un contenedor tome el control del flujo de un programa y realice llamadas a nuestro código personalizado en lugar de realizar llamadas a una biblioteca. Para implementar IoC, se utiliza el concepto Spring Dependency Injection.

5. ¿Cuáles son las responsabilidades del módulo Spring Context?

El módulo Context hereda sus características del módulo Beans e incluye soporte para internacionalización (I18N), propagación de eventos, carga de recursos y la creación transparente de contextos. El módulo Context también contiene soporte para algunas características de Java EE como EJB, JMX y soporte remoto básico. La interfaz ApplicationContext (también llamada Spring Container) es el punto clave del módulo Context que proporciona estas características.

6. ¿Cuáles son las responsabilidades del módulo Spring Expression Language?

El  módulo de lenguaje de expresión proporciona un poderoso lenguaje de expresión para consultar y manipular un gráfico de objetos en tiempo de ejecución. Se puede considerar como una extensión del lenguaje de expresión unificado (EL unificado) como se especifica en la especificación JSP 2.1. El lenguaje admite la configuración y obtención de valores de propiedades, asignación de propiedades, invocación de métodos, acceso al contexto de matrices, colecciones e indexadores, operadores lógicos y aritméticos, variables con nombre y recuperación de objetos por nombre del contenedor IoC de Spring. También es compatible con la proyección y selección de listas, así como con los agregadores de listas comunes.

7. ¿Qué es un frijol en Spring Core?

Un bean en Spring Core es una clase Java creada y administrada por el contenedor Spring. Puede ser accedido y utilizado por otras clases/objetos en la aplicación.

8. ¿Podemos declarar cualquier clase o una interfaz como Spring Bean?

Podemos considerar cualquier clase como Spring Bean , excepto una clase abstracta y una interfaz . También puede ser una clase POJO, una clase simple de Java Bean o cualquier otra clase.

9. ¿Qué es el Contenedor de Primavera?

El contenedor Spring es el componente central del marco Spring que es responsable de crear, configurar y administrar los beans Spring en la aplicación. También es responsable de las dependencias de cableado entre los objetos.

10. ¿Cuál es la diferencia entre el contenedor Spring y otros contenedores Java?

El contenedor Spring es un contenedor especializado que está diseñado para administrar beans en una aplicación Spring. Proporciona funciones como la creación de beans, la gestión de beans, la destrucción de beans, la inyección de dependencias, etc. Por otro lado, otros contenedores Java, como el contenedor Servlet, el contenedor JSP, son contenedores genéricos que se utilizan para administrar los objetos respectivos en cualquier aplicación Java.

11. ¿Cuáles son los diferentes tipos de contenedores Spring?

Hay dos tipos de contenedores Spring: BeanFactory y ApplicationContext. BeanFactory es un contenedor liviano que proporciona las características básicas del marco Spring. ApplicationContext es un contenedor más avanzado que proporciona características adicionales como internacionalización, resolución de mensajes y manejo de eventos de aplicaciones, etc.

12. ¿Cuándo usar BeanFactory vs. ApplicationContext?

Si está utilizando una aplicación basada en resortes liviana y de pequeña escala, prefiera usar el contenedor BeanFactory, ya que requiere menos memoria para funcionar. En otras palabras, si existe una limitación de memoria, prefiera usar el contenedor BeanFactory. Por ejemplo, aplicaciones móviles, aplicaciones de sistemas integrados, aplicaciones IOT, etc.

En todas las demás aplicaciones pesadas donde no existe limitación de memoria, como aplicaciones web, aplicaciones empresariales, aplicaciones distribuidas, aplicaciones de escritorio, etc., prefiera usar el contenedor ApplicationContext.

En la práctica general, deberíamos preferir usar el contenedor ApplicationContext siempre que sea posible usarlo. Debe tener una razón genuina para no usar ApplicationContext Container.

13. ¿Qué es una clase de configuración en Spring Core?

Una clase de configuración en Spring Core es una clase de Java que se utiliza para definir la configuración de una aplicación Spring. Está anotado con la anotación @Configuration y contiene uno o más métodos @Bean que definen los beans para la aplicación.

14. ¿Qué es un alcance de frijol en Spring Core?

Un alcance de bean en Spring Core define el alcance o la vida útil de un bean en la aplicación. Controla la creación de instancias del bean y es administrado por el contenedor de primavera. Básicamente, controla cuándo se creará una instancia del objeto de Bean, cuánto tiempo vive ese objeto y cuántos objetos se crearán para ese bean en todo momento. Hay diferentes ámbitos de bean disponibles en Spring, como singleton, prototipo, solicitud, sesión y sesión global.

15. ¿Qué es un alcance de frijol singleton?

Un alcance de bean singleton es un alcance de bean en el que solo hay una instancia del bean en el contexto de la aplicación. Es el ámbito de frijol predeterminado en Spring.

16. ¿Qué es un alcance de bean prototipo?

Un ámbito de bean prototipo es un ámbito de bean en el que se crea una nueva instancia del bean cada vez que se solicita.

17. ¿Qué es un alcance de bean de solicitud?

Un ámbito de bean de solicitud es un ámbito de bean en el que se crea una nueva instancia del bean para cada solicitud HTTP.

18. ¿Qué es el alcance de un bean de sesión?

Un ámbito de bean de sesión es un ámbito de bean en el que se crea una nueva instancia del bean para cada sesión HTTP.

19. ¿Qué es un alcance de bean de sesión global?

Un ámbito de bean de sesión global es un ámbito de bean en el que se crea una nueva instancia del bean para cada sesión HTTP global.

20. ¿Qué es el cableado de bean en Spring Framework?

El cableado de beans en Spring se refiere al proceso de creación de dependencias entre beans en el contexto de la aplicación. En otras palabras, es un mecanismo por el cual el contenedor Spring gestiona las relaciones entre diferentes objetos dependientes en una aplicación Spring. Existen varios enfoques del cableado de Bean, como la configuración XML, la configuración basada en Java y la configuración basada en anotaciones.

21. ¿Qué es la inyección de constructor?

La inyección de constructor es una forma de inyección de dependencia en la que las dependencias se inyectan en el constructor de una clase.

22. ¿Qué es la inyección de setter?

La inyección de setter es una forma de inyección de dependencia en la que las dependencias se inyectan en los métodos setter de una clase.

23. ¿Qué es el cableado automático en Spring?

El cableado automático en Spring es un mecanismo para conectar automáticamente dependencias entre beans en función de sus tipos. Spring Container detecta la relación entre los beans leyendo el archivo de configuración XML o escaneando las anotaciones de Java en el momento de iniciar la aplicación. Además, creará los objetos y conectará las dependencias. Dado que Spring Container realiza este proceso automáticamente, se lo conoce como cableado automático , es decir, cableado automático.

24. ¿Cuáles son los diferentes tipos de cableado automático en Spring?

Hay varios modos de cableado automático en Spring, incluido el no cableado automático, por nombre, por tipo y constructor.

25. ¿Cuál es la diferencia entre 'sin conexión automática' y 'conexión automática por nombre'?

Sin cableado automático, las dependencias no se conectan automáticamente entre beans. Con el cableado automático por nombre, las dependencias se conectan automáticamente en función de los nombres de los beans.

26. ¿Cuál es la diferencia entre 'por tipo de cableado automático' y 'autocableado de constructor'?

Con el cableado automático por tipo, las dependencias se conectan automáticamente en función de sus tipos. Con el cableado automático del constructor, las dependencias se conectan automáticamente a través del constructor de la clase.

27. ¿Qué es la anotación @Autowired?

La anotación @Autowired se usa para inyectar automáticamente dependencias en Spring. Se puede usar en propiedades, setters y constructores. Cuando Spring encuentra esta anotación, busca un bean del mismo tipo y lo inyecta en la clase.

28. ¿Qué es la anotación @Qualifier?

La anotación @Qualifier se usa para especificar qué bean usar para el cableado automático cuando hay varios beans del mismo tipo.

29. ¿Qué es la anotación @Value?

La anotación @Value se usa para inyectar valores en las propiedades de un bean en Spring.

30. ¿Qué es la anotación @Component?

La anotación @Component se usa para marcar una clase como componente Spring/Spring Bean. Además, la anotación @Component se usa para indicar que una clase debe ser administrada por el contenedor Spring igual que un bean Spring. Es una anotación de estereotipo genérico que se puede utilizar para cualquier clase.

31. ¿Cuál es la diferencia entre las anotaciones @Component, @Service y @Repository?

La anotación @Component es una anotación estereotipada genérica que se puede usar para cualquier clase. La anotación @Service se usa para marcar una clase como componente de servicio, mientras que la anotación @Repository se usa para marcar una clase como componente de acceso a datos.

32. ¿Qué es la anotación @Configuration?

La anotación @Configuration se usa para marcar una clase como una clase de configuración en Spring Core. Contiene uno o más métodos @Bean que definen los beans para la aplicación.

33. ¿Qué es la anotación @Bean?

La anotación @Bean se usa para declarar un bean en Spring.

34. ¿Cuál es la diferencia entre las anotaciones @Bean y @Component?

La anotación @Component se usa para marcar una clase como componente Spring, mientras que la anotación @Bean se usa para declarar un bean. La anotación @Component se usa para clases que no están configuradas explícitamente en el contexto de la aplicación, mientras que la anotación @Bean se usa para clases que están configuradas explícitamente en el contexto de la aplicación.

35. ¿Cuál es el propósito de la anotación @Import?

La anotación @Import se usa para importar una o más clases de configuración a otra clase de configuración.

36. ¿Cuál es el propósito de la anotación @PropertySource?

La anotación @PropertySource se utiliza para especificar la ubicación de un archivo de propiedades que contiene propiedades de configuración para la aplicación.

37. ¿Cuál es la diferencia entre un archivo de propiedades y un archivo YAML en Spring?

Tanto los archivos de propiedades como los archivos YAML se usan comúnmente para configurar aplicaciones Spring, pero tienen algunas diferencias en términos de sintaxis y características. Los archivos de propiedades usan un formato simple de clave-valor para almacenar información de configuración, con cada clave y valor separados por un signo igual (=). Por otro lado, YAML usa sangría de espacios en blanco para indicar la estructura. YAML admite estructuras de datos más complejas, lo que lo convierte en un formato más flexible y expresivo para la configuración. En general, los archivos de propiedades son más simples y fáciles de usar para la configuración básica, mientras que YAML es más potente y se adapta mejor a escenarios de configuración más complejos.

38. ¿Cuál es el propósito de la anotación @Profile?

La anotación @Profile se usa en Spring para especificar qué beans deben cargarse en función de los perfiles activos. Un perfil es una forma de definir un conjunto de configuraciones que se utilizan en diferentes entornos o situaciones, como desarrollo, prueba o producción. La anotación @Profile se puede aplicar a una clase o un método, y su valor especifica con qué perfil o perfiles se debe asociar el bean.

39. ¿Cuál es la diferencia entre una definición de bean y una instancia de bean en Spring?

Una definición de bean es un modelo para un bean, mientras que una instancia de bean es un objeto real que se crea a partir de la definición de bean.

40. ¿Cuál es el propósito de BeanFactory en Spring?

BeanFactory es la interfaz de contenedor central en Spring Core. Es responsable de crear y administrar varios beans que residen en el contenedor.

41. ¿Cuál es el propósito de ApplicationContext en Spring?

ApplicationContext es una interfaz de contenedor más avanzada en Spring Core. Amplía la funcionalidad de BeanFactory y proporciona características adicionales, como la internacionalización y el manejo de eventos de aplicaciones.

42. ¿Cuál es el propósito de la interfaz BeanPostProcessor en Spring?

La interfaz BeanPostProcessor se utiliza para personalizar la creación de instancias y la inicialización de beans en Spring.

43. ¿Cuál es el propósito de la interfaz BeanFactoryPostProcessor en Spring?

La interfaz BeanFactoryPostProcessor se utiliza para personalizar la configuración de BeanFactory en Spring.

44. ¿Cuál es el propósito de la interfaz InitializingBean en Spring?

La interfaz InitializingBean se utiliza para realizar tareas de inicialización después de que se haya creado una instancia de un bean y se hayan establecido todas sus dependencias. Se utiliza para declarar el método del ciclo de vida del frijol .

45. ¿Cuál es el propósito de la interfaz de AvailableBean en Spring Core?

La interfaz de AvailableBean se utiliza para realizar tareas de limpieza antes de que se destruya un bean. También se utiliza para declarar el método del ciclo de vida del frijol.

46. ¿Cuál es el propósito de la anotación @PostConstruct?

La anotación @PostConstruct se usa para especificar un método que debe llamarse después de que se haya creado una instancia de un bean y se hayan establecido todas sus dependencias. Es una alternativa a la interfaz InitializingBean.

47. ¿Cuál es el propósito de la anotación @PreDestroy?

La anotación @PreDestroy se usa para especificar un método que debe llamarse antes de que se destruya un bean. Es una alternativa a la interfaz de AvailableBean.

48. ¿Qué anotación se usa generalmente para inyectar dependencias en un bean en Spring?

La anotación @Autowired se usa comúnmente en Spring Dependency Injection para inyectar automáticamente dependencias en un bean/clase. Cuando Spring encuentra esta anotación, busca un bean del mismo tipo y lo inyecta en la clase.

49. ¿Cómo ayuda Spring Dependency Injection con las pruebas unitarias?

Spring Dependency Injection puede ayudar a simplificar las pruebas unitarias al permitir que los desarrolladores simulen o sustituyan fácilmente las dependencias durante las pruebas. Esto facilita aislar el comportamiento de la clase que se está probando y asegura que las pruebas no dependan del comportamiento de otras clases.

50. ¿Cuáles son las ventajas de usar Spring Dependency Injection?

Las ventajas de usar Spring Dependency Injection incluyen un acoplamiento reducido entre clases, capacidad de prueba mejorada, mayor modularidad y flexibilidad, y un mantenimiento más fácil de la base de código.

51. ¿Cuál es la diferencia entre las anotaciones @Autowired y @Qualifier en Spring Dependency Injection?

@Autowired se usa para inyectar automáticamente dependencias en una clase, mientras que @Qualifier se usa para especificar qué bean usar cuando hay varios beans del mismo tipo en el contenedor.

52. ¿Cómo maneja Spring Dependency Injection las dependencias circulares?

Spring Dependency Injection puede manejar dependencias circulares mediante el uso de inicialización diferida, donde los beans solo se inicializan cuando se necesitan. Otro enfoque es usar la inyección de setter, donde una de las dependencias se establece después de construir el objeto.

53. ¿Cuáles son las mejores prácticas para usar Spring Dependency Injection?

Algunas de las mejores prácticas para usar Spring Dependency Injection incluyen mantener un número bajo de dependencias, evitar dependencias circulares, usar interfaces para definir dependencias y mantener la configuración del contenedor de inyección de dependencia simple y organizada.

54. ¿Qué es la inicialización perezosa en el contenedor Spring?

La inicialización diferida es una característica del contenedor Spring que retrasa la creación de beans hasta que realmente se necesitan. Esto ayuda a mejorar el rendimiento y reducir el consumo de recursos.

55. ¿Cuáles son las diferentes formas de configurar una inyección de dependencia de Spring?

La inyección de dependencias de Spring se puede configurar mediante archivos de configuración XML, clases de configuración de Java o anotaciones. Los archivos de configuración XML proporcionan una forma declarativa de configurar el contenedor, mientras que las anotaciones y las clases de configuración de Java proporcionan una forma más programática de configurar la inyección de dependencia.

56. ¿Cuál es el propósito de un posprocesador de frijoles en el contenedor Spring?

Un posprocesador de beans es un mecanismo en el contenedor Spring que permite el procesamiento personalizado de beans antes y después de que se instancian. Esto se puede usar para personalizar el comportamiento de los beans o realizar tareas de inicialización adicionales.

57. ¿Cómo determina Spring qué bean autoconectar?

Spring utiliza un conjunto de reglas para determinar qué bean conectar automáticamente, en función del modo de conexión automática. Para el cableado automático por tipo, Spring busca un solo bean del mismo tipo que la propiedad. Por nombre autowiring, Spring busca un bean con el mismo nombre que la propiedad. Para el cableado automático del constructor, Spring busca un bean con un argumento constructor del mismo tipo que la propiedad.

58. ¿Qué sucede si Spring encuentra varios beans que coinciden con los criterios de cableado automático?

Si Spring encuentra varios beans que coinciden con los criterios de cableado automático, generará una excepción. Para resolver esto, puede usar la anotación @Qualifier para especificar qué bean usar, o usar la anotación @Primary para indicar el bean preferido.

59. ¿Cuál es la diferencia entre las anotaciones @Autowired y @Inject en Spring?

@Autowired y @Inject se usan para el cableado automático en Spring, pero están definidos por marcos diferentes. @Autowired es una anotación específica de Spring, mientras que @Inject es una anotación estándar definida por la especificación JSR-330. Las dos anotaciones son funcionalmente equivalentes en la mayoría de los casos.

60. ¿Cómo deshabilita el cableado automático para un bean específico en Spring?

Para deshabilitar el cableado automático para un bean específico en Spring, puede usar la anotación @Autowired con el atributo 'requerido' establecido en 'falso'. Esto le dice a Spring que no lance una excepción si el bean no se puede conectar automáticamente.

61. ¿Cuál es el modo de cableado automático predeterminado en Spring?

El modo de cableado automático predeterminado en Spring es por tipo. Si Spring no puede encontrar un bean del mismo tipo que la propiedad, buscará un bean con el mismo nombre que la propiedad.
