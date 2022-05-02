package dto;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import modelo.Alumno;
import modelo.Curso;
import modelo.MatriculaPK;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MatriculaDto {


	private double nota;
	private CursoDto curso;
	private AlumnoDto alumno;
	
}
