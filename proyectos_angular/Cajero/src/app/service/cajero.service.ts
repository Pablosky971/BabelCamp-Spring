import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Movimiento } from '../model/Movimiento';
@Injectable({
  providedIn: 'root'
})
export class CajeroService {

  urlIngreso:string="http://localhost:8080/16_cajero/Ingreso";
  urlExtraccion:string="http://localhost:8080/16_cajero/Extraccion";
  urlTransferencia:string="http://localhost:8080/16_cajero/Transferencia";
  urlMovimientos:string="http://localhost:8080/16_cajero/Movimientos"


  constructor(private http: HttpClient) { }


  ingreso(cantidad:number, numeroCuenta:number) {
    return this.http.post(`${this.urlIngreso}?cantidad=${cantidad}&numeroCuenta=${numeroCuenta}`,null);
  }

  extraccion(cantidad:number, numeroCuenta:number) {
    return this.http.post(`${this.urlExtraccion}?cantidad=${cantidad}&numeroCuenta=${numeroCuenta}`,null);
  }

  transferencia(cantidad:number, numeroCuentaRemitente:number, numeroCuentaDestinatario:number) {
    return this.http.post(`${this.urlExtraccion}?cantidad=${cantidad}&numeroCuentaRemitente=${numeroCuentaRemitente}&numeroCuentaRemitente=${numeroCuentaRemitente}`,null);
  }

  movimientos(fechaInicio:string, fechaFin:string, numeroCuenta:number) {
    return this.http.get<Movimiento[]>(this.urlMovimientos,{
      params: {fechaInicio:fechaInicio, fechaFin:fechaFin, numeroCuenta:numeroCuenta},
    });
  }

}
