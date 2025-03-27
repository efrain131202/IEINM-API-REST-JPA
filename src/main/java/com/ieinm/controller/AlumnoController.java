package com.ieinm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ieinm.modelo.Alumno;
import com.ieinm.repository.AlumnoRepository;

// Permite solicitudes CORS desde el frontend en localhost:4200 "ANGULAR".
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

// Marca esta clase como un controlador REST REST para gestionar las operaciones CRUD.
@RestController

// Define la ruta base para las solicitudes.
@RequestMapping("/alumnos")
public class AlumnoController {

	// Inyecta el repositorio de alumnos para acceder a la base de datos
	@Autowired
	private AlumnoRepository alumnoRepository;

	// Obtiene la lista de todos los alumnos.
	@GetMapping("/listar")
	public List<Alumno> listarAlumnos() {
		List<Alumno> alumnos = (List<Alumno>) alumnoRepository.findAll();
		return alumnos;
	}

	// Obtiene un alumno específico por su ID.
	@GetMapping("/{id}")
	public Optional<Alumno> alumnoPorId(@PathVariable int id) {
		return alumnoRepository.findById(id);
	}

	// Crea un nuevo alumno en la base de datos.
	@PostMapping
	public Alumno agregarAlumno(@RequestBody Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	// Actualiza los datos de un alumno existente.
	@PutMapping("/{id}")
	public Alumno actualizarAlumno(@RequestBody Alumno alumno, @PathVariable int id) {
		// Establece el ID del alumno para la actualización
		alumno.setId(id);
		return alumnoRepository.save(alumno);
	}

	// Elimina un alumno de la base de datos por su ID.
	@DeleteMapping("/{id}")
	public void borrarAlumno(@PathVariable int id) {
		alumnoRepository.deleteById(id);
	}
}
