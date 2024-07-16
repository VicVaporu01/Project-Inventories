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

  GetProductsList(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${environment.urlBase}/products`);
  }

  AddNewProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(`${environment.urlBase}/create-product`, product);
  }

}
