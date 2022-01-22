/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Estudiante")
public class Estudiante {

    @Id
    private String id;
    private String nombre;
    private String correo;
    private String pais;
    private LocalDateTime fechaCreacion;
    private LocalDate fechaNacimiento;
    private String estado;
    private List<Curso> cursos;
}
