package fr.orsys.groupe3.gamerefback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class GamerefBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamerefBackApplication.class, args);
	}

}
