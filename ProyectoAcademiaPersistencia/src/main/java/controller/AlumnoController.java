package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import service.AlumnoService;


@CrossOrigin("*")
@Controller
public class AlumnoController {

	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping(value="Cursos",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> cursos () { 
		
		List<String> cursos = alumnoService.cursos();
		return cursos;
		
	}


	@GetMapping(value="Buscar",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> buscarPorCurso(@RequestParam("curso") String curso, HttpServletRequest request) { 
		
		List<Alumno> alumnos = alumnoService.buscarCurso(curso);
		return alumnos;
		
	}

	@PostMapping("Add")
	public String add(@ModelAttribute Alumno a) {
		
		if(!alumnoService.existeAlumno(a)) {
			
			alumnoService.add(a);
			return "add";
		} else {
			return "error";
		}
		
	}
	
	
 	
	
}
