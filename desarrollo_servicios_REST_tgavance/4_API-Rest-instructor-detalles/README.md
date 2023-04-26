# APIs REST con relaciones unidireccional @ManyToOne de publicaciones y comentarios

Imagen de la relación a realizar en BD:

![Image text](https://github.com/yadevom/apirest_biblioteca_bidirecional/blob/main/relacion_bd.png)

### Creación Base de Dato (MySQL)
Debemos tener creada la BD antes de ejecutar la App
```
create database instructor;

ó

CREATE SCHEMA instructor DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
```
### Configuración conexión BD
En el archivio application.properties, indicar el nombre de la BD, username y password:
```
spring.datasource.url = jdbc:mysql://localhost:3306/instructor 
spring.datasource.username = $USER
spring.datasource.password = $PASS
```
### Script SQL
Consulta de publicaciones:
```
SELECT * FROM instructor.instructor;
```

Ingresar datos instructor_detalles
```
INSERT INTO instructor.instructor_detalle (id, canal_youtube, pasa_tiempo) VALUES ('1', 'midudev', 'mover las manitos');
INSERT INTO instructor.instructor_detalle (id, canal_youtube, pasa_tiempo) VALUES ('2', 'hola mundo', 'vender cursos');
```

Ingresar datos instructor
```
INSERT INTO instructor.instructor (id, apellido, email, nombre, instuctor_detalle_id) VALUES ('1', 'roman', 'ro@gmail.com', 'midudev', '1');
```

### Consultas end point

Consulta todas los instructores - GET ```http://localhost:8080/api/v1/instructores```

Eliminar instructor especifica - DELETE ```http://localhost:8080/api/v1/instrutores/2```

