package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Pagina;
import service.BuscadorService;

@Controller
public class BuscadorController {

	@Autowired
	BuscadorService buscadorService;
	
	@GetMapping(value="Buscador")
	public String buscar(@RequestParam("tematica") String tematica, HttpServletRequest request) {
		
		List<Pagina> paginas = buscadorService.buscar(tematica);
		request.setAttribute("paginas", paginas);
		return "listado"; // Nombre de la vista.
	}
	
	
	@PostMapping(value="Agregar")
	public String agregar(@ModelAttribute Pagina pagina) {
		
		buscadorService.agregar(pagina);
		return "datos";
	}
}
