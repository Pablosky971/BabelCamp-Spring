package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {
	
	Alumno validarUsuario(String usuario, String password);
	List<Curso> cursosAlumno(String usuario);
	List<Curso> cursos();
	List<Alumno> alumnosCurso(String nombreCurso);
	void matricularAlumno(int idCurso, String usuario);
	List<Alumno> alumnos();
}
