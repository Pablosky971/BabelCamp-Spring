package testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


import config.ServiceConfig;
import service.ProductoService;

@ExtendWith(SpringExtension.class) // Clase encargada de hacer tests con Spring.
@ContextConfiguration(classes = {ServiceConfig.class}) // Indicamos la clase de configuración que ha de emplear. En este caso, que configure la lógica de negocio.
public class TestProductoService {
	
	@Autowired
	ProductoService service;
	
	@Test
	void testProducto() {
		assertEquals(12.0, service.buscarProducto(10).getPrecio());
		assertNull(service.buscarProducto(800));
	}
	
//	@Test
//	void testMedia() {
//		assertEquals(50.0, service.buscarProducto(4).getPrecio());
//		
//	}

}
