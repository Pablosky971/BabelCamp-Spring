package dto;


import java.util.Date;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@Id
	private int idMovimiento;
	private double cantidad;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date fecha;
	private Operacion operacion;
	private CuentaDto cuenta;

}
