import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Empleado } from 'src/app/core/models/empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  private baseUrl = "http://localhost:8080/api/v1/empleados";

  constructor(private httpClient : HttpClient) { }

  obtenerListaDeEmpleados():Observable<Empleado[]> {
    return this.httpClient.get<Empleado[]>(`${this.baseUrl}`);
  }

  registrarEmpleado(empleado:Empleado): Observable<any> {
    return this.httpClient.post(`${this.baseUrl}`,empleado);
  }

  actualizarEmpleado(id:number, empleado:Empleado): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/${id}`,empleado);
  }

  obtenerEmpleadoPorId(id:number): Observable<Empleado> {
    return this.httpClient.get<Empleado>(`${this.baseUrl}/${id}`);
  }

  eliminarEmpleado(id:number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
}
