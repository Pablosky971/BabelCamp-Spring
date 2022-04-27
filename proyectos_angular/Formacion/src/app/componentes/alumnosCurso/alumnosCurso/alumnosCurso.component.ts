import { Component, OnInit } from '@angular/core';
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
  nombre:string
  alumnos:Alumno[]|undefined;
  curso: Curso;
 

  constructor(private _formacionService: FormacionService) {

    _formacionService.listarCursos().subscribe(data => this.listaCursos=data);
   }

   buscarAlumnosCurso() {
   
    this._formacionService.buscarAlumnosCurso(this.nombre).subscribe(data => this.alumnos=data);
  }
  ngOnInit() {
  }

}
