package com.ieinm.service;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// Clase que inicializa la aplicación cuando se despliega en un servidor externo Tomcat.
// SpringBootServletInitializer para permitir la configuración personalizada.

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ControlAlumnosApplication.class);
	}
}
