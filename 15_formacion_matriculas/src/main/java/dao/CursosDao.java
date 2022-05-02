package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import modelo.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer>{
	
	List<Curso> findByNombre(String nombre);
	@Query("select c from Curso c join c.matriculas m where m.alumno.usuario=?1")
	List<Curso> findByAlumno(String usuario);
	
	@Query("Select c From Curso c Where c Not In (Select c From Curso c join c.matriculas m Where m.alumno.usuario=?1)")
	List<Curso> findByAlumnoNoMatriculado(String usuario);
	
	

}
