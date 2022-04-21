package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Producto;
import service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@GetMapping("Buscar")
	public String buscarPorSeccion(@RequestParam("seccion") String seccion, HttpServletRequest request) { 
		
		List<Producto> productos = productoService.buscarSeccion(seccion);
		request.setAttribute("productos", productos);
		
		return "listado";
		
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
