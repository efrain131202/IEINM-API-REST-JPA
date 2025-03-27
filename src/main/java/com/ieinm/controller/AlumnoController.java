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

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoRepository alumnoRepository;

	@GetMapping("/listar")
	public List<Alumno> listarAlumnos() {
		List<Alumno> alumnos = (List<Alumno>) alumnoRepository.findAll();
		return alumnos;
	}

	@GetMapping("/{id}")
	public Optional<Alumno> alumnoPorId(@PathVariable int id) {
		return alumnoRepository.findById(id);
	}

	@PostMapping
	public Alumno agregarAlumno(@RequestBody Alumno alumno) {
		return alumnoRepository.save(alumno);
	}

	@PutMapping("/{id}")
	public Alumno actualizarAlumno(@RequestBody Alumno alumno, @PathVariable int id) {
		alumno.setId(id);
		return alumnoRepository.save(alumno);
	}

	@DeleteMapping("/{id}")
	public void borrarAlumno(@PathVariable int id) {
		alumnoRepository.deleteById(id);
	}

}
