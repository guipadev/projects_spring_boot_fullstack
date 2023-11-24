# ¿Qué es la anotación @Configuration en Spring Boot?
El uso @Configurationen Spring Boot principalmente para declarar nuevos beans que se 
incluirán en Spring Context. 
Podemos inyectar estos beans a través de la anotación @Autowired donde los necesitemos. 
Además, @Configuration etiqueta esta clase como un bean para poder incluirla en el 
contexto Spring.

## @Configurationtiene 3 atributos:
- `value`, que le permite especificar el nombre del bean.
- `proxyBeanMethods`, que por defecto es true.
- `enforceUniqueMethods` que por defecto es true.

## Creando los Servicios
Para demostrar cómo funciona @Configuration crearemos 3 servicios:
- `PunctuationService`, un servicio que proporciona signos de puntuación como "." o "?".
- `LowerCaseWordsService`, un servicio que proporciona algunas palabras en minúscula y tiene `PunctuationService` como dependencia.
- `UpperCaseWordsService` un servicio que proporciona algunas palabras en mayúsculas y tiene `PunctuationService` como dependencia.

No agregamos a ninguna clase al Spring Context ya que no tienen ninguna anotación como @Service.

## Creando la clase de configuración usando la anotación @Configuration
Crear la clase Configuración y ver cómo podemos declarar beans a través de ella. 

### Atributo de métodos proxyBean
Este atributo especifica si @Bean los métodos anotados utilizarán un proxy (más específicamente CGLib). 
Tener en cuenta que establecer este atributo en falso (también conocido como modo @Bean Lite) 
hace que @Configuration la anotación sea redundante y solo la anotación @Component sería suficiente.

La ventaja de usar un proxy es que siempre que llamemos a un método anotado @Bean, se devolverá el mismo bean. 
Sin embargo, esto tiene algunas desventajas:

- El tiempo de inicio puede ser más lento en comparación con configurar este atributo como false. 
  Especialmente cuando existen muchas @Configurationclases anotadas.
- No puede declarar tanto la clase como cualquier método como finales, ya que es necesario subclasificarlos.

### Atributo enforceUniqueMethods
Este atributo es exactamente lo que su nombre indica; No podemos tener dos métodos de lo mismo.

Como resultado, la sobrecarga no se puede aplicar a todos @Bean los métodos anotados.

### Uso de valores predeterminados
El primer caso es cuando no cambiamos los valores de proxyBeanMethods y enforceUniqueMethods.