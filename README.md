# springboot_fullstack
spring boot y spring boot feat angular, react, bd relacionales y no relacionales

## Qué es una API
La palabra **API** es un acrónimo que significa **Interfaz de Programación de Aplicaciones** (Application Programming Interface). Es un sistema que funciona como intermediario entre diferentes aplicaciones de software y su función es permitir que estas aplicaciones pueda comunicarse entre sí. Cada ves que usas una app como WhatsApp, Instagram o Facebook, estás usando una API sin saberlo.

## Cómo funciona una API

**Base de datos**	------------------>	**API** ---------------------------->	**Aplicación**
La información o las herramientas		Una API permite conectar la 			El cliente tiene accesoa toda
desarrolladas por una empresa son 		información o funcionalidades con 		su información requerida en 
utilizadas en servicios de terceros.	los requerimientos de una aplicación.	una sola aplicación.

## Qué es REST?
REST no es un protocolo ni un estándar, sino más bien un conjunto de límites de arquitectura. Los desarrolladores de las API pueden implementarlo de distintas maneras. REST es una arquitectura para APIs que se conectan vía web con el protocolo HTTP.

## Spring Boot RESTful Web Services CRUD API

-------------------------------------------------------------------
|		Aplicación Spring springboot							  |	
|  -------------------------------------------------------------  |
|  |	Servidor Tomcat embebido							   |  |
|  |  -------------------------------------------------------  |  |
|  |  |	Aplicación Spring Web								|  |  |
|  |  |														|  |  |
|  |  |  ------------------				------------------- |  |  |
|  |  |	 |Spring Data JPA |	  ←------→	| RESTful 		  |	|  |  |
|  |  |	 ------------------				| Web Services	  |	|	POST		  -----------
|  |  |			↑						|				  |	←--------------→  |	RESTful |
|  |  |			↓						| Guardar		  |	|	GET			  |	  Web   |
|  |  |	 -------------------------		| Listar		  |	←--------------→  |	Service |
|  |  |	 |	 |Hibernate framework|		| Actualizar	  | |	PUT			  |	Clientes|
|  |  |	 -------------------------		| Eliminar		  |	←--------------→  |		    |
|  |  |									|				  | |	DELETE        |         |
|  |  |									|Spring Controller| ←--------------→  |         |
|  |  |									-------------------	|  |  |           -----------  
|  |    -----------------------------------------------------  |  |
|   ------------------------------------------------------------  |
-------------------------------------------------------------------