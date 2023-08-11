# Arquitectura Hexagonal con Spring

## ¿Qué es la Arquitectura Hexagonal o Patrón de Puertos y Adaptadores?
https://youtu.be/eNFAJbWCSww

La Arquitectura Hexagonal propone que nuestro dominio sea el núcleo de las capas y que este no se acople a nada externo. 
En lugar de hacer uso explícito y mediante el principio de inversión de dependencias nos acoplamos a contratos (interfaces o puertos) y no a implementaciones concretas.

Definiendo puertos o puntos de entrada e interfaces (adaptadores) para que otros módulos (UI, BBDD, Test) puedan implementarlas y comunicarse con la capa de negocio sin que ésta deba saber el origen de la conexión.

Esto es lo llamado puertos y adaptadores, que podrían ser definidos de la siguiente manera:

- Port: definición de una interfaz pública.
- Adapter: especialización de un puerto para un contexto concreto.

## Recursos:

JsonPlaceholder API, este recurso nos ayudará a dar un ejemplo de como sería consumir una API en esta arquitectura.

## Creando nuestro proyecto de Spring Boot
- Spring Web
- Lombok
- Feign Client (Aquí hay una pequeña configuración extra por usar Spring Boot 3)
- Vertical Slicing.

## Diseño y Modelamiento de API
Siguiendo las buenas prácticas Web API Design de Microsoft.
https://learn.microsoft.com/en-us/azure/architecture/best-practices/api-design

## End point
- Obtener todos los posts ```GET - https://localhost:8080/posts```
- Obtener todos los posts por usuario ```GET - https://localhost:8080/users/{id}/posts```

## ¿Quiénes son los adaptadores?
Nuestros adaptadores serían las clases concretas o implementaciones de nuestras interfaces definidas en la capa de Domain.

- PostCommandRepositoryImpl.java (Adapter)
- PostQueryRepositoryImpl.java (Adapter)


## Ambas implementaciones están usando JsonPlaceholderAPIClient, ¿Y qué tiene esta clase?

Primero, no es una clase, es una interfaz. Segundo, es nuestra interface donde estamos consumiendo la API de JsonPlaceholder.

- https://jsonplaceholder.typicode.com/

Para nuestro caso de estudio sería como consumir otra API (interna o externa de nuestro proyecto) que se tiene que comunicar con nuestra API.

## ¿Cuál es la diferencia entre una API externa o interna?

Externa es cuando es una API de un tercero, qué quiere decir como por ejemplo en este caso JsonPlaceholder, también puede ser PokeAPI, RickAndMorty API.

Interna es cuando es una API realizada por nuestra empresa/equipo de desarrollo, que podría ser por ejemplo cuando una API de Carrito de Compras se quiera comunicar con nuestra API de Productos.

En resumen, estamos utilizando una API Externa que es JsonPlaceholder y esto va dentro de nuestra carpeta “external” que sirve para el consumo de API’s.

También tenemos nuestra carpeta “database” en este caso yo no lo estoy utilizando para el ejemplo, pero prácticamente allí iría nuestra interface que en el MVC llamamos el @Repository, por ejemplo.

## Consumiendo JsonPlaceholderAPI
El código pertenece a nuestra interface JsonPlaceholderAPIClient.java

- Infrastructure puede conocer a Domain y Application
- Application solo puede conocer a Domain y no a Infrastructure.
- Domain no conoce a nadie.

- Puertos de la carpeta “repository” de la capa “domain”, que su implementación se encuentra en la capa “infrastructure”.
- Puertos de la carpeta “service” de la capa “domain”, que su implementación se encuentra en la capa de “application”.

Así es, los puertos de los casos de uso se encuentra dentro del package service de domain, quiere decir que, realizaremos la inyección de dependecias a través de estos puertos, no se hagan mucho lío, lo veremos más adelante.

Nuestra nueva estructura de proyectos agregando nuestros casos de uso es:

post/
├── application/
│   ├── create/
│   │   ├── PostCreateUseCase.java
│   │   └── ...
│   ├── find/
│   │   ├── PostFindUseCase.java
│   │   └── ...
│
├── domain/
│   ├── model/
│   │   ├── PostCommand.java
│   │   └── PostQuery.java
│   ├── repository/
│       ├── PostCommandRepository.java
│       └── PostQueryRepository.java
│
└── infrastructure/
    ├── inbound/
    │   ├── controllers/
    │   │   ├── PostController.java
    │   │   └── UserController.java
    │   └── ...
    ├── outbound/
    │   ├── database/
    │   └── external/
    │       ├── JsonPlaceholderAPIClient.java
    │       └── ...
    ├── PostCommandRepositoryImpl.java
    └── PostQueryRepositoryImpl.java

Como ven no he agregado la carpeta “service” en “domain”, para nuestro ejemplo no utilizaré un puerto para nuestros adaptadores de “application”.

Tenemos nuestros casos de uso.

- PostCreateUseCase.java
- PostFindUseCase.java

## Utilizando nuestros puertos para poder conectarnos a nuestros adaptadores
Como nuestros casos de uso se encuentran en la capa de “application”, significa que sólo debe tener importaciones del package “domain”, y aquí es donde utilizaremos el patrón de Inyección de dependencias por constructor, utilizando la anotación @RequiredArgsConstructor de Lombok.

@RequiredArgsConstructor genera un constructor con un parámetro para cada campo que requiere un manejo especial. Todos los campos finales no inicializados obtienen un parámetro, así como también los campos que están marcados como @NonNull que no se inicializan donde se declaran.

- PostFindUseCase.java

Para acceder a nuestro adaptador PostQueryRepositoryImpl, utilizamos la inyección de dependencias y accedemos a él a traés de nuestro puerto PostQueryRepository, recordar que:

- La capa de “application” sólo debe conocer a domain, y accede a infrastructure a través de la inyección de dependencias, y así estamos cumpliendo con nuestra Arquitectura Hexagonal como en la gráfica inicial.

## ¿Dónde se encuentran los controladores?
Están en la carpeta inbound, dentro de nuestro package “infrastructure”.

post/
├── application/
│   ├── create/
│   │   ├── PostCreateUseCase.java
│   │   └── ...
│   ├── find/
│   │   ├── PostFindUseCase.java
│   │   └── ...
│
├── domain/
│   ├── model/
│   │   ├── PostCommand.java
│   │   └── PostQuery.java
│   ├── repository/
│       ├── PostCommandRepository.java
│       └── PostQueryRepository.java
│
└── infrastructure/
    ├── inbound/
    │   ├── controllers/
    │   │   ├── PostController.java
    │   │   └── UserController.java
    │   └── ...
    ├── outbound/
    │   ├── database/
    │   └── external/
    │       ├── JsonPlaceholderAPIClient.java
    │       └── ...
    ├── PostCommandRepositoryImpl.java
    └── PostQueryRepositoryImpl.java
    
Nuestros casos de uso no tienen puertos por lo tanto su inyección de dependencias será a través de su clase concreta.

## ¿Estamos incumpliendo con la comunicación de las capas?
Claro que no, ya que “infrastructure” sí puede conocer “application” no hay problema si es que se importa la clase concreta de los casos de uso, pero una buena práctica si sería que tenga sus puertos en el package “service” dentro de “domain”.

Nuestros controladores

- PostController.java
- UserController.java

