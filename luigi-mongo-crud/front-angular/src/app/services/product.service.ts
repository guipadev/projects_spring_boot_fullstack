import { Injectable } from '@angular/core';
import { environment } from 'src/enviroments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  productURL = environment.apiResrURL + '/product';

  // Inyectamos el httpclient
  constructor(private httpClient: HttpClient) {}

  // Observable para recibir una lista de productos
  public list(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.productURL);
  }

  // Recibir un producto en especifico
  public detail(id: number): Observable<Product> {
    return this.httpClient.get<Product>(this.productURL + `/${id}`);
  }

  // crear producto
  public create(product: Product): Observable<any> {
    return this.httpClient.post<any>(this.productURL, product);
  }

  // actualizar producto
  public update(id: number, product: Product): Observable<any> {
    return this.httpClient.put<any>(this.productURL + `/${id}`, product);
  }

  // eliminar producto
  public delete(id: number): Observable<any> {
    return this.httpClient.delete<any>(this.productURL + `/${id}`);
  }
}
