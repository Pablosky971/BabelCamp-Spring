package converters;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import dtos.AlumnoDto;
import dtos.CursoDto;
import model.Alumno;
import model.Curso;

// Para que Spring pueda instanciar la clase:
@Component
public class ConversorEntityDtoImpl implements ConversorEntityDto {

	// Convertir un objeto Curso en un Dto.
	public CursoDto cursoToDto(Curso curso) {
		
		return new CursoDto(curso.getIdCurso(),curso.getNombre(),curso.getDuracion(), curso.getPrecio(), curso.getFechaInicio(),
				curso.getAlumnos()
				.stream().map(a->a.getNombre())
				.collect(Collectors.toList()));
	}


	public Curso dtoToCurso(CursoDto dto) {
		
		return new Curso(dto.getIdCurso(),dto.getNombre(),dto.getDuracion(),dto.getPrecio(),dto.getFechaInicio());
	}

	
	public AlumnoDto alumnoToDto(Alumno alumno) {
		
		return new AlumnoDto(alumno.getUsuario(),alumno.getPassword(),alumno.getNombre(),alumno.getEmail(),alumno.getEdad());
	}

	
	public Alumno dtoToAlumno(AlumnoDto dto) {
		
		return new Alumno(dto.getUsuario(),dto.getPassword(),dto.getNombre(),dto.getEmail(),dto.getEdad());
	}

}
