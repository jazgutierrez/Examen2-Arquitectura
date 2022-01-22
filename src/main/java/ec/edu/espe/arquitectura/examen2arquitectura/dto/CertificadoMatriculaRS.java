/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.dto;

import lombok.Data;

@Data
public class CertificadoMatriculaRS {
    private String idEstudiante;
    private String nombreEstudiante;
    private String correo;
    private CursoRS curso;
}
