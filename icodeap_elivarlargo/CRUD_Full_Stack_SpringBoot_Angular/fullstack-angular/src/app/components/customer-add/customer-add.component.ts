import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css'],
})
export class CustomerAddComponent implements OnInit {
  /**
   * Var para realizar binding con los elementos HTML
   * Que van a estar en la plantilla, cada archivo ts sabe tener su plantilla
   */
  id: number = 0;
  firstName: string = '';
  lastName: string = '';
  email: string = '';

  constructor(private customerService: CustomerService) {}

  ngOnInit(): void {}

  addCustomer() {
    let customer = new Customer(
      this.id,
      this.firstName,
      this.lastName,
      this.email
    );
    //console.log(customer);
    this.customerService
      .createCustomer(customer)
      .subscribe((res) => console.log(res));
  }
}
