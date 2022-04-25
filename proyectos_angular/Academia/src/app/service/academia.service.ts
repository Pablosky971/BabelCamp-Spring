import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Alumno } from '../model/Alumno';

@Injectable({
  providedIn: 'root'
})
export class AcademiaService {

  
  urlCursos:string="Cursos";
  urlBuscar:string="Buscar";
  cursos:string[]|undefined;



  constructor(private http:HttpClient) {}

    listarCursos() {
  
      // El tipo indicado entre los diamantes, es el tipo de salida.
      return this.http.get<string[]>(this.urlCursos);
    }

    buscar(curso:string) {

      // El tipo indicado entre los diamantes, es el tipo de salida.
      return this.http.get<Alumno[]>(this.urlBuscar,{params:{curso:curso}});
    }

    //add(nombre:string, curso:string, nota:number) {
      //const headers= new HttpHeaders()
      //.set('content-type', 'application/json')
      //.set('Access-Control-Allow-Origin', '*');

      //let jsonAlumno = { nombre: nombre, curso: curso, nota: nota};

      //return this.http.post<any>(this.urlAdd, jsonAlumno,{ 'headers': headers })
    //}
}
