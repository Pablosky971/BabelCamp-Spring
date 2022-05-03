package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import converter.ConversorEntityDto;
import dao.ClientesDao;
import dao.CuentasDao;
import dao.MovimientosDao;
import dto.CuentaDto;
import dto.MovimientoDto;
import model.Cuenta;
import model.Movimiento;

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

	
	public CuentaDto validarCuenta(int numeroCuenta) {
		
		Optional<Cuenta> cuenta = cuentasDao.findById(numeroCuenta);
		
		if(cuenta.isPresent())
		return conversor.cuentaToDto(cuenta.get());
		
		return null;
		
	}

	
	public void ingreso(MovimientoDto m) {
		
		 movimientosDao.save(conversor.dtoToMovimiento(m));
		 cuentasDao.ingreso(m.getCantidad(), m.getCuenta().getNumeroCuenta());
		
	}


	public void extraccion(MovimientoDto m) {
		
		 movimientosDao.save(conversor.dtoToMovimiento(m));
		 cuentasDao.extraccion(m.getCantidad(), m.getCuenta().getNumeroCuenta());
		
	}


	

	public void transferencia(MovimientoDto movimientoIngreso, MovimientoDto movimientoExtraccion) {
		
		this.ingreso(movimientoIngreso);
		this.extraccion(movimientoExtraccion);
		
		
		
	}


	@Override
	public List<MovimientoDto> movimientos(Date fechaInicio, Date fechaFin, int numeroCuenta) {
		List<MovimientoDto> res = new ArrayList<>();
		List<Movimiento> movimientos = movimientosDao.findMovimientosCuentaFechas(fechaInicio, fechaFin, numeroCuenta);
		
		for(Movimiento m : movimientos) {
			MovimientoDto dto = conversor.movimientoToDto(m);
			res.add(dto);
		}

		 return res;
	}


	@Override
	public double saldoCuenta(int numeroCuenta) {
		
		return cuentasDao.saldoCuenta(numeroCuenta);
	}


}
