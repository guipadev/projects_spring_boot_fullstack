# Aplicación Gestion Empleados - CRUD Angular Spring Boot MySQL
- Se realizara aplicación gestion de empleados, donde podremos crear, editarlos, eliminarlos, ver detalles
de cada uno y mostrar todos los registros de los empleados.
- El formulario de registro tendra validaciones antes de enviar la información al backend.
- Desarrollo de aplicación web full stack en Spring Boot como backend y Angular como frontend. 
- Se crea API RESTful con Spring Boot (conectar la API REST a JPA / Hibernate con Spring Boot)
- Conectar Angular Frontend a una RESTful API de Spring Boot.

Arquitectura de la aplicación a realizar:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/arquitectura.png)

Mediante un componente de Angular, que solicita un servicio HttpClient accede a la URL del Controller de Spring Boot para solicitar y retornar la rta.

## Consideraciones del Backend

## Servidor de desarrollo
`http://localhost:8080`

### Dependencias Spring Boot
- SPring Data JPA
- mysql Drive
- Spring Web
- Spring Boot DevTools                                   

### Configuración conexión BD MySQL
En el archivio application.properties, indicar el nombre de la BD, username y password:
```
spring.datasource.url = jdbc:mysql://localhost:3306/control_empleados 
spring.datasource.username = $USER
spring.datasource.password = $PASS
```
- Descomentar las últimas lineas y configurar los datos para la conexión a la BD mysql del archivo application.properties
- Esta últimas 3 lineas se comentan para que cada que se inicie la aplicación no cree las tablas nuevamente


### Creación Base de Dato (MySQL)
Debemos tener creada la BD antes de ejecutar la App
```
CREATE DATABASE control_empleados DEFAULT CHARACTER SET utf8;
```

### Script SQL
Ingreso datos de prueba con el Backend.
```
insert into control_empleados.empleados (id, apellido, email, nombre) values
(1, 'Aguilar', 'aguilar@gmail.com', 'Antonio'),
(2, 'Infante', 'pinfante@gmail.com', 'Pedro'),
(3, 'Fernandez', 'chentef@gmail.com', 'Vicente'),
(4, 'Negrete', 'jnegrete@gmail.com', 'Jorge'),
(5, 'Solis', 'jsolis@gmail.com', 'Javier'),
(6, 'Jimenez', 'jajimenez@gmail.com', 'Jose Alfredo'),
(7, 'Aguilar', 'laguilar@gmail.com', 'Luis');
```

Visualizar datos registrados en la tabla
```
SELECT * FROM control_empleados.empleados;
```

Muestra creacion de tabla NO necesario ejecutar ya que desde el Back se crea.
```
CREATE TABLE personaje.personas (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NULL,
  lastname VARCHAR(65) NULL,
  PRIMARY KEY (id
```

### Consultas end point empleados
Consulta todos los empleados - GET ```http://localhost:8080/api/v1/empleados```

Consulta empleado en especifico - GET ```http://localhost:8080/api/v1/empleados/2```

Eliminar empleado - DELETE ```http://localhost:8080/api/v1/empleados/2```

Registrar empleado - POST ```http://localhost:8080/api/v1/empleados```
```
{
    "apellido": "Rodriguez",
    "email": "rj@gmail.com",
    "nombre": "James"
}
```
Actualizar empleado - PUT ```http://localhost:8080/api/v1/empleados/8```

Indicar el ID actualizar y escribir cuerpo dato a modificar
```
{
  "apellido": "Rodriguez",
  "email": "rajo@gmail.com",
  "nombre": "Jaimes"
}
```


## Consideraciones Frontend
Arquitectura frontend Angular a realizar:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/arquitectura_front.png)

Tendremos servicio con HttpClient y Router.
- Router configuramos las rutas y cada componente estara vinculado con la ruta.
- Osea al ingresar a una ruta, ingresaremos a un componente y ese componente llamara a un servicio.

## Creación directorio node
Antes de inicial la aplicación, dentro del directorio debes recrear la carpeta node con el siguiente comando, el cual instalara las demas librerias necesarias para el funcionamiento de la aplicación:
```
npm install
```

### Dependencias Angular 
- Sweet Alert: Para todo tipo de alertas de confirmacion o errores `npm install --save sweetalert2@7.26.9`
- Bootstrap: Para la apariencia, en este caso de utilizo la URL del CDN que ofrece la pagina principal `https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css`
## Servidor de desarrollo
Ejecute `ng serve` o `npm start` para un servidor de desarrollo. Navegue a `http://localhost:4200/`. 
La aplicación se recargará automáticamente si cambia alguno de los archivos de origen.

## Code scaffolding
Ejecute `ng generate component component-name`  para generar un nuevo componente.

## Construir proyecto para produccion - Build
Ejecute `ng build` para compilar el proyecto. Los artefactos de compilación se almacenarán en el directorio `dist/`.

## Ejecutando pruebas unitarias
Ejecute `ng test` para ejecutar las pruebas unitarias a través de [Karma](https://karma-runner.github.io).

### Configuración Angular para que no obligue que las propiedades deben ser inicializadas
Se busca el archivo tsconfig.json
En la opción de "compilarOptions" vamos agregar "strictPropertyInitialization": false
Se realiza cambios adicionales de restrincciones que causan molestia


## Demostración aplicación en funcionamiento

Pagina principal, si tiene empleados registrados aparecera un lista con las opciones de editar, eliminar y detalles, en la parte superior las opciones de ver este listado o registrar empleado:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/app0.png)

Seleccion `Editar` mostrar  los datos que se puede modificar del empleado:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/app1.png)

Se deben cumplirse con las restrincciones que tiene el formulario para que se habilite el boton `Guardar`:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/app2.png)

Se genera una alerta de confirmacion de la edicion:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/app3.png)

Selecion `Eliminar` aparecera una alerta para notificarnos si estamos seguro de realizar la accion:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/app4.png)

Si la confirmamos nos aparecera otra alerta informando el proceso con exito:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/app5.png)

Seleccion `Detalles` arrojara una alerta informando el ingreso:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/app6.png)

Posterior nos dara a conocer los datos de empleado:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/app7.png)

Seleccion `Registrar Empleado` nos mostrara un formularo con los campos:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/app8.png)

Se debe cumplir con las restrincciones para habilitar el boton `Registrar` y almacenar el nuevo registro en BD:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/app9.png)

Si los datos estan correctos se habilitara el `Registrar`:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/app10.png)

Notificación que el registro del empleado fue exitoso:

![Image text](https://github.com/yadevom/crud_angular_spring_mysql/blob/main/img_explicativas/app11.png)