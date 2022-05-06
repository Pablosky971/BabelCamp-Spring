import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Alumno } from '../model/Alumno';
import { Curso } from '../model/Curso';
import { Matricula } from '../model/Matricula';
import { FormacionService } from '../service/formacion.service';

@Component({
  selector: 'app-consultarMatriculas',
  templateUrl: './consultarMatriculas.component.html',
  styleUrls: ['./consultarMatriculas.component.css']
})
export class ConsultarMatriculasComponent implements OnInit {


  matriculas: Matricula[] | undefined;
  alumnos: Alumno[] | undefined;
  cursos: Curso[] | undefined;

  fechaInicio: string = '';
  fechaFin: string = '';

  cursosAlumno: Curso[] | undefined;
  alumnosString: String[] | undefined;

  constructor(private _formacionService: FormacionService, private router: Router) {}
 
  volver() {
    this.router.navigate(['']);
  }

  consultarMatriculas() {
  
    this._formacionService
      .matriculas(this.fechaInicio, this.fechaFin)
      .subscribe((data) => (this.matriculas = data));
   
  }

  ngOnInit() {
  }

}
