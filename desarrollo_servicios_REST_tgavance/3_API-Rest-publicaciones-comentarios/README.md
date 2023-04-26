# APIs REST con relaciones unidireccional @ManyToOne de publicaciones y comentarios

Imagen de la relación a realizar en BD:

![Image text](https://github.com/yadevom/apirest_biblioteca_bidirecional/blob/main/relacion_bd.png)

### Creación Base de Dato (MySQL)
Debemos tener creada la BD antes de ejecutar la App
```
create database publicaciones;

o

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

Consulta todas las publicaciones - GET ```http://localhost:8080/publicaciones```

Consulta biblioteca especifica - GET ```http://localhost:8080/api/library/2```

Eliminar biblioteca - DELETE ```http://localhost:8080/api/library/2```

Registrar biblioteca - POST ```http://localhost:8080/api/library```
```
{
    "name": "Casa de programacion"
}
```
Actualizar biblioteca - PUT ```http://localhost:8080/api/library/2```

Indicar el ID actualizar y escribir cuerpo dato a modificar
```
{
    "name": "Arquitectura Frontend"
}
```

### Consultas end point Libros
Registrar un libro - POST ```http://localhost:8080/api/books```
```
{
    "name": "ReactJS Ganchos",
    "library": {
        "id" : 2
    }
}
```

Consulta todas los libros - GET ```http://localhost:8080/api/books```

Consulta libro en especifico - GET ```http://localhost:8080/api/books/2```

Eliminar libro - DELETE ```http://localhost:8080/api/books/2```


Actualizar libro - PUT ```http://localhost:8080/api/books/1```

Indicar el ID actualizar dato del libro o biblioteca a modificar
```
{
    "name": "Algoritmia avanzada",
    "library": {
        "id" : 1
    }
}
```

