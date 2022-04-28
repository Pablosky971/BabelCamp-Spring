package service;

import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {
	
	Alumno validarUsuario(String usuario, String password);
	List<Curso> cursosAlumno(String usuario);
	List<Curso> cursos();
	List<Alumno> alumnosCurso(String nombreCurso);
	boolean matricularAlumno(int idCurso, String usuario);
	List<Alumno> alumnos();
	boolean altaAlumno(Alumno a);
	boolean altaCurso(Curso c);
	List<Curso> consultarMatriculas(Date f1, Date f2);
	List<Curso> cursosPosiblesMatricularAlumno(String usuario);
}
