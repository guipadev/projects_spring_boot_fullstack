# Fullstack project for CSRF implementation with Spring Boot and Angular

El proyecto tiene implementada la protección CSRF en ambas partes, el backend y el frontend.

La protección CSRF permite al backend saber que el frontend que inició la comunicación es el mismo que envía las solicitudes.

Al cargar el frontend, se debe realizar una solicitud inicial para obtener el token CSRF. Entonces todo las solicitudes realizadas por el frontend deben devolver este token CSRF (todos menos GET).

## Backend

El backend se implementa con Spring Boot. A medida que se suman las dependencias, existe la dependencia web.

Para tener algunos puntos finales disponibles y Spring Security para configurar fácilmente la protección CSRF.

Primero, necesito proteger el proyecto con Autenticación. Elegí utilizar la sesión de cookies. 

Luego, la protección CSRF se superpondrá a la autenticación. Tanto la autenticación de una solicitud y el token CSRF debe enviarse desde el frontend al backend en dos diferentes sistemas. 

Cuando elijo la sesión para la autenticación, ya tengo una cookie para la sesión. Esto significa que debo enviar el CSRF en un encabezado HTTP.

Para iniciar el proyecto backend:

```
cd backend
./mvnw spring-boot:run
```

## Frontend

El frontend está implementado con Angular. Solo agregué la dependencia Material para crear fácilmente los componentes de la interfaz de usuario.

El componente raíz debe solicitar el token CSRF desde el backend y almacenarlo al principio.

Como uso una cookie para identificar la sesión y la autenticación del usuario, no puedo usar otra cookie para almacenar el token CSRF. 

Elijo almacenar el token en una variable simple y enviarlo para cada solicitud en un encabezado HTTP. 

Para eso, anulé el HttpClient y uso el mío propio pero asegúrese de enviar siempre el encabezado HTTP con el token CSRF.

Para iniciar el proyecto frontend (asegúrese de tener instalada la CLI de Angular):

```
cd frontend
ng serve
```

