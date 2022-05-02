package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import model.Curso;
import org.springframework.web.bind.annotation.ResponseBody;
import service.FormacionService;

@CrossOrigin("*")
@Controller
public class FormacionController {
	
	@Autowired
	FormacionService formacionService;
	
	@PostMapping(value="Login")
	public String validarUsuario(@RequestParam("usuario") String usuario, @RequestParam("password") String password, HttpServletRequest request, HttpSession sesion) { 
		
		Alumno a = formacionService.validarUsuario(usuario, password);
		
		if(a != null) {
			sesion.setAttribute("alumno",a);
			return "login";
			
		} else {
			return "error";
		}
		
	}
	
	@GetMapping(value="Cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursos() { 
		
		return formacionService.cursos();
		
	}
	
	@GetMapping(value="Alumnos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> alumnos() { 
		
		return formacionService.alumnos();
		
	}
	
	@GetMapping(value="AlumnosCurso", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> alumnosCurso(@RequestParam("nombre") String nombre, HttpServletRequest request) { 
		
		List<Alumno> alumnos = formacionService.alumnosCurso(nombre);
		
		return alumnos;
		
	}
	
	@GetMapping(value="CursosAlumno", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursosAlumno(@RequestParam("usuario") String usuario, HttpServletRequest request) { 
		
		List<Curso> cursos = formacionService.cursosAlumno(usuario);
		
		return cursos;
		
	}
	
	@GetMapping(value="NoCursosAlumno", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> noCursosAlumno(@RequestParam("usuario") String usuario, HttpServletRequest request) { 
		
		List<Curso> cursos = formacionService.cursosPosiblesMatricularAlumno(usuario);
		
		return cursos;
		
	}
	
//	@GetMapping(value="CursosFechas", produces=MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody List<Curso> cursosFechas(@RequestParam("fechaInicio")  String fechaInicio, @RequestParam("fechaFin")  String fechaFin, HttpServletRequest request) { 
//		
//		try {
//			Date fi = new SimpleDateFormat("yyyy/MM/dd").parse(fechaInicio);
//			Date ff = new SimpleDateFormat("yyyy/MM/dd").parse(fechaFin);
//			List<Curso> cursos = formacionService.consultarMatriculas(fi, ff);
//			
//			return cursos;
//		} catch(ParseException ex) {
//			ex.printStackTrace();
//			return null;
//		}
//		
//		
//	}
	
	@GetMapping(value="CursosFechas", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursosFechas(@RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
			@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date fechaFin) { 
		
		
			return formacionService.consultarMatriculas(fechaInicio, fechaFin);
		
	}
	

	
	@PostMapping(value="AltaAlumno", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean altaAlumno(@RequestParam("usuario") String usuario, @RequestParam("password") String password, @RequestParam("nombre") String nombre, @RequestParam("email") String email, @RequestParam("edad") int edad) { 
		
		Alumno a = new Alumno();
		a.setUsuario(usuario);
		a.setPassword(password);
		a.setNombre(nombre);
		a.setEmail(email);
		a.setEdad(edad);
		return formacionService.altaAlumno(a);
		
	}
	
	@PostMapping(value="AltaCurso", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean altaCurso(@RequestParam("nombre") String nombre, @RequestParam("duracion") int duracion, @RequestParam("fechaInicio") Date fechaInicio) { 
		
		Curso c = new Curso();		
		c.setNombre(nombre);
		c.setDuracion(duracion);
		c.setFechaInicio(fechaInicio);
		return formacionService.altaCurso(c);
		
	}
	
	
	
	

		

}
