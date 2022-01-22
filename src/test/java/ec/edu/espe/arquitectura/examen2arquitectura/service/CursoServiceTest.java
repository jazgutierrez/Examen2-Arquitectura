/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.service;

import ec.edu.espe.arquitectura.examen2arquitectura.dao.CursoRepository;
import ec.edu.espe.arquitectura.examen2arquitectura.model.Curso;
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
public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepo;

    @InjectMocks
    private CursoService cursoService;

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
    public void testBuscarPorArea() {
       try {
            when(cursoRepo.findByFechaInicioAfterAndArea(LocalDate.now(), "COMPUTACION")).thenReturn(cursos);
            Assertions.assertEquals(cursos, cursoService.buscarPorArea("COMPUTACION"));
        } catch (Exception e) {
            Logger.getLogger(CursoServiceTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Test
    public void testBuscarPorNombre() {
         try {
            when(cursoRepo.findByFechaInicioAfterAndNombreLike(LocalDate.now(), "PROG")).thenReturn(cursos);
            Assertions.assertEquals(cursos, cursoService.buscarPorNombre("PROG"));
        } catch (Exception e) {
            Logger.getLogger(CursoServiceTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
