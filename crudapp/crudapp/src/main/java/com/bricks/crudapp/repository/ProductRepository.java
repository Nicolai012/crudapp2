package com.bricks.crudapp.repository;

import com.bricks.crudapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
