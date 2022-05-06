import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlumnosCursoComponent } from './alumnosCurso/alumnosCurso.component';
import { CursosAlumnoComponent } from './cursosAlumno/cursosAlumno.component';
import { MatricularAlumnoComponent } from './matricularAlumno/matricularAlumno.component';
import { ConsultarMatriculasComponent } from './consultarMatriculas/consultarMatriculas.component';

@NgModule({
  declarations: [		
    AppComponent,
    AlumnosCursoComponent,
    CursosAlumnoComponent,
      MatricularAlumnoComponent,
      ConsultarMatriculasComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, 
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
