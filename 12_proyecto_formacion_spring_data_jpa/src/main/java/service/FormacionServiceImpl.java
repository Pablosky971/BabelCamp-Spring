package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import dao.CursosDao;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService {

	
	AlumnosDao alumnosDao;
	
	
	CursosDao cursosDao;
	
	public FormacionServiceImpl(@Autowired AlumnosDao alumnosDao, @Autowired CursosDao cursosDao) {
		this.alumnosDao = alumnosDao;
		this.cursosDao = cursosDao;
	}
	
	
	@Override
	public Alumno validarUsuario(String usuario, String password) {
		
		return alumnosDao.findByUsuarioAndPassword(usuario, password);
	}

	@Override
	public List<Curso> cursosAlumno(String usuario) {
	
		return cursosDao.findByAlumno(usuario);
	}

	@Override
	public List<Curso> cursos() {
		
		return cursosDao.findAll();
	}
	
	@Override
	public List<Alumno> alumnos() {
		
		return alumnosDao.findAll();
	}

	@Override
	public List<Alumno> alumnosCurso(String nombreCurso) {
		
		return alumnosDao.findByCurso(nombreCurso);
	}

	
	public boolean matricularAlumno(int idCurso, String usuario) {
		
		Optional<Curso> c = cursosDao.findById(idCurso);
		Optional<Alumno> alumno = alumnosDao.findById(usuario);
		
		if(c.isPresent()&&alumno.isPresent()) {
			Alumno a = alumno.get();
			a.getCursos().add(c.get());
			alumnosDao.save(a);
			return true;
		}
		return false;
	}

	
	
	
}
