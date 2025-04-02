package com.ieinm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

// Clase con anotación para indicar que contiene configuraciones la aplicación
@Configuration
public class OpenApiConfig {

	// URL de la documentación de Swagger UI
	// http://localhost:7676/swagger-ui.html
	// URL de JSON de OpenAPI http://localhost:7676/api-docs
	// El metodo retorna un objeto para indicar que es Bean
	// Clase que contiene las especificaciones de la API
	@Bean
	OpenAPI customApenAPI() {

		// Define la informacion de la API
		return new OpenAPI().info(new Info().title("API DE CONTROL ESCOLAR IEINM")

				// Contiene un breve descripción
				.description("API REST para gestionar alumnos del IEINM").version("1.0")

				// Información del contacto
				.contact(new Contact().name("Efrain Cruz Lobato").email("efraincruzlobato13@gmail.com"))

				// Agrega licensias
				.license(new License().name("APACHE 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html")));
	}
}
