package converter;

import dto.ClienteDto;
import dto.CuentaDto;
import dto.MovimientoDto;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;

public interface ConversorEntityDto {

	public ClienteDto clienteToDto(Cliente cliente);
	public Cliente dtoToCliente(ClienteDto dto);
	
	public CuentaDto cuentaToDto(Cuenta cuenta);
	public Cuenta dtoToCuenta(CuentaDto dto);
	
	public MovimientoDto movimientotoDto(Movimiento movimiento);
	public Movimiento dtoToMovimiento(MovimientoDto dto);
}
