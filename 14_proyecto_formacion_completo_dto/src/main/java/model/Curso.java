package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name="cursos")
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCurso;
	private String nombre;
	private int duracion;
	private double precio;
	@Temporal(TemporalType.DATE) // Es recomendable, aunque no obligatorio, especificar el tipo de fecha concreto que se devuelve.
	private Date fechaInicio;
	
	// Clave ajena:
	@ManyToMany(mappedBy="cursos")
	private List<Alumno> alumnos;
	
	// Incluimos estos constructores extra por si acaso.

	public Curso(int idCurso, String nombre, int duracion, double precio, Date fechaInicio) {
		super();
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
	}
	
	public Curso(String nombre, int duracion, double precio, Date fechaInicio) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
	}
	
	
	
}
	
	
