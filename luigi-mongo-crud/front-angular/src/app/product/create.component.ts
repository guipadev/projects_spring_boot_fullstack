import { Product } from './../model/product';
import { ProductService } from './../services/product.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
})
export class CreateComponent implements OnInit {
  // var que necesita el formulario e indicamos que si tendran valor, que no va ser undefined y null
  name!: string;
  price!: number;

  // Inyectamos servicios y demas a utilizar
  constructor(
    private productService: ProductService,
    private toast: ToastrService,
    private router: Router
  ) {}

  ngOnInit(): void {
    //this.onCreate();
  }

  // Creación de producto
  onCreate(): void {
    const product = new Product(this.name, this.price);
    this.productService.create(product).subscribe(
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
}
