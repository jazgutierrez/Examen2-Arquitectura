/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class EstudianteRQ {
    private String nombre;
    private String correo;
    private String pais;
    private LocalDateTime fechaNacimiento;
}
