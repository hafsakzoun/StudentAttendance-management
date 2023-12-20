package com.example.Atelier8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.Atelier8.persistence") // Fix the typo here
@EnableJpaRepositories("com.example.Atelier8.repository")
@ComponentScan("com.example.Atelier8.services")
@ComponentScan("com.example.Atelier8.controller")
public class Atelier8Application {

	public static void main(String[] args) {
		SpringApplication.run(Atelier8Application.class, args);
	}
}
