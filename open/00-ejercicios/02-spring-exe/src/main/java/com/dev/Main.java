package com.dev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        NotificationService notificationService = (NotificationService) context.getBean("notificationService");
        String textoMsj = notificationService.saludo();
        System.out.println(textoMsj);

        UserService saludito = (UserService) context.getBean("userService");
        System.out.println(saludito.notificationService.saludo());

    }
}
