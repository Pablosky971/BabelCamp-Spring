package service;

import java.util.List;

import model.Producto;

public interface ProductoService {
	
	List<Producto> buscarSeccion(String seccion);
	void alta(Producto p);
	void modificarPrecio(String nombre, double precioModificado);
	void eliminar(String nombre);
	Producto buscarProducto(int idProducto);

}
