package com.karthik.rental.service;

import com.karthik.rental.dto.RentalRequest;
import com.karthik.rental.entity.*;
import com.karthik.rental.repository.ProductRepository;
import com.karthik.rental.repository.RentalRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RentalService {
    private final ProductRepository productRepository;
    private final RentalRepository rentalRepository;

    public RentalService(ProductRepository productRepository, RentalRepository rentalRepository) {
        this.productRepository = productRepository;
        this.rentalRepository = rentalRepository;
    }

    public Rental create(RentalRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        if (!product.isAvailable()) {
            throw new IllegalStateException("Product is currently unavailable");
        }
        if (request.getEndDate().isBefore(request.getStartDate())) {
            throw new IllegalArgumentException("End date must be after start date");
        }

        long days = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate()) + 1;
        BigDecimal total = product.getPricePerDay()
                .multiply(BigDecimal.valueOf(days))
                .add(product.getSecurityDeposit());

        Rental rental = new Rental();
        rental.setProduct(product);
        rental.setCustomerName(request.getCustomerName());
        rental.setCustomerEmail(request.getCustomerEmail());
        rental.setStartDate(request.getStartDate());
        rental.setEndDate(request.getEndDate());
        rental.setTotalAmount(total);
        rental.setStatus(RentalStatus.CONFIRMED);

        product.setAvailable(false);
        productRepository.save(product);
        return rentalRepository.save(rental);
    }

    public List<Rental> all() {
        return rentalRepository.findAllByOrderByIdDesc();
    }
}
