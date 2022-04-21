import { Component } from '@angular/core';
import { Alumno } from './model/Alumno';
import { AcademiaService } from 'src/app/service/academia.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  listaCursos: string[];

  constructor(private _academiaService: AcademiaService){

    this._academiaService.listarCursos.subscribe(data => );
    this._academiaService = _academiaService;
   
    


  }

  buscarCurso(curso:string) {

    this.


    
  }

}
