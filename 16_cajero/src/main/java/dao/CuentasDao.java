package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import model.Cuenta;


public interface CuentasDao extends JpaRepository<Cuenta, Integer> {

@Query("select c.saldo from Cuenta c where c.numeroCuenta=?1")
double saldoCuenta(int numeroCuenta);

@Modifying
  @Query("update Cuenta c set c.saldo=c.saldo+?1 where c.numeroCuenta=?2")
  void actualizarSumaCantidad(double cantidad, int numeroCuenta);
  
@Modifying
  @Query("update Cuenta c set c.saldo=c.saldo-?1 where c.numeroCuenta=?2")
  void actualizarRestaCantidad(double cantidad, int numeroCuenta);
}
