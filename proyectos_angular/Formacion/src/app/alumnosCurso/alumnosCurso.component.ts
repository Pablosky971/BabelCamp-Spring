import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Alumno } from 'src/app/model/Alumno';
import { Curso } from 'src/app/model/Curso';
import { FormacionService } from 'src/app/service/formacion.service';

@Component({
  selector: 'app-alumnosCurso',
  templateUrl: './alumnosCurso.component.html',
  styleUrls: ['./alumnosCurso.component.css']
})
export class AlumnosCursoComponent implements OnInit {

  listaCursos: Curso[]|undefined;
  nombre:string="";
  alumnos:Alumno[]|undefined;
  curso: string;
 

  constructor(private _formacionService: FormacionService, private router:Router) {

    _formacionService.listarCursos().subscribe(data => this.listaCursos=data);
   }

   buscarAlumnosCurso() {
   
    this._formacionService.buscarAlumnosCurso(this.curso).subscribe(data => this.alumnos=data);
  }
  ngOnInit() {
  }

  volver() {
    this.router.navigate(['']);
  }
}
