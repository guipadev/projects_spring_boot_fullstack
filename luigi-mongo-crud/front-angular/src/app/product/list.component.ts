import { Router } from '@angular/router';
import { Product } from './../model/product';
import Swal from 'sweetalert2';
import { ProductService } from './../services/product.service';
import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { StorageService } from '../services/storage.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class ListComponent implements OnInit {
  // Necesitamos recibir un array de productos
  products: Product[] = [];

  constructor(
    // Inyectamos el servicio y lo necesario
    private productService: ProductService,
    private toast: ToastrService,
    private storageService: StorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Invocamos para inicializar el método
    this.getProducts();
  }

  getProducts(): void {
    this.productService.list().subscribe(
      (data) => {
        this.products = data;
      },
      (err) => {
        this.toast.error(err.error.message, 'Error', {
          timeOut: 3000,
          positionClass: 'toast-top-center',
        });
      }
    );
  }

  onDelete(id: number): void {
    Swal.fire({
      title: 'Está seguro?',
      text: 'No se puede deshacer',
      icon: 'warning',
      showCancelButton: true, // ver boton de cancelar
      confirmButtonText: 'OK',
      cancelButtonText: 'Cancel',
    }).then((result) => {
      if (result.value) {
        this.productService.delete(id).subscribe(
          (data) => {
            this.toast.success(data.message, 'OK', {
              timeOut: 3000,
              positionClass: 'toast-top-center',
            });
            this.getProducts();
          },
          (err) => {
            this.toast.error(err.error.message, 'Error', {
              timeOut: 3000,
              positionClass: 'toast-top-center',
            });
          }
        );
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire('canceled', 'product not deleted', 'error');
      }
    });
  }

  setProduct(product: Product): void {
    this.storageService.setProduct(product);
    this.router.navigate(['/update']);
  }
}
