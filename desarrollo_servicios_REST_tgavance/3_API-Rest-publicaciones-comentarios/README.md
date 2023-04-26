# APIs REST con relaciones unidireccional @ManyToOne de publicaciones y comentarios

Imagen de la relación a realizar en BD:

![Image text](https://github.com/yadevom/apirest_biblioteca_bidirecional/blob/main/relacion_bd.png)

### Creación Base de Dato (MySQL)
Debemos tener creada la BD antes de ejecutar la App
```
create database publicaciones;

ó

CREATE SCHEMA publicaciones DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
```
### Configuración conexión BD
En el archivio application.properties, indicar el nombre de la BD, username y password:
```
spring.datasource.url = jdbc:mysql://localhost:3306/colegio_editorial 
spring.datasource.username = $USER
spring.datasource.password = $PASS
```
### Script SQL
Consulta de publicaciones:
```
SELECT * FROM publicaciones.publicaciones;
```

Consulta de libros:
```
SELECT * FROM colegio_editorial.books ;
```

### Consultas end point
Creacion de publicaciones - POST ```http://localhost:8080/publicaciones```

```
{
    "titulo" : "Curso API Rest 10",
    "descripcion" : "CRUD OneyToMany unidericcional",
    "contenido" : "anotaciones relacionales"
}
```

Consulta todas las publicaciones - GET ```http://localhost:8080/publicaciones```

Actualizar publicacion - PUT ```http://localhost:8080/publicaciones/1```

Conulstar publicacion por paginacion - GET ```http://localhost:8080/publicaciones?page=0&size=2&sort=fechaCreacion,desc```

Registrar comentarios - POST ```http://localhost:8080/publicaciones/1/comentarios```
```
{
    "texto" : "Muy didactico"
}
```
Consultar comentarios de publicacion - GET ```http://localhost:8080/publicaciones/1/comentarios```

Eliminar comentario especifico de publicacion - DELETE ```http://localhost:8080/publicaciones/1/comentarios/1```

Eliminar publicacion especifica - DELETE ```http://localhost:8080/publicaciones/1```

