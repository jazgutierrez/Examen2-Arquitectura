/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.controller;

import ec.edu.espe.arquitectura.examen2arquitectura.dao.CursoRepository;
import ec.edu.espe.arquitectura.examen2arquitectura.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.examen2arquitectura.dto.CertificadoMatriculaRS;
import ec.edu.espe.arquitectura.examen2arquitectura.dto.EstudianteRQ;
import ec.edu.espe.arquitectura.examen2arquitectura.dto.InscripcionRQ;
import ec.edu.espe.arquitectura.examen2arquitectura.model.Curso;
import ec.edu.espe.arquitectura.examen2arquitectura.model.Estudiante;
import ec.edu.espe.arquitectura.examen2arquitectura.service.EstudianteService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author yazbe
 */
public class EstudianteControllerTest {

    @Mock
    private EstudianteService estudianteService;

    @InjectMocks
    private EstudianteController estudianteController;

    private Estudiante estudiante;

    private EstudianteRQ estudianteRQ;

    @BeforeEach
    public void setUp() {

        estudiante = new Estudiante();
        estudiante.setId("uywe8723ha7");
        estudiante.setCorreo("jazz@gamil.com");
        estudiante.setNombre("Jazz");
        estudiante.setPais("ECU");

        estudianteRQ = new EstudianteRQ();
        estudianteRQ.setCorreo("jazz@gamil.com");
        estudianteRQ.setNombre("Jazz");
        estudianteRQ.setPais("ECU");

    }

    @Test
    public void testCrear() {
        try {
            when(estudianteService.crearEstudiante(estudiante)).thenReturn(estudiante.getId());
            Assertions.assertEquals(ResponseEntity.ok(estudiante), estudianteController.crear(estudianteRQ));
        } catch (Exception e) {
            Logger.getLogger(CursoControllerTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
