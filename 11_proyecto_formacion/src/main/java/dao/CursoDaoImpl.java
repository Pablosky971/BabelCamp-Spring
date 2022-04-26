package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import model.Curso;

@Repository
public class CursoDaoImpl implements CursosDao {

	@PersistenceContext
	EntityManager entityManager;

	public Curso findById(int idCurso) {
		
		return entityManager.find(Curso.class, idCurso);
		
	}


	public List<Curso> findAll() {
		
		String jpql = "select c from Curso c";
		TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
		List<Curso> cursos = query.getResultList();
		return cursos.size()>0 ? cursos :null;
	}

	public List<Curso> findByAlumno(String usuario) {
		
		String jpql = "select c from Curso c join c.alumnos a where a.usuario=?1";
		TypedQuery<Curso> query = entityManager.createQuery(jpql, Curso.class);
		query.setParameter(1, usuario);
		List<Curso> cursos = query.getResultList();
		return cursos.size()>0 ? cursos:null;
	}

}
