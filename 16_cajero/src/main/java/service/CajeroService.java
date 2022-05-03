package service;

import java.util.Date;
import java.util.List;

import dto.CuentaDto;
import dto.MovimientoDto;

public interface CajeroService {
	
	CuentaDto validarCuenta(int numeroCuenta);
	void ingreso(MovimientoDto m);
	void extraccion(MovimientoDto m);
	void transferencia(MovimientoDto movimientoIngreso, MovimientoDto movimientoExtraccion);
	List<MovimientoDto> movimientos(Date fechaInicio, Date fechaFin, int numeroCuenta);
	double saldoCuenta(int numeroCuenta);

}
