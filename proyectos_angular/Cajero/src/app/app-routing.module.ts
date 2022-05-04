import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExtraccionComponent } from './extraccion/extraccion.component';
import { IngresoComponent } from './ingreso/ingreso.component';
import { MovimientosComponent } from './movimientos/movimientos.component';
import { TransferenciaComponent } from './transferencia/transferencia.component';

const routes: Routes = [

  {
    path : 'ingreso',
    component : IngresoComponent
  },

  {
    path : 'extraccion',
    component : ExtraccionComponent
  },

  {
    path : 'transferencia',
    component : TransferenciaComponent
  },

  {
    path : 'movimientos',
    component : MovimientosComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
