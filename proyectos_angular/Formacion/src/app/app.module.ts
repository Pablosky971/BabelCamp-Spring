import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlumnosCursoComponent } from './componentes/alumnosCurso/alumnosCurso/alumnosCurso.component';
import { CursosAlumnoComponent } from './componentes/cursosAlumno/cursosAlumno/cursosAlumno.component';

@NgModule({
  declarations: [
    AppComponent,
    AlumnosCursoComponent,
    CursosAlumnoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
