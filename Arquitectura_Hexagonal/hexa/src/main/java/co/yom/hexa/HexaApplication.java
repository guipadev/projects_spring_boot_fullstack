package co.yom.hexa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HexaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexaApplication.class, args);
	}

}