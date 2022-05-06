import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';


@Injectable({
  providedIn: 'root'
})
export class FormacionService {

  urlAlumnos:string="http://localhost:8080/12_proyecto_formacion_spring_data_jpa/Alumnos";
  urlCursos:string="http://localhost:8080/12_proyecto_formacion_spring_data_jpa/Cursos";
  urlAlumnosCurso:string="http://localhost:8080/12_proyecto_formacion_spring_data_jpa/AlumnosCurso";
  urlCursoAlumnos:string="http://localhost:8080/12_proyecto_formacion_spring_data_jpa/CursoAlumnos";
  

  cursos:string[]|undefined;

  constructor(private http:HttpClient) {}
   
  listarCursos() {
  
      
    return this.http.get<Curso[]>(this.urlCursos);
  }

  listarAlumnos() {

    
    return this.http.get<Alumno[]>(this.urlAlumnos);
  }


  buscarAlumnosCurso(curso:string) {

    // El tipo indicado entre los diamantes, es el tipo de salida.
    return this.http.get<Alumno[]>(this.urlAlumnosCurso,{params:{nombre:curso}});
  }

  buscarCursosAlumno(usuario:string) {

    // El tipo indicado entre los diamantes, es el tipo de salida.
    return this.http.get<Curso[]>(this.urlAlumnosCurso,{params:{usuario:usuario}});
  }
}
