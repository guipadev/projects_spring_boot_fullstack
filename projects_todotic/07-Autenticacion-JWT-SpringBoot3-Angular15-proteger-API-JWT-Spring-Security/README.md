# ss

## Consultas endpoint

### Consulta sin token
GET - http://localhost:8080/contactos
Authorization
Type - Basic Auth
Username - usuario
Password - clave

### Comprobar ingreso ruta
GET - http://localhost:8080/login
```
{
    "email": "prueba@gmail.com",
    "password": "darwin"
}
```

### Obtener el token
En el Headers se encontrara el token para uso
KEY: Authorization
VALUE: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcnVlYmFAZ21haWwuY29tIiwiZXhwIjoxNjg0MTcwMDU2LCJub21icmUiOiJNYXJjb3MgUml2YXMifQ.HaEnXrqOL6bcRmFmsGgyte2DrN8Ju5oH1doVrJDNn6o

### Consulta con token
GET - http://localhost:8080/contactos
Authorization
Type - Bearer Token
Token - eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcnVlYmFAZ21haWwuY29tIiwiZXhwIjoxNjg0MTcwMDU2LCJub21icmUiOiJNYXJjb3MgUml2YXMifQ.HaEnXrqOL6bcRmFmsGgyte2DrN8Ju5oH1doVrJDNn6o


## Script BD

### Consultar usuario
```
SELECT * FROM agenda.usuario;
```
### Consultar contacto
```
SELECT * FROM agenda.contacto;
```

### Ingresar datos a usuarios
```
INSERT INTO agenda.usuario (idusuario, email, nombre, password) VALUES ('1', 'prueba@gmail.com', 'Marcos Rivas', '$2a$10$P6hxDfl4OucMEKpJo0rtKucCwK6PvqkZBkzLaOlTTegQFQS/Or3HS');
```

### Ingresar datos contacto
```
INSERT INTO agenda.contacto (idcontacto, celular, email, fechanac, nombre) VALUES ('1', '3001231223', 'prueba@gmail.com', '1990-04-30', 'marcos rivas');

```
