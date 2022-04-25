package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface EscuelaService {
	
	List<Alumno> alumnosCursos(String nombre);
	List<Alumno> alumnosCursoDuracion(int duracionMax);
	Curso cursoMatriculadoAlumno(String dni);
	
	/**
	 * Lista de cursos en los que est� matriculados alumnos con edad superior o igual al valor recibido.
	 * @param edad indicada
	 * @return devuelve los alumnos registrados en el sistema cuya edad es superior o igual a la indicada por par�metro.
	 */
	List<Curso> alumnosSenior(int edad); 
	
	/**
	 * Consultar la media de la edad del curso indicado.
	 * @param nombreCurso nombre del curso que se quiere consultar.
	 * @return edad media de los alumnos pertenecientes al curso indicado.
	 */
	double edadMediaCurso(String nombreCurso);

	/**
	 * Consulta el precio del curso donde est� matriculado el alumno se�alado por su direcci�n de email.
	 * @param email, direcci�n de email del alumno.
	 * @return precio del curso donde est� matriculado el alumno.
	 */
	double precioCurso(String email);
}
