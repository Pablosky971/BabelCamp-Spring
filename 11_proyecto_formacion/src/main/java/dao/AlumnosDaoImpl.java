package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Repository
public class AlumnosDaoImpl implements AlumnosDao {


	@PersistenceContext
	EntityManager entityManager;

	
	public Alumno findByUsuarioAndPassword(String usuario, String password) {
		String jpql = "select a from Alumno a where a.usuario=?1 and a.password=?2";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, usuario);
		query.setParameter(2, password);
		try {
			return query.getSingleResult();
		} catch(NoResultException ex) {
			return null;
		}
		
	}

	
	public List<Alumno> findByCurso(String nombreCurso) {
	
		String jpql = "select a from Alumno a join a.cursos c where c.nombre=?1";
		TypedQuery<Alumno> query = entityManager.createQuery(jpql, Alumno.class);
		query.setParameter(1, nombreCurso);
		List<Alumno> alumnos = query.getResultList();
		return alumnos.size()>0 ? alumnos:null;
	}
	public Alumno findById(String usuario) {
		
		return entityManager.find(Alumno.class, usuario);
	}

	@Transactional
	public void update(Alumno alumno) {
		entityManager.merge(alumno);

	}

}
