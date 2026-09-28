package com.karthik.rental.repository;

import com.karthik.rental.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryIgnoreCase(String category);
    List<Product> findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(String name, String brand);
}
