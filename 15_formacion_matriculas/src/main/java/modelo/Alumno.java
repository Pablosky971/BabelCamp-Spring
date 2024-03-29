package modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="alumnos")
public class Alumno {
		
		@Id
		private String usuario;
		private String password;
		private String nombre;
		private String email;
		private Integer edad;
		@OneToMany(mappedBy="alumno")
		private List<Matricula> matriculas;
		
		public Alumno(String usuario, String password, String nombre, String email, Integer edad) {
			super();
			this.usuario = usuario;
			this.password = password;
			this.nombre = nombre;
			this.email = email;
			this.edad = edad;
		}
		
	
		

}
