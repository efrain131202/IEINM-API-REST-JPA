package com.ieinm.service;

import com.ieinm.controller.AlumnoController;
import com.ieinm.modelo.Alumno;
import com.ieinm.repository.AlumnoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ControlAlumnosApplicationTests {

    @Autowired
    private AlumnoController alumnoController;

    @MockBean
    private AlumnoRepository alumnoRepository;

    private Alumno alumnoTest;

    @BeforeEach
    void setUp() {
        // Crear un alumno de prueba completo antes de cada test
        alumnoTest = new Alumno();
        alumnoTest.setId(1);
        alumnoTest.setNombre("Juan");
        alumnoTest.setApepa("Pérez");
        alumnoTest.setApema("González");
        alumnoTest.setMatricula("A12345");
        alumnoTest.setCarrera("Ingeniería de Sistemas");
        alumnoTest.setEstado("Activo");
    }

    @Test
    void testListarAlumnos() {
        // Configurar el comportamiento del repositorio mock
        when(alumnoRepository.findAll()).thenReturn(List.of(alumnoTest));

        // Ejecutar el método a probar
        List<Alumno> alumnos = alumnoController.listarAlumnos();

        // Verificaciones
        assertNotNull(alumnos);
        assertFalse(alumnos.isEmpty());
        assertEquals(1, alumnos.size());
        
        Alumno alumnoRecuperado = alumnos.get(0);
        assertEquals(13, alumnoRecuperado.getId());
        assertEquals("Efrain", alumnoRecuperado.getNombre());
        assertEquals("Cruz", alumnoRecuperado.getApepa());
        assertEquals("Lobato", alumnoRecuperado.getApema());
        assertEquals("20202ITI029", alumnoRecuperado.getMatricula());
        assertEquals("Desarrollo de Software", alumnoRecuperado.getCarrera());
        assertEquals("Titulado", alumnoRecuperado.getEstado());

        // Verificar que se llamó al método findAll del repositorio
        verify(alumnoRepository, times(1)).findAll();
    }

    @Test
    void testAlumnoPorId() {
        // Configurar el comportamiento del repositorio mock
        when(alumnoRepository.findById(1)).thenReturn(Optional.of(alumnoTest));

        // Ejecutar el método a probar
        Optional<Alumno> alumnoEncontrado = alumnoController.alumnoPorId(1);

        // Verificaciones
        assertTrue(alumnoEncontrado.isPresent());
        
        Alumno alumnoRecuperado = alumnoEncontrado.get();
        assertEquals(1, alumnoRecuperado.getId());
        assertEquals("Juan", alumnoRecuperado.getNombre());
        assertEquals("Pérez", alumnoRecuperado.getApepa());
        assertEquals("González", alumnoRecuperado.getApema());
        assertEquals("A12345", alumnoRecuperado.getMatricula());
        assertEquals("Ingeniería de Sistemas", alumnoRecuperado.getCarrera());
        assertEquals("Activo", alumnoRecuperado.getEstado());

        // Verificar que se llamó al método findById del repositorio
        verify(alumnoRepository, times(1)).findById(1);
    }

    @Test
    void testAgregarAlumno() {
        // Configurar el comportamiento del repositorio mock
        when(alumnoRepository.save(alumnoTest)).thenReturn(alumnoTest);

        // Ejecutar el método a probar
        Alumno alumnoGuardado = alumnoController.agregarAlumno(alumnoTest);

        // Verificaciones
        assertNotNull(alumnoGuardado);
        assertEquals(1, alumnoGuardado.getId());
        assertEquals("Juan", alumnoGuardado.getNombre());
        assertEquals("Pérez", alumnoGuardado.getApepa());
        assertEquals("González", alumnoGuardado.getApema());
        assertEquals("A12345", alumnoGuardado.getMatricula());
        assertEquals("Ingeniería de Sistemas", alumnoGuardado.getCarrera());
        assertEquals("Activo", alumnoGuardado.getEstado());

        // Verificar que se llamó al método save del repositorio
        verify(alumnoRepository, times(1)).save(alumnoTest);
    }

    @Test
    void testActualizarAlumno() {
        // Modificar el alumno de prueba
        alumnoTest.setNombre("Juan Carlos");
        alumnoTest.setCarrera("Ingeniería Industrial");
        alumnoTest.setEstado("Inactivo");

        // Configurar el comportamiento del repositorio mock
        when(alumnoRepository.save(alumnoTest)).thenReturn(alumnoTest);

        // Ejecutar el método a probar
        Alumno alumnoActualizado = alumnoController.actualizarAlumno(alumnoTest, 1);

        // Verificaciones
        assertNotNull(alumnoActualizado);
        assertEquals(1, alumnoActualizado.getId());
        assertEquals("Juan Carlos", alumnoActualizado.getNombre());
        assertEquals("Pérez", alumnoActualizado.getApepa());
        assertEquals("González", alumnoActualizado.getApema());
        assertEquals("A12345", alumnoActualizado.getMatricula());
        assertEquals("Ingeniería Industrial", alumnoActualizado.getCarrera());
        assertEquals("Inactivo", alumnoActualizado.getEstado());

        // Verificar que se llamó al método save del repositorio
        verify(alumnoRepository, times(1)).save(alumnoTest);
    }

    @Test
    void testBorrarAlumno() {
        // Ejecutar el método a probar
        alumnoController.borrarAlumno(1);

        // Verificar que se llamó al método deleteById del repositorio
        verify(alumnoRepository, times(1)).deleteById(1);
    }

}