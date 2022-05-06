import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AlumnosCursoComponent } from './alumnosCurso/alumnosCurso.component';
import { CursosAlumnoComponent } from './cursosAlumno/cursosAlumno.component';
import { MatricularAlumnoComponent } from './matricularAlumno/matricularAlumno.component';
import { ConsultarMatriculasComponent } from './consultarMatriculas/consultarMatriculas.component';

const routes: Routes = [
  
  

{
  path: 'componentAlumnosCurso',
  component: AlumnosCursoComponent
},

{
  path: 'componentCursosAlumno',
  component: CursosAlumnoComponent
},

{
  path : 'matricularAlumno',
  component : MatricularAlumnoComponent
},
{
  path : 'consultarMatriculas',
  component : ConsultarMatriculasComponent
},

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

