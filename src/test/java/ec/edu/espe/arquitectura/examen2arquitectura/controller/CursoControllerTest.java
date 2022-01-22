/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.controller;

import ec.edu.espe.arquitectura.examen2arquitectura.model.Curso;
import ec.edu.espe.arquitectura.examen2arquitectura.service.CursoService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CursoControllerTest {

    @Mock
    private CursoService cursoService;

    @InjectMocks
    private CursoController controller;

    private Curso curso1;
    private Curso curso2;

    private List<Curso> cursos;

    @BeforeEach
    public void setUp() {

        curso1 = new Curso();
        curso1.setCodigo("2kj238s8wwdej21");
        curso1.setArea("COMPUTACION");
        curso1.setCosto(new BigDecimal("200.5"));
        curso1.setFechaInicio(LocalDate.now().plusDays(5));
        curso1.setDuracion(2);
        curso1.setNombre("PROGRAMACION 1");

        curso2 = new Curso();
        curso2.setCodigo("2kj238s8wwdej22");
        curso2.setArea("COMPUTACION");
        curso2.setCosto(new BigDecimal("240.5"));
        curso2.setFechaInicio(LocalDate.now().plusDays(5));
        curso2.setDuracion(2);
        curso2.setNombre("PROGRAMACION 2");

        cursos = new ArrayList<Curso>();
        cursos.add(curso1);
        cursos.add(curso2);
    }

    @Test
    public void testConsultarCursosPorArea() {

        try {
            when(cursoService.buscarPorArea("COMPUTACION")).thenReturn(cursos);
            Assertions.assertEquals(ResponseEntity.ok(cursos), controller.consultarCursosPorArea("COMPUTACION"));
        } catch (Exception e) {
            Logger.getLogger(CursoControllerTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Test
    public void testConsultarCursosPorNombre() {
      try {
            when(cursoService.buscarPorNombre("PROGRAMACION")).thenReturn(cursos);
            Assertions.assertEquals(ResponseEntity.ok(cursos), controller.consultarCursosPorNombre("PROGRAMACION"));
        } catch (Exception e) {
            Logger.getLogger(CursoControllerTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
