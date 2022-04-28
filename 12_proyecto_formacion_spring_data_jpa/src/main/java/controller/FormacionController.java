package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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

		

}
