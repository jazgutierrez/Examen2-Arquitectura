/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.controller;

import ec.edu.espe.arquitectura.examen2arquitectura.model.Ejemplo;
import ec.edu.espe.arquitectura.examen2arquitectura.service.EjemploService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/ejemplo")
public class EjemploController {
    
    private final EjemploService service;

    public EjemploController(EjemploService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity crear()
    {
        Ejemplo ejemplo = new Ejemplo();
        ejemplo.setCodigo("1");
        ejemplo.setDescripcion("dhgfcvbsd");
        ejemplo.setNombre("aksnx");
        return ResponseEntity.ok(this.service.crear(ejemplo));
        
    }
}
