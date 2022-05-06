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
		
		return new Cliente(dto.getDni(),dto.getNombre(),dto.getDireccion(),dto.getTelefono(), null);
	}


	public CuentaDto cuentaToDto(Cuenta cuenta) {
		
		return new CuentaDto(cuenta.getNumeroCuenta(),cuenta.getSaldo(),cuenta.getTipoCuenta());
	}


	public Cuenta dtoToCuenta(CuentaDto dto) {
		
		return new Cuenta(dto.getNumeroCuenta(),dto.getSaldo(),dto.getTipoCuenta());
	}


	public MovimientoDto movimientoToDto(Movimiento movimiento) {
	
		return new MovimientoDto(movimiento.getIdMovimiento(),movimiento.getIdCuenta(),movimiento.getFecha(),movimiento.getCantidad(),movimiento.getOperacion(),cuentaToDto(movimiento.getCuenta()));
	}

	public Movimiento dtoToMovimiento(MovimientoDto dto) {
		
		return new Movimiento(dto.getIdMovimiento(),dto.getIdCuenta(),dto.getFecha(),dto.getCantidad(),dto.getOperacion(), dtoToCuenta(dto.getCuenta()));
	}

	

}
