package com.vic.inventarios.controllers;

import com.vic.inventarios.models.Product;
import com.vic.inventarios.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("inventory-app")
@CrossOrigin("http://localhost:4200")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> GetProducts() {
        try {
            List<Product> products = productService.ListProducts();

            logger.info("Products gotten: ");
            products.forEach((product -> logger.info(product.toString())));

            return ResponseEntity.status(HttpStatus.OK).body(products);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Map<String, String>> CreateProduct(@RequestBody Product product) {
        try {
            String response = productService.SaveProduct(product);
            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("message", response);

            return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
