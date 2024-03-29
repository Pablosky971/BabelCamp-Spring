package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Id
	private int numeroCuenta;
	private double saldo;
	private String tipoCuenta;
	
	@OneToMany(mappedBy="cuenta")
	@JsonIgnore
	List<Movimiento> movimientos;

	@ManyToMany(mappedBy="cuentas")
	private List<Cliente> clientes;

	public Cuenta(int numeroCuenta, double saldo, String tipoCuenta) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
	}

}
