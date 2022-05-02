package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Movimiento;

public interface MovimientosDao extends JpaRepository<Movimiento, Integer> {

	
	
//	@Query("update ")
//	Integer ingreso(double cantidad, int numeroCuenta);
//	
//	@Query("update ")
//	Integer extraccion(double cantidad, int numeroCuenta);
}
