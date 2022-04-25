package service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Producto;


@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	JdbcTemplate template;

	public ProductoServiceImpl() {
		
	}
	
	public List<Producto> buscarSeccion(String seccion) {
		
	
		String sql = "select * from productos where seccion=?";
		return template.query(sql, (rs,f) -> new Producto(rs.getInt("idProducto"),rs.getString("nombre"),rs.getString("seccion"),
				rs.getDouble("precio"),rs.getInt("stock")), seccion);
		
	}
	
	public void alta(Producto p) {
	
		String sql = "insert into productos(nombre,seccion,precio,stock) values(?,?,?,?)";
		template.update(sql, p.getNombre(), p.getSeccion(), p.getPrecio(), p.getStock());
		
		
	}
	
	public void modificarPrecio(String nombre, double precioModificado) {

		String sql = "update productos set precio=? where nombre=?";
		template.update(sql, precioModificado, nombre);
		
	}
	
	public void eliminar(String nombre) {
	
		String sql = "delete from productos where nombre=?";
		template.update(sql, nombre);
		
		
		
	}


	public Producto buscarProducto(int idProducto) {
		String sql = "select * from productos where idProducto=?";
		List<Producto> productos = template.query(sql, (rs,f) -> new Producto(rs.getInt("idProducto"),rs.getString("nombre"),rs.getString("seccion"),
				rs.getDouble("precio"),rs.getInt("stock")), idProducto);
		return productos.size() > 0 ? productos.get(0):null;
	}
	
}
