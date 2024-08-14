import {Component} from '@angular/core';
import {Product} from "../../interfaces/product";
import {ProductService} from "../../services/product.service";

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {
  products: Product[] = [];

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.GetProducts();
  }

  private GetProducts() {
    this.productService.productsList().subscribe({
        next: (products: Product[]) => {
          this.products = products;
        },
        error: (error) => {
          console.error(error);
        },
        complete: () => {
          console.info("Products list obtained.");
        }
      }
    );
  }

}
