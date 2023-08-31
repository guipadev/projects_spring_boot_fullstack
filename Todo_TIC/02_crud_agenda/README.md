# Getting Started

Agenda Virtual que te permitirá crear, consultar, actualizar y eliminar tus contactos. 
Esta aplicación será desarrollada usando el proyecto Spring Boot, el motor de plantillas Thymeleaf, Java Persistence API, Lombok, DevTools, Bootstrap y MySQL.

### Script SQL
Debes tener creada inicialmente la BD y la siguienta tabla:
```
create database agenda;
```
```
use agenda;
create table agenda.contacto (
idcontacto int primary key auto_increment,
nombre varchar(100) not null,
fechanac date,
celular varchar(15),
email varchar(50)
);
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web.servlet.spring-mvc.template-engines)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

