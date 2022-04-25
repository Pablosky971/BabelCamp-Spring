package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Producto;


@Service
public class ProductoServiceImpl implements ProductoService {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public List<Producto> buscarSeccion(String seccion) {
		String jpql = "select p from Producto p where seccion=?1";
		TypedQuery<Producto> query = entityManager.createQuery(jpql, Producto.class);
		query.setParameter(1, seccion);
		List<Producto> res = query.getResultList();
		return res;
		
	}

	@Transactional
	public void alta(Producto p) {
		entityManager.persist(p);
		
	}

	@Transactional
	public void modificarPrecio(String nombre, double precioModificado) {
	
		String jpql= "update Producto p set p.precio=?1 where p.nombre=?2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, precioModificado);
		query.setParameter(2, nombre);
		query.executeUpdate();
		
		
	}

	@Transactional
	public void eliminar(String nombre) {
	
		String jpql= "delete Producto p where p.nombre=?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, nombre);
		query.executeUpdate();
	
		
		
	}

	@Transactional
	public Producto buscarProducto(int idProducto) {
		
		return entityManager.find(Producto.class, idProducto);
	}

	@Override
	public Producto buscarProductoNombre(String nombre) {
		String jpql = "select p from Producto p where nombre=?1";
		TypedQuery<Producto> query = entityManager.createQuery(jpql, Producto.class);
		query.setParameter(1, nombre);
		List<Producto> res = query.getResultList();
		return res.size()>0?res.get(0):null;
	}
	
	
	

	
}
