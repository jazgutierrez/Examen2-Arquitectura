/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ejemplo")
public class Ejemplo {
    @Id
    private String id;
    private String codigo;
    private String nombre;
    private Integer seccion;
    private String descripcion;
}
