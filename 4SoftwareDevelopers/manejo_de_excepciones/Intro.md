# Excepciones

## Qúe son las excepciones?
No son errores, son caminos alternos al flujo normal de una aplicación, esta se puede componer de muchas cosas y puede llegar a tener un proceso muy complejo detrás.

Por ejemplo una aplicación encargada de sumar números, ocurriria una excepción en dicha aplicación, si ingresamos valores como letras.

Estos hace parte de un sin número de casos que no son contemplados dentro del flujo normal de la aplicación y como programadores debemos tratar de controlar todos estos flujos alternos.

## Jerarquía de las excepciones
Todos los objetos en Java, directa o indirectamente extienden de la clase Object.

La clase padre de todas las excepciones **Throwable** 

```
public class Throwable implements Serializable {}
```

De esta tienen dos hijos muy caracteristicos la clase **Error** y la clase **Exception**

```
public class Error extends Throwable {}
```

Errores grabes del funcionamiento de Java, más no necesariamente de la aplicación. No se pueden cachear, como por ejemplo un error grave en el servidor, o que se acabo la memoria.


```
public class Exception extends Throwable {}
```

Exception, extienden de la gran mayoria, tiene la particularidad que nos permite hacer Catch, y es la cual podemos heredar para crear nuestras propias excepciones, siempre y cuando cuyo Catch sea obligatorio al momento de programar.


```
public class RuntimeException extends Exception {}
```

RutimeException es el padre de todas las UNCHECKED EXCEPTIONS

CHECKED EXCEPTIONS
Son excepciones que necesitamos atrapar en algún momento

```
public static void main(String[] args) {
	new FileInputStream(new File("."));
}
```

No solicita que sea atrapada:

```
try {
	new FileInputStream(new File("."));
} catch (FileNotFoundException e) {

}

```

En este caso es atrapado por Java:

```
public static void main(String[] args) throws FileNotFoundException {
	new FileInputStream(new File("."));
}
```

UNCHECKED EXCEPTIONS
No son necesario que se atrapen, la más famosa es la null pointer exception

```
public static void main(String[] args) {
	String nombre = null;
	nombre.toString();
}
```

Si nosotros vamos a crear una excepción, que no necesita ser controlada por la aplicación, se va a extender normalmente a RuntimeException, mejor dicho extender de Exception, porque esas son las excepciones que nosotros necesitamos controlar en nuestra aplicación, por ejemplo cuando se valida de una cedula sea vigente, osea si realizas una consulta a BD y te dice esta cedula ya no esta vigente, como programador tenemos que controlar dicha excepción.

Entonces la forma de controlar u/o obligar o sercioramos que el código haya controlado dicha excepción, pues extendiendo de Exception.