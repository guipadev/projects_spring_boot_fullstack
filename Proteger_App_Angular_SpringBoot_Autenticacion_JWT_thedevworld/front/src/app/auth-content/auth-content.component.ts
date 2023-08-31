import { Component } from '@angular/core';
import { AxiosService } from '../axios.service';

@Component({
  selector: 'app-auth-content',
  templateUrl: './auth-content.component.html',
  styleUrls: ['./auth-content.component.css']
})

export class AuthContentComponent {
  // var almacenar rta back
  data: string[] = [];

  // Inyectamos servicio axios en constructor
  constructor(private axiosService: AxiosService) {}

  // Solictar al backend en la inicialización del componente
  ngOnInit(): void {
    this.axiosService.request(
      // Método GET para el endpoint de los mensajes sin argumentos
      "GET",
      "/messages",
      {}).then(
        (response) => {
          // almacenar rta en var data
          this.data = response.data;
        }).catch(
          (error) => {
            if (error.response.status === 401) {
              this.axiosService.setAuthToken(null);
            } else {
              this.data = error.response.code;
            }
          }
        );
      }
  }
