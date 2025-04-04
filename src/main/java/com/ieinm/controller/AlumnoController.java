package com.ieinm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ieinm.modelo.Alumno;
import com.ieinm.repository.AlumnoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

// Permite solicitudes CORS desde el frontend en localhost:4200 "ANGULAR".
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

// Marca esta clase como un controlador REST REST para gestionar las operaciones CRUD.
@RestController

// Define la ruta base para las solicitudes.
@RequestMapping("/alumnos")
@Tag(name = "Alumnos", description = "API para gestionar alumnos")
public class AlumnoController {

	// Inyecta el repositorio de alumnos para acceder a la base de datos
	@Autowired
	private AlumnoRepository alumnoRepository;

	// Descripción de operación
	@Operation(summary = "Listar todos los alumnos", description = "Obtiene una lista de todos los alumnos registrados en el sistema")

	// Respuesta de solisitud positiva
	@ApiResponse(responseCode = "200", description = "Lista de alumnos obtenida con exito")

	// Obtiene la lista de todos los alumnos.
	@GetMapping("/listar")
	public List<Alumno> listarAlumnos() {
		List<Alumno> alumnos = (List<Alumno>) alumnoRepository.findAll();
		return alumnos;
	}

	// Descripción de la operación
	@Operation(summary = "Obtener alumno por ID", description = "Obtiene los detalles de un alumno especifico por su ID")

	// Respuesta de solicitud positiva
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Alumno encontrado"),

			// Respuesta de solicitud negativa
			@ApiResponse(responseCode = "404", description = "Alumno no encontrado") })

	// Obtiene un alumno específico por su ID.
	@GetMapping("/{id}")
	public Optional<Alumno> alumnoPorId(

			// Parametros requeridos
			@Parameter(description = "ID del alumno a buscar", required = true, example = "1") @PathVariable int id) {
		return alumnoRepository.findById(id);
	}

	// Descripción de la operación
	@Operation(summary = "Crear nuevo alumno", description = "Registra un nuevo alumno en el sistema")

	// Respuesta de solicitud positiva
	@ApiResponse(responseCode = "201", description = "Alumno creado con exito")

	// Crea un nuevo alumno en la base de datos.
	@PostMapping

	// Respuesta del estado HTTP
	@ResponseStatus(HttpStatus.CREATED)
	public Alumno agregarAlumno(

			// Parametros requeridos
			@Parameter(description = "Datos del alumno a crear", required = true) @RequestBody Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	// Descripción de la operación
	@Operation(summary = "Actualizar alumno", description = "Actualiza los datos de un alumno existente")

	// Respuesta de solicitud positiva
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Alumno actualizado con exito"),

			// Respuesta de solicitud negativa
			@ApiResponse(responseCode = "404", description = "Alumno no encontrado") })

	// Actualiza los datos de un alumno existente.
	@PutMapping("/{id}")
	public Alumno actualizarAlumno(

			// Parametros requeridos a actualizar
			@Parameter(description = "Datos actualizados del alumno", required = true) @RequestBody Alumno alumno,

			// Parametro requerido ID
			@Parameter(description = "ID del alumno a actualizar", required = true, example = "1") @PathVariable int id) {

		// Establece el ID del alumno para la actualización
		alumno.setId(id);
		return alumnoRepository.save(alumno);
	}

	// Descripción de la operación
	@Operation(summary = "Eliminar alumno", description = "Elimina un alumno por su ID")

	// Respuesta de solicitud positiva
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Alumno eliminado con exito"),

			// Respuesta de solicitud negativa
			@ApiResponse(responseCode = "404", description = "Alumno no encontrado") })

	// Elimina un alumno de la base de datos por su ID.
	@DeleteMapping("/{id}")
	public void borrarAlumno(

			// Parametros requeridos ID
			@Parameter(description = "ID del alumno a eliminar", required = true, example = "1") @PathVariable int id) {
		alumnoRepository.deleteById(id);
	}
}
