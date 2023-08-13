import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../models/usuario.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class UsuarioService {

  private apiServerURL = environment.apiBaseURL;

  constructor(private http: HttpClient) {}
  listarNombres(): Observable<string[]> {
    return this.http.get<string[]>(this.apiServerURL + '/rest/util/listaNombres');
  }

  listarTelefonos(): Observable<string[]> {
    return this.http.get<string[]>(this.apiServerURL + '/rest/util/listaTelefonos');
  }

  listarDirecciones(): Observable<string[]> {
    return this.http.get<string[]>(this.apiServerURL + '/rest/util/listaDirecciones');
  }

  listarDepartamento(): Observable<string[]> {
    return this.http.get<string[]>(this.apiServerURL + '/rest/util/listaDepartamentos');
  }

  listaProvincias(paramDep: any): Observable<string[]> {
    return this.http.get<string[]>(this.apiServerURL + '/rest/util/listaProvincias/' + paramDep);
  }

  listaDistritos(paramDep: any, paramProv: any): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.apiServerURL + '/rest/util/listaDistritos/' + paramDep + '/' + paramProv);
  }
}
