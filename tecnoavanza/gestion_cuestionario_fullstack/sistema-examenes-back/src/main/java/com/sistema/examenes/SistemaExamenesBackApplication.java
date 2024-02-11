package com.sistema.examenes;

import com.sistema.examenes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SistemaExamenesBackApplication implements CommandLineRunner {

	// Busca la interfaz e implementa el mètodo
	@Autowired
	private UserService userService;

	public static void main(String[] args) {

		SpringApplication.run(SistemaExamenesBackApplication.class, args);
	}

	// Al momento de compilar se puede ejecutar
	@Override
	public void run(String... args) throws Exception {

		/*
			// Ingresar usuario manualmente
	try {
			User user = new User();

			user.setName("Ernesto");
			user.setLastname("Perez");
			user.setUsername("frailejon");
			user.setPassword("12345");
			user.setEmail("ep@gmail.com");
			user.setPhone("3003012345");
			user.setProfil("foto.png");

			Role role = new Role();
			role.setRolId(1L);
			role.setRolName("ADMIN");

			// Relacionar usuario / rol
			Set<UserRole> usersRoles = new HashSet<>();

			UserRole userRol = new UserRole();

			userRol.setRole(role);
			userRol.setUser(user);

			usersRoles.add(userRol);

			// Guardar en la BD
			User theUserSave = userService.saveUser(user, usersRoles);
			System.out.println(theUserSave.getUsername());
		}(UserFoundException exception){
			exception.printStackTrace();
		}
		 */

	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedHeaders("*")
						.maxAge(3600);
			}
		};
	}
}