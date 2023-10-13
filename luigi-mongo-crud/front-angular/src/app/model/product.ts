export class Product {
  id!: number; // Indicamos que nos aseguramos que id no sera nulo
  name: string;
  price: number;

  // El back genera el Id automaticamnte
  constructor(name: string, price: number) {
    this.name = name;
    this.price = price;
  }
}
