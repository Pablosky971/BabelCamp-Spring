package service;

import java.util.Date;
import java.util.List;

import dto.CuentaDto;
import dto.MovimientoDto;

public interface CajeroService {
	
	boolean validarCuenta(int numeroCuenta);
	void ingreso(double cantidad, int numeroCuenta);
	void extraccion(double cantidad, int numeroCuenta);
	void transferencia(double cantidad, int numeroCuentaRemitente, int numeroCuentaDestinatario);
	List<MovimientoDto> movimientos(Date fechaInicio, Date fechaFin, int numeroCuenta);
	double saldoCuenta(int numeroCuenta);

}
