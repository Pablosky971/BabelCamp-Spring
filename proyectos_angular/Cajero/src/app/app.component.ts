import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CajeroService } from './service/cajero.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
 


  constructor(private cajeroService: CajeroService, private router: Router) {
    
  }
  enrutarIngreso() {
    this.router.navigate(['/ingreso']);
  }

  enrutarExtraccion() {
    this.router.navigate(['/extraccion']);
  }

  enrutarTransferencia() {
    this.router.navigate(['/transferencia']);
  }

  enrutarMovimientos() {
    this.router.navigate(['/movimientos']);
  }

  routeindex() {
    this.router.navigate(['']);
  }
}
