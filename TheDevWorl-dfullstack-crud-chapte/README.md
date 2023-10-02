# CRUD Application made with Spring Boot and Angular

Proyecto Spring Boot, creado con Spring Initializer.

## Frontend
- Angular 16
- Angular Material
- Se crea componente display con tarjeta para mostrar un vehiculo
- Se crea componente input para enviar un nuevo vehiculo al back
- Cuando se inicializa el componente app, busca todos los vehiculos del back y se muestra en un bucle for
- Se agrega boton de edicion y eliminar en el componente display a un solo vehiculo
- Componente wrapper para cambiar el componente display a un formulario edicion


## Backend
- Spring boot 3
- Java 17
- JPA
- Postgres

## Dependencias
- Web
- JPA
- Postgres
- Mapstruct
- Lombok
- Valid

## End Point
- Obtener vehiculo
- Obtener todos los vehiculos
- Crear vehiculo
- Eliminar vehiculo
- Actualizar/reemplazar vehiculo

## Configuraciones
- Se agrega configuración CORS que permite al frontend acceder por URL al backend
- Se agrega un aspecto para detectar todas las excepciones y devolver un mensaje legible en la interfaz

## Otros pendientes
- Crear más endpoint para PATCH en un vehiculos, para buscar un vehiculo y filtros

