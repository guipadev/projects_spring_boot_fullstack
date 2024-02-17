import { Component, OnInit } from '@angular/core';
import { ConfirmationService, MenuItem, MessageService } from 'primeng/api';
import { Persona } from 'src/app/models/persona';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css'],
})
export class PersonaComponent implements OnInit {
  personas: Persona[] = [];

  // Arreglo para tener las columnas de forma dinamica
  cols: any[] = [];

  // Ménu de opciones
  items: MenuItem[] = [];

  // Mostrar / Cerrar dialogo
  displaySaveDialog: boolean = false;

  // Modelo para guardar persona
  persona: Persona = {
    id: 0,
    nombre: '',
    apellido: '',
    direccion: '',
    telefono: '',
  };

  // Seleccionar persona
  selectedPersona: Persona = {
    id: 0,
    nombre: null,
    apellido: null,
    direccion: null,
    telefono: null,
  };

  constructor(
    private personaService: PersonaService,
    private messageService: MessageService,
    private confirmService: ConfirmationService
  ) {}

  getAll() {
    this.personaService.getAll().subscribe(
      (result: any) => {
        let personitas: Persona[] = [];

        for (let i = 0; i < result.length; i++) {
          let persona = result[i] as Persona; // Castero var persona a tipo Persona
          personitas.push(persona);
        }
        this.personas = personitas;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  /**
   * Modelo persona es igual a persona seleccionada, para que los campos del formulario,
   * se apliquen los valores del registro que se selecciono
   * Osea si es de editar mostrara modal con datos llenos y si es de crear datos vacios
   */
  showSaveDialog(editar: boolean) {
    if (editar) {
      if (this.selectedPersona != null && this.selectedPersona.id != null) {
        this.persona = this.selectedPersona;
      } else {
        this.messageService.add({
          severity: 'warn',
          summary: 'Advertencia!',
          detail: 'Por favor, seleccionar un registro!!',
        });
        return;
      }
    } else {
      this.persona = {
        id: 0,
        nombre: '',
        apellido: '',
        direccion: '',
        telefono: '',
      };
    }
    this.displaySaveDialog = true;
  }

  save() {
    this.personaService.save(this.persona).subscribe(
      (result: any) => {
        // result convertir a tipo Persona
        let persona = result as Persona;
        // El resultado inmediatamente pasarlo a la lista para no referescar y ver el registro en la tabla
        this.validarPersona(persona);
        // Msj registro exitoso
        this.messageService.add({
          severity: 'success',
          summary: 'Resultado',
          detail: 'Registro de persona correcto!!',
        });
        // Cerrar modal
        this.displaySaveDialog = false;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  delete() {
    if (this.selectedPersona === null || this.selectedPersona.id == 0) {
      this.messageService.add({
        severity: 'warn',
        summary: 'Advertencia!',
        detail: 'Por favor, seleccionar un registro!!',
      });
      return;
    }

    this.confirmService.confirm({
      message: '¿Está seguro que desea eliminar el registro?',
      accept: () => {
        this.personaService
          .delete(this.selectedPersona.id)
          .subscribe((result: any) => {
            this.messageService.add({
              severity: 'success',
              summary: 'Resultado',
              detail: 'Se eliminó el registro',
            });
            this.deleteObject(result.id);
          });
      },
    });
  }

  deleteObject(id: number) {
    let index = this.personas.findIndex((e) => e.id == id);

    if (index != -1) {
      this.personas.splice(index, 1);
    }
  }

  validarPersona(persona: Persona) {
    let index = this.personas.findIndex((e) => e.id == persona.id);

    if (index != -1) {
      this.personas[index] = persona;
    } else {
      this.personas.push(persona);
    }
  }

  ngOnInit(): void {
    // Incializar el servicio api
    this.getAll();

    // Columnas dinamicas
    this.cols = [
      { field: 'id', header: 'Id' },
      { field: 'nombre', header: 'Nombre' },
      { field: 'apellido', header: 'Apellido' },
      { field: 'direccion', header: 'DIreccion' },
      { field: 'telefono', header: 'Telefono' },
    ];

    // Ménu opciones
    this.items = [
      {
        label: 'Nuevo',
        icon: 'pi pi-fw pi-plus',
        command: () => this.showSaveDialog(false),
      },
      {
        label: 'Editar',
        icon: 'pi pi-fw pi-pencil',
        command: () => this.showSaveDialog(true),
      },
      {
        label: 'Eliminar',
        icon: 'pi pi-fw pi-times',
        command: () => this.delete(),
      },
    ];
  }
}
