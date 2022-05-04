import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CajeroService } from '../service/cajero.service';

@Component({
  selector: 'app-transferencia',
  templateUrl: './transferencia.component.html',
  styleUrls: ['./transferencia.component.css']
})
export class TransferenciaComponent implements OnInit {
  cantidad:number=0;
  numeroCuentaRemitente:number=0;
  numeroCuentaDestinatario:number=0;
  

  constructor(private cajeroService: CajeroService, private router:Router) { }

  transferir() {
    this.cajeroService.transferencia(this.cantidad,this.numeroCuentaRemitente,this.numeroCuentaDestinatario);
  }

  volver() {
    this.router.navigate(['']);
  }
  

  ngOnInit() {
  }

}
