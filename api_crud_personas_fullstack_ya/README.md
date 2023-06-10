# crud_springboot_angular_postgresql
Creación de un CRUD para creación de personas, para indicar de que pais y el estado. Teniendo las opciones de crear, eliminar, editar y visualizar los registros.

## Script SQL
En el directorio SQL encontrara los Script a ejecutar:
- Ejecutar el script de creación de BD.
- Luego de inicializar el proyecto Back ejecuta los script de ingresar datos a las tabla paises y estados.

## Backend
En directorio personaBACKEND encontrara el proyecto creado Spring Boot el cual conecta a BD postgres. Configurado para correr por defecto ```http://localhost:8080/```

Antes de ejecutarlo debes ingresar al archivo de scripts ```personaSCRIPT_BD_paises_estado.sql```
- Debe estar creada la BD persona_db en postgre
- Insertarle los datos a la tabla pais y estado
- configurado ```application.properties``` con la conexion y credenciales a BD postgre
- Despues de los puntos anteriores ejecutar la aplicación
- Comentar las últimas lineas ```application.properties``` para que no se vuelvan a crear las tablas y se pierdan los registros de estado y paises.

### Pruebas Unitarias Mockito
- Para realizar pruebas se utilizo la libreria de mockito

## FRONT
- Directorio persona_front
- Se desarrollo mediante el framework Angular
- Se instalo la libreria Bootstrap para mejorar el diseño

### Iniciar el proyecto
- Recrear el directorio node ```npm install```
- Luego iniciar con el comando ```npm start```
- El proyecto front visualizarlo en el navegador ```localhost:4200```


## Consulta endpoint
- Consulta paises - GET ```http://localhost:8080/pais/```

- Consulta estados - GET ```http://localhost:8080/estados/82/```

- Consulta personas - GET ```http://localhost:8080/personas/```

- Eliminar personas - DELETE + Id ```http://localhost:8080/personas/5```

- Actualizar personas - PUT + Id ```http://localhost:8080/personas/3```

## Visualización proyecto

- Formulario para diligenciar datos de la persona, automaticamente trae de BD el pais y estado. Apareceran datos en caso de haber registros:

![Image text](https://github.com/yadevom/crud_springboot_postgre/blob/main/imgs/app0.png)

- El boton guardar se habilita al estar diligenciado el formulario, automaticamente se muestra en la tabla al registrar, estan las opiones de edita y eliminar.

![Image text](https://github.com/yadevom/crud_springboot_postgre/blob/main/imgs/app1.png)

