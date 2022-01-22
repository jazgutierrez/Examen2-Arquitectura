/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.controller;

import ec.edu.espe.arquitectura.examen2arquitectura.dto.EstudianteRQ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author yazbe
 */
public class EstudianteControllerTest {
    
    public EstudianteControllerTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testCrear() {
        System.out.println("crear");
        EstudianteRQ estudianteRQ = null;
        EstudianteController instance = null;
        ResponseEntity expResult = null;
        ResponseEntity result = instance.crear(estudianteRQ);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
