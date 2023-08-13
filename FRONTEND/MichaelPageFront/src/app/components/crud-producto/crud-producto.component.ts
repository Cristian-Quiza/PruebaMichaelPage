import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto.model';
import { Usuario } from 'src/app/models/usuario.model';
import { ProductoService } from 'src/app/services/producto.service';
import { UsuarioService } from 'src/app/services/usuario.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-crud-producto',
  templateUrl: './crud-producto.component.html',
  styleUrls: ['./crud-producto.component.css']
})
export class CrudProductoComponent implements OnInit {

  //Para la Grilla
  productos: Producto [] = [];
   filtro: string ="";

   //Para el usuario
   departamentos: string[] = [];;
   provincias: string[] = [];;
   distritos: Usuario[] = [];;


  //Json para registrar o actualizar
  producto: Producto = {
    idProducto:0,
    nombre:"",
    dni:"",
    estado:1,
    usuario:{
      idUsuario: -1,
      departamento:"-1",
      provincia:"-1",
      distrito:"-1",
    }
  };

  //Declaracion de validaciones
    formsRegistra = new FormGroup({
      validaNombre: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z ]{3,30}')]),
      validaDni: new FormControl('', [Validators.required,Validators.pattern('[0-9]{8}')]),
      validaDepartamento: new FormControl('', [Validators.min(1)]),
      validaProvincia: new FormControl('', [Validators.min(1)]),
      validaDistrito: new FormControl('', [Validators.min(1)]),
  });

  formsActualiza = new FormGroup({
    validaNombre: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z ]{3,30}')]),
    validaDni: new FormControl('', [Validators.required,Validators.pattern('[0-9]{8}')]),
    validaDepartamento: new FormControl('', [Validators.min(1)]),
    validaProvincia: new FormControl('', [Validators.min(1)]),
    validaDistrito: new FormControl('', [Validators.min(1)]),
    validaEstado: new FormControl('', [Validators.min(0)]),
  });

  //para verificar que e pulsó el boton
  submitted = false;

  constructor(private productoService:ProductoService, private usuarioService:UsuarioService) {
      this.usuarioService.listarDepartamento().subscribe(
          response => this.departamentos = response
      );
  }

  cargaProvincia(){
      this.usuarioService.listaProvincias(this.producto.usuario?.departamento).subscribe(
        response =>  this.provincias= response
      );

      this.producto!.usuario!.provincia = "-1";
      this.distritos = [];
      this.producto!.usuario!.idUsuario = -1;

  }

  cargaDistrito(){
    this.usuarioService.listaDistritos(this.producto.usuario?.departamento, this.producto.usuario?.provincia).subscribe(
      response =>  this.distritos= response
     );

     this.producto!.usuario!.idUsuario = -1;
   }

  ngOnInit(): void {
    this.consulta();
  }

  consulta(){
      this.productoService.listaProducto(this.filtro==""?"todos":this.filtro).subscribe(
            (x) => this.productos = x
      );
  }

  actualizaEstado(aux : Producto){
        aux.estado = aux.estado == 0? 1 :0;
        this.productoService.actualizaProducto(aux).subscribe();
  }

  registra(){
       this.submitted = true;

        //finaliza el método si hay un error
        if (this.formsRegistra.invalid){
         return;
        }

        this.submitted = false;

        this.productoService.registraProducto(this.producto).subscribe(
              (x) => {
                document.getElementById("btn_reg_cerrar")?.click();
                Swal.fire('Mensaje', x.mensaje,'success');
                this.productoService.listaProducto(this.filtro==""?"todos":this.filtro).subscribe(
                        (x) => this.productos = x
                );

              }
        );

        //limpiar los comobobox
        this.distritos = [];
        this.provincias = [];

        //limpiar los componentes del formulario a través de los ngModel

        this.producto = {
              idProducto:0,
              nombre:"",
              dni:"",
              estado:1,
              usuario:{
                idUsuario: -1,
                departamento:"-1",
                provincia:"-1",
                distrito:"-1",
              }
        }
  }

  buscar(aux :Producto){
        this.producto  = aux;

        this.usuarioService.listaProvincias(this.producto.usuario?.departamento).subscribe(
          response =>  this.provincias= response
        );

      this.usuarioService.listaDistritos(this.producto.usuario?.departamento, this.producto.usuario?.provincia).subscribe(
        response =>  this.distritos= response
      );

  }


  actualiza(){
    this.submitted = true;

    //finaliza el método si hay un error
    if (this.formsActualiza.invalid){
     return;
    }

    this.submitted = false;

    this.productoService.actualizaProducto(this.producto).subscribe(
          (x) => {
            document.getElementById("btn_act_cerrar")?.click();
            Swal.fire('Mensaje', x.mensaje,'success');
            this.productoService.listaProducto(this.filtro==""?"todos":this.filtro).subscribe(
                    (x) => this.productos = x
            );
          }
    );

    //limpiar los comobobox
    this.distritos = [];
    this.provincias = [];

    //limpiar los componentes del formulario a través de los ngModel

    this.producto = {
          idProducto:0,
          nombre:"",
          dni:"",
          estado:1,
          usuario:{
            idUsuario: -1,
            departamento:"-1",
            provincia:"-1",
            distrito:"-1",
          }
    }
}



elimina(aux :Producto){
      Swal.fire({
            title: '¿Estás Seguro?',
            text: "¡No se puede revertir!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sí, Elimínalo'
      }).then((result) => {
          if (result.isConfirmed) {
                this.productoService.eliminaProducto(aux.idProducto).subscribe(
                  (x) => {
                    Swal.fire('Mensaje',x.mensaje, 'success');
                    this.productoService.listaProducto(this.filtro==""?"todos":this.filtro).subscribe(
                            (x) => this.productos = x
                    );

                  }
                );
          }
      })
}



}



