# CRUD con SPRING BOOT 
Creación Rest api con la siguientes tecnologias:
+ JPA 
+ POSTGRESQL 
+ PAGINATION 
+ Gradle 
+ Swagger 
+ Lombok 
+ Validator

### Ejecuta la apliación Gradle
- Primero debe estar creada la BD
```
CREATE DATABASE estudiante_db;
```

### Realizar configuración conexion a POSTGRESQL
Archivo ```application.properties```

### Al ejecutar la aplicación, corre en la siguiente dirección:
```http://localhost:8080```

### Se instalo Swagger que es opcional, realiza la misma funcion que postman
http://localhost:8080/swagger-ui.html

### Consulta end point

- Crear un usuario - POST - http://localhost:8080/student

```
{
  "name": "Jose",
  "lastName": "Ortiz",
  "age": 29
}
```

- Consultar todos los usuarios/estudiantes - GET - http://localhost:8080/student

- Consultar un usuario en especifico - GET - http://localhost:8080/student/{id}

- Eliminar un usuario en especifico - DELETE - http://localhost:8080/student/{id}

- Modificar usuario/estudiante - PUT - http://localhost:8080/student/{id}
```
{
  "name": "Hulk",
  "lastName": "Dr. Banner",
  "age": 29
}
```