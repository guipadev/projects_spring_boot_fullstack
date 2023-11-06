import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  tareas: any[] = [];

  tarea = {
    id: null,
    nombre: '',
    completado: false
  }

  // constructor para implementar inyeccion appService
  constructor(
    private appService: AppService
  ) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.appService.getAll()
      .subscribe((data: any) => this.tareas = data);
  }

  // crear y editar
  save() {

    if (this.tarea.id) {
      this.appService.update(this.tarea.id!, this.tarea) // id siempre distinto de nulo
        .subscribe(() => this.getAll());
    } else {
      this.appService.create(this.tarea)
      .subscribe(() => this.getAll()); // cargar nuevamente las tareas
    }

    // Limpiar el formulario
    this.tarea = {
      id: null,
      nombre: '',
      completado: false
    }
  }

  edit(tarea: any) { // Asignamos a tarea un nuevo objeto y destructuramos los valores de la tarea que recibimos como parametro
    this.tarea = {
      ...tarea  
    };
  }

  delete(tarea: any) {
    this.appService.delete(tarea.id)
      .subscribe(() => this.getAll());
  }

  
}
