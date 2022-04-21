package service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Alumno;



@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	JdbcTemplate template;

	public AlumnoServiceImpl() {
		
	}

	@Override
	public List<Alumno> buscarCurso(String curso) {
	
		String sql = "select * from alumnos where curso=?";
		return template.query(sql, (rs,f) -> new Alumno(rs.getInt("idAlumno"), rs.getString("nombre"),
				rs.getString("curso"), rs.getDouble("nota")), curso);
	}

	@Override
	public void add(Alumno a) {
		
		String sql = "insert into alumnos(nombre,curso,nota) values(?,?,?)";
		template.update(sql, a.getNombre(), a.getCurso(), a.getNota());
		
	}

	@Override
	public boolean existeAlumno(Alumno a) {
		
		String sqlConsulta = "select * from alumnos where nombre=? and curso=? and nota=?";
		List<Alumno> alumno = template.query(sqlConsulta, (rs,f) -> new Alumno(rs.getInt("idAlumno"), rs.getString("nombre"),
				rs.getString("curso"), rs.getDouble("nota")), a.getNombre(), a.getCurso(), a.getNota());
		
		if(alumno.isEmpty()) {
			return false;
		}
		
		return true;
	
	}

	@Override
	public List<String> cursos() {
		String sql = "select distinct(curso) from alumnos";
		
		return template.query(sql, (rs,f) -> rs.getString("curso"));
	}
	
	
}
