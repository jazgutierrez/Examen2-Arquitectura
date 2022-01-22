/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.examen2arquitectura.service;

import ec.edu.espe.arquitectura.examen2arquitectura.dao.CursoRepository;
import ec.edu.espe.arquitectura.examen2arquitectura.model.Estudiante;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ec.edu.espe.arquitectura.examen2arquitectura.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.examen2arquitectura.dto.CertificadoMatriculaRS;
import ec.edu.espe.arquitectura.examen2arquitectura.dto.InscripcionRQ;
import ec.edu.espe.arquitectura.examen2arquitectura.exceptions.CreateException;
import ec.edu.espe.arquitectura.examen2arquitectura.model.Curso;
import ec.edu.espe.arquitectura.examen2arquitectura.transform.CursoRSTransform;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EstudianteService {

    private final EstudianteRepository estudinateRepo;
    private final CursoRepository cursoRepo;

    public EstudianteService(EstudianteRepository estudinateRepo, CursoRepository cursoRepo) {
        this.estudinateRepo = estudinateRepo;
        this.cursoRepo = cursoRepo;
    }

    public String crearEstudiante(Estudiante estudiante) {
        List<Estudiante> estudiantes = this.estudinateRepo.findByCorreo(estudiante.getCorreo());
        if (estudiantes.size() == 0) {
            return this.estudinateRepo.save(estudiante).getId();
        } else {
            throw new CreateException("Ese correo ya existe");
        }
    }

    public CertificadoMatriculaRS inscribirCurso(InscripcionRQ inscripcion) {
        Optional<Estudiante> estudianteOpt = this.estudinateRepo.findById(inscripcion.getCodigoEstudiante());
        Optional<Curso> cursoOpt = this.cursoRepo.findById(inscripcion.getCodigoCurso());

        if (estudianteOpt.isEmpty()) {
            throw new CreateException("No se ha podido encontrar el estudiante");
        }
        if (cursoOpt.isEmpty()) {
            throw new CreateException("No se ha podido encontrar el curso");
        }

        if (estudianteOpt.get().getCursos().size() < 2) {
            for (Curso c : estudianteOpt.get().getCursos()) {
                if (c.getCodigo().equals(inscripcion.getCodigoCurso())) {
                    throw new CreateException("Ya se encuentra matriculado en este curso");
                }
            }

            estudianteOpt.get().getCursos().add(cursoOpt.get());
            this.estudinateRepo.save(estudianteOpt.get());

            CertificadoMatriculaRS certificado = new CertificadoMatriculaRS();
            certificado.setIdEstudiante(estudianteOpt.get().getId());
            certificado.setCorreo(estudianteOpt.get().getCorreo());
            certificado.setNombreEstudiante(estudianteOpt.get().getNombre());
            certificado.setCurso(CursoRSTransform.buildCursoRS(cursoOpt.get()));

            return certificado;
        } else {
            throw new CreateException("El estudiante ya tiene dos cursos inscritos");
        }

    }
}
