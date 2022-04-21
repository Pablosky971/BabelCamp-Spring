import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Producto } from '../model/Producto';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {

  //url:string="http://localhost:8080/05_tienda_spring_ajax/Buscador";
  url:string="Buscador";


  constructor(private http:HttpClient) {}

    buscar(seccion:string) {

      // El tipo indicado entre los diamantes, es el tipo de salida.
      return this.http.get<Producto[]>(this.url,{params:{seccion:seccion}});
    }

   
}
