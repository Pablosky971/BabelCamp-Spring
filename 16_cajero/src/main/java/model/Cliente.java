package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="clientes")
public class Cliente {
	@Id
	private int dni;
	private String nombre;
	private String direccion;
	private int telefono;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "titulares",
	joinColumns = @JoinColumn(name = "idCliente", referencedColumnName = "dni"),
	inverseJoinColumns = @JoinColumn(name = "idCuenta", referencedColumnName = "numeroCuenta"))
	private List<Cuenta> cuentas;
	
	
	
	
	
	
	
}
