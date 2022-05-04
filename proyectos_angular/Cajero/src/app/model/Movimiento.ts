import { Cuenta } from "./Cuenta";

export class Movimiento {

    idMovimiento:number = 0;
	cantidad:number = 0;
	fecha: Date;
    operacion:string="";
    cuenta:Cuenta;
}