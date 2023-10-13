import { Subscription } from 'rxjs';
//import { MessageService } from './../services/message.service';
import { Product } from './../model/product';
import { ProductService } from './../services/product.service';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css'],
})
export class UpdateComponent implements OnInit, OnDestroy {
  // Los campos a actualizar del form
  product!: Product;

  subscription: Subscription | undefined;

  // Inyectamos servicios y demas
  constructor(
    private productService: ProductService,
    private toast: ToastrService,
    private router: Router,
    private activatedRoute: ActivatedRoute //private messageService: MessageService
  ) {}

  // inicializar el metodo
  ngOnInit(): void {
    this.getProduct();
  }

  onUpdate(): void {
    this.productService.update(this.product.id, this.product).subscribe(
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
    // acceder al elemento con el parametro
    const id = this.activatedRoute.snapshot.params['id'];
    // acceder al metodo del servicio
    this.productService.detail(id).subscribe(
      (data) => {
        this.product = data;
        console.log(this.product);
      },
      (err) => {
        this.toast.error(err.error.message, 'Error', {
          timeOut: 3000,
          positionClass: 'toast-top-center',
        });
        this.router.navigate(['']);
      }
    );
  }

  /*
  getProduct(): void {
    this.subscription = this.messageService.getMessage().subscribe(
      data => {
        this.product = data.product;
        console.log(data.product);
        
      },
      err => {
        console.log(err);
      }
    );
  }
  */

  ngOnDestroy(): void {
    this.subscription?.unsubscribe();
  }
}
