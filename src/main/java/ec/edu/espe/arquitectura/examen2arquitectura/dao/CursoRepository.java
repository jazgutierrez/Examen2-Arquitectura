/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.dao;

import ec.edu.espe.arquitectura.examen2arquitectura.model.Curso;
import ec.edu.espe.arquitectura.examen2arquitectura.model.Estudiante;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author yazbe
 */
public interface CursoRepository extends MongoRepository<Curso, String> {
    List<Curso> findByFechaInicioAfterAndArea(LocalDate fecha, String Area);
    List<Curso> findByFechaInicioAfterAndNombreLike(LocalDate fecha, String Area);
    
}
