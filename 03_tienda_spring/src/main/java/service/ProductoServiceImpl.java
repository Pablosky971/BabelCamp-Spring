package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Producto;


@Service
public class ProductoServiceImpl implements ProductoService {
	
	

	static List<Producto> productos=new ArrayList<>(List.of(new Producto("vino","alimentación",8.4,25),
			new Producto("leche","alimentación",1.2,70),
			new Producto("cable usb","informática",5.6,30),
			new Producto("arroz","alimentación",3.1,16),
			new Producto("silla","hogar",30.6,10),
			new Producto("monitor","informática",125.0,5),
			new Producto("escritorio","hogar",230,4)
			));
	public ProductoServiceImpl() {
		
	}
	
	public List<Producto> buscarSeccion(String seccion) {
		
		
		return productos.stream().filter(x -> x.getSeccion().equals(seccion)).collect(Collectors.toList());
	}
	
	public void alta(Producto p) {
		
		 
		 productos.add(p);
		
	}
	
	public void modificarPrecio(String nombre, double precioModificado) {
		

		productos.forEach(x -> {
			if(x.getNombre().equals(nombre)) {
				x.setPrecio(precioModificado);
			}
		});
	}
	
	public void eliminar(String nombre) {
		
		productos.removeIf(x -> x.getNombre().equals(nombre));
		
		
	}


	
}
