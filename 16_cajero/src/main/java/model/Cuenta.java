package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="cuentas")
public class Cuenta {
	
	
	private int numeroCuenta;
	private double saldo;
	private String tipoCuenta;
	
	@OneToMany(mappedBy="cuenta")
	List<Movimiento> movimientos;


	public Cuenta(int numeroCuenta, double saldo, String tipoCuenta) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
	}

}