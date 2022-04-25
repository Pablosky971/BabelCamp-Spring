package testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.persistence.TypedQuery;

import config.ServiceConfig;
import model.Alumno;
import service.EscuelaService;


@ExtendWith(SpringExtension.class) // Clase encargada de hacer tests con Spring.
@ContextConfiguration(classes = {ServiceConfig.class}) // Indicamos la clase de configuración que ha de emplear. En este caso, que configure la lógica de negocio.
public class TestEscuelaService {
	
	@Autowired
	EscuelaService service;
	
	@Test
	void alumnosCursos() {
		assertNotNull(service.alumnosCursos("java"));
		
	}
	
	@Test
	void cursoMatriculadoAlumno() {
		
		assertNotNull(service.cursoMatriculadoAlumno("1111A"));
		
	}
	
	@Test
	void alumnosSenior() {
		assertNotNull(service.alumnosSenior(12));
	}
	
	@Test
	void testEdadMediaCurso() {
		assertNotNull(service.edadMediaCurso("java"));
		assertEquals(25.0, service.edadMediaCurso("java"));
		
	}
	
	@Test
	void testPrecioCurso() {
		assertNotNull(service.precioCurso("primero@gmail.com"));
		assertEquals(250.0,service.precioCurso("primero@gmail.com"));
	}

}
