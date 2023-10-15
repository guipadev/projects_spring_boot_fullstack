import { ProductService } from './../services/product.service';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Product } from '../model/product';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css'],
})
export class UpdateComponent implements OnInit {
  // Los campos a actualizar del form
  id!: number;
  name!: string;
  price!: number;

  constructor(
    private productService: ProductService,
    private toast: ToastrService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.getProduct();
  }

  onUpdate(): void {
    const product = new Product(this.name, this.price);
    // this se ve desde cualquier método de la clase, cuando no lo lleva como en caso de product
    // se ve solo desde el metodo donde se ha creado esa variable
    this.productService.update(this.id, product).subscribe(
      (data) => {
        this.toast.success(data.message, 'OK', {
          timeOut: 3000,
          positionClass: 'toast-top-center',
        });
        this.router.navigate(['']);
      },
      (err) => {
        this.toast.error(err.error.message, 'Error', {
          timeOut: 3000,
          positionClass: 'toast-top-center',
        });
      }
    );
  }

  getProduct(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.name = this.activatedRoute.snapshot.params['name'];
    this.price = this.activatedRoute.snapshot.params['price'];
  }
}
