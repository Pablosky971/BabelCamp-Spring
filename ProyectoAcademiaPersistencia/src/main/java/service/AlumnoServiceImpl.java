package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import model.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public AlumnoServiceImpl() {
		
	}

	@Transactional
	public List<Alumno> buscarCurso(String curso) {
	
		String jpql = "select a from Alumno a where curso=?1";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, curso);
		List<Alumno> res = query.getResultList();
		return res;
	}

	@Transactional
	public void add(Alumno a) {
		
		entityManager.persist(a);
		
	}

	@Transactional
	public boolean existeAlumno(Alumno a) {
		
		String jpql = "select a from Alumno a where nombre=?1 and curso=?2 and nota=?3";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, a.getNombre());
		query.setParameter(2, a.getCurso());
		query.setParameter(3, a.getNota());
		List<Alumno> alumno = query.getResultList();
		
		if(alumno.isEmpty()) {
			return false;
		}
		
		return true;
	
	}

	@Transactional
	public List<String> cursos() {
		
		String jpql = "select distinct a.curso from Alumno a";
		TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
		List<String> cursos = query.getResultList();
		return cursos;
	}
	
	
}
