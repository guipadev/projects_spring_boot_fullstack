import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css'],
})
export class CustomerListComponent implements OnInit {
  // Lista a guardar elementos
  customers: Customer[] = [];

  constructor(private customerService: CustomerService) {}

  // Ejecuta cada vez que componente se carga
  ngOnInit(): void {
    this.listCustomers();
  }

  // Nos subcribimos porque el servicio que llama a la url
  // El sitio pueda que no funcione en el momento
  listCustomers() {
    this.customerService.getCustomerList().subscribe((data) => {
      this.customers = data;
      console.log(this.customers);
    });
  }

  /**
   * La finalidad de suscribirse, para que una vez realizado el eliminado
   * del objeto Customer, pueda actualizar y visualizar en el componente
   * de lista de customer que ya no existe
   * @param id
   */
  deleteCustomer(id: number) {
    this.customerService
      .deleteCustomerById(id)
      .subscribe(() => this.listCustomers());
  }
}
