/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.controller;

import ec.edu.espe.arquitectura.examen2arquitectura.dto.EstudianteRQ;
import ec.edu.espe.arquitectura.examen2arquitectura.model.Curso;
import ec.edu.espe.arquitectura.examen2arquitectura.model.Estudiante;
import ec.edu.espe.arquitectura.examen2arquitectura.service.EstudianteService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {
    
    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity crear(@RequestBody EstudianteRQ estudianteRQ)
    {
        try{
             Estudiante estudiante = new Estudiante();
        estudiante.setNombre(estudianteRQ.getNombre());
        estudiante.setCorreo(estudianteRQ.getCorreo());
        estudiante.setPais(estudianteRQ.getPais());
        estudiante.setFechaCreacion(LocalDateTime.now());
        estudiante.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudiante.setEstado("ACT");
        estudiante.setCursos(new ArrayList<Curso>());
        
        return ResponseEntity.ok(this.service.crearEstudiante(estudiante));
        }catch(Exception e){
            log.info("Error en crear al estudiante: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
       
        
    }
}
