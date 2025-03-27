package com.ieinm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ieinm.modelo.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {

}
