# Proteger Aplicación Fullstack Angular - Spring Boot con La Autenticación JWT

- Se crea un formulario de inicio de sesión donde se necesitara Spring Security 6
- Y se usara JWT para autenticar las llamadas

## ¿Como funciona un sistema de autenticación?

El backend necesita saber que alguien en quien confio hace las solicitudes entrantes.
Para crear esta confianza, el backend valida un nombre de usuario y una contraseña del frontend.
Pero hago esto para la primer llamada. Entonces, ¿cómo confiar en las siguientes llamadas?, para eso usaremos JWT.

## JWT
Es un documento JSON codificado. Cuando el backend primero valida el nombre de usuario y la contraseña, crea un JWT a cambio.
Está codificado con una clave secreta que solo conoce el backend.
Luego, el frontend debe almacenar el JWT y usarlo para todas las siguientes llamadas.
Como la clave secreta solo se conoce en el backend, si el JWT recibido se decodifica correctamente, el backend asume que el JWT fue creado por sí mismo y puede confiar en la llamada.

Pero almacenar el JWT en el frontend, existe un riesgo de que alguien robe el JWT y lo descifre. Por eso, al generar el JWT, se agrega una fecha de validez. Tan corto como sea posible. Entonces, como existe el riesgo de descifrar el JWT, no puedo almacenar información crítica.

Es por es que solo se almacenara la información del usuario que no es crítica, como el nombre, apellido, los roles y nombre de usuario. De esta manera no necesito solicitar a la Base de Datos en cada llamada.
