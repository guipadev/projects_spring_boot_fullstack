package example.cashcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * La anotación @JsonTest marca CashCardJsonTest como una clase de prueba que utiliza el marco Jackson
 * (que se incluye como parte de Spring).
 * Esto proporciona una amplia compatibilidad con pruebas y análisis de JSON.
 * También establece todo el comportamiento relacionado para probar objetos JSON.
 *
 * JacksonTester es un contenedor conveniente para la biblioteca de análisis Jackson JSON.
 * Maneja la serialización y deserialización de objetos JSON.
 *
 * @Autowired es una anotación que indica a Spring que cree un objeto del tipo solicitado.
 */
@JsonTest
class CashCardJsonTest {

    @Autowired
    private JacksonTester<CashCard> json;
    @Test
    public void myFirstTest() {
        assertThat(42).isEqualTo(42);
    }


    /*
    @Test
    public void cashCardSerializationTest() throws IOException {
        CashCard cashCard = new CashCard(99L, 123.45);

        assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id")
                .isEqualTo(99);
        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount")
                .isEqualTo(123.45);
    }*/

    /**
     * La deserialización es el proceso inverso a la serialización.
     * Transforma los datos de un archivo o flujo de bytes en un objeto para su aplicación.
     * Esto hace posible que un objeto serializado en una plataforma se deserialice en una plataforma diferente.
     * Por ejemplo, su aplicación cliente puede serializar un objeto en Windows mientras que el backend
     * lo deserializaría en Linux.
     *
     * La serialización y la deserialización trabajan juntas para transformar/recrear objetos de datos a/desde
     * un formato portátil.
     * El formato de datos más popular para serializar datos es JSON.
     *
     * Escribamos una segunda prueba para deserializar los datos para que se conviertan de JSON a Java después de
     * que pase la primera prueba.
     * Esta prueba utiliza una técnica de prueba primero en la que deliberadamente escribe una prueba fallida.
     * Específicamente: los valores de id y cantidad no son los esperados.
     * @throws IOException
     */

    @Test
    public void cashCardDeserializationTest() throws IOException {
        String expected = """
           {
               "id":99,
               "amount":123.45
           }
           """;
        assertThat(json.parse(expected))
                .isEqualTo(new CashCard(99L, 123.45));
        assertThat(json.parseObject(expected).id()).isEqualTo(99);
        assertThat(json.parseObject(expected).amount()).isEqualTo(123.45);
    }
}