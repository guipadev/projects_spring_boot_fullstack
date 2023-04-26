package com.api.rest.instructor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// Habilitar la superclase
@EnableJpaAuditing
public class InstructorApp {

	public static void main(String[] args) {

		SpringApplication.run(InstructorApp.class, args);
	}

}
