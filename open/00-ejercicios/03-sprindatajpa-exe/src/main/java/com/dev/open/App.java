package com.dev.open;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(App.class, args);

		ZooAnimalRepository repository = context.getBean(ZooAnimalRepository.class);

		System.out.println("Datos animales zoologico: " + repository.count());

		ZooAnimal ani1 = new ZooAnimal(null, "Tigre", "Felino", 10);
		ZooAnimal ani2 = new ZooAnimal(null, "Leon", "Felino", 5);
		ZooAnimal ani3 = new ZooAnimal(null, "Toro", "Bovino", 10);

		repository.save(ani1);
		repository.save(ani2);
		repository.save(ani3);

		System.out.println("Datos animales zoologico: " + repository.count());

		System.out.println(repository.findAll());
	}

}
