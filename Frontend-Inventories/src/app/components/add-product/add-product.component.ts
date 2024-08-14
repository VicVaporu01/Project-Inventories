import {Component} from '@angular/core';
import {Product} from "../../interfaces/product";
import {ProductService} from "../../services/product.service";
import {Router} from "@angular/router";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-add-product',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './add-product.component.html',
  styleUrl: './add-product.component.css'
})
export class AddProductComponent {
  private _newProduct: Product;

  constructor(private productService: ProductService, private router: Router) {
    // Default values to avoid errors
    this._newProduct = {
      description: '',
      price: 0,
      stock: 0,
    };
  }

  onSubmit() {
    this.saveProduct();
  }

  get newProduct(): Product {
    return this._newProduct;
  }

  saveProduct() {
    this.productService.newProduct(this._newProduct).subscribe(
      {
        next: (data: Product) => {
          this.goProductList();
        }, error: (error: any) => {
          console.error(error);
        }
      }
    );
  }

  goProductList() {
    this.router.navigate(['/']);
  }

}
