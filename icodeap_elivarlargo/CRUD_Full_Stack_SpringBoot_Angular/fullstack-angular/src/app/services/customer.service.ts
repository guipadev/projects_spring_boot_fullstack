import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../models/customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  PTO: number = 8081;

  private api: string = `http://localhost:${this.PTO}/api/customers`;

  constructor(private http: HttpClient) {}

  getCustomerList(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.api);
  }

  /**
   * Método creación objecto tipo customer
   * Retorna un objeto tipo customer, ya que retornamos el objeto ya creado
   * @param customer
   */
  createCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.api, customer);
  }
}
