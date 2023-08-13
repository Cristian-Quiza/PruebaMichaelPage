import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CrudProductoComponent } from './components/crud-producto/crud-producto.component';
import { CrudUsuarioComponent } from './components/crud-usuario/crud-usuario.component';

@NgModule({
  declarations: [
    AppComponent,
    CrudProductoComponent,
    CrudUsuarioComponent
  ],

  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
