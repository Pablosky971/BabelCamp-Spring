import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CajeroService } from '../service/cajero.service';

@Component({
  selector: 'app-extraccion',
  templateUrl: './extraccion.component.html',
  styleUrls: ['./extraccion.component.css']
})
export class ExtraccionComponent implements OnInit {
  cantidad:number=0;
  numeroCuenta:number=0;
  

  constructor(private cajeroService: CajeroService, private router:Router) { }

  extraccion() {
    this.cajeroService.extraccion(this.cantidad,this.numeroCuenta);
  }

  volver() {
    this.router.navigate(['']);
  }

  ngOnInit() {
  }

}
