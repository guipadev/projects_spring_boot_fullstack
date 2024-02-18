import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Persona } from '../models/persona';

@Injectable({
  providedIn: 'root',
})
export class PersonaService {
  baseUrl: string = 'http://localhost:8082/api/v1';

  constructor(private http: HttpClient) {}

  //Consultar todos los registros de personas
  getAll(): Observable<any> {
    return this.http.get(this.baseUrl + '/all');
  }

  // Guardar o Editar registro de persona
  save(persona: Persona): Observable<any> {
    // Indicamos que pasaremos JSON en el header
    let headers = new HttpHeaders();

    headers = headers.set('Content-Type', 'application/json');

    return this.http.post(this.baseUrl + '/save', JSON.stringify(persona), {
      headers: headers,
    });
  }

  // Eliminar registro de persona
  delete(id: any): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/delete/${id}`);
    console.log(this.http.delete<any>(`${this.baseUrl}/delete/${id}`));
  }
}
