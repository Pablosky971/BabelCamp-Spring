package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer>{
	
	List<Curso> findByNombre(String nombre);
	@Query("select c from Curso c join c.alumnos a where a.usuario=?1")
	List<Curso> findByAlumno(String usuario);
	
	@Query("Select c From Curso c Where c Not In (Select c From Curso c join c.alumnos a Where a.usuario=?1)")
	List<Curso> findByAlumnoNoMatriculado(String usuario);
	
	List<Curso> findByFechaInicioBetween(Date inicio, Date fin);

}
