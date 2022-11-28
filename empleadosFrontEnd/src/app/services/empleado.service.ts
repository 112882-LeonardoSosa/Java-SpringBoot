import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empleado } from '../models/empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  private Url_Base: string =
    'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  obtenerListado(): Observable<Empleado[]> {
    const result = this.http.get<Empleado[]>(this.Url_Base+"getEmpleados");
    return result;
  }

  eliminar(empleado: Empleado): Observable<any> {
    return this.http.delete(this.Url_Base + empleado.id);
  }

  agregar(empleado: Empleado): Observable<Empleado> {
    return this.http.post<Empleado>(this.Url_Base+"saveEmpleado", empleado);
  }

  modificar(empleado: Empleado): Observable<Empleado> {
    return this.http.put<Empleado>(this.Url_Base + empleado.id, empleado);
  }

}
