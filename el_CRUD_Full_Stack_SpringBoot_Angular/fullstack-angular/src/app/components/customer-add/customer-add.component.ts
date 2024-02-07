import { Component, OnInit } from '@angular/core';

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
  id: string = '';
  firstName: string = '';
  lastName: string = '';
  email: string = '';

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
}
