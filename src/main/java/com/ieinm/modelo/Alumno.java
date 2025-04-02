package com.ieinm.modelo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Entidad que representa a un alumno en la base de datos.
@Entity

// Define el nombre de la tabla en la base de datos.
@Table(name = "ALUMNO")

//Descripción de la entidad
@Schema(description = "Entidad que representa a un alumno en el sistema educativo")
public class Alumno {

	// Identificador único del alumno.
	@Id
	@Column

	// Descripcion de variable id
	@Schema(description = "Identificador único del alumno", example = "1")
	private int id;

	// Nombre del alumno.
	@Column(name = "NOMBRE")

	// Descripcion de variable anombre
	@Schema(description = "Nombre del alumno", example = "Efrain")
	private String nombre;

	// Apellido paterno del alumno.
	@Column(name = "APEPA")

	// Descripción de variable apepa
	@Schema(description = "Apellido paterno del alumno", example = "Cruz")
	private String apepa;

	// Apellido materno del alumno.
	@Column(name = "APEMA")

	// Descripción de variable apema
	@Schema(description = "Apellido materno del alumno", example = "Lobato")
	private String apema;

	// Matrícula del alumno.
	@Column(name = "MATRICULA")

	// Descripción de variable matricula
	@Schema(description = "Matricula del alumno", example = "20202ITI029")
	private String matricula;

	// Carrera que estudia el alumno.
	@Column(name = "CARRERA")

	// Descripción de variable carrera
	@Schema(description = "Carrera del alumno", example = "Ingenieria en desarrollo y gestión de software")
	private String carrera;

	// Estado actual del alumno.
	@Column(name = "ESTADO")

	// Descripción de variable estado
	@Schema(description = "Estado actual del alumno", example = "graduado")
	private String estado;

	// Constructor vacío necesario para JPA.
	public Alumno() {
		super();
	}

	// Constructor con todos los atributos.
	public Alumno(int id, String nombre, String apepa, String apema, String matricula, String carrera, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apepa = apepa;
		this.apema = apema;
		this.matricula = matricula;
		this.carrera = carrera;
		this.estado = estado;
	}

	// Métodos getter y setter para cada atributo
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApepa() {
		return apepa;
	}

	public void setApepa(String apepa) {
		this.apepa = apepa;
	}

	public String getApema() {
		return apema;
	}

	public void setApema(String apema) {
		this.apema = apema;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// Representación en cadena del objeto Alumno.
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apepa=" + apepa + ", apema=" + apema + ", matricula="
				+ matricula + ", carrera=" + carrera + ", estado=" + estado + "]";
	}
}
