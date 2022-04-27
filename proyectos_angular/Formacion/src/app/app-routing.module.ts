import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AlumnosCursoComponent } from './componentes/alumnosCurso/alumnosCurso/alumnosCurso.component';
import { CursosAlumnoComponent } from './componentes/cursosAlumno/cursosAlumno/cursosAlumno.component';

const routes: Routes = [
  
  {  path: '',
  component: AppComponent
},

{
  path: '/componentAlumnosCurso',
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

