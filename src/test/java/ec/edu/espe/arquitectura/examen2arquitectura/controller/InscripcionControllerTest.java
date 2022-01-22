/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.controller;

import ec.edu.espe.arquitectura.examen2arquitectura.dto.InscripcionRQ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author yazbe
 */
public class InscripcionControllerTest {
    
    public InscripcionControllerTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testInscripcionCurso() {
        System.out.println("inscripcionCurso");
        InscripcionRQ incripcionRQ = null;
        InscripcionController instance = null;
        ResponseEntity expResult = null;
        ResponseEntity result = instance.inscripcionCurso(incripcionRQ);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
