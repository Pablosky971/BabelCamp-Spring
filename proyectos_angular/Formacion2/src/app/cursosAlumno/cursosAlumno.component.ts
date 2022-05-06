import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import { FormacionService } from 'src/app/service/formacion.service';
import { Alumno } from 'src/app/model/Alumno';
import { Curso } from 'src/app/model/Curso';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cursosAlumno',
  templateUrl: './cursosAlumno.component.html',
  styleUrls: ['./cursosAlumno.component.css']
})
export class CursosAlumnoComponent implements OnInit {

  listaAlumnos: Alumno[]|undefined;
  curso: string="";
  cursos: Curso[]|undefined;
  alumno:string="";

  constructor(private _formacionService: FormacionService, private router:Router) {

    _formacionService.listarAlumnos().subscribe(data => this.listaAlumnos=data);

   }

   buscarCursosAlumno() {

    this._formacionService.buscarCursosAlumno(this.alumno).subscribe(data => this.cursos=data);
  }

  volver() {
    this.router.navigate(['']);
  }
  ngOnInit() {
  }

}
