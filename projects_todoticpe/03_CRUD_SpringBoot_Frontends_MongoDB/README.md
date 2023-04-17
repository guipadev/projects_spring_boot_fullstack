## Aplicación Agenda CRUD
Aplicación web usando Spring Boot 3 y BD no relacional MongoDB. 
Esta las versiones en Angular y React frontend.

Con esta aplicación se podrá consultar, crear, actualizar y eliminar tus tareas.

![Imagen de la aplicación](https://github.com/yadevom/springboot_projects_todoTIC/blob/main/03_CRUD_SpringBoot_Frontends_MongoDB/img_app.png)

GET - Consultar todas las tareas
```
localhost:8080/tareas
```

POST - Ingresar tarea
```
localhost:8080/tareas
```
```
{
    "nombre": "Ir a estudiar programación",
    "completado": true
}
```

PUT - Actualizar tarea, colocar ID
```
localhost:8080/tareas/63f6c07c1c075d33e803a56d
```
```
{
    "nombre": "Ir a estudiar programación",
    "completado": false
}
```

DELETE - Eliminar tarea, colocar ID
```
localhost:8080/tareas/63f6c07c1c075d33e803a56d
```
