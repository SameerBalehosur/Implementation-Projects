package com.testyantra.sastaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * @author Sameer Balehosur
 *
 * 
 */
@SpringBootApplication
public class SastaInstaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SastaInstaApplication.class, args);
	}
	
	
}
