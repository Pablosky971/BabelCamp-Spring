package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Cuenta;


public interface CuentasDao extends JpaRepository<Cuenta, Integer> {

  @Query("select c from Cuenta c join c.movimientos m where m.idCuenta = ?1")
  Cuenta cuentaMovimiento(int numeroCuenta);
	
}
