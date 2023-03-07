import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  libros: any[] = [];
  formulario!: FormGroup; // ! indicar que se inicializara déspues 

  constructor(
    private appService: AppService,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {

    // Inicializar un formulario reactivo
    this.formulario = this.fb.group({
      titulo: [, [Validators.required, Validators.minLength(3)]] //1er elemento es el valor por defecto(en este caso no habra), 2do array validaciones sincronas, 3cero array validacioines asincronas (validar que un correo no esta en uso en BD)
    })

    this.getAll();
  }

  getAll() {
    this.appService.getAll()
      .subscribe((data: any) => {
        this.libros = data['_embedded']['libros'];
      }); // Normalmente primero se define la estructura que tiene la data y no uso de any
  }

  create() {
    if (this.formulario.invalid) {
      this.formulario.markAllAsTouched();
      return;
    }

    this.appService.create(this.formulario.value)
      .subscribe(() => {
        this.formulario.setValue({titulo: ''}); // Reset formulario
        this.getAll();
      })
  }
  
}
