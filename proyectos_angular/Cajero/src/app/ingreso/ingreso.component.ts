import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CajeroService } from '../service/cajero.service';

@Component({
  selector: 'app-ingreso',
  templateUrl: './ingreso.component.html',
  styleUrls: ['./ingreso.component.css']
})
export class IngresoComponent implements OnInit {

  cantidad:number=0;
  numeroCuenta:number=0;
  

  constructor(private cajeroService: CajeroService, private router:Router) { }

  ingreso() {
    this.cajeroService.ingreso(this.cantidad,this.numeroCuenta);
  }

  volver() {
    this.router.navigate(['']);
  }

  ngOnInit() {
  }

}
