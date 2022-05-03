package dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import model.Operacion;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovimientoDto {
	
	
	private int idMovimiento;
	private double cantidad;
	private Date fecha;
	private Operacion operacion;
	private CuentaDto cuenta;

}
