package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.CajeroService;


@ExtendWith(SpringExtension.class) // Clase encargada de hacer tests con Spring.
@ContextConfiguration(classes = {ServiceConfig.class}) // Indicamos la clase de configuración que ha de emplear. En este caso, que configure la lógica de negocio.
public class TestCajeroService {
	
	@Autowired
	CajeroService service;
	
	@Test
	void validarCuenta() {
		assertNotNull(service.validarCuenta(1000));
		assertNull(service.validarCuenta(666));
		
	}
	
	@Test
	void ingreso() {
		service.ingreso(200, 1000);
		assertEquals(41767,service.validarCuenta(1000).getSaldo());
		
	}
	
	@Test
	void extraccion() {
		service.extraccion(200, 1000);
		assertEquals(41567,service.validarCuenta(1000).getSaldo());
		
	}
	
	@Test
	void transferencia() {
		
		service.transferencia(1, 1000, 1234);
		assertEquals(41566,service.validarCuenta(1000).getSaldo());
		assertEquals(571,service.validarCuenta(1234).getSaldo());
		
		
	}
	
//	@Test
//	void movimientos() {
//		
//		
//		assertNotNull(service.movimientos(, , 0));
//		
//		
//	}
	
	@Test
	void saldo() {
		assertEquals(41566,service.saldoCuenta(1000));
	}

}
