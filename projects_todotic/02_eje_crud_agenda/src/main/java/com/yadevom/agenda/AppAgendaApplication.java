package com.yadevom.agenda;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class AppAgendaApplication {

	// Prueba Manual
	/*
	@Autowired
	private ContactoRepository contactoRepository;

	@PostConstruct
	void init() {
		Contacto contacto1 = new Contacto();

		contacto1.setNombre("Rigobert Ortigoza");
		contacto1.setCelular("1213445678");
		contacto1.setEmail("do@gmail.com");
		contacto1.setFechaNacimiento(LocalDate.now());

		contactoRepository.save(contacto1);

		Contacto contacto2 = new Contacto();

		contacto2.setNombre("David Rojas");
		contacto2.setCelular("12484578");
		contacto2.setEmail("dr@gmail.com");
		contacto2.setFechaNacimiento(LocalDate.now());

		contactoRepository.save(contacto2);

		contactoRepository.findAll().forEach(c -> log.info("Contacto: {}" + c.getNombre()));
	}
	*/
	public static void main(String[] args) {
		SpringApplication.run(AppAgendaApplication.class, args);
	}

}
