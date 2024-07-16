package com.vic.inventarios.services;

import com.vic.inventarios.models.Product;
import com.vic.inventarios.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> ListProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product GetProductById(Integer idProduct) {
        return productRepository.findById(idProduct).orElse(null);
    }


    @Override
    public String SaveProduct(Product product) {
        productRepository.save(product);
        return "Product " + product.getDescription() + " saved.";
    }

    @Override
    public String DeleteProductById(Integer idProduct) {
        productRepository.deleteById(idProduct);
        return "Product " + idProduct + " deleted.";
    }
}
