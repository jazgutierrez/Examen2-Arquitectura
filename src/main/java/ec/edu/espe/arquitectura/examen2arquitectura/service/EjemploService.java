/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.service;

import ec.edu.espe.arquitectura.examen2arquitectura.dao.EjemploRepository;
import ec.edu.espe.arquitectura.examen2arquitectura.model.Ejemplo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EjemploService {
    private final EjemploRepository repo;

    public EjemploService(EjemploRepository repo) {
        this.repo = repo;
    }
    
    public String crear(Ejemplo ejemplo){
        return this.repo.save(ejemplo).getId();
    }
}
