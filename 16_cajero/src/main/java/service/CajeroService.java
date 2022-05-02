package service;

import dto.CuentaDto;
import dto.MovimientoDto;
import model.Movimiento;

public interface CajeroService {
	
	CuentaDto validarCuenta(int numeroCuenta);
	void ingreso(MovimientoDto m);
	void extraccion(MovimientoDto m);

}
