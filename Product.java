package com.karthik.rental.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    @NotBlank
    private String brand;

    @Column(length = 2000)
    private String description;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal pricePerDay;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal securityDeposit;

    private String imageUrl;
    private boolean available = true;

    public Product() {}

    public Product(String name, String category, String brand, String description,
                    BigDecimal pricePerDay, BigDecimal securityDeposit, String imageUrl) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.pricePerDay = pricePerDay;
        this.securityDeposit = securityDeposit;
        this.imageUrl = imageUrl;
        this.available = true;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getBrand() { return brand; }
    public String getDescription() { return description; }
    public BigDecimal getPricePerDay() { return pricePerDay; }
    public BigDecimal getSecurityDeposit() { return securityDeposit; }
    public String getImageUrl() { return imageUrl; }
    public boolean isAvailable() { return available; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setDescription(String description) { this.description = description; }
    public void setPricePerDay(BigDecimal pricePerDay) { this.pricePerDay = pricePerDay; }
    public void setSecurityDeposit(BigDecimal securityDeposit) { this.securityDeposit = securityDeposit; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public void setAvailable(boolean available) { this.available = available; }
}
