package dto;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import modelo.Matricula;

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
