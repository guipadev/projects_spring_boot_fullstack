# 1. ¿Qué es @Autowired en primavera?

@Autowired anotación permite inyectar un bean a una clase (esto se llama inyección de dependencia o DI para abreviar). 
Además, @Autowired se puede aplicar a cada uno de los siguientes:

- Un constructor ( @Autowiredes opcional desde Spring 4.2)
- Un setter
- Un Field (campo)
- Parámetro de un método

Se prefiere mucho la inyección de constructores por las siguientes razones:

- Garantiza que la referencia del bean no cambiará configurándola como final.
- Está claro qué dependencias obligatorias tiene cada clase.
- Mejora el acoplamiento flojo

Además, @Autowired tiene un solo atributo, y ese es boolean require del valor predeterminado verdadero. 
Hay que saber para qué y cuándo es posible que necesitemos establecerlo en falso.


## perfil de acuerdo al tipo de autowired a ver
```applicatioin.properties```