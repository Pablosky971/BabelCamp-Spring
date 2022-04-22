package service;

import java.util.List;

import model.Alumno;

public interface AlumnoService {
	
	List<Alumno> buscarCurso(String curso);
	void add(Alumno a);
	boolean existeAlumno(Alumno a);
	List<String> cursos();
	

}
