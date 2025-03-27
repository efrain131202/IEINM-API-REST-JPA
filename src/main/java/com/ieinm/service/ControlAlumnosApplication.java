package com.ieinm.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Clase principal de la aplicación Spring Boot. Inicia la API REST para el control de alumnos.
@SpringBootApplication

// Escanea los componentes dentro del paquete especificado
@ComponentScan(basePackages = { "com.ieinm" })

// Especifica la ubicación de las entidades JPA
@EntityScan("com.ieinm.modelo")

// Habilita los repositorios JPA en el paquete indicado
@EnableJpaRepositories("com.ieinm.repository")
public class ControlAlumnosApplication {

	// Método principal que inicia la aplicación Spring Boot.
	public static void main(String[] args) {
		SpringApplication.run(ControlAlumnosApplication.class, args);
	}
}
