package com.vic.inventarios.repositories;

import com.vic.inventarios.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
