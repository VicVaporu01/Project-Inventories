import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../interfaces/product";
import {environment} from "../../environments/environment.development";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) {
  }

  productsList(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${environment.urlBase}/products`);
  }

  newProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(`${environment.urlBase}/products`, product);
  }

}
