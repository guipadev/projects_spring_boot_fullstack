# Productos tecnologicos API CRUD

### Desarrollo de una API de servicios web RESTful para operaciones CRUD con MySQL en Spring Boot
Se desarrolla mediante Spring Boot el desarrollo de una API de servicios web RESTful para operaciones CRUD con MySQL en Spring Boot.  

Las operaciones CRUD incluyen Crear, Recuperar, Actualizar y Eliminar.

### Dependencias utilizadas para App
- MySQL Drive
- Spring Data JPA
- Spring Web

### Creación Base de Dato (MySQL)
Debemos tener creada la BD antes de ejecutar la App
```
create database bd_inventario;
```
### Configuración conexión BD
En el archivio application.properties, indicar el nombre de la BD, username y password:
```
spring.datasource.url = jdbc:mysql://localhost:3306/bd_inventario 
spring.datasource.username = $USER
spring.datasource.password = $PASS
```
### Script SQL
Ingresar datos de pruebas:
```
INSERT INTO bd_inventario.producto(id, nombre, precio) VALUES
("1", "Televisor", 2500000),
("2", "Celular", 1500000),
("3", "Auriculares", 35000);
```
Consulta de datos:
```
SELECT * FROM bd_inventario.producto;
```
### Consultas end point
Consulta todos los productos - GET ```http://localhost:8080/productos/```

Consulta producto especifio por Id - GET ```http://localhost:8080/productos/2```

Registrar producto - POST ```http://localhost:8080/productos```
```
{
    "nombre": "USB",
    "precio": 29000
}
```

Actualizar producto - PUT ```http://localhost:8080/productos/4```

Indicar el ID actualizar y escribir todo el body del producto
```
{
    "id": 4,
    "nombre": "USB",
    "precio": 29000
}
```

### Eliminar producto - DELETE

Indicar el ID del producto a eliminar ```http://localhost:8080/productos/6```