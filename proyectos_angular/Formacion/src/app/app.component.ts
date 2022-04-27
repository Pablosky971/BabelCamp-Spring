import { Component } from '@angular/core';
import { Alumno } from './model/Alumno';
import { Curso } from './model/Curso';

import { FormacionService } from 'src/app/service/formacion.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  listaAlumnos: Alumno[]|undefined;
  
  cursos: Curso[]|undefined;
  

  nombre:string;
  usuario:string;

  constructor(private _formacionService: FormacionService){

  }

}

  