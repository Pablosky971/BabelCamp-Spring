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

import model.Producto;
import service.ProductoService;


@CrossOrigin("*")
@Controller
public class ProductoController {

	@Autowired
	ProductoService productoService;
	

	@GetMapping(value="Buscador",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Producto> buscarPorSeccion(@RequestParam("seccion") String seccion, HttpServletRequest request) { 
		
		List<Producto> productos = productoService.buscarSeccion(seccion);
		return productos;
		
	}

	@PostMapping("Alta")
	public String alta(@ModelAttribute Producto p) {
		productoService.alta(p);
		return "alta";
	}
	
	@PostMapping("ModificarPrecio")
	public String modificarPrecio(@RequestParam("nombre") String nombre, @RequestParam("precio") double precio) {
		productoService.modificarPrecio(nombre, precio);;
		return "modificar";
	}
	
	@PostMapping("Eliminar")
	public String eliminar(@RequestParam("nombre") String nombre) {
		productoService.eliminar(nombre);
		return "eliminar";
	}
 	
	
}
