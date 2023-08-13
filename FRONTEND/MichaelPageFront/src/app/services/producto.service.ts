import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../models/producto.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class ProductoService {

  private apiServerURL = environment.apiBaseURL;

  constructor(private http:HttpClient) { }


  listaProducto(filtro:string):Observable<Producto[]> {
      return this.http.get<Producto[]>(this.apiServerURL + "/rest/crudProducto/listaProductoPorNombreLike/"+ filtro);
  }

  registraProducto(obj: Producto): Observable<any>{
      return this.http.post(this.apiServerURL + "/rest/crudProducto/registraProducto", obj);
  }

  actualizaProducto(obj: Producto): Observable<any>{
    return this.http.put(this.apiServerURL + "/rest/crudProducto/actualizaProducto", obj);
  }

  eliminaProducto(id: any): Observable<any>{
    return this.http.delete(this.apiServerURL + "/rest/crudProducto/eliminaProducto/" + id);
  }

}
