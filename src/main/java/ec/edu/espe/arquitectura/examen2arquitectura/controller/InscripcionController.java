/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.controller;

import ec.edu.espe.arquitectura.examen2arquitectura.dto.InscripcionRQ;
import ec.edu.espe.arquitectura.examen2arquitectura.service.CursoService;
import ec.edu.espe.arquitectura.examen2arquitectura.service.EstudianteService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    private final CursoService cursoService;
    private final EstudianteService estudianteService;

    public InscripcionController(CursoService cursoService, EstudianteService estudianteService) {
        this.cursoService = cursoService;
        this.estudianteService = estudianteService;
    }

    @PostMapping
    public ResponseEntity inscripcionCurso(@RequestBody InscripcionRQ incripcionRQ) {
        try {
            return ResponseEntity.ok(this.estudianteService.inscribirCurso(incripcionRQ));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
