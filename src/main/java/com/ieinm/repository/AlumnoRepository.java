package com.ieinm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ieinm.modelo.Alumno;

// Repositorio JPA para la entidad Alumno.
// Proporciona operaciones CRUD sobre la base de datos.
@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {

}
