import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ListaEmpleadosComponent } from './modules/empleados/components/lista-empleados/lista-empleados.component';
import { RegistrarEmpleadoComponent } from './modules/empleados/components/registrar-empleado/registrar-empleado.component';
import { ActualizarEmpleadoComponent } from './modules/empleados/components/actualizar-empleado/actualizar-empleado.component';
import { EmpleadoDetallesComponent } from './modules/empleados/components/empleado-detalles/empleado-detalles.component';

const routes: Routes = [
  {path: 'empleados', component: ListaEmpleadosComponent},
  {path: 'registrar-empleado', component: RegistrarEmpleadoComponent},
  {path: 'actualizar-empleado/:id', component: ActualizarEmpleadoComponent},
  {path: 'empleado-detalles/:id', component: EmpleadoDetallesComponent},
  {path: '', redirectTo:'empleados', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
