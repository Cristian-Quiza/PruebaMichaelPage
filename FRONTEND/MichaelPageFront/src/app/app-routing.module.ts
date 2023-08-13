import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { CrudProductoComponent } from './components/crud-producto/crud-producto.component';
import { CrudUsuarioComponent } from './components/crud-usuario/crud-usuario.component';


const routes: Routes = [
  {path:"crProducto", component:CrudProductoComponent },
  {path:"crUsuario", component:CrudUsuarioComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
