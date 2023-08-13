import { Usuario } from "./usuario.model";

export class Producto {


    idProducto?:number;
    nombre?:string;
    precio?:number;
    cantidadStock?:number;
    usuario?:Usuario;
    dni?:string;
    estado?:number;

}
