import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movimiento } from '../model/Movimiento';
import { CajeroService } from '../service/cajero.service';

@Component({
  selector: 'app-movimientos',
  templateUrl: './movimientos.component.html',
  styleUrls: ['./movimientos.component.css']
})
export class MovimientosComponent implements OnInit {

  listaMovimientos:Movimiento[];
  numeroCuenta:number;
  fechaInicio:string;
  fechaFin:string;
  saldo:number;
  

  constructor(private cajeroService: CajeroService, private router:Router) { 

   
  }

  movimientos() {
    this.cajeroService.movimientos(this.fechaInicio,this.fechaFin,this.numeroCuenta).subscribe(data => this.listaMovimientos=data);
    this.cajeroService.saldoCuenta(this.numeroCuenta).subscribe(data => this.saldo=data);
  }

  volver() {
    this.router.navigate(['']);
  }

  ngOnInit() {
  }

}
