package service;

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

@Service
public class CajeroServiceImpl implements CajeroService {
	
	@Autowired
	ConversorEntityDto conversor;
	
	ClientesDao clienteDao;
	
	CuentasDao cuentaDao;
	
	MovimientosDao movimientoDao;
	
	

	public CajeroServiceImpl(@Autowired ClientesDao clienteDao, @Autowired CuentasDao cuentaDao, @Autowired MovimientosDao movimientoDao) {
		super();
		this.clienteDao = clienteDao;
		this.cuentaDao = cuentaDao;
		this.movimientoDao = movimientoDao;
	}

	
	public CuentaDto validarCuenta(int numeroCuenta) {
		
		Optional<Cuenta> cuenta = cuentaDao.findById(numeroCuenta);
		
		if(cuenta.isPresent())
		return conversor.cuentaToDto(cuenta.get());
		
		return null;
		
	}

	
	public void ingreso(MovimientoDto m) {
		
		 movimientoDao.save(conversor.dtoToMovimiento(m));
		 
		 Cuenta c = cuentaDao.cuentaMovimiento(m.getCuenta().getNumeroCuenta());
		 cuentaDao.save(c);
		 
		 
		
		
	}


	public boolean extraccion(MovimientoDto m) {
		
		return false;
	}
	

}
