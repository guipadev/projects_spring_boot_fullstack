import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { Contacto, credentials } from './model';

@Injectable({
  providedIn: 'root'
})

export class ApiService {

  constructor(
    private http: HttpClient
  ) { }

  getContactos(): Observable<Contacto[]> {
    return this.http.get<Contacto[]>('http://localhost:8080/api/contactos');
  }

  //Aún no tiene forma de comunicarse con la Api y obtener acceso
  //Esta función recibira las credenciales del usuario
  login(creds: credentials) {
    return this.http.post('http://localhost:8080/login', creds, {observe: 'response'})
      .pipe(map((response: HttpResponse<any>) => {
        const body = response.body;
        const headers = response.headers;
        const bearerToken = headers.get('Authorization')!;
        const token = bearerToken.replace('Bearer ', '');

        localStorage.setItem('token', token);

        return body;
      }))
  }

  //Obtener el token
  getToken() {
    return localStorage.getItem('token');
  }
}
