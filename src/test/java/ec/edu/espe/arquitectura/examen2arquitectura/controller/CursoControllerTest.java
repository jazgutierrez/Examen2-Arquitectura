/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CursoControllerTest {
    

    
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testConsultarCursosPorArea() {
        System.out.println("consultarCursosPorArea");
        String area = "";
        CursoController instance = null;
        ResponseEntity expResult = null;
        ResponseEntity result = instance.consultarCursosPorArea(area);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarCursosPorNombre() {
        System.out.println("consultarCursosPorNombre");
        String nombre = "";
        CursoController instance = null;
        ResponseEntity expResult = null;
        ResponseEntity result = instance.consultarCursosPorNombre(nombre);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
