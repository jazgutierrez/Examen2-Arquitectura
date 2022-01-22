/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.service;

import ec.edu.espe.arquitectura.examen2arquitectura.dao.CursoRepository;
import ec.edu.espe.arquitectura.examen2arquitectura.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.examen2arquitectura.dto.CertificadoMatriculaRS;
import ec.edu.espe.arquitectura.examen2arquitectura.dto.CursoRS;
import ec.edu.espe.arquitectura.examen2arquitectura.dto.InscripcionRQ;
import ec.edu.espe.arquitectura.examen2arquitectura.model.Curso;
import ec.edu.espe.arquitectura.examen2arquitectura.model.Estudiante;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {

    @Mock
    private EstudianteRepository estudianteRepo;
    @Mock
    private CursoRepository cursoRepo;

    @InjectMocks
    private EstudianteService estudianteService;

    private Estudiante estudiante;

    private List<Estudiante> estudiantes;

    private Curso curso1;

    private CertificadoMatriculaRS certificado;

    private List<Curso> cursos;
    
    private InscripcionRQ inscripcion;

    @BeforeEach
    public void setUp() {
        estudiante = new Estudiante();
        estudiante.setId("365w3jnsd7523ssd");
        estudiante.setCorreo("jazz@gamil.com");
        estudiante.setNombre("Jazz");

        estudiantes = new ArrayList<Estudiante>();

        estudiantes.add(estudiante);

        curso1 = new Curso();
        curso1.setCodigo("2kj238s8wwdej21");
        curso1.setArea("COMPUTACION");
        curso1.setCosto(new BigDecimal("200.5"));
        curso1.setFechaInicio(LocalDate.now().plusDays(5));
        curso1.setDuracion(2);
        curso1.setNombre("PROGRAMACION 1");

        cursos = new ArrayList<Curso>();
        cursos.add(curso1);
        estudiante.setCursos(cursos);

        certificado= new CertificadoMatriculaRS();
        certificado.setCorreo("jazz@gamil.com");
        certificado.setIdEstudiante("365w3jnsd7523ssd");
        certificado.setNombreEstudiante("Jazz");
        
        inscripcion= new InscripcionRQ();
        inscripcion.setCodigoCurso("2kj238s8wwdej21");
        inscripcion.setCodigoEstudiante("365w3jnsd7523ssd");

    }

    @Test
    public void testCrearEstudiante() {
        try {
            when(estudianteRepo.findByCorreo("jazz@gamil.com")).thenReturn(new ArrayList<Estudiante>());
            Assertions.assertEquals(estudiante, estudianteService.crearEstudiante(estudiante));
        } catch (Exception e) {
            Logger.getLogger(CursoServiceTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Test
    public void testInscribirCurso() {
        try {
            when(estudianteRepo.findById("2kj238s8wwdej21")).thenReturn(Optional.of(estudiante));
            when(cursoRepo.findById("2kj238s8wwdej21")).thenReturn(Optional.of(curso1));
            when(estudianteRepo.save(estudiante)).thenReturn(estudiante);

            Assertions.assertEquals(certificado, estudianteService.inscribirCurso(inscripcion));
        } catch (Exception e) {
            Logger.getLogger(CursoServiceTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
