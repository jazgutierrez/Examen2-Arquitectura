/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.controller;

import ec.edu.espe.arquitectura.examen2arquitectura.service.CursoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("area/(area)")
    public ResponseEntity consultarCursosPorArea(@PathVariable("area") String area) {
        try {
            return ResponseEntity.ok(this.cursoService.buscarPorArea(area));
        } catch (Exception e) {
            log.info("No se pudo obtener la información por: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("nombre/(nombre)")
    public ResponseEntity consultarCursosPorNombre(@PathVariable("nombre") String nombre) {
        try {
            return ResponseEntity.ok(this.cursoService.buscarPorNombre(nombre));
        } catch (Exception e) {
            log.info("No se pudo obtener la información por: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
