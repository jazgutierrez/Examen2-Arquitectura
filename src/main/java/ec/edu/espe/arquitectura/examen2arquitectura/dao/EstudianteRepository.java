/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.dao;

import ec.edu.espe.arquitectura.examen2arquitectura.model.Estudiante;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EstudianteRepository extends MongoRepository<Estudiante, String>{
    List<Estudiante> findByCorreo(String correo);
}
