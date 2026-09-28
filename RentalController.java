package com.karthik.rental.controller;

import com.karthik.rental.dto.RentalRequest;
import com.karthik.rental.entity.Rental;
import com.karthik.rental.service.RentalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@CrossOrigin
public class RentalController {
    private final RentalService service;

    public RentalController(RentalService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody RentalRequest request) {
        try {
            return ResponseEntity.ok(service.create(request));
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(java.util.Map.of("message", e.getMessage()));
        }
    }

    @GetMapping
    public List<Rental> all() {
        return service.all();
    }
}
