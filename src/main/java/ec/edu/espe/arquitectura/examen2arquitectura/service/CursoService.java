/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.service;

import ec.edu.espe.arquitectura.examen2arquitectura.dao.CursoRepository;
import ec.edu.espe.arquitectura.examen2arquitectura.model.Curso;
import java.lang.module.FindException;
import java.time.LocalDate;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CursoService {

    private final CursoRepository cursoRepo;

    public CursoService(CursoRepository cursoRepo) {
        this.cursoRepo = cursoRepo;
    }

    public List<Curso> buscarPorArea(String area) {
        log.info("Se va a consultar una ista de cursos disponibles con el area {}", area);
        List<Curso> cursos = this.cursoRepo.findByFechaInicioAfterAndArea(LocalDate.now(), area);
        if (cursos.size() == 0) {
            throw new FindException("No se ha podido encontrar cursos disponibles");

        } else {
            return cursos;
        }
    }

    public List<Curso> buscarPorNombre(String nombre) {
        log.info("Se va a consultar una ista de cursos disponibles con el nombre {}", nombre);

        List<Curso> cursos = this.cursoRepo.findByFechaInicioAfterAndNombreLike(LocalDate.now(), nombre);
        if (cursos.size() == 0) {
            throw new FindException("No se ha podido encontrar cursos disponibles");
        } else {
            return cursos;
        }
    }
}
