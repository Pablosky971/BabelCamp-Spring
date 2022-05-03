package model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="movimientos")
public class Movimiento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMovimiento;
	private double cantidad;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private Operacion operacion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idCuenta", referencedColumnName="numeroCuenta",insertable=false,updatable=false)
	Cuenta cuenta;

	public Movimiento(int idMovimiento, double cantidad, Date date, Operacion operacion) {
		this.idMovimiento=idMovimiento;
		this.cantidad=cantidad;
		this.fecha=date;
		this.operacion=operacion;
	}
}
