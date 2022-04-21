package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Producto;


@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	JdbcTemplate template;
//
//	static ArrayList<Producto> productos=new ArrayList<>(List.of(new Producto("vino","alimentación",8.4,25),
//			new Producto("leche","alimentación",1.2,70),
//			new Producto("cable usb","informática",5.6,30),
//			new Producto("arroz","alimentación",3.1,16),
//			new Producto("silla","hogar",30.6,10),
//			new Producto("monitor","informática",125.0,5),
//			new Producto("escritorio","hogar",230,4)
//			));
	public ProductoServiceImpl() {
		
	}
	
	public List<Producto> buscarSeccion(String seccion) {
		
		//Con SQL
		String sql = "select * from productos where seccion=?";
		return template.query(sql, (rs,f) -> new Producto(rs.getInt("idProducto"),rs.getString("nombre"),rs.getString("seccion"),
				rs.getDouble("precio"),rs.getInt("stock")), seccion);
		
		// Sin SQL
		//return productos.stream().filter(x -> x.getSeccion().equals(seccion)).collect(Collectors.toList());
	}
	
	public void alta(Producto p) {
		
		// Con SQL
		String sql = "insert into productos(nombre,seccion,precio,stock) values(?,?,?,?)";
		template.update(sql, p.getNombre(), p.getSeccion(), p.getPrecio(), p.getStock());
		
		// Sin SQL
		// productos.add(p);
		
	}
	
	public void modificarPrecio(String nombre, double precioModificado) {
		
		// Con SQL
		String sql = "update from productos set precio=? where nombre=?";
		template.update(sql, precioModificado, nombre);
		
		// Sin SQL
//		productos.forEach(x -> {
//			if(x.getNombre().equals(nombre)) {
//				x.setPrecio(precioModificado);
//			}
//		});
	}
	
	public void eliminar(String nombre) {
		
		// Con SQL
		String sql = "delete from productos where nombre=?";
		template.update(sql, nombre);
		
		// Sin SQL
		//productos.removeIf(x -> x.getNombre().equals(nombre));
		
		
	}


	public Producto buscarProducto(int idProducto) {
		String sql = "select * from productos where idProducto=?";
		List<Producto> productos = template.query(sql, (rs,f) -> new Producto(rs.getInt("idProducto"),rs.getString("nombre"),rs.getString("seccion"),
				rs.getDouble("precio"),rs.getInt("stock")), idProducto);
		return productos.size() > 0 ? productos.get(0):null;
	}
	
}
