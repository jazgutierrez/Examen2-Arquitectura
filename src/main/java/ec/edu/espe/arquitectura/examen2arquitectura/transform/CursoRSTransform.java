/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.transform;

import ec.edu.espe.arquitectura.examen2arquitectura.dto.CursoRS;
import ec.edu.espe.arquitectura.examen2arquitectura.model.Curso;

public class CursoRSTransform {

    public static CursoRS buildCursoRS(Curso curso) {
        return CursoRS.builder()
                .codigo(curso.getCodigo())
                .area(curso.getArea())
                .nombre(curso.getNombre())
                .costo(curso.getCosto())
                .duracion(curso.getDuracion())
                .fechaInicio(curso.getFechaInicio())
                .build();
    }
}
