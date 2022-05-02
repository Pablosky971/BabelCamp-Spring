package converter;

import org.springframework.stereotype.Component;

import dto.ClienteDto;
import dto.CuentaDto;
import dto.MovimientoDto;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;

@Component
public class ConversorEntityDtoImpl implements ConversorEntityDto {

	
	public ClienteDto clienteToDto(Cliente cliente) {
		
		return new ClienteDto(cliente.getDni(),cliente.getNombre(),cliente.getDireccion(),cliente.getTelefono());
	}

	public Cliente dtoToCliente(ClienteDto dto) {
		
		return new Cliente(dto.getDni(),dto.getNombre(),dto.getDireccion(),dto.getTelefono());
	}


	public CuentaDto cuentaToDto(Cuenta cuenta) {
		
		return new CuentaDto(cuenta.getNumeroCuenta(),cuenta.getSaldo(),cuenta.getTipoCuenta());
	}


	public Cuenta dtoToCuenta(CuentaDto dto) {
		
		return new Cuenta(dto.getNumeroCuenta(),dto.getSaldo(),dto.getTipoCuenta());
	}


	public MovimientoDto movimientotoDto(Movimiento movimiento) {
	
		return new MovimientoDto(movimiento.getIdMovimiento(),movimiento.getCantidad(),movimiento.getFecha(),movimiento.getOperacion(),movimiento.getCuenta());
	}

	public Movimiento dtoToMovimiento(MovimientoDto dto) {
		
		return new Movimiento(dto.getIdMovimiento(),dto.getCantidad(),dto.getFecha(),dto.getOperacion());
	}

}
