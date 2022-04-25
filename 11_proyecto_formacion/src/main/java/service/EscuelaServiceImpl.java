package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import model.Alumno;
import model.Curso;

@Service
public class EscuelaServiceImpl implements EscuelaService {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Alumno> alumnosCursos(String nombre) {
		String jpql = "select a from Alumno a where a.curso.denominacion=?1";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, nombre);
		return query.getResultList(); 
	}

	@Override
	public List<Alumno> alumnosCursoDuracion(int duracionMax) {
		String jpql = "select a from Alumno a where a.curso.duracion<=?1";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, duracionMax);
		return query.getResultList(); 
	}

	@Override
	public Curso cursoMatriculadoAlumno(String dni) {
		// String jpql = "select c from Curso c where c.alumnos.dni=?1". No se puede; es una colección; hemos de usar join explícito
		
		String jpql = "select c from Curso c join c.alumnos a where a.dni=?1";
		TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter(1, dni);
		return query.getSingleResult(); 
	}

	@Override
	public List<Curso> alumnosSenior(int edad) {
		
		String jpql = "select c from Curso c join c.alumnos a where a.edad>=?1";
		TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter(1, edad);
		return query.getResultList(); 
	}

	@Override
	public double edadMediaCurso(String nombreCurso) {
		String jpql = "select avg(a.edad) from Alumno a where a.curso.denominacion=?1";
		TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
		query.setParameter(1, nombreCurso);
		return query.getSingleResult(); 
	
	}

	@Override
	public double precioCurso(String email) {
		String jpql = "select c.precio from Curso c join c.alumnos a where a.email=?1";
		TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
		query.setParameter(1, email);
		return query.getSingleResult(); 
		
	}

}
