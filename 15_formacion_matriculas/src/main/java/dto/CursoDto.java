package dto;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import modelo.Matricula;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CursoDto {
	
	
	private int idCurso;
	private String nombre;
	private int duracion;
	private double precio;
	private Date fechaInicio;

	

	
}
	
	
