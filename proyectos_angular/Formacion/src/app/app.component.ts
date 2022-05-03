import { Component } from '@angular/core';
import { Alumno } from './model/Alumno';
import { Curso } from './model/Curso';

import { FormacionService } from 'src/app/service/formacion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  listaAlumnos: Alumno[]|undefined;
  listaCursos: Curso[]|undefined;
  curso: string = '';
  alumno: string = '';
  alumnosCurso: Alumno[] | undefined;
  cursosAlumno: Curso[] | undefined;

  constructor(private _formacionService: FormacionService, private router : Router) {

    _formacionService.listarCursos().subscribe((data) => (this.listaCursos = data));
    _formacionService.listarAlumnos().subscribe((data) => (this.listaAlumnos = data));

  }

  
  busquedaAlumnosCurso() {
    this._formacionService
      .buscarAlumnosCurso(this.curso)
      .subscribe((data) => (this.alumnosCurso = data));
   
  }

  busquedaCursosAlumno() {
    this._formacionService
      .buscarCursosAlumno(this.alumno)
      .subscribe((data) => (this.cursosAlumno = data));
    
  }

  enrutarAlumnosCurso() {
    this.router.navigate(['componentAlumnosCurso']);
  }

  enrutarCursosAlumno() {
    this.router.navigate(['componentCursosAlumno']);
  }
  volver() {
    this.router.navigate(['']);
  }

}

  