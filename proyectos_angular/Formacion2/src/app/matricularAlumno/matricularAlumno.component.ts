import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';
import { Matricula } from '../model/Matricula';
import { FormacionService } from '../service/formacion.service';

@Component({
  selector: 'app-matricularAlumno',
  templateUrl: './matricularAlumno.component.html',
  styleUrls: ['./matricularAlumno.component.css']
})
export class MatricularAlumnoComponent implements OnInit {

  matriculas: Matricula[] | undefined;
  alumnos: Alumno[] | undefined;
  cursos: Curso[] = [];
  
  curso: string = '';
  alumno: string = '';
  idCurso: number = 0;


  constructor(private _formacionService: FormacionService, private router: Router) {
    _formacionService.listarAlumnos().subscribe((data) => (this.alumnos = data));
    _formacionService.listarCursos().subscribe((data) => (this.cursos = data));
  }
  ngOnInit() {
    
  }

  matricularAlumnoCurso() {
    this._formacionService
      .matricular(this.idCurso, this.alumno)
      .subscribe((data) => console.log(data));
    
  }
  
  volver() {
    this.router.navigate(['']);
  }

}
