package com.bricks.crudapp.controller;

import com.bricks.crudapp.model.Product;
import com.bricks.crudapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return repository.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        Product existing = repository.findById(id).orElseThrow();
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
