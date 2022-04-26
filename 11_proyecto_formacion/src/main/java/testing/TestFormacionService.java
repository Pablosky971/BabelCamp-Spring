package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import model.Alumno;
import model.Curso;
import service.FormacionService;


@ExtendWith(SpringExtension.class) // Clase encargada de hacer tests con Spring.
@ContextConfiguration(classes = {ServiceConfig.class}) // Indicamos la clase de configuración que ha de emplear. En este caso, que configure la lógica de negocio.
public class TestFormacionService {
	
	@Autowired
	FormacionService service;
	
	@Test
	void validarUsuario() {
		assertNotNull(service.validarUsuario("diego armando", "diego"));
		
	}
	
	@Test
	void cursosAlumno() {
		assertNotNull(service.cursosAlumno("aaa"));
		
	}
	
	@Test
	void cursos() {
		assertNotNull(service.cursos());
	}
	
	@Test
	void alumnosCurso() {
		
		assertNotNull(service.alumnosCurso("java 10"));
		
	}
	
	@Test
	void matricular() {
		
		service.matricularAlumno(18, "aaa");
		assertEquals(1, service.alumnosCurso("ww").size());
		assertEquals(9, service.cursosAlumno("aaa").size());
		
	}

}
