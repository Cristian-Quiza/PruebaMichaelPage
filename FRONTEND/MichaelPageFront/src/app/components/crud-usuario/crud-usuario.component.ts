import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2'


interface Producto {
  idProducto: number;
  nombre: string;
  precio: number;
  cantidadStock: number;
  cantidadDeseos?: number;
}


@Component({
  selector: 'app-crud-usuario',
  templateUrl: './crud-usuario.component.html',
  styleUrls: ['./crud-usuario.component.css']
})
export class CrudUsuarioComponent implements OnInit {


  ngOnInit(): void {
  }

  productos: Producto[] = [
    { idProducto: 1, nombre: 'Producto 1', precio: 10, cantidadStock: 5 },
    { idProducto: 2, nombre: 'Producto 2', precio: 15, cantidadStock: 8 },
    { idProducto: 3, nombre: 'Producto 3', precio: 20, cantidadStock: 3 },
    { idProducto: 4, nombre: 'Producto 4', precio: 25, cantidadStock: 10 },
  ];

  listaDeseos: Producto[] = [];

  filtro: string = "";

  constructor() { }

  consulta() {
    this.productos = this.productos.filter(producto => producto.nombre.toLowerCase().includes(this.filtro.toLowerCase()));
  }


  agregarDeseo(producto: Producto) {
    if (producto.cantidadStock > 0) {
      // Verificamos que haya stock disponible
      producto.cantidadStock--; // Disminuimos la cantidad en stock del producto
      producto.cantidadDeseos = producto.cantidadDeseos ? producto.cantidadDeseos + 1 : 1; // Aumentamos la cantidad de deseos del producto
      this.listaDeseos.push(producto);
      Swal.fire({
        title: 'Producto Agregado',
        text: 'El producto se agregó a la lista de deseos',
        icon: 'success',
      });
    } else {
      Swal.fire({
        title: 'Sin Stock',
        text: 'El producto no tiene stock disponible',
        icon: 'error',
      });
    }
  }
  eliminarDeseo(deseo: Producto): void {
    const index = this.listaDeseos.findIndex((item) => item.idProducto === deseo.idProducto);
    if (index !== -1) {
      const producto = this.productos.find((item) => item.idProducto === deseo.idProducto);
      if (producto) {
        producto.cantidadStock += deseo.cantidadDeseos || 0; // Restauramos la cantidad en stock del producto
        delete deseo.cantidadDeseos; // Eliminamos la propiedad cantidadDeseos del objeto deseo
      }
      this.listaDeseos.splice(index, 1);
      Swal.fire({
        title: 'Producto Eliminado',
        text: 'El producto se eliminó de la lista de deseos',
        icon: 'success',
      });
    }
  }
 }


