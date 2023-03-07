import swal from 'sweetalert2';

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Empleado } from 'src/app/core/models/empleado';
import { EmpleadoService } from '../../services/empleado.service';

@Component({
  selector: 'app-lista-empleados',
  templateUrl: './lista-empleados.component.html',
  styleUrls: ['./lista-empleados.component.css'],
})
export class ListaEmpleadosComponent implements OnInit {
  empleados: Empleado[];

  constructor(
    private empleadoServicio: EmpleadoService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.obtenerEmpleados();
  }

  /*
  Uso validar con empleados creados (quemados)
  constructor() {}

  ngOnInit(): void {
    this.empleados = [
      {
        "id": 1,
        "nombre": "Jose",
        "id":1,
        "id":1,
      },
      {

      },
    ];
  }
  */

  private obtenerEmpleados() {
    this.empleadoServicio.obtenerListaDeEmpleados().subscribe((dato) => {
      this.empleados = dato;
    });
  }

  actualizarEmpleado(id: number) {
    this.router.navigate(['actualizar-empleado', id]);
  }

  eliminarEmpleado(id: number) {
    swal({
      title: 'Estas seguro?',
      text: 'Confirma si deseas eliminar al empleado',
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonText: 'No, cancelar',
      confirmButtonClass: 'btn btn-success',
      cancelButtonClass: 'btn btn-danger',
      buttonsStyling: true,
    }).then((result) => {
      if (result.value) {
        this.empleadoServicio.eliminarEmpleado(id).subscribe((dato) => {
          this.obtenerEmpleados();
          swal(
            'Registro Eliminado',
            'El empleado se eliminado con exito',
            'success'
          );
        });
      }
    });
  }

  verDetallesDelEmpleado(id: number) {
    this.router.navigate(['empleado-detalles', id]);
  }
}
