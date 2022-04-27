import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';


@Injectable({
  providedIn: 'root'
})
export class FormacionService {

  urlAlumnos:string="Alumnos";
  urlCursos:string="Cursos";
  urlAlumnosCurso:string="AlumnosCurso"
  urlCursoAlumnos:string="CursoAlumnos"
  

  cursos:Curso[]|undefined;
  alumnos:Alumno[]|undefined;


  constructor(private http:HttpClient) {}
   
  listarCursos() {
  
      
    return this.http.get<Curso[]>(this.urlCursos);
  }

  listarAlumnos() {

    
    return this.http.get<Alumno[]>(this.urlAlumnos);
  }


  buscarAlumnosCurso(nombre:string) {

    // El tipo indicado entre los diamantes, es el tipo de salida.
    return this.http.get<Alumno[]>(this.urlAlumnosCurso,{params:{nombre:nombre}});
  }

  buscarCursosAlumno(usuario:string) {

    // El tipo indicado entre los diamantes, es el tipo de salida.
    return this.http.get<Curso[]>(this.urlAlumnosCurso,{params:{usuario:usuario}});
  }
}
