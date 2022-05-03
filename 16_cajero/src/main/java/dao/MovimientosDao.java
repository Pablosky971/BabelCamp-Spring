package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Movimiento;


public interface MovimientosDao extends JpaRepository<Movimiento, Integer> {

	
	@Query("select m from Movimiento m where m.fecha between ?1 and ?2 and m.cuenta.numeroCuenta=?3")
	List<Movimiento> findMovimientosCuentaFechas(Date fechaInicio, Date fechaFin, int numeroCuenta);
}
