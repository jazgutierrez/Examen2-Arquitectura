/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.dao;

import ec.edu.espe.arquitectura.examen2arquitectura.model.Ejemplo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EjemploRepository extends MongoRepository<Ejemplo, String>{
    
}
