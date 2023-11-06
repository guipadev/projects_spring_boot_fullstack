# Spring Boot Crud
Este proyecto es un CRUD desarrollado con Spring Boot & Spring Data JPA

## Requerimiento de Tecnologias
- [Java 17](https://adoptium.net/) or higher. Setting the [JAVA_HOME](https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux) environment variable
- [Maven](https://maven.apache.org/download.cgi)
- [Lombok](https://projectlombok.org/download)

## Caracteristicas y librerias del Proyecto

- Spring Boot
- Spring Data JPA
- [Cors](https://www.baeldung.com/spring-cors)
- [ModelMapper](https://modelmapper.org/)
- [Lombok](https://projectlombok.org/)
- Repository
- DAO
- Create your own insert, update, and delete queries
- [Projection](https://www.baeldung.com/spring-data-jpa-projections)
- [Criteria queries](https://www.baeldung.com/spring-data-criteria-queries)
- [JdbcTemplate](https://www.baeldung.com/spring-jdbc-jdbctemplate)
- [Pagination](https://www.baeldung.com/spring-data-jpa-pagination-sorting)
- Specification / Criteria
- [RestControllerAdvice](https://websparrow.org/spring/spring-restcontrolleradvice-annotation-example)
- Generics
- Transactional
- Managing many-to-many relationships
- H2


## Instrucciones
Si desea ejecutar el proyecto y probar desde la consola:
```
mvn clean install
mvn spring-boot:run
```

## Conexión a BD H2
LINK: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:./data/testdb
USER: sa
PASS: pass

## Consulta BD
SELECT * FROM AUTHORS

## Consulta end points

- Crear
POST - http://localhost:8080/authors
{"firstName":"Bruno", "lastName":"Wein", "birthdate":"10/12/1980"}

- Actualizar
PUT - http://localhost:8080/authors/1
{"firstName":"Bruno", "lastName":"Wein", "birthdate":"10/12/1980"}

- Buscar
GET - http://localhost:8080/authors/1

- Eliminar
DELETE - http://localhost:8080/authors/1

- Paginado, buscar por autor
GET - http://localhost:8080/authors/page?q=lastName1&sortDirection=desc&page=5

- Paginado, buscar por libro titulo
GET - http://localhost:8080/books/pages?page=D&q=title
 
- Registrar libroPUT
POST - http://localhost:8080/books
{"title":"100 años de soledad", "publicationDate":"10/12/1988", "onlineAvailability":true, "authors": [1,2,3]}

