package com.dev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Saludo saludito = (Saludo) context.getBean("saludo");

        String txtSaludo = saludito.imprimirSaludo();

        System.out.println(txtSaludo);


    }
}
