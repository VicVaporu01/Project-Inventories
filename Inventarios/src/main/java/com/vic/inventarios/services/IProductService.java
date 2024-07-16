package com.vic.inventarios.services;

import com.vic.inventarios.models.Product;

import java.util.List;

public interface IProductService {
    public List<Product> ListProducts();

    public Product GetProductById(Integer idProduct);

    public String SaveProduct(Product product);

    public String DeleteProductById(Integer idProduct);
}
