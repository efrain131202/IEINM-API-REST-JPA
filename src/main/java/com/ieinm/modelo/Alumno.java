package com.ieinm.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ALUMNO")
public class Alumno {

	@Id
	@Column
	private int id;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APEPA")
	private String apepa;

	@Column(name = "APEMA")
	private String apema;

	@Column(name = "MATRICULA")
	private String matricula;

	@Column(name = "CARRERA")
	private String carrera;

	@Column(name = "ESTADO")
	private String estado;

	public Alumno() {
		super();
	}

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

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apepa=" + apepa + ", apema=" + apema + ", matricula="
				+ matricula + ", carrera=" + carrera + ", estado=" + estado + "]";
	}

}
