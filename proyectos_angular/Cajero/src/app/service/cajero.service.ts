import { Injectable } from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders} from '@angular/common/http';
import { Movimiento } from '../model/Movimiento';
@Injectable({
  providedIn: 'root'
})
export class CajeroService {

  urlIngreso:string="http://localhost:8080/16_cajero/Ingreso";
  urlExtraccion:string="http://localhost:8080/16_cajero/Extraccion";
  urlTransferencia:string="http://localhost:8080/16_cajero/Transferencia";
  urlMovimientos:string="http://localhost:8080/16_cajero/Movimientos";
  urlSaldoCuenta:string="http://localhost:8080/16_cajero/SaldoCuenta";


  constructor(private http: HttpClient) { }

  
  ingreso(cantidad:number, numeroCuenta:number) {
    
    let parametros=new HttpParams();
    parametros=parametros.set("cantidad",cantidad);
    parametros=parametros.set("numeroCuenta",numeroCuenta);
    let heads=new HttpHeaders();
    heads.set('Content-Type','application/x-www-form-urlencoded');

    return this.http.post<String>(this.urlIngreso,parametros,{headers:heads});
  }

  extraccion(cantidad:number, numeroCuenta:number) {

    let parametros=new HttpParams();
    parametros=parametros.set("cantidad",cantidad);
    parametros=parametros.set("numeroCuenta",numeroCuenta);
    let heads=new HttpHeaders();
    heads.set('Content-Type','application/x-www-form-urlencoded');

    return this.http.post<String>(this.urlExtraccion,parametros,{headers:heads});
    
  }

  transferencia(cantidad:number, numeroCuentaRemitente:number, numeroCuentaDestinatario:number) {
    let parametros=new HttpParams();
    parametros=parametros.set("cantidad",cantidad);
    parametros=parametros.set("numeroCuentaRemitente",numeroCuentaRemitente);
    parametros=parametros.set("numeroCuentaDestinatario",numeroCuentaDestinatario);
    let heads=new HttpHeaders();
    heads.set('Content-Type','application/x-www-form-urlencoded');

    return this.http.post<String>(this.urlTransferencia,parametros,{headers:heads});
    
  }

  movimientos(fechaInicio:string, fechaFin:string, numeroCuenta:number) {
    return this.http.get<Movimiento[]>(this.urlMovimientos,{
      params: {fechaInicio:fechaInicio, fechaFin:fechaFin, numeroCuenta:numeroCuenta},
    });
  }

  saldoCuenta(numeroCuenta:number) {
    return this.http.get<number>(this.urlSaldoCuenta,{
      params: {numeroCuenta:numeroCuenta},
    });
  }
}
