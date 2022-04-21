package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Producto;


@Service
public class ProductoServiceImpl implements ProductoService {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Producto> buscarSeccion(String seccion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alta(Producto p) {
		entityManager.persist(p);
		
	}

	@Override
	public void modificarPrecio(String nombre, double precioModificado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto buscarProducto(int idProducto) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
