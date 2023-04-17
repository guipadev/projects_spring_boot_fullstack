import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { credentials } from '../model';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  creds: credentials = { 
    email: '',
    password: ''
  };

  constructor(
    private apiService: ApiService,
    private router: Router
  ) { }

  //Función a ejecutar cuando se envie formulario
  login(form: NgForm) { 
    //mostrar datos enviados para credenciales
    //console.log('form value', form.value);

    this.apiService.login(this.creds)
      .subscribe(response => {
        this.router.navigate(['/']);
      })
  }
}
