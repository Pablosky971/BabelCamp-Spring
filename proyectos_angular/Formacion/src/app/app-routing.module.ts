import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AlumnosCursoComponent } from './alumnosCurso/alumnosCurso.component';
import { CursosAlumnoComponent } from './cursosAlumno/cursosAlumno.component';

const routes: Routes = [
  
  

{
  path: 'componentAlumnosCurso',
  component: AlumnosCursoComponent
},

{
  path: 'componentCursosAlumno',
  component: CursosAlumnoComponent
},


];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

