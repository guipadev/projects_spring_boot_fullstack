import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({ providedIn: 'root' })

export class AxiosService {

  constructor() {
    // Establecer por defecto URL base del Back
    axios.defaults.baseURL = 'http://localhost:8081';
    // De forma predeterminada todas las llamadas POST tendran encabezado JSON
    axios.defaults.headers.post['Content-Type'] = 'application/json';
  }

  // Administrar el acceso al localstorage
  getAuthToken(): string | null {
    return window.localStorage.getItem("auth_token");
  }

  // Agregar el token en el localstorage
  setAuthToken(token: string | null): void {
    // Si valor es null, elimino el token existente
    if (token !== null) {
      window.localStorage.setItem("auth_token", token);
    } else {
      window.localStorage.removeItem("auth_token");
    }
  }


  request(method: string, url: string, data: any): Promise<any> {
    let headers: any = {};

    // Agregar encabezado de autorización en la solicitud, si el token esta presente en el localstorage
    if (this.getAuthToken() !== null) {
      headers = {"Authorization": "Bearer " + this.getAuthToken()};
    }

    return axios({
      method: method,
      url: url,
      data: data,
      headers: headers
    });
  }
}
