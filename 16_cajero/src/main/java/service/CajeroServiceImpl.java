package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import converter.ConversorEntityDto;
import dao.ClientesDao;
import dao.CuentasDao;
import dao.MovimientosDao;
import dto.CuentaDto;
import dto.MovimientoDto;
import model.Cuenta;
import model.Movimiento;
import model.Operacion;

@Service
public class CajeroServiceImpl implements CajeroService {
	
	@Autowired
	ConversorEntityDto conversor;
	
	ClientesDao clientesDao;
	
	CuentasDao cuentasDao;
	
	MovimientosDao movimientosDao;
	
	

	public CajeroServiceImpl(@Autowired ClientesDao clientesDao, @Autowired CuentasDao cuentasDao, @Autowired MovimientosDao movimientosDao) {
		super();
		this.clientesDao = clientesDao;
		this.cuentasDao = cuentasDao;
		this.movimientosDao = movimientosDao;
	}

	
	public boolean validarCuenta(int numeroCuenta) {
		
		Optional<Cuenta> cuenta = cuentasDao.findById(numeroCuenta);
		
		if(cuenta.isPresent()) {
		return true;
		}
		return false;
		
	}

	@Transactional
	public void ingreso(double cantidad, int numeroCuenta) {
		
		Optional<Cuenta> c = cuentasDao.findById(numeroCuenta);
		if(c.isPresent()) {
		Movimiento m = new Movimiento(numeroCuenta, new Date(), cantidad, "ingreso");
		movimientosDao.save(m);
		}
		 
		 cuentasDao.actualizarSumaCantidad(cantidad, numeroCuenta);
		
	}

	@Transactional
	public void extraccion(double cantidad, int numeroCuenta) {
		
		Optional<Cuenta> c = cuentasDao.findById(numeroCuenta);
		if(c.isPresent()) {
			Movimiento m = new Movimiento(numeroCuenta, new Date(), cantidad, "extraccion");
			movimientosDao.save(m);
			}
		
		 cuentasDao.actualizarRestaCantidad(cantidad, numeroCuenta);
		
	}


	
	@Transactional
	public void transferencia(double cantidad, int numeroCuentaRemitente, int numeroCuentaDestinatario) {
		
		ingreso(cantidad, numeroCuentaDestinatario);
		extraccion(cantidad, numeroCuentaRemitente);
			
	}


	
	public List<MovimientoDto> movimientos(Date fechaInicio, Date fechaFin, int numeroCuenta) {
		List<MovimientoDto> res = new ArrayList<>();
		List<Movimiento> movimientos = movimientosDao.findMovimientosCuentaFechas(fechaInicio, fechaFin, numeroCuenta);
		
		for(Movimiento m : movimientos) {
			MovimientoDto dto = conversor.movimientoToDto(m);
			res.add(dto);
		}

		 return res;
	}


	
	public double saldoCuenta(int numeroCuenta) {
		
		return cuentasDao.saldoCuenta(numeroCuenta);
	}


}
