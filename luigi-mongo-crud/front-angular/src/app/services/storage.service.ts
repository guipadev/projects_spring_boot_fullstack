import { Product } from '../model/product';
import { Injectable } from '@angular/core';

const KEY_PRODU = 'prod_update';

@Injectable({
  providedIn: 'root',
})
export class StorageService {
  constructor() {}

  public setProduct(product: Product): void {
    localStorage.setItem(KEY_PRODU, JSON.stringify(product));
  }

  public getProduct(): Product {
    return JSON.parse(localStorage.getItem(KEY_PRODU)!);
  }

  public clear(): void {
    localStorage.removeItem(KEY_PRODU);
  }
}
