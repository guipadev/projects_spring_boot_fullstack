package com.example.demo;

import com.example.demo.exception.DemoSpringException;
import com.example.demo.exception.ExceptionDetails;
import org.springframework.util.ObjectUtils;

public class ProbarExcepciones {

    public static void main(String[] args) throws DemoSpringException {

        if (ObjectUtils.isEmpty(args)) {
            throw new DemoSpringException("The args parameter is empty",
                    new ExceptionDetails("Ha ocurrido un error inesperado", "error"));
        }

        // Ejemplo conservar la cadena de excepciones
        try {

        } catch (Exception e) {
            throw new DemoSpringException("Ocurrio un error generando jasper",
                    new ExceptionDetails("Ha ocurrido error generando reporte de ventas", "warning"), e);
        }
    }
}
