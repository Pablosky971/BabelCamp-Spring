import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import { FormacionService } from 'src/app/service/formacion.service';
import { Alumno } from 'src/app/model/Alumno';
import { Curso } from 'src/app/model/Curso';

@Component({
  selector: 'app-cursosAlumno',
  templateUrl: './cursosAlumno.component.html',
  styleUrls: ['./cursosAlumno.component.css']
})
export class CursosAlumnoComponent implements OnInit {

  listaAlumnos:Alumno[]|undefined;
  usuario: string;
  cursos: Curso[]|undefined;
  alumno: Alumno;
  constructor(private _formacionService: FormacionService) {

    _formacionService.listarAlumnos().subscribe(data => this.listaAlumnos=data);

   }

   buscarCursosAlumno() {

    this._formacionService.buscarCursosAlumno(this.usuario).subscribe(data => this.cursos=data);
  }

  ngOnInit() {
  }

}
