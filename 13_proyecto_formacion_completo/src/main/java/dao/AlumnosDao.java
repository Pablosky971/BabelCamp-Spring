package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;
import model.Curso;

public interface AlumnosDao extends JpaRepository<Alumno, String>{
	
	
	Alumno findByUsuarioAndPassword(String usuario, String password);
	@Query("select a from Alumno a join a.cursos c where c.nombre=?1")
	List<Alumno> findByCurso(String nombreCurso);
	//Alumno findById(String usuario); No hace falta indicarlo; JPA ya lo incorpora p.d.
	// void update(Alumno alumno); No hace falta indicarlo; JPA ya lo incorpora p.d.
	//List<Alumno> findAll(); No hace falta indicarlo; JPA ya lo incorpora p.d.

	@Query("select c from Curso c join c.alumnos a where a.usuario!=?1")
	List<Curso> findByFechaInicioAndFin(Date fechaInicio, Date fechaFin);
}
