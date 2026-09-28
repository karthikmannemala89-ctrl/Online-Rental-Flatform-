package com.karthik.rental.repository;

import com.karthik.rental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findAllByOrderByIdDesc();
}
