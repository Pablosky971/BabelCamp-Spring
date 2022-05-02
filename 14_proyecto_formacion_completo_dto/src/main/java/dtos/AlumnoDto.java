package dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Curso;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlumnoDto {

	private String usuario;
	private String password;
	private String nombre;
	private String email;
	private Integer edad;
}
