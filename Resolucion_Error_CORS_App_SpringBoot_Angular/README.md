# Resolución del Error CORS de una Aplicación Spring Boot y Angular

## CORS Error
Cross-Origin-Resources-Sharing Error
Error de intercambio de recurso de origen cruzado

Pero este error solo ocurre en los navegadores. Cuando realizo una solicitud a mi backend desde una terminal o desde postman, no vere este error.

Solo ocurre en los navegadores porque tienen unas condiciones de seguridad. Si el frontend intenta acceder a un backend que no tiene la misma URL, el navegador lanza un error.

http://front.my.app.com
http://back.my.app.com

El intercambio de recursos de origen cruzado significa que el frontend y el backend están en diferentes URL, en diferentes origenes. Y no hay información sobre permitirles compartir recursos.

Porque ¿qué pasa si un pirata informático copia un sitio web y usa el mismo backend?

El frontend será una URL diferente, pero el sitio web consumirá el mismo backend. Cuando intento acceder a mi cuenta personal, no noto nada extraño, ya que los datos están todos bien. Mientras tanto, el sitio web robará mi cuenta personal.

Es por eso que el backend debe identificar los frontend de confianza. Para solucionar esto, existen algunos encabezados HTTP que indican al navegador  que el frontend y backend funcionan juntos. Esos encabezados(**Headers**) son:

- Access-Control-Allow-Origin
- Access-Control-Request-Method
- Acces-Control-Request-Headers

Esos son encabezados enviados por mi backend para decirle al navegador cómo proteger al usuario. El primer encabezado le dice al navegador qué frontend puede solicitar el backend.

```
Access-Control-Allow-Origin: *
Access-Control-Allow-Origin: front.my.app.com
Access-Control-Allow-Origin: null
```

Pero esto no solo es suficiente. El segundo encabezado le dice al navegador qué método HTTP acepta el backend.

```
Access-Control-Request-Method: GET, POST
```

Y el último encabezado indica qué encabezados acepta mi servidor. De hecho el navegador realizará una primera solicitud para verificar si el backend está bien con el frontend actual.

```
Acces-Control-Request-Headers: Authorization
```

Esto se denomina solicitud pre-flight. Y se hace con el método Options HTTP. La solicitud pre-flight es una solicitud realizada automáticamente por el navegador. Por eso no lo veo desde una terminal o desde Postman. Entonces, el error de CORS solo se puede resolver configurando mi backend para aceptar un frontend con un origen diferente.

Cuando ambos estan en el mismo origen. Tanto el frontend como el backend en el mismo origen significa que ambos son cargados por el mismo servidor web. Entonces debe incluir el frontend dentro de mi backend. Pero no puede hacer esto con Angular.

Para ver este ejemplo crearemos una simple pagina HTML con una solicitud Ajax a mi backend.
