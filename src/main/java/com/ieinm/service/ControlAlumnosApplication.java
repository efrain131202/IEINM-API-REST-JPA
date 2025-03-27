package com.ieinm.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ieinm"})
@EntityScan("com.ieinm.modelo")  
@EnableJpaRepositories("com.ieinm.repository")  
public class ControlAlumnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlAlumnosApplication.class, args);
	}

}
