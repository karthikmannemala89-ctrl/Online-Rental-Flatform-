package com.karthik.rental.config;

import com.karthik.rental.entity.Product;
import com.karthik.rental.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seed(ProductRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Product("MacBook Air M2", "Laptop", "Apple",
                        "Lightweight Apple laptop suitable for students and professionals.",
                        new BigDecimal("850"), new BigDecimal("5000"),
                        "https://images.unsplash.com/photo-1517336714731-489689fd1ca8?w=800"));

                repo.save(new Product("iPhone 15", "Smartphone", "Apple",
                        "Modern iPhone with excellent camera and performance.",
                        new BigDecimal("600"), new BigDecimal("4000"),
                        "https://images.unsplash.com/photo-1591337676887-a217a6970a8a?w=800"));

                repo.save(new Product("Galaxy S24", "Smartphone", "Samsung",
                        "Premium Android smartphone with high-end display and camera.",
                        new BigDecimal("500"), new BigDecimal("3500"),
                        "https://images.unsplash.com/photo-1610945265064-0e34e5519bbf?w=800"));

                repo.save(new Product("Sony A7 IV", "Camera", "Sony",
                        "Full-frame mirrorless camera for photography and video.",
                        new BigDecimal("1200"), new BigDecimal("8000"),
                        "https://images.unsplash.com/photo-1516035069371-29a1b244cc32?w=800"));

                repo.save(new Product("PlayStation 5", "Gaming", "Sony",
                        "Next-generation console for home gaming.",
                        new BigDecimal("900"), new BigDecimal("5000"),
                        "https://images.unsplash.com/photo-1606813907291-d86efa9b94db?w=800"));

                repo.save(new Product("Dell XPS 13", "Laptop", "Dell",
                        "Premium Windows ultrabook for work and study.",
                        new BigDecimal("700"), new BigDecimal("4500"),
                        "https://images.unsplash.com/photo-1593642702821-c8da6771f0c6?w=800"));
            }
        };
    }
}
