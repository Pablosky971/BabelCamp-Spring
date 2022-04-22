import { Component } from '@angular/core';
import { Alumno } from './model/Alumno';
import { AcademiaService } from 'src/app/service/academia.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  listaCursos: String[]|undefined;
  curso: string="";
  alumnos: Alumno[]|undefined;

  constructor(private _academiaService: AcademiaService){

    _academiaService.listarCursos().subscribe(data => this.listaCursos=data);
  

  }

  buscarCurso() {

    this._academiaService.buscar(this.curso).subscribe(data => this.alumnos=data)
  }

}
