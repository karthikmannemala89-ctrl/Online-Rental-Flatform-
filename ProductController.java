package com.karthik.rental.controller;

import com.karthik.rental.entity.Product;
import com.karthik.rental.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Product> all(@RequestParam(required = false) String search,
                             @RequestParam(required = false) String category) {
        if (search != null && !search.isBlank())
            return repository.findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(search, search);
        if (category != null && !category.isBlank())
            return repository.findByCategoryIgnoreCase(category);
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> one(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return repository.save(product);
    }
}
