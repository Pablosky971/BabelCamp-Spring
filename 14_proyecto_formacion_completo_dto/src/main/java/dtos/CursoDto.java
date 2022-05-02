package dtos;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Alumno;
import model.Curso;


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
	private List<String> alumnos;

}
