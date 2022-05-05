package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MatriculaDto {


	private double nota;
	@JsonProperty("curso")
	private CursoDto curso;
	@JsonProperty("alumno")
	private AlumnoDto alumno;
	
}
